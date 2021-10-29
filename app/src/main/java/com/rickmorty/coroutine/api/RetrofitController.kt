package com.rickmorty.coroutine.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitController {
    companion object {
        private const val BASE_URL = "https://rickandmortyapi.com/"

        fun getRetrofit(): Requests {
            return Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(Requests::class.java)
        }
    }
}