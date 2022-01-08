package com.scetasj.universitydatabase.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.scetasj.universitydatabase.model.Staff
import java.lang.reflect.Type

class ListTypeConverter {
    var gson: Gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String): List<Staff> {

        val listType: Type = object : TypeToken<List<Staff>>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: List<Staff>): String {
        return gson.toJson(someObjects)
    }
}