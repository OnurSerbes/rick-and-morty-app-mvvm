package com.example.rickandmortyapi_kotlin.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapi_kotlin.R
import com.example.rickandmortyapi_kotlin.model.Character
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_item.view.*
import kotlinx.android.synthetic.main.fragment_card.*


class MyAdapter: RecyclerView.Adapter<MyAdapter.ViewHolder>()  {

    private var characterList = emptyList<Character>() //TODO try listOf instead of emptyList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Picasso.get().load(characterList[position].image).into(holder.itemView.imageView) // inserting images
        holder.itemView.tx_name.text = characterList[position].name //for names

        holder.itemView.setOnClickListener { view ->

            //we will use safe args to intent our arguments easily to destination fragment
            //we need to assign an argument from navigation components

            val action = ListFragmentDirections.actionListFragmentToCardFragment(characterList[position])
            view.findNavController().navigate(action)

        }
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    fun setCharacters(character: List<Character>){
        characterList = character
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}

