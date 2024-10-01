package com.sportscan.ui.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProfileViewModel : ViewModel() {

    private val _sectionName = MutableStateFlow("")
    val sectionName = _sectionName.asStateFlow()
    fun updateSectionName(sectionName: String) {
        _sectionName.value = sectionName }


    private val _isExpandedSportType = MutableStateFlow(false)
    val isExpandedSportType = _isExpandedSportType.asStateFlow()
    fun updateExpandedSportType(isExpandedSportType: Boolean) {
        _isExpandedSportType.value = isExpandedSportType }
    private val _selectedSport = MutableStateFlow("Type of sport")
    val selectedSport = _selectedSport.asStateFlow()
    fun updateSelectedSport(selectedSport: String) {
        _selectedSport.value = selectedSport }


    private val _isExpandedAgeOfClient = MutableStateFlow(false)
    val isExpandedAgeOfClient = _isExpandedAgeOfClient.asStateFlow()
    fun updateExpandedAgeOfClient(isExpandedAgeOfClient: Boolean) {
        _isExpandedAgeOfClient.value = isExpandedAgeOfClient }
    private val _ageOfClient = MutableStateFlow("Age of client")
    val ageOfClient = _ageOfClient.asStateFlow()
    fun updateAgeOfClient(ageOfClient: String) {
        _ageOfClient.value = ageOfClient }


    private val _costOfLesson = MutableStateFlow("")
    val costOfLesson = _costOfLesson.asStateFlow()
    fun updateCostOfLesson(costOfLesson: String) {
        _costOfLesson.value = costOfLesson }


    private val _isExpandedWorkGraphic = MutableStateFlow(false)
    val isExpandedWorkGraphic = _isExpandedWorkGraphic.asStateFlow()
    fun updateExpandedWorkGraphic(isExpandedWorkGraphic: Boolean) {
        _isExpandedWorkGraphic.value = isExpandedWorkGraphic }
    private val _day = MutableStateFlow("day...")
    val day = _day.asStateFlow()
    fun updateDay(day: String) {
        _day.value = day }

}