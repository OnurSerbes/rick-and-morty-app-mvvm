package com.example.rickandmortyapp.api

import com.example.rickandmortyapi_kotlin.model.CharacterList
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterAPI {

    //query for all characters
    @GET("api/character")
    suspend fun getCharactersList(
        @Query("page") page: Int
    ): CharacterList

    //query by name filter
    @GET("api/character")
    suspend fun getCharactersByName(@Query("name") name : String): CharacterList
}