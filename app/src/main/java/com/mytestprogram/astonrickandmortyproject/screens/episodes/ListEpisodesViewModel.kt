package com.mytestprogram.astonrickandmortyproject.screens.episodes

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mytestprogram.astonrickandmortyproject.data.models.allepisodesresponse.EpisodesListResponse
import com.mytestprogram.astonrickandmortyproject.data.models.alllocationsresponse.LocationsListResponse
import com.mytestprogram.astonrickandmortyproject.data.network.NetworkInstance
import kotlinx.coroutines.launch

class ListEpisodesViewModel: ViewModel() {

    private val _episodesList = MutableLiveData<EpisodesListResponse>()
    val episodesList: LiveData<EpisodesListResponse> = _episodesList

    init {
        getAllEpisodes()
    }

    private fun getAllEpisodes() = viewModelScope.launch {
        NetworkInstance.retrofit.getAllEpisodes().let { response ->
            if (response.isSuccessful) {
                _episodesList.postValue(response.body())
            } else {
                Log.d("ListLocationsFragment", "Loading error: ${response.code()}")
            }
        }
    }
}