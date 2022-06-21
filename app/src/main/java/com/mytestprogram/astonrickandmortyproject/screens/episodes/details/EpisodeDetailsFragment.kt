package com.mytestprogram.astonrickandmortyproject.screens.episodes.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.mytestprogram.astonrickandmortyproject.databinding.FragmentEpisodesDetailsBinding

class EpisodeDetailsFragment : Fragment() {

    private lateinit var binding: FragmentEpisodesDetailsBinding
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

        viewModel.episodeDetails.observe(viewLifecycleOwner, Observer {
            binding.episodeName.text = viewModel.episodeDetails.value!!.name
            binding.episodeNumber.text = viewModel.episodeDetails.value!!.episode
            binding.episodeAirdate.text = viewModel.episodeDetails.value!!.air_date
        })
        return binding.root
    }

    companion object {
        private const val ARG_EPISODE_ID = "ARG_EPISODE_ID"
        fun newInstance(id: Int): EpisodeDetailsFragment {
            val args = Bundle()
            ARG_EPISODE_ID to id
            val fragment = EpisodeDetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }

}