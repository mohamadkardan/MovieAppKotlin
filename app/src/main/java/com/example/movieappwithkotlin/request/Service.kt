package com.example.movieappwithkotlin.request

import android.util.Log
import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Service {

    companion object {

        private lateinit var instance: Service

        fun getInstance(): Service {
            return Service()
        }

        private fun getClient(): OkHttpClient {
            val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            return OkHttpClient.Builder().addInterceptor(interceptor).build()
        }

        private val retrofitBuilder: Retrofit.Builder = Retrofit.Builder()
            .client(getClient())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(com.example.movieappwithkotlin.Credentials.base_url)

        private val retrofit: Retrofit = retrofitBuilder.build()

        private val apiService: ApiService = retrofit.create(ApiService::class.java)

        fun getApiService(): ApiService {
            return apiService
        }

    }

}