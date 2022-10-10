package com.itscatalano.capstonenewsapp.request

import com.squareup.moshi.Json

class NewsDataRequest (
    @field:Json(name = "q") val q: String,
    @field:Json(name = "from") val from: String,
    @field:Json(name = "sortBy") val sortBy: String? = null,
    @field:Json(name = "apiKey") val apiKey: String? = null
)