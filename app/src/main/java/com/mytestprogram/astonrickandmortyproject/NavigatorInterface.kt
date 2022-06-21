package com.mytestprogram.astonrickandmortyproject

import com.mytestprogram.astonrickandmortyproject.data.models.allcharactersresponse.SingleCharacter
import com.mytestprogram.astonrickandmortyproject.data.models.alllocationsresponse.SingleLocation

interface NavigatorInterface {

    fun showLocationsList()

    fun showEpisodesList()

    fun showCharacterDetails(singleCharacter: SingleCharacter)

    fun showLocationDetails(singleLocation: SingleLocation)

    fun showEpisodeDetails()

    fun goBack()



}