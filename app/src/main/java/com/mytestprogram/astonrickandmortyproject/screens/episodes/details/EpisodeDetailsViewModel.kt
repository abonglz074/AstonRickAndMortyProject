package com.mytestprogram.astonrickandmortyproject.screens.episodes.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mytestprogram.astonrickandmortyproject.data.models.allcharactersresponse.SingleCharacter
import com.mytestprogram.astonrickandmortyproject.data.models.allepisodesresponse.SingleEpisode
import com.mytestprogram.astonrickandmortyproject.data.network.NetworkInstance
import kotlinx.coroutines.launch

class EpisodeDetailsViewModel: ViewModel() {

    private val _episodeDetails = MutableLiveData<SingleEpisode>()
    val episodeDetails: LiveData<SingleEpisode> = _episodeDetails

    private val _characterDetails = MutableLiveData<List<SingleCharacter>>()
    val characterDetails: LiveData<List<SingleCharacter>> = _characterDetails

    fun loadEpisodeDetailsData(episodeId: Int) = viewModelScope.launch {
        NetworkInstance.retrofit.getEpisodeById(episodeId).let { response ->
            if (response.isSuccessful) {
                _episodeDetails.postValue(response.body())
            } else {
                Log.d("EpisodeDetailsFragment", "Loading error: ${response.code()}")
            }
        }
    }

    fun loadMultipleCharactersDetails(characterIds: List<Int>) = viewModelScope.launch {
        NetworkInstance.retrofit.getMultipleCharactersById(characterIds).let { response ->
            if (response.isSuccessful) {
                _characterDetails.postValue(response.body())
            } else {
                Log.d("EpisodeDetailsFragment", "Loading error: ${response.code()}")
            }
        }
    }
}