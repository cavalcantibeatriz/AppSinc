package com.example.appassinc

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {
    const val BASE_URL = "https://61c71fed90318500175472ff.mockapi.io/api/"
    fun getIntance(): Retrofit{
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create())
            .build()

    }
}