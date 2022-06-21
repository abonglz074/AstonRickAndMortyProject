package com.mytestprogram.astonrickandmortyproject.screens.locations.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mytestprogram.astonrickandmortyproject.data.models.alllocationsresponse.SingleLocation
import com.mytestprogram.astonrickandmortyproject.data.network.NetworkInstance
import kotlinx.coroutines.launch

class LocationDetailsViewModel: ViewModel() {

    private val _locationDetails = MutableLiveData<SingleLocation>()
    val locationDetails: LiveData<SingleLocation> = _locationDetails

    fun loadLocationDetailsData(locationId: Int) = viewModelScope.launch {
        NetworkInstance.retrofit.getLocationById(locationId).let { response ->
            if (response.isSuccessful) {
                _locationDetails.postValue(response.body())
            } else {
                Log.d("LocationDetailsFragment", "Loading error: ${response.code()}")
            }
        }
    }
}