package com.example.rickandmortyapi_kotlin.api

import com.example.rickandmortyapi_kotlin.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) // we will use Gson in here to convert json to kotlin class
            .build()
    }

    val api: CharacterAPI by lazy{
        retrofit.create(CharacterAPI::class.java)
    }
}