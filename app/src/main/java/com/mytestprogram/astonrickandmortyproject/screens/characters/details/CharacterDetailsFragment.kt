package com.mytestprogram.astonrickandmortyproject.screens.characters.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.mytestprogram.astonrickandmortyproject.MainActivity
import com.mytestprogram.astonrickandmortyproject.data.models.allepisodesresponse.SingleEpisode
import com.mytestprogram.astonrickandmortyproject.databinding.FragmentCharactersDetailsBinding
import com.mytestprogram.astonrickandmortyproject.screens.episodes.lists.ListEpisodesActionListener
import com.mytestprogram.astonrickandmortyproject.screens.navigator

class CharacterDetailsFragment : Fragment() {

    private lateinit var binding: FragmentCharactersDetailsBinding
    private val viewModel: CharacterDetailsViewModel by viewModels()
    private lateinit var adapter: CharacterDetailsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadCharacterDetailsData(requireArguments().getInt(ARG_CHARACTER_ID))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharactersDetailsBinding.inflate(layoutInflater, container, false)
        (requireActivity() as MainActivity).bottomNavigationGone()



        adapter = CharacterDetailsAdapter(object : ListEpisodesActionListener {
            override fun showEpisodeDetailsScreen(episodeId: Int) {
                navigator().showEpisodeDetails(episodeId)
            }
        })


        binding.characterDetailsRecyclerviewEpisodes.layoutManager = LinearLayoutManager(context)
        binding.characterDetailsRecyclerviewEpisodes.adapter = adapter

        viewModel.characterDetails.observe(viewLifecycleOwner, Observer {
            binding.characterDetailsName.text = viewModel.characterDetails.value!!.name
            binding.characterDetailsGender.text = viewModel.characterDetails.value!!.gender
            binding.characterDetailsLocation.text = viewModel.characterDetails.value!!.location.name
            binding.characterDetailsOrigin.text = viewModel.characterDetails.value!!.origin.name
            binding.characterDetailsSpecies.text = viewModel.characterDetails.value!!.species
            binding.characterDetailsStatus.text = viewModel.characterDetails.value!!.status
            Glide.with(binding.characterDetailsImageview.context)
                .load(viewModel.characterDetails.value!!.image)
                .into(binding.characterDetailsImageview)

            val locationUrl = viewModel.characterDetails.value!!.location.url
            val locationId = locationUrl.substring(41).toInt()
            binding.characterDetailsLocation.setOnClickListener {
                navigator().showLocationDetails(locationId)
            }
            binding.characterDetailsOrigin.setOnClickListener {
                navigator().showLocationDetails(locationId)
            }


            val episodesUrlsList: List<String> = viewModel.characterDetails.value!!.episode
            val episodeIds = mutableListOf<Int>()
            episodesUrlsList.forEach { i ->
                episodeIds.add(i.substring(40).toInt())
            }
            viewModel.loadMultipleEpisodes(episodeIds)

            viewModel.episodeDetails.observe(viewLifecycleOwner, Observer {
                adapter.episodes = viewModel.episodeDetails.value!!
            })




        })

        return binding.root
    }


    companion object {

        private const val ARG_CHARACTER_ID = "ARG_CHARACTER_ID"

        fun newInstance(id: Int): CharacterDetailsFragment {
            val args = Bundle()

            val fragment = CharacterDetailsFragment()
            fragment.arguments = bundleOf(ARG_CHARACTER_ID to id)
            return fragment
        }
    }
}