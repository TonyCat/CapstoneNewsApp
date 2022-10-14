package com.itscatalano.capstonenewsapp.database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.itscatalano.capstonenewsapp.models.CountryType
import com.itscatalano.capstonenewsapp.models.LanguageType

class CountryConverter {
    @TypeConverter
    fun fromListToString(value: List<CountryType>): String {
        val gson = Gson()
        val type = object : TypeToken<List<CountryType>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toListFromString(value: String) : List<CountryType>{
        val gson = Gson()
        val type = object : TypeToken<List<CountryType>>() {}.type
        return gson.fromJson(value, type)
    }
}