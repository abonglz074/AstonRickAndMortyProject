package com.mytestprogram.astonrickandmortyproject.screens

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.mytestprogram.astonrickandmortyproject.databinding.FragmentCharactersDetailsBinding

class CharacterDetailsFragment: Fragment() {

    private lateinit var binding: FragmentCharactersDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    companion object {

        private const val ARG_CONTACT_ID = "ARG_CONTACT_ID"

        fun newInstance(id: Long): CharacterDetailsFragment {
            val args = Bundle()

            val fragment = CharacterDetailsFragment()
            fragment.arguments = bundleOf(ARG_CONTACT_ID to id)
            return fragment
        }
    }
}