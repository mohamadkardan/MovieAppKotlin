package com.example.movieappwithkotlin.model

import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.movieappwithkotlin.Credentials
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.makeramen.roundedimageview.RoundedImageView
import java.util.*

data class Trend(
    @SerializedName("id") @Expose val id: Int,
    @SerializedName("poster_path") @Expose
    var posterPath: String,
    @SerializedName("name") @Expose
    var name: String,
    @SerializedName("original_title") @Expose
    var title: String,
    @SerializedName("media_type") @Expose
    var mediaType: String,
    @SerializedName("genre_ids") @Expose
    private var genreIdList: ArrayList<Int?>
) {

    companion object {
        @JvmStatic
        @BindingAdapter("android:imageUrl")
        fun loadImage(imageView: RoundedImageView, url: String) {
            Glide.with(imageView).load(Credentials.poster_base_url + url).into(imageView)
        }
    }

}