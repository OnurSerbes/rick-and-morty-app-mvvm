package com.example.rickandmortyapi_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_card.view.*
import kotlinx.android.synthetic.main.fragment_list.view.*

class CardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_card, container, false)

        view.tx_previous.setOnClickListener { Navigation.findNavController(view).navigate(R.id.action_cardFragment_to_list_fragment) }

        return view
    }

}