
package com.itscatalano.capstonenewsapp.models


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class NewsList(val name: String , val news: ArrayList<String> = ArrayList()) : Parcelable

