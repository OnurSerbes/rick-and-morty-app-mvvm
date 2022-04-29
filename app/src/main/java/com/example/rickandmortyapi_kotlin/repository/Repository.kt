package com.example.rickandmortyapi_kotlin.repository

import com.example.rickandmortyapp.api.RetrofitInstance
import com.example.rickandmortyapi_kotlin.model.CharacterList

class Repository {

    suspend fun getCharacterList(page: Int): CharacterList {
        return RetrofitInstance.api.getCharactersList(page)
    }

    suspend fun getCharactersByName(name: String): CharacterList {
        return RetrofitInstance.api.getCharactersByName(name)
    }
}