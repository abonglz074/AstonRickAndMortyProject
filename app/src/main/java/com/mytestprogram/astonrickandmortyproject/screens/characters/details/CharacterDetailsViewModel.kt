package com.mytestprogram.astonrickandmortyproject.screens.characters.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mytestprogram.astonrickandmortyproject.data.models.allcharactersresponse.SingleCharacter
import com.mytestprogram.astonrickandmortyproject.data.models.allepisodesresponse.EpisodesListResponse
import com.mytestprogram.astonrickandmortyproject.data.models.allepisodesresponse.SingleEpisode
import com.mytestprogram.astonrickandmortyproject.data.network.NetworkInstance
import kotlinx.coroutines.launch

class CharacterDetailsViewModel: ViewModel() {

    private val _characterDetails = MutableLiveData<SingleCharacter>()
    var characterDetails: LiveData<SingleCharacter> = _characterDetails

    private val _episodeDetails = MutableLiveData<List<SingleEpisode>>()
    var episodeDetails: LiveData<List<SingleEpisode>> = _episodeDetails


    fun loadCharacterDetailsData(characterId: Int) = viewModelScope.launch {
        NetworkInstance.retrofit.getCharacterById(characterId).let { response ->
            if (response.isSuccessful) {
                _characterDetails.postValue(response.body())
            } else {
                Log.d("CharacterDetailFragment", "Loading Error: ${response.code()}")
            }
        }
    }

    fun loadMultipleEpisodes(episodeId: List<Int>) = viewModelScope.launch {
        NetworkInstance.retrofit.getMultipleEpisodesById(episodeId).let { response ->
            if (response.isSuccessful) {
                _episodeDetails.postValue(response.body())
            } else {
                Log.d("CharacterDetailFragment", "Loading Error: ${response.code()}")
            }
        }
    }





}