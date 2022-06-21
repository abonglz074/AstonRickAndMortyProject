package com.mytestprogram.astonrickandmortyproject.screens.locations.lists

import com.mytestprogram.astonrickandmortyproject.data.models.alllocationsresponse.SingleLocation

interface ListLocationsActionListener {

    fun onLocationDetailsScreen(singleLocation: SingleLocation)
}