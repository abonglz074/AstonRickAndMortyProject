package com.mytestprogram.astonrickandmortyproject.screens.locations

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mytestprogram.astonrickandmortyproject.data.models.alllocationsresponse.LocationsListResponse
import com.mytestprogram.astonrickandmortyproject.data.network.NetworkInstance
import kotlinx.coroutines.launch

class ListLocationsViewModel: ViewModel() {

    private val _locationsList = MutableLiveData<LocationsListResponse>()
    val locationsList: LiveData<LocationsListResponse> = _locationsList

    init {
        getAllLocations()
    }

    private fun getAllLocations() = viewModelScope.launch {
        NetworkInstance.retrofit.getAllLocations().let { response ->
            if (response.isSuccessful) {
                _locationsList.postValue(response.body())
            } else {
                Log.d("ListLocationsFragment", "Loading error: ${response.code()}")
            }
        }
    }


}