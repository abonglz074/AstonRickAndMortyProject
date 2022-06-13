package com.mytestprogram.astonrickandmortyproject.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mytestprogram.astonrickandmortyproject.databinding.FragmentListLocationsBinding


class ListLocationsFragment : Fragment() {


    private lateinit var binding: FragmentListLocationsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListLocationsBinding.inflate(inflater, container, false)
        return binding.root
    }
}