package com.sportscan.ui.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProfileViewModel : ViewModel() {

    private val _isExpanded = MutableStateFlow(false)
    val isExpanded = _isExpanded.asStateFlow()

    fun updateIsExpanded(isExpanded: Boolean) {
        _isExpanded.value = isExpanded
    }


    private val _selectedSport = MutableStateFlow("Type of sport")
    val selectedSport = _selectedSport.asStateFlow()

    fun updateSelectedSport(selectedSport: String) {
        _selectedSport.value = selectedSport
    }


    private val _ageOfClient = MutableStateFlow("Age of client")
    val ageOfClient = _ageOfClient.asStateFlow()

    fun updateAgeOfClient(ageOfClient: String) {
        _ageOfClient.value = ageOfClient
    }


    private val _costOfLesson = MutableStateFlow("per...")
    val costOfLesson = _costOfLesson.asStateFlow()

    fun updateCostOfLesson(costOfLesson: String) {
        _costOfLesson.value = costOfLesson
    }


    private val _from = MutableStateFlow("")
    val from = _from.asStateFlow()

    fun updateFrom(from: String) {
        _from.value = from
    }


    private val _to = MutableStateFlow("")
    val to = _to.asStateFlow()

    fun updateTo(to: String) {
        _to.value = to
    }


    private val _day = MutableStateFlow("day...")
    val day = _day.asStateFlow()

    fun updateDay(day: String) {
        _day.value = day
    }
}