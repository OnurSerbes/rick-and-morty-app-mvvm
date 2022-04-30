package com.example.rickandmortyapi_kotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.rickandmortyapi_kotlin.repository.Repository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapi_kotlin.model.Character
import kotlinx.coroutines.launch

class ViewModel (private val repository: Repository): ViewModel() {


    var myResponse = MutableLiveData<List<Character>>()

    fun getCharacterList(page: Int) {
        viewModelScope.launch{
            val response = repository.getCharacterList(page)
            myResponse.value = response.result
        }
    }

    fun getCharacterByName(name: String){
        viewModelScope.launch{
            val response = repository.getCharactersByName(name)
            myResponse.value = response.result
        }
    }


}