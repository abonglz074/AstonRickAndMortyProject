package com.mytestprogram.astonrickandmortyproject.screens.locations.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mytestprogram.astonrickandmortyproject.data.models.allcharactersresponse.SingleCharacter
import com.mytestprogram.astonrickandmortyproject.data.models.alllocationsresponse.SingleLocation
import com.mytestprogram.astonrickandmortyproject.data.network.NetworkInstance
import kotlinx.coroutines.launch

class LocationDetailsViewModel: ViewModel() {

    private val _locationDetails = MutableLiveData<SingleLocation>()
    val locationDetails: LiveData<SingleLocation> = _locationDetails

    private val _characterDetails = MutableLiveData<List<SingleCharacter>>()
    val characterDetails: LiveData<List<SingleCharacter>> = _characterDetails

    fun loadLocationDetailsData(locationId: kotlin.Int) = viewModelScope.launch {
        NetworkInstance.retrofit.getLocationById(locationId).let { response ->
            if (response.isSuccessful) {
                _locationDetails.postValue(response.body())
            } else {
                Log.d("LocationDetailsFragment", "Loading error: ${response.code()}")
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