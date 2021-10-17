package com.example.movieappwithkotlin.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.movieappwithkotlin.model.Movie
import com.example.movieappwithkotlin.model.TV
import com.example.movieappwithkotlin.repository.MovieRepository

class DetailViewModel : ViewModel() {
    private lateinit var liveDataMovie: MutableLiveData<Movie>
    private lateinit var liveDataTV: MutableLiveData<TV>

    fun getMovieDetail(id: Int): LiveData<Movie> {
        liveDataMovie = MutableLiveData()
        if (liveDataMovie != MovieRepository.requestGetMovieDetail(id)) {
            liveDataMovie = MovieRepository.requestGetMovieDetail(id)
        }
        return liveDataMovie
    }

    fun getTVDetail(id: Int): LiveData<TV> {
        liveDataTV = MutableLiveData()
        if (liveDataTV != MovieRepository.requestGetTVDetail(id)) {
            liveDataTV = MovieRepository.requestGetTVDetail(id)
        }
        return liveDataTV
    }

    fun backOnClick(view: View) {
        Navigation.findNavController(view).popBackStack()
    }

}