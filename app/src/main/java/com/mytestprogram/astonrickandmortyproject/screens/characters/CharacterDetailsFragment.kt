package com.mytestprogram.astonrickandmortyproject.screens.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.mytestprogram.astonrickandmortyproject.databinding.FragmentCharactersDetailsBinding

class CharacterDetailsFragment: Fragment() {

    private lateinit var binding: FragmentCharactersDetailsBinding
    private val viewModel: CharacterDetailsViewModel by viewModels()

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

        viewModel.characterDetails.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            binding.characterDetailsName.text = viewModel.characterDetails.value!!.name
            binding.characterDetailsGender.text = viewModel.characterDetails.value!!.gender
            binding.characterDetailsLocation.text = viewModel.characterDetails.value!!.location.name
            binding.characterDetailsOrigin.text = viewModel.characterDetails.value!!.origin.name
            binding.characterDetailsSpecies.text = viewModel.characterDetails.value!!.species
            binding.characterDetailsStatus.text = viewModel.characterDetails.value!!.status
            Glide.with(binding.characterDetailsImageview.context)
                .load(viewModel.characterDetails.value!!.image)
                .into(binding.characterDetailsImageview)
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