package com.itscatalano.capstonenewsapp.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.util.*


/***
 * Author: Anthony Catalano
 * Data class to hold the source of the Articles
 * This is part of the Articles data class and is represented as a
 * pair in the JSON
 *
 */
@Parcelize
@Entity(tableName="sources")
data class Source(

    val id: String? = null,
    @PrimaryKey
    val name: String,
    val description: String? = null,
    val url: String?  = null,
    val category: CategoryType? = CategoryType.business,
    val language: LanguageType? = LanguageType.all,
    val country: CountryType? = CountryType.us):
    Parcelable


