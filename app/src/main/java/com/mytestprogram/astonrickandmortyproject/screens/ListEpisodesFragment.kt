package com.mytestprogram.astonrickandmortyproject.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mytestprogram.astonrickandmortyproject.databinding.FragmentListEpisodesBinding

class ListEpisodesFragment : Fragment() {

    private lateinit var binding: FragmentListEpisodesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListEpisodesBinding.inflate(inflater, container, false)
        return binding.root
    }

}