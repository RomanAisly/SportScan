package com.sportscan.ui.viewmodels

import androidx.compose.ui.state.ToggleableState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProfileViewModel : ViewModel() {

    private val _sectionName = MutableStateFlow("")
    val sectionName = _sectionName.asStateFlow()
    fun updateSectionName(sectionName: String) {
        _sectionName.value = sectionName
    }


    private val _selectedSport = MutableStateFlow("Type of sport")
    val selectedSport = _selectedSport.asStateFlow()
    fun updateSelectedSport(selectedSport: String) {
        _selectedSport.value = selectedSport
    }


    private val _address = MutableStateFlow("")
    val address = _address.asStateFlow()
    fun updateAddress(address: String) {
        _address.value = address
    }


    private val _ageOfClient = MutableStateFlow("Age of client")
    val ageOfClient = _ageOfClient.asStateFlow()
    fun updateAgeOfClient(ageOfClient: String) {
        _ageOfClient.value = ageOfClient
    }


    private val _costOfLesson = MutableStateFlow("")
    val costOfLesson = _costOfLesson.asStateFlow()
    private val _costPeriod = MutableStateFlow("per/")
    val costPeriod = _costPeriod.asStateFlow()
    fun updateCostOfLesson(costOfLesson: String) {
        _costOfLesson.value = costOfLesson
    }

    fun updateCostPeriod(selectedPeriod: String) {
        _costPeriod.value = selectedPeriod
    }


    private val _workGraphic = MutableStateFlow("Work graphic")
    val workGraphic = _workGraphic.asStateFlow()
    fun updateWorkGraphic(workGraphic: String) {
        _workGraphic.value = workGraphic
    }


    private val _about = MutableStateFlow("")
    val about = _about.asStateFlow()
    fun updateAbout(about: String) {
        _about.value = about
    }


    private val _isSelectedDoc = MutableStateFlow(false)
    val isSelectedDoc = _isSelectedDoc.asStateFlow()
    fun updateSelectedDoc(isSelectedDoc: Boolean) {
        _isSelectedDoc.value = isSelectedDoc
    }


    private val _isSelectedDorCertReq = MutableStateFlow(false)
    val isSelectedDorCertReq = _isSelectedDorCertReq.asStateFlow()
    fun updateSelectedDorCertReq(isSelectedDorCertReq: Boolean) {
        _isSelectedDorCertReq.value = isSelectedDorCertReq
    }


    private val _isSelectedAbilityMedCert = MutableStateFlow(false)
    val isSelectedAbilityMedCert = _isSelectedAbilityMedCert.asStateFlow()
    fun updateSelectedAbilityMedCert(isSelectedAbilityMedCert: Boolean) {
        _isSelectedAbilityMedCert.value = isSelectedAbilityMedCert
    }


    private val _isSelectedCerfFromOtherDocs = MutableStateFlow(false)
    val isSelectedCerfFromOtherDocs = _isSelectedCerfFromOtherDocs.asStateFlow()
    fun updateSelectedCerfFromOtherDocs(isSelectedCerfFromOtherDocs: Boolean) {
        _isSelectedCerfFromOtherDocs.value = isSelectedCerfFromOtherDocs
    }


    private val _checked = MutableStateFlow(ToggleableState.Off)
    val checked = _checked.asStateFlow()
    fun updateChecked(checked: ToggleableState) {
        _checked.value = checked
    }


    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()
    fun updateEmail(email: String) {
        _email.value = email
    }


    private val _phone = MutableStateFlow("")
    val phone = _phone.asStateFlow()
    fun updatePhone(phone: String) {
        _phone.value = phone
    }


    private val _siteAddress = MutableStateFlow("")
    val siteAddress = _siteAddress.asStateFlow()
    fun updateSiteAddress(siteAddress: String) {
        _siteAddress.value = siteAddress
    }


    fun updateAllFields(
        allClear: String = "",
        selectedSport: String = "Type of sport",
        ageOfClient: String = "Age of client",
        costPeriod: String = "per/",
        workGraphic: String = "Work graphic",
        isSelected: Boolean = false,
        checked: ToggleableState = ToggleableState.Off
    ) {
        _sectionName.value = allClear
        _selectedSport.value = selectedSport
        _address.value = allClear
        _ageOfClient.value = ageOfClient
        _costOfLesson.value = allClear
        _costPeriod.value = costPeriod
        _workGraphic.value = workGraphic
        _about.value = allClear
        _isSelectedDoc.value = isSelected
        _isSelectedDorCertReq.value = isSelected
        _isSelectedAbilityMedCert.value = isSelected
        _isSelectedCerfFromOtherDocs.value = isSelected
        _checked.value = checked
        _email.value = allClear
        _phone.value = allClear
        _siteAddress.value = allClear

    }
}