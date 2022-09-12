package com.itscatalano.capstonenewsapp

import android.content.Context
import android.preference.PreferenceManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class NewsDataManager (private val context: Context){

    fun saveNews(list:List<Article>){
        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context)
        val gson = Gson()

        sharedPrefs.edit().putString("storeAllarticles",gson.toJson(list)).commit()



    }

    fun readNews(): List<Article>{
        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context)

        val storedArticles = sharedPrefs.getString("storeAllarticles", "")

        if (storedArticles.isNullOrEmpty() ){
            return emptyList()
        }

        val gson = Gson()

        return gson.fromJson(storedArticles, object : TypeToken<List<Article>>() {}.type)



    }
}