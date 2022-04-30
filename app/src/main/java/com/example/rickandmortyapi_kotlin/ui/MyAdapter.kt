package com.example.rickandmortyapi_kotlin.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapi_kotlin.R
import com.example.rickandmortyapi_kotlin.model.Character
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_item.view.*

class MyAdapter: RecyclerView.Adapter<MyAdapter.ViewHolder>()  {

    private var characterList = emptyList<Character>() //TODO try listOf instead of emptyList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Picasso.get().load(characterList[position].image).into(holder.itemView.imageView) // inserting images
        holder.itemView.tx_name.text = characterList[position].name //for names

    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}