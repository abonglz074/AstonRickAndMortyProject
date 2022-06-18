package com.mytestprogram.astonrickandmortyproject

//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//
//class ListCharactersViewModel(
//    private val repository: CharactersRepository
//) : ViewModel() {
//
//    private val _characters = MutableLiveData<List<Character>>()
//    val character: LiveData<List<Character>> = _characters
//
//    suspend fun getCharacters() {
//        val characters = repository.getCharacters()
//        _characters.value = characters
//    }
//
//}