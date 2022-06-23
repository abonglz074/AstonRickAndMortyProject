package com.mytestprogram.astonrickandmortyproject

interface NavigatorInterface {

    fun showCharactersList()

    fun showLocationsList()

    fun showEpisodesList()

    fun showCharacterDetails(characterId: Int)

    fun showLocationDetails(locationId: Int)

    fun showEpisodeDetails(episodeId: Int)

    fun goBack()



}