package com.itscatalano.capstonenewsapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/***
 * Author: Anthony Catalano
 * Data class to hold the source of the Articles
 * This is part of the Articles data class and is represented as a
 * pair in the JSON
 *
 */
@Parcelize
data class Source(val id: String? = null, val name: String, val description: String, val url: String, val category:CategoryType , val language:LanguageType , val country: CountryType) :
    Parcelable


