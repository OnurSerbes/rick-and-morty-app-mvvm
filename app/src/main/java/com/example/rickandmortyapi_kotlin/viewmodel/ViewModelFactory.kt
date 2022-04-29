package com.example.rickandmortyapi_kotlin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmortyapi_kotlin.repository.Repository


class ViewModelFactory (private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return com.example.rickandmortyapi_kotlin.viewmodel.ViewModel(repository) as T
    }
}