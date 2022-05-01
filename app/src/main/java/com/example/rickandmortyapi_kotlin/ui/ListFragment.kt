package com.example.rickandmortyapi_kotlin.ui

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.rickandmortyapi_kotlin.R
import com.example.rickandmortyapi_kotlin.repository.Repository
import com.example.rickandmortyapi_kotlin.viewmodel.ViewModel
import com.example.rickandmortyapi_kotlin.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment(R.layout.fragment_list) {

    private val viewModel: ViewModel by activityViewModels{ViewModelFactory(Repository())} //it will implement the viewModel
    var myAdapter = MyAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupObserver()

    }


    private fun setupRecyclerView() {
        Log.d(TAG, "setupRecyclerView: start")
        //my layout will include two column to show recyclerView items
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.adapter = myAdapter
        Log.d(TAG, "setupRecyclerView: ends")

    }

    private fun setupObserver() {
        Log.d(TAG, "setupObserver: starts")
        //this code block will add the characters from api to the recyclerView
        viewModel.myResponse.observe(viewLifecycleOwner) {
//            myAdapter.setCharacters(it)
            it?.let { nonNull -> myAdapter.setCharacters(nonNull) }
            Log.d(TAG, "my response $it ")
        }
        Log.d(TAG, "setupObserver: ends")
    }

    override fun onAttach(context: Context) {
        Log.d(TAG, "onAttach: starts")
        super.onAttach(context)
        viewModel.getCharacterList(2)
        Log.d(TAG, "onAttach: ends")
    }
}