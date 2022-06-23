package com.mytestprogram.astonrickandmortyproject.screens.locations.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.mytestprogram.astonrickandmortyproject.databinding.FragmentListLocationsBinding
import com.mytestprogram.astonrickandmortyproject.databinding.FragmentLocationDetailsBinding
import com.mytestprogram.astonrickandmortyproject.screens.characters.details.CharacterDetailsFragment
import com.mytestprogram.astonrickandmortyproject.screens.characters.lists.ListCharactersActionListener
import com.mytestprogram.astonrickandmortyproject.screens.navigator

class LocationDetailsFragment: Fragment() {

    private lateinit var binding: FragmentLocationDetailsBinding
    private lateinit var adapter: LocationDetailsAdapter
    private val viewModel: LocationDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadLocationDetailsData(requireArguments().getInt(ARG_LOCATION_ID))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLocationDetailsBinding.inflate(layoutInflater, container, false)


        adapter = LocationDetailsAdapter(object : ListCharactersActionListener{
            override fun onCharacterDetailsScreen(characterId: Int) {
                navigator().showCharacterDetails(characterId)
            }
        })
        binding.locationDetailsCharactersRecyclerview.layoutManager = GridLayoutManager(context, 2)
        binding.locationDetailsCharactersRecyclerview.adapter = adapter

        viewModel.locationDetails.observe(viewLifecycleOwner, Observer {
            binding.locationName.text = viewModel.locationDetails.value!!.name
            binding.locationDimension.text = viewModel.locationDetails.value!!.dimension
            binding.locationsType.text = viewModel.locationDetails.value!!.type

            val characterUrlsList: List<String> = viewModel.locationDetails.value!!.residents
            val characterIds = mutableListOf<Int>()
            characterUrlsList.forEach { i ->
                characterIds.add(i.substring(42).toInt())
            }
            viewModel.loadMultipleCharactersDetails(characterIds)

            viewModel.characterDetails.observe(viewLifecycleOwner, Observer {
                adapter.characters = viewModel.characterDetails.value!!
            })
        })


        return binding.root
    }

    companion object {

        private const val ARG_LOCATION_ID = "ARG_LOCATION_ID"

        fun newInstance(id: Int): LocationDetailsFragment {
            val args = Bundle()

            val fragment = LocationDetailsFragment()
            fragment.arguments = bundleOf(ARG_LOCATION_ID to id)
            return fragment
        }
    }

}