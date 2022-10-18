package com.itscatalano.capstonenewsapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.itscatalano.capstonenewsapp.dao.ArticleDao
import com.itscatalano.capstonenewsapp.dao.ArticleSourceDao
import com.itscatalano.capstonenewsapp.dao.SourceDao
import com.itscatalano.capstonenewsapp.database.converters.SourceConverter
import com.itscatalano.capstonenewsapp.models.Article
import com.itscatalano.capstonenewsapp.models.Source


const val DATABASE_VERSION = 1

@Database(
    entities = [Article::class , Source::class],
    version = DATABASE_VERSION
)
@TypeConverters(SourceConverter::class)

abstract class NewsDatabase : RoomDatabase() {

    companion object {
        private const val DATABASE_NAME = "NewsDatabase"

        fun buildDatabase(context: Context): NewsDatabase {
            return Room.databaseBuilder(
                context,
                NewsDatabase::class.java,
                DATABASE_NAME
            )
                .allowMainThreadQueries()
                .build()
        }

    }
    abstract fun articleDao(): ArticleDao

    abstract fun articleSourceDao(): ArticleSourceDao

    abstract fun sourceDao(): SourceDao
}