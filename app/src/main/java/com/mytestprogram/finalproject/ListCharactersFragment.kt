package com.mytestprogram.finalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mytestprogram.finalproject.databinding.FragmentListCharactersBinding


class ListCharactersFragment : Fragment() {

    private lateinit var binding: FragmentListCharactersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }
}