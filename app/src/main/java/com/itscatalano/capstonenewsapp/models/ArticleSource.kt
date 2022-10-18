package com.itscatalano.capstonenewsapp.models

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Relation
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArticleSource(
    @Embedded
    val article: Article,
    @Relation(
        parentColumn = "title",
        entityColumn = "name"
    )
    val source: Source

) : Parcelable
