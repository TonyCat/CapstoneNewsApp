/*package com.itscatalano.capstonenewsapp

import android.content.Context
import android.preference.PreferenceManager


class NewsDataManager (private val context: Context){

    fun saveNews(list: NewsList){
        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context)

        sharedPrefs.edit().putStringSet(list.name,list.news.toHashSet()).commit()


    }

    fun readNews(): ArrayList<Article>{
        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context)

        val contents = sharedPrefs.all
        val newsLists = ArrayList<NewsList>()

        for (taskList in contents){
            val newsItems = ArrayList(taskList.value as HashSet<String>)
            val list = NewsList(taskList.key,newsItems)
            newsLists.add(list)
        }

        return newsLists
    }
}*/