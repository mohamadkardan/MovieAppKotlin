package com.example.movieappwithkotlin.response

import com.example.movieappwithkotlin.model.Movie
import com.google.gson.annotations.SerializedName

class MovieResponse(
    @SerializedName("page") val page: String,
    @SerializedName("results") val results: List<Movie>
)