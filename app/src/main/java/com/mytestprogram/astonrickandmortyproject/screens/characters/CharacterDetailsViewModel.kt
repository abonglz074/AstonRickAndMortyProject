package com.mytestprogram.astonrickandmortyproject.screens.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CharacterDetailsViewModel: ViewModel() {

    private val _characterDetails = MutableLiveData<Character>()
    var characterDetails: LiveData<Character> = _characterDetails





}