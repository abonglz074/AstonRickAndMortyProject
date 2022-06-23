package com.mytestprogram.astonrickandmortyproject.screens.characters.lists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.mytestprogram.astonrickandmortyproject.MainActivity
import com.mytestprogram.astonrickandmortyproject.data.models.allcharactersresponse.SingleCharacter
import com.mytestprogram.astonrickandmortyproject.databinding.FragmentListCharactersBinding
import com.mytestprogram.astonrickandmortyproject.screens.navigator

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
        (requireActivity() as MainActivity).bottomNavigationVisible()


        adapter = ListCharactersAdapter(object : ListCharactersActionListener {
            override fun onCharacterDetailsScreen(characterId: Int) {
                navigator().showCharacterDetails(characterId)
            }

        })

        binding.charactersListRecyclerview.layoutManager = GridLayoutManager(context, 2)
        binding.charactersListRecyclerview.adapter = adapter

        viewModel.character.observe(viewLifecycleOwner, Observer {
            adapter.characters = viewModel.character.value!!.results
        })

        return binding.root
    }

}