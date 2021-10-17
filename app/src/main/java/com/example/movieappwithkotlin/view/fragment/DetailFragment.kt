package com.example.movieappwithkotlin.view.fragment

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.example.movieappwithkotlin.Credentials
import com.example.movieappwithkotlin.R
import com.example.movieappwithkotlin.databinding.FragmentDetailBinding
import com.example.movieappwithkotlin.viewmodel.DetailViewModel
import java.lang.String

class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding
    lateinit var detailViewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        setViewModel()
        observer()
        return binding.root
    }

    private fun setViewModel() {
        detailViewModel = ViewModelProvider(this)[DetailViewModel::class.java]
        binding.detailViewModel = detailViewModel
    }

    private fun observer() {
        if (requireArguments().getString("mediaType") == "tv") {
            getTVData(requireArguments().getInt("id"))
        } else {
            getMovieData(requireArguments().getInt("id"))
        }
    }

    private fun getTVData(id: Int) {
        Log.d("Loger", "observer tv: $id")
        detailViewModel.getTVDetail(id).observe(viewLifecycleOwner) {
            if (it != null) {
                binding.textviewOverviewFragmentDetail.text = it.overview
                binding.textviewLanguageFragmentDetail.text = it.original_language
                binding.textviewDateFragmentDetail.text = it.first_air_date
                binding.textviewTitleFragmentDetail.text = it.name
                binding.textviewVoteFragmentDetail.text = String.valueOf(it.vote_average)
                Glide.with(requireContext())
                    .load(Credentials.poster_base_url + it.posterPath)
                    .into(binding.roundedImageviewFragmentDetail)
            }
        }
    }

    private fun getMovieData(id: Int) {
        Log.d("Loger", "observer movie: $id")

        detailViewModel.getMovieDetail(id).observe(viewLifecycleOwner, {
            if (it != null) {
                binding.textviewOverviewFragmentDetail.text = it.overview
                binding.textviewLanguageFragmentDetail.text = it.original_language
                binding.textviewDateFragmentDetail.text = it.release_date
                binding.textviewTitleFragmentDetail.text = it.title
                binding.textviewVoteFragmentDetail.text = String.valueOf(it.vote_average)
                Glide.with(requireContext())
                    .load(Credentials.poster_base_url + it.posterPath)
                    .into(binding.roundedImageviewFragmentDetail)
            }
        })
    }

}