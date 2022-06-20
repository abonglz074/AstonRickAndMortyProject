package com.mytestprogram.astonrickandmortyproject.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mytestprogram.astonrickandmortyproject.data.models.Character

class CharacterDetailsViewModel: ViewModel() {


    private val _characterDetails = MutableLiveData<Character>()
    var characterDetails: LiveData<Character> = _characterDetails



}