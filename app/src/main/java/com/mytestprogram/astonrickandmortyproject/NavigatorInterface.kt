package com.mytestprogram.astonrickandmortyproject

import android.content.Context

interface NavigatorInterface {

    fun showLocationsList()

    fun showEpisodesList()

    fun showCharacterDetails(characterId: Int)

    fun showLocationDetails()

    fun showEpisodeDetails()


}