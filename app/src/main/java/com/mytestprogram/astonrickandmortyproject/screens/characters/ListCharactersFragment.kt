package com.mytestprogram.astonrickandmortyproject.screens.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.mytestprogram.astonrickandmortyproject.databinding.FragmentListCharactersBinding

class ListCharactersFragment : Fragment() {

    private lateinit var binding: FragmentListCharactersBinding
    private lateinit var adapter: ListCharactersAdapter
    private val viewModel: ListCharactersViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListCharactersBinding.inflate(inflater, container, false)

        adapter = ListCharactersAdapter()

        binding.charactersListRecyclerview.layoutManager = GridLayoutManager(context, 2)
        binding.charactersListRecyclerview.adapter = adapter

        viewModel.character.observe(viewLifecycleOwner, Observer {
            adapter.characters = viewModel.character.value!!.results
        })

        return binding.root
    }


}