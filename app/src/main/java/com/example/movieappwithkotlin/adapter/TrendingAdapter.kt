package com.example.movieappwithkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movieappwithkotlin.R
import com.example.movieappwithkotlin.databinding.ItemCardTrendBinding
import com.example.movieappwithkotlin.model.Trend
import com.example.movieappwithkotlin.viewmodel.HomeViewModel

class TrendingAdapter : RecyclerView.Adapter<TrendingAdapter.ViewHolder>() {

    private var trends: List<Trend> = ArrayList()

    fun addTrendingList(trends: List<Trend>) {
        this.trends = trends
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingAdapter.ViewHolder {
        val binding: ItemCardTrendBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_card_trend, parent, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrendingAdapter.ViewHolder, position: Int) {
        val trend: Trend = trends[position]
        holder.binding.trend = trend
        holder.binding.viewModel = HomeViewModel()
    }

    override fun getItemCount(): Int {
        return trends.size
    }

    class ViewHolder(val binding: ItemCardTrendBinding) : RecyclerView.ViewHolder(binding.root)
}