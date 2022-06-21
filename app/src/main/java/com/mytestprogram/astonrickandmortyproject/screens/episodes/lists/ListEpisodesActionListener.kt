package com.mytestprogram.astonrickandmortyproject.screens.episodes.lists

import com.mytestprogram.astonrickandmortyproject.data.models.allepisodesresponse.SingleEpisode

interface ListEpisodesActionListener {

    fun showEpisodeDetailsScreen(singleEpisode: SingleEpisode)
}