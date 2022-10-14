package com.itscatalano.capstonenewsapp.database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.itscatalano.capstonenewsapp.App
import com.itscatalano.capstonenewsapp.models.CategoryType
import com.itscatalano.capstonenewsapp.models.Source

class CategoryConverter {

//    @TypeConverter
//    fun fromCategory(categoryType: CategoryType): String = App.gson.toJson(categoryType)
//
//    @TypeConverter
//    fun toCategory(json: String): CategoryType = App.gson.fromJson(json, CategoryType::class.java)




//    @TypeConverter
//    fun fromListToString(value: List<CategoryType>): String {
//        val gson = Gson()
//        val type = object : TypeToken<List<CategoryType>>() {}.type
//        return gson.toJson(value, type)
//    }
//
//    @TypeConverter
//    fun toListFromString(value: String) : List<CategoryType>{
//        val gson = Gson()
//        val type = object : TypeToken<List<CategoryType>>() {}.type
//        return gson.fromJson(value, type)
//    }
}