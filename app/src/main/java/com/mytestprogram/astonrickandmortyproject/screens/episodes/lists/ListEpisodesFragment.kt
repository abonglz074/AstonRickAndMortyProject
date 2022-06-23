package com.mytestprogram.astonrickandmortyproject.screens.episodes.lists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.mytestprogram.astonrickandmortyproject.MainActivity
import com.mytestprogram.astonrickandmortyproject.data.models.allepisodesresponse.SingleEpisode
import com.mytestprogram.astonrickandmortyproject.databinding.FragmentListEpisodesBinding
import com.mytestprogram.astonrickandmortyproject.screens.navigator

class ListEpisodesFragment : Fragment() {

    private lateinit var binding: FragmentListEpisodesBinding
    private lateinit var adapter: ListEpisodesAdapter
    private val viewModel: ListEpisodesViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListEpisodesBinding.inflate(inflater, container, false)
        (requireActivity() as MainActivity).bottomNavigationVisible()

        adapter = ListEpisodesAdapter(object : ListEpisodesActionListener {
            override fun showEpisodeDetailsScreen(episodeId: Int) {
                navigator().showEpisodeDetails(episodeId)
            }
        })
        binding.listEpisodesRecyclerviewItem.layoutManager = GridLayoutManager(context, 2)
        binding.listEpisodesRecyclerviewItem.adapter = adapter

        viewModel.episodesList.observe(viewLifecycleOwner, Observer {
            adapter.episodes = viewModel.episodesList.value!!.results
        })
        return binding.root
    }
}