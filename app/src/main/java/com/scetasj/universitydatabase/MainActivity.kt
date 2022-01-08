package com.scetasj.universitydatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.room.TypeConverter
import com.google.gson.GsonBuilder
import com.scetasj.universitydatabase.model.Info
import com.scetasj.universitydatabase.repository.UserRepository
import org.json.JSONObject
import java.io.InputStream

import com.google.gson.reflect.TypeToken

import com.google.gson.JsonElement
import com.scetasj.universitydatabase.model.Staff
import java.lang.reflect.Type


val mutableList = mutableListOf<Info>()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        UserRepository(applicationContext).getAllUsers().observe(this, {
            Log.d("one", "readData: live data observed")
            Log.d("one", "readData: ${it.toString()}")
        })
    }

    private fun readData() {
        var Json: String? = null

        try {
            val inputStream: InputStream = assets.open("Department.json")
            Json = inputStream.bufferedReader().use { it.readText() }

            var jsonObject = JSONObject(Json)

            var jsonArray = jsonObject.getJSONArray("Dept")

            /*var co=jsonArray.getJSONObject(0)

            var json2=co.getJSONArray("Computer")*/

            for (u in 0..jsonArray.length() - 1) {


                var dept = jsonArray.getJSONObject(u).get("dept")

                var co = jsonArray.getJSONObject(u)

                var json2 = co.getJSONArray("staff")

                val gson = GsonBuilder().create()

                val packagesArray =
                    gson.fromJson(json2.toString(), Array<Staff>::class.java).toList()


                Log.d("TAG", "readData: " + json2)



                UserRepository(applicationContext).insertUser(
                    Info(
                        null,
                        dept.toString(),
                        packagesArray
                    )
                )


//                mutableList.add(Info(null,name as String, bio as String,"comp"))
//                UserRepository(applicationContext).insertUser(Info(null,"name as String", "bio as String","comp"))
            }


/*
           UserRepository(applicationContext).getAllUsers()
*/

//            Log.d("TAG", "readData: "+ UserRepository(this).getAllUsers().toString())

            UserRepository(applicationContext).getAllUsers().observe(this, {
                Log.d("one", "readData: ${it[0].staff.toString()}")
                for (i in it) {
                    for (j in i.staff) {
                        Log.d("TAG", "personal info -> ${j.toString()} ")
                    }
                }
            })

/*

//            var jsonArray = JSONArray(Json).get(1)
            Log.d("TAG", "readData: "+jsonArray)

            for (i in 0..co.length()){
                var jsonObject=jsonArray.getJSONObject(i)

                Log.d("TAG", "readData: "+jsonObject)

            }
*/

        } catch (e: Exception) {

            Log.e("TAG", "readData: ", e)

        }

    }
}