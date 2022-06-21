package com.mytestprogram.astonrickandmortyproject.screens.characters

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mytestprogram.astonrickandmortyproject.data.models.allcharactersresponse.SingleCharacter
import com.mytestprogram.astonrickandmortyproject.data.network.NetworkInstance
import kotlinx.coroutines.launch

class CharacterDetailsViewModel: ViewModel() {

    private val _characterDetails = MutableLiveData<SingleCharacter>()
    var characterDetails: LiveData<SingleCharacter> = _characterDetails


    fun loadCharacterDetailsData(characterId: Int) = viewModelScope.launch {
        NetworkInstance.retrofit.getCharacterById(characterId).let { response ->
            if (response.isSuccessful) {
                _characterDetails.postValue(response.body())
            } else {
                Log.d("CharacterDetailFragment", "Loading Error: ${response.code()}")
            }
        }
    }





}