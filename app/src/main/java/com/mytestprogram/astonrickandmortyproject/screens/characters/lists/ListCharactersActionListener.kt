package com.mytestprogram.astonrickandmortyproject.screens.characters.lists

import com.mytestprogram.astonrickandmortyproject.data.models.allcharactersresponse.SingleCharacter
import com.mytestprogram.astonrickandmortyproject.data.models.alllocationsresponse.SingleLocation

interface ListCharactersActionListener {

    fun onCharacterDetailsScreen(singleCharacter: SingleCharacter)

}