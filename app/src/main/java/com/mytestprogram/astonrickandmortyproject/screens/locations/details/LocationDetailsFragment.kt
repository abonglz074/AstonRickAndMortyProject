package com.mytestprogram.astonrickandmortyproject.screens.locations.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.mytestprogram.astonrickandmortyproject.databinding.FragmentListLocationsBinding
import com.mytestprogram.astonrickandmortyproject.databinding.FragmentLocationDetailsBinding
import com.mytestprogram.astonrickandmortyproject.screens.characters.details.CharacterDetailsFragment

class LocationDetailsFragment: Fragment() {

    private lateinit var binding: FragmentLocationDetailsBinding
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

        viewModel.locationDetails.observe(viewLifecycleOwner, Observer {
            binding.locationName.text = viewModel.locationDetails.value!!.name
            binding.locationDimension.text = viewModel.locationDetails.value!!.dimension
            binding.locationsType.text = viewModel.locationDetails.value!!.type
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