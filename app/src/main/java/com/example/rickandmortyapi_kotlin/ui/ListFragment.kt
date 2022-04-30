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
import kotlinx.android.synthetic.main.fragment_list.view.*


class ListFragment : Fragment() {

    private val viewModel: ViewModel by activityViewModels{ViewModelFactory(Repository())} //it will implement the viewModel
    var myAdapter = MyAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupObserver()

    }


    private fun setupRecyclerView() {
        //my layout will include two column to show recyclerView items
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.adapter = myAdapter

    }

    private fun setupObserver() {
        //this code block will add the characters from api to the recyclerView
        viewModel.myResponse.observe(viewLifecycleOwner) {
            myAdapter.setCharacters(it)
            Log.d(TAG, "my response $it ")
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel.getCharacterList(1)
    }

}