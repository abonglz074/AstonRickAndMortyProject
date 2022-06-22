package com.mytestprogram.astonrickandmortyproject.screens.locations.lists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.mytestprogram.astonrickandmortyproject.databinding.FragmentListLocationsBinding
import com.mytestprogram.astonrickandmortyproject.screens.navigator

class ListLocationsFragment: Fragment() {

    private lateinit var binding: FragmentListLocationsBinding
    private lateinit var adapter: ListLocationsAdapter
    private val viewModel: ListLocationsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListLocationsBinding.inflate(inflater, container, false)

        adapter = ListLocationsAdapter(object : ListLocationsActionListener {
            override fun onLocationDetailsScreen(locationId: Int) {
                navigator().showLocationDetails(locationId)
            }
        })
        binding.listLocationsRecyclerview.layoutManager = GridLayoutManager(context, 2)
        binding.listLocationsRecyclerview.adapter = adapter

        viewModel.locationsList.observe(viewLifecycleOwner, Observer {
            adapter.locations = viewModel.locationsList.value!!.results
        })

        return binding.root
    }


}