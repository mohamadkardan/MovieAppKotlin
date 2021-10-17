package com.example.movieappwithkotlin.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.example.movieappwithkotlin.R
import com.example.movieappwithkotlin.adapter.TopRatesAdapter
import com.example.movieappwithkotlin.adapter.TrendingAdapter
import com.example.movieappwithkotlin.adapter.UpComingAdapter
import com.example.movieappwithkotlin.databinding.FragmentHomeBinding
import com.example.movieappwithkotlin.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var trendingAdapter: TrendingAdapter
    private lateinit var upComingAdapter: UpComingAdapter
    private lateinit var topRatesAdapter: TopRatesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        setViewModel()
        setRecyclerview()
        observer()
        return binding.root
    }

    private fun setViewModel() {
        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
    }

    private fun setRecyclerview() {
        setAdapters()

//        setup trends recyclerview
        binding.discreteScrollViewFragmentHome.adapter = trendingAdapter

        binding.recyclerviewUpcomingFragmentHome.layoutManager =
            LinearLayoutManager(requireContext(), HORIZONTAL, false)
        binding.recyclerviewUpcomingFragmentHome.adapter = upComingAdapter

        binding.recyclerviewTopRatedFragmentHome.layoutManager =
            LinearLayoutManager(requireContext(), HORIZONTAL, false)
        binding.recyclerviewTopRatedFragmentHome.adapter = topRatesAdapter
    }

    private fun setAdapters() {
        trendingAdapter = TrendingAdapter()
        upComingAdapter = UpComingAdapter()
        topRatesAdapter = TopRatesAdapter()
    }

    private fun observer() {
        observeTrends()
        observeUpComings()
        observeTopRates()
    }

    private fun observeTrends() {
        homeViewModel.getTrends().observe(viewLifecycleOwner, {
            if (it != null) {
                trendingAdapter.addTrendingList(it)
            }
        })
    }

    private fun observeUpComings() {
        homeViewModel.getUpComings().observe(viewLifecycleOwner, {
            upComingAdapter.addUpComingsList(it)
        })
    }

    private fun observeTopRates() {
        homeViewModel.getTopRates().observe(viewLifecycleOwner, {
            topRatesAdapter.addTopRatesList(it)
        })
    }
}