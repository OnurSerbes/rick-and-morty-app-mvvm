package com.example.rickandmortyapi_kotlin.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.rickandmortyapi_kotlin.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_card.*
import kotlinx.android.synthetic.main.fragment_card.view.*

class CardFragment : Fragment(R.layout.fragment_card) {

    //we need to implement our args from navArgs
    private val args: CardFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val character = args.character

        tx_name.text = character.name
        tx_status.text = character.status
        tx_location.text = character.location.name
        Picasso.get().load(character.image).into(card_image)

    }

}