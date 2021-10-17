package com.example.movieappwithkotlin.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.movieappwithkotlin.Credentials
import com.example.movieappwithkotlin.model.Movie
import com.example.movieappwithkotlin.model.TV
import com.example.movieappwithkotlin.model.Trend
import com.example.movieappwithkotlin.request.Service
import com.example.movieappwithkotlin.response.MovieResponse
import com.example.movieappwithkotlin.response.TrendingResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository {
    companion object {
        fun requestGetTrends(): MutableLiveData<List<Trend>> {
            val mutableLiveData: MutableLiveData<List<Trend>> = MutableLiveData()
            val call: Call<TrendingResponse> =
                Service.getApiService().getTrendingMovies("tv", "day", Credentials.api_key)

            call.enqueue(object : Callback<TrendingResponse> {
                override fun onResponse(
                    call: Call<TrendingResponse>,
                    response: Response<TrendingResponse>
                ) {
                    if (response.isSuccessful) {
                        mutableLiveData.postValue(response.body()?.results)
                    }
                }

                override fun onFailure(call: Call<TrendingResponse>, t: Throwable) {
                    Log.d("log", "onFailure: $t")
                }
            })

            return mutableLiveData
        }

        fun requestGetUpComings(): MutableLiveData<List<Movie>> {
            val mutableLiveData: MutableLiveData<List<Movie>> = MutableLiveData()
            val call: Call<MovieResponse> =
                Service.getApiService().getUpcomingMovies(Credentials.api_key)
            call.enqueue(object : Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    if (response.isSuccessful) {
                        mutableLiveData.postValue(response.body()?.results)
                    }
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    Log.d("onFailure", "onFailure: $t")
                }
            })
            return mutableLiveData
        }

        fun requestGetTopRated(): MutableLiveData<List<Movie>> {
            val mutableLiveData: MutableLiveData<List<Movie>> = MutableLiveData()
            val call: Call<MovieResponse> =
                Service.getApiService().getTopRatedMovies(Credentials.api_key)

            call.enqueue(object : Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    if (response.isSuccessful) {
                        mutableLiveData.postValue(response.body()?.results)
                    }
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    Log.d("onFailure", "onFailure: $t")
                }
            })

            return mutableLiveData
        }

        fun requestGetMovieDetail(movieID: Int): MutableLiveData<Movie> {
            val mutableLiveData: MutableLiveData<Movie> = MutableLiveData()
            val call: Call<Movie?>? = Service.getApiService().getMovie(movieID, Credentials.api_key)
            call?.enqueue(object : Callback<Movie?> {
                override fun onResponse(call: Call<Movie?>, response: Response<Movie?>) {
                    if (response.isSuccessful) {
                        mutableLiveData.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<Movie?>, t: Throwable) {
                    Log.d("onFailure", "onFailure: $t")
                }
            })

            return mutableLiveData
        }

        fun requestGetTVDetail(tvID: Int): MutableLiveData<TV> {
            val mutableLiveData: MutableLiveData<TV> = MutableLiveData()
            val call: Call<TV?>? = Service.getApiService().getTVShow(tvID, Credentials.api_key)
            call?.enqueue(object : Callback<TV?> {
                override fun onResponse(call: Call<TV?>, response: Response<TV?>) {
                    if (response.isSuccessful) {
                        mutableLiveData.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<TV?>, t: Throwable) {
                    Log.d("onFailure", "onFailure: $t")
                }
            })

            return mutableLiveData
        }
    }
}