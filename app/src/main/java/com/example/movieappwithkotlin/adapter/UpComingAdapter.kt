package com.example.movieappwithkotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movieappwithkotlin.R
import com.example.movieappwithkotlin.databinding.ItemStandardMovieBinding
import com.example.movieappwithkotlin.model.Movie
import com.example.movieappwithkotlin.viewmodel.HomeViewModel

class UpComingAdapter : RecyclerView.Adapter<UpComingAdapter.ViewHolder>() {

    private var upcomingList: List<Movie> = ArrayList()

    fun addUpComingsList(upcomingList: List<Movie>) {
        this.upcomingList = upcomingList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemStandardMovieBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_standard_movie, parent, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie: Movie = upcomingList[position]
        holder.binding.movie = movie
        holder.binding.viewModel = HomeViewModel()
    }

    override fun getItemCount(): Int {
        return upcomingList.size
    }

    class ViewHolder(val binding: ItemStandardMovieBinding) :
        RecyclerView.ViewHolder(binding.root)

}