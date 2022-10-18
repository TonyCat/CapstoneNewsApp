package com.itscatalano.capstonenewsapp.database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.itscatalano.capstonenewsapp.App
import com.itscatalano.capstonenewsapp.models.Source

class SourceConverter {


    @TypeConverter
    fun toSource(json: String) : Source = App.gson.fromJson(json, Source::class.java)

    @TypeConverter
    fun fromSource(source: Source): String = App.gson.toJson(source)
//
//    @TypeConverter
//    fun fromListToString(value: List<Source>): String {
//        val gson = Gson()
//        val type = object : TypeToken<List<Source>>() {}.type
//        return gson.toJson(value, type)
//    }
//
//    @TypeConverter
//    fun toListFromString(value: String) : List<Source>{
//        val gson = Gson()
//        val type = object : TypeToken<List<Source>>() {}.type
//        return gson.fromJson(value, type)
//    }
}