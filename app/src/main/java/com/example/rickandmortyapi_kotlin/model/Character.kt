package com.example.rickandmortyapi_kotlin.model

import android.os.Parcelable
import com.example.rickandmortyapi_kotlin.model.Location
import com.example.rickandmortyapi_kotlin.model.Origin
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin, //TODO
    val location: Location, //TODO
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String,
): Parcelable
