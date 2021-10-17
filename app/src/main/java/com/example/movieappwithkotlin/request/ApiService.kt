package com.example.movieappwithkotlin.request

import com.example.movieappwithkotlin.model.Movie
import com.example.movieappwithkotlin.model.TV
import com.example.movieappwithkotlin.response.MovieResponse
import com.example.movieappwithkotlin.response.TrendingResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("3/trending/{media_type}/{time_window}")
    fun getTrendingMovies(
        @Path("media_type") media_type: String,
        @Path("time_window") time_window: String,
        @Query("api_key") api_key: String
    ): Call<TrendingResponse>

    @GET("3/movie/upcoming")
    fun getUpcomingMovies(@Query("api_key") api_key: String): Call<MovieResponse>

    @GET("3/movie/top_rated")
    fun getTopRatedMovies(@Query("api_key") api_key: String): Call<MovieResponse>

    @GET("3/tv/{tv_id}")
    fun getTVShow(@Path("tv_id") tvID: Int?, @Query("api_key") apiKey: String?): Call<TV?>?

    @GET("3/movie/{movie_id}")
    fun getMovie(@Path("movie_id") movieID: Int?, @Query("api_key") apiKey: String?): Call<Movie?>?

}