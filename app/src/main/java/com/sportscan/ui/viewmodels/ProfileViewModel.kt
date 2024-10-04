package com.sportscan.ui.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProfileViewModel : ViewModel() {

    private val _sectionName = MutableStateFlow("")
    val sectionName = _sectionName.asStateFlow()
    fun updateSectionName(sectionName: String) {
        _sectionName.value = sectionName }


    private val _selectedSport = MutableStateFlow("Type of sport")
    val selectedSport = _selectedSport.asStateFlow()
    fun updateSelectedSport(selectedSport: String) {
        _selectedSport.value = selectedSport }

    private val _address = MutableStateFlow("")
    val address = _address.asStateFlow()
    fun updateAddress(address: String) {
        _address.value = address }


    private val _ageOfClient = MutableStateFlow("Age of client")
    val ageOfClient = _ageOfClient.asStateFlow()
    fun updateAgeOfClient(ageOfClient: String) {
        _ageOfClient.value = ageOfClient }


    private val _costOfLesson = MutableStateFlow("")
    val costOfLesson = _costOfLesson.asStateFlow()
    fun updateCostOfLesson(costOfLesson: String) {
        _costOfLesson.value = costOfLesson }


    private val _workGraphic = MutableStateFlow("Work graphic")
    val workGraphic = _workGraphic.asStateFlow()
    fun updateWorkGraphic(workGraphic: String) {
        _workGraphic.value = workGraphic }


    fun updateAllFields(allFields: String = "") {
        _sectionName.value = allFields
        _selectedSport.value = allFields
        _address.value = allFields
        _ageOfClient.value = allFields
        _costOfLesson.value = allFields
        _workGraphic.value = allFields
    }

}