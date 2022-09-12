/*
package com.itscatalano.capstonenewsapp

import android.os.Parcel
import android.os.Parcelable

class NewsList(val name: String , val news: ArrayList<String> = ArrayList()) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.createStringArrayList()!!

    ) {
    }

    companion object CREATOR: Parcelable.Creator<NewsList>{
        override fun createFromParcel(source: Parcel): NewsList = NewsList(source)
        override fun newArray(size: Int): Array<NewsList?> = arrayOfNulls(size)

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeStringList(news)
    }

    override fun describeContents(): Int {
        return 0
    }



}

*/