package com.mytestprogram.astonrickandmortyproject

interface NavigatorInterface {

    fun showLocationsList()

    fun showEpisodesList()

    fun showCharacterDetails(characterId: kotlin.Int)

    fun showLocationDetails(locationId: kotlin.Int)

    fun showEpisodeDetails(episodeId: kotlin.Int)

    fun goBack()



}