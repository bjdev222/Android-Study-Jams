package com.scetasj.universitydatabase.db

import android.content.Context
import android.system.Os.open
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.google.gson.GsonBuilder
import com.scetasj.universitydatabase.model.Info
import com.scetasj.universitydatabase.db.converters.ListTypeConverter
import com.scetasj.universitydatabase.model.Staff
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.io.InputStream

@Database(entities = [Info::class], version = 1, exportSchema = false)
@TypeConverters(ListTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): dao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, "proffesor.db"
                    ).allowMainThreadQueries()
                        .addCallback(object : RoomDatabase.Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {

                                Log.d("db", "onCreate: db created")


                                var Json: String? = null

                                try {
                                    val inputStream: InputStream =
                                        context.assets.open("Department.json")
                                    Json = inputStream.bufferedReader().use { it.readText() }

                                    var jsonObject = JSONObject(Json)
                                    var jsonArray = jsonObject.getJSONArray("Dept")

                                    val gson = GsonBuilder().create()

                                    for (i in 0 until jsonArray.length()) {

                                        val info = gson.fromJson(
                                            jsonArray[i].toString(),
                                            Info::class.java
                                        )
                                        Log.d("db", "info is $i -> ${info.toString()}")
                                        CoroutineScope(Dispatchers.IO).launch {
                                            INSTANCE?.userDao()?.insertUser(info)
                                        }

//                                        INSTANCE?.userDao()?.insertUser(info)
                                    }
                                } catch (e: Exception) {
                                    Log.e("db", "readData: ", e)
                                }

                                super.onCreate(db)
                            }
                        })
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}