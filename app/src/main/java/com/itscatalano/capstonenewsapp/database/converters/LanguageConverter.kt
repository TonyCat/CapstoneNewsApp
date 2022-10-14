package com.itscatalano.capstonenewsapp.database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.itscatalano.capstonenewsapp.models.LanguageType
import com.itscatalano.capstonenewsapp.models.Source

class LanguageConverter {
    @TypeConverter
    fun fromListToString(value: List<LanguageType>): String {
        val gson = Gson()
        val type = object : TypeToken<List<LanguageType>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toListFromString(value: String) : List<LanguageType>{
        val gson = Gson()
        val type = object : TypeToken<List<LanguageType>>() {}.type
        return gson.fromJson(value, type)
    }
}