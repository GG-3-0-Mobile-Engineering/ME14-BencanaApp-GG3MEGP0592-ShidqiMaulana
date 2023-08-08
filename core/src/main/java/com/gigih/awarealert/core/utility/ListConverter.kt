package com.gigih.awarealert.core.utility

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListConverter {
    @TypeConverter
    fun restoreList(listOfString: String?): List<Double?>? {
        return Gson().fromJson(listOfString, object : TypeToken<List<Double?>?>() {}.type)
    }

    @TypeConverter
    fun saveList(listOfString: List<Double?>?): String? {
        return Gson().toJson(listOfString)
    }

}