package com.example.androidapp.search

import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SearchViewModel : ViewModel() {

    var searchQuery by mutableStateOf("")
        private set

    fun updateSearchQuery(searchedString: String){
        searchQuery = searchedString
    }

}