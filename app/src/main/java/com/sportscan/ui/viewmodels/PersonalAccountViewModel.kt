package com.sportscan.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PersonalAccountViewModel : ViewModel() {
    private val _age = MutableStateFlow("")
    val age = _age.asStateFlow()

    fun updateAge(newAge: String) {
        viewModelScope.launch {
            _age.value = newAge
        }
    }

}