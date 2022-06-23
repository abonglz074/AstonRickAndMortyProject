package com.mytestprogram.astonrickandmortyproject.screens.episodes.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.mytestprogram.astonrickandmortyproject.MainActivity
import com.mytestprogram.astonrickandmortyproject.databinding.FragmentEpisodesDetailsBinding
import com.mytestprogram.astonrickandmortyproject.screens.characters.lists.ListCharactersActionListener
import com.mytestprogram.astonrickandmortyproject.screens.locations.details.LocationDetailsFragment
import com.mytestprogram.astonrickandmortyproject.screens.navigator

class EpisodeDetailsFragment : Fragment() {

    private lateinit var binding: FragmentEpisodesDetailsBinding
    private lateinit var adapter: EpisodeDetailsAdapter
    private val viewModel: EpisodeDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadEpisodeDetailsData(requireArguments().getInt(ARG_EPISODE_ID))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEpisodesDetailsBinding.inflate(layoutInflater, container, false)
        (requireActivity() as MainActivity).bottomNavigationGone()

        adapter = EpisodeDetailsAdapter(object: ListCharactersActionListener{
            override fun onCharacterDetailsScreen(characterId: Int) {
                navigator().showCharacterDetails(characterId)
            }
        })
        binding.episodeDetailsCharactersRecyclerview.layoutManager = GridLayoutManager(context, 2)
        binding.episodeDetailsCharactersRecyclerview.adapter = adapter

        viewModel.episodeDetails.observe(viewLifecycleOwner, Observer {
            binding.episodeName.text = viewModel.episodeDetails.value!!.name
            binding.episodeNumber.text = viewModel.episodeDetails.value!!.episode
            binding.episodeAirdate.text = viewModel.episodeDetails.value!!.air_date

            val characterUrlsList: List<String> = viewModel.episodeDetails.value!!.characters
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

        private const val ARG_EPISODE_ID = "ARG_EPISODE_ID"

        fun newInstance(id: Int): EpisodeDetailsFragment {
            val args = Bundle()

            val fragment = EpisodeDetailsFragment()
            fragment.arguments = bundleOf(ARG_EPISODE_ID to id)
            return fragment
        }
    }

}