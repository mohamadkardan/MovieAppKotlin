package com.example.movieappwithkotlin.model

import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.movieappwithkotlin.Credentials
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.makeramen.roundedimageview.RoundedImageView
import java.util.ArrayList

data class Movie(
    @SerializedName("id") @Expose
    val id: Int,
    @SerializedName("poster_path") @Expose
    var posterPath: String,
    @SerializedName("name") @Expose
    var name: String,
    @SerializedName("original_title") @Expose
    var title: String,
    @SerializedName("release_date") @Expose
    var release_date: String,
    @SerializedName("genre_ids") @Expose
    var genreIdList: ArrayList<Int?>,
    @SerializedName("vote_average") @Expose
    var vote_average: Float,
    @SerializedName("original_language") @Expose
    var original_language: String,
    @SerializedName("overview") @Expose
    var overview: String
) {

    companion object {
        @JvmStatic
        @BindingAdapter("android:imageUrl")
        fun loadImage(imageView: RoundedImageView, url: String) {
            Glide.with(imageView).load(Credentials.poster_base_url + url).into(imageView)
        }
    }

}