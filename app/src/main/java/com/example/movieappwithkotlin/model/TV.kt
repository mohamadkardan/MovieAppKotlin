package com.example.movieappwithkotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

class TV(
    @SerializedName("id") @Expose
    val id: String,
    @SerializedName("poster_path") @Expose
    var posterPath: String,
    @SerializedName("name") @Expose
    var name: String,
    @SerializedName("original_title") @Expose
    var title: String,
    @SerializedName("first_air_date") @Expose
    var first_air_date: String,
    @SerializedName("genre_ids") @Expose
    var genreIdList: ArrayList<Int?>,
    @SerializedName("vote_average") @Expose
    var vote_average: Float,
    @SerializedName("original_language") @Expose
    var original_language: String,
    @SerializedName("overview") @Expose
    var overview: String
)