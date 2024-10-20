package com.sportscan.ui.viewmodels

import android.net.Uri
import androidx.compose.ui.state.ToggleableState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProfileViewModel : ViewModel() {

    private val _uriList = MutableStateFlow<List<Uri>>(emptyList())
    val uriList = _uriList.asStateFlow()
    fun updateUriList(uris: List<Uri>) {
        _uriList.value = uris
    }

    private val _sectionName = MutableStateFlow("")
    val sectionName = _sectionName.asStateFlow()
    fun updateSectionName(sectionName: String) {
        _sectionName.value = sectionName
    }


    private val _selectedSport = MutableStateFlow("")
    val selectedSport = _selectedSport.asStateFlow()
    fun updateSelectedSport(selectedSport: String) {
        _selectedSport.value = selectedSport
    }


    private val _address = MutableStateFlow("")
    val address = _address.asStateFlow()
    fun updateAddress(address: String) {
        _address.value = address
    }


    private val _ageOfClient = MutableStateFlow("Возраст клиента")
    val ageOfClient = _ageOfClient.asStateFlow()
    fun updateAgeOfClient(ageOfClient: String) {
        _ageOfClient.value = ageOfClient
    }


    private val _costOfLesson = MutableStateFlow("")
    val costOfLesson = _costOfLesson.asStateFlow()
    private val _costPeriod = MutableStateFlow("в/")
    val costPeriod = _costPeriod.asStateFlow()
    fun updateCostOfLesson(costOfLesson: String) {
        _costOfLesson.value = costOfLesson
    }

    fun updateCostPeriod(selectedPeriod: String) {
        _costPeriod.value = selectedPeriod
    }


    private val _workGraphic = MutableStateFlow("Рабочий график")
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


    private val _checkedCash = MutableStateFlow(ToggleableState.Off)
    val checkedCash = _checkedCash.asStateFlow()
    fun updateCheckedCash(checkedCash: ToggleableState) {
        _checkedCash.value = checkedCash
    }


    private val _checkedCard = MutableStateFlow(ToggleableState.Off)
    val checkedCard = _checkedCard.asStateFlow()
    fun updateCheckedCard(checkedCard: ToggleableState) {
        _checkedCard.value = checkedCard
    }


    private val _checkedOnlinePayment = MutableStateFlow(ToggleableState.Off)
    val checkedOnlinePayment = _checkedOnlinePayment.asStateFlow()
    fun updateCheckedOnlinePayment(checkedOnlinePayment: ToggleableState) {
        _checkedOnlinePayment.value = checkedOnlinePayment
    }


    private val _checkedQR = MutableStateFlow(ToggleableState.Off)
    val checkedQR = _checkedQR.asStateFlow()
    fun updateCheckedQR(checkedQR: ToggleableState) {
        _checkedQR.value = checkedQR
    }


    private val _siteAddress = MutableStateFlow("")
    val siteAddress = _siteAddress.asStateFlow()
    fun updateSiteAddress(siteAddress: String) {
        _siteAddress.value = siteAddress
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


    private val _vk = MutableStateFlow("")
    val vk = _vk.asStateFlow()
    fun updateVk(vk: String) {
        _vk.value = vk
    }


    private val _telegram = MutableStateFlow("")
    val telegram = _telegram.asStateFlow()
    fun updateTelegram(telegram: String) {
        _telegram.value = telegram
    }


    private val _ok = MutableStateFlow("")
    val ok = _ok.asStateFlow()
    fun updateOk(ok: String) {
        _ok.value = ok
    }


    private val _youtube = MutableStateFlow("")
    val youtube = _youtube.asStateFlow()
    fun updateYoutube(youtube: String) {
        _youtube.value = youtube
    }


    private val _ruTube = MutableStateFlow("")
    val ruTube = _ruTube.asStateFlow()
    fun updateRuTube(ruTube: String) {
        _ruTube.value = ruTube
    }


    private val _dzen = MutableStateFlow("")
    val dzen = _dzen.asStateFlow()
    fun updateDzen(dzen: String) {
        _dzen.value = dzen
    }


    fun updateAllFields(
        resetValue: String = "",
        uriList: List<Uri> = emptyList(),
        ageOfClient: String = "Возраст клиента",
        costPeriod: String = "в/",
        workGraphic: String = "Рабочий график",
        isSelected: Boolean = false,
        checked: ToggleableState = ToggleableState.Off
    ) {
        _uriList.value = uriList
        _sectionName.value = resetValue
        _selectedSport.value = resetValue
        _address.value = resetValue
        _ageOfClient.value = ageOfClient
        _costOfLesson.value = resetValue
        _costPeriod.value = costPeriod
        _workGraphic.value = workGraphic
        _about.value = resetValue
        _isSelectedDoc.value = isSelected
        _isSelectedDorCertReq.value = isSelected
        _isSelectedAbilityMedCert.value = isSelected
        _isSelectedCerfFromOtherDocs.value = isSelected
        _checkedCash.value = checked
        _checkedCard.value = checked
        _checkedOnlinePayment.value = checked
        _checkedQR.value = checked
        _siteAddress.value = resetValue
        _email.value = resetValue
        _phone.value = resetValue
        _vk.value = resetValue
        _telegram.value = resetValue
        _ok.value = resetValue
        _youtube.value = resetValue
        _ruTube.value = resetValue
    }
}