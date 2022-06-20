package com.mytestprogram.astonrickandmortyproject.screens

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mytestprogram.astonrickandmortyproject.data.models.Character
import com.mytestprogram.astonrickandmortyproject.data.models.CharactersListResponse
import com.mytestprogram.astonrickandmortyproject.data.network.CharactersRepository
import com.mytestprogram.astonrickandmortyproject.data.network.NetworkInstance
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListCharactersViewModel: ViewModel() {


    private val _charactersList = MutableLiveData<CharactersListResponse>()
    val character: LiveData<CharactersListResponse> = _charactersList

    init {
        getAllCharacters()
    }

    private fun getAllCharacters() = viewModelScope.launch {
        NetworkInstance.retrofit.getAllCharacters().let { response ->

            if (response.isSuccessful) {
                _charactersList.postValue(response.body())
            } else {
                Log.d("ListCharactersFragment", "Loading error: ${response.code()}")
            }
        }
    }


}