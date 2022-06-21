package com.mytestprogram.astonrickandmortyproject

import android.content.Context
import com.mytestprogram.astonrickandmortyproject.data.models.allcharactersresponse.SingleCharacter

interface NavigatorInterface {

    fun showLocationsList()

    fun showEpisodesList()

    fun showCharacterDetails(singleCharacter: SingleCharacter)

    fun showLocationDetails()

    fun showEpisodeDetails()


}