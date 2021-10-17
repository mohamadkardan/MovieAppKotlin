package com.example.movieappwithkotlin.response

import com.example.movieappwithkotlin.model.Trend
import com.google.gson.annotations.SerializedName

data class TrendingResponse(
    @SerializedName("page") var page: Int,
    @SerializedName("results") var results: List<Trend>
)