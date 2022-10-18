package com.itscatalano.capstonenewsapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.itscatalano.capstonenewsapp.models.Source


@Dao
interface SourceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSources(source: Source)

    @Query("SELECT * FROM sources")
    suspend fun getSources(): Source


    @Query("DELETE FROM sources")
    suspend fun deleteSources()
}
