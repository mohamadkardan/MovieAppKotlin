package com.example.movieappwithkotlin.viewmodel

import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.movieappwithkotlin.R
import com.example.movieappwithkotlin.model.Movie
import com.example.movieappwithkotlin.model.Trend
import com.example.movieappwithkotlin.repository.MovieRepository

class HomeViewModel : ViewModel() {
    private lateinit var trendLiveData: MutableLiveData<List<Trend>>
    private lateinit var upcomingLiveData: MutableLiveData<List<Movie>>
    private lateinit var topRatesLiveData: MutableLiveData<List<Movie>>

    fun getTrends(): LiveData<List<Trend>> {
        trendLiveData = MutableLiveData()
        if (trendLiveData != MovieRepository.requestGetTrends()) {
            trendLiveData = MovieRepository.requestGetTrends()
        }
        return trendLiveData
    }

    fun getUpComings(): LiveData<List<Movie>> {
        upcomingLiveData = MutableLiveData()
        if (upcomingLiveData != MovieRepository.requestGetUpComings()) {
            upcomingLiveData = MovieRepository.requestGetUpComings()
        }
        return upcomingLiveData
    }

    fun getTopRates(): LiveData<List<Movie>> {
        topRatesLiveData = MutableLiveData()
        if (topRatesLiveData != MovieRepository.requestGetTopRated()) {
            topRatesLiveData = MovieRepository.requestGetTopRated()
        }

        return topRatesLiveData
    }

    fun onClickTrendItems(view: View, trend: Trend) {
        val bundle = Bundle()
        bundle.putInt("id", trend.id)
        bundle.putString("mediaType", trend.mediaType)
        Navigation.findNavController(view).navigate(R.id.detailFragment, bundle)
    }

    fun onClickMovieItems(view: View, movie: Movie) {
        val bundle = Bundle()
        bundle.putInt("id", movie.id)
        bundle.putString("mediaType", "movie")
        Navigation.findNavController(view).navigate(R.id.detailFragment, bundle)
    }

}