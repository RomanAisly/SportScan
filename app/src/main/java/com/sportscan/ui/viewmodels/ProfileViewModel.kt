package com.sportscan.ui.viewmodels

import android.net.Uri
import androidx.compose.ui.state.ToggleableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

data class ProfileState(
    val isLoading: Boolean = false,
    val uriList: List<Uri> = emptyList(),
    val sectionName: String = "",
    val selectedSport: String = "",
    val address: String = "",
    val ageOfClient: String = "Возраст клиента",
    val costOfLesson: String = "",
    val costPeriod: String = "в/",
    val workGraphic: String = "Рабочий график",
    val about: String = "",
    val isSelectedDoc: Boolean = false,
    val isSelectedDorCertReq: Boolean = false,
    val isSelectedAbilityMedCert: Boolean = false,
    val isSelectedCerfFromOtherDocs: Boolean = false,
    val checkedCash: ToggleableState = ToggleableState.Off,
    val checkedCard: ToggleableState = ToggleableState.Off,
    val checkedOnlinePayment: ToggleableState = ToggleableState.Off,
    val checkedQR: ToggleableState = ToggleableState.Off,
    val siteAddress: String = "",
    val email: String = "",
    val phone: String = "",
    val vk: String = "",
    val telegram: String = "",
    val ok: String = "",
    val youtube: String = "",
    val ruTube: String = "",
    val dzen: String = ""
)

class ProfileViewModel : ViewModel() {

    private val _state = MutableStateFlow(ProfileState())
    val state: StateFlow<ProfileState> = _state.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = ProfileState()
    )

    fun updateUriList(uris: List<Uri>) {
        _state.value = _state.value.copy(uriList = uris)
    }

    fun updateSectionName(sectionName: String) {
        _state.value = _state.value.copy(sectionName = sectionName)
    }

    fun updateSelectedSport(selectedSport: String) {
        _state.value = _state.value.copy(selectedSport = selectedSport)
    }

    fun updateAddress(address: String) {
        _state.value = _state.value.copy(address = address)
    }

    fun updateAgeOfClient(ageOfClient: String) {
        _state.value = _state.value.copy(ageOfClient = ageOfClient)
    }

    fun updateCostOfLesson(costOfLesson: String) {
        _state.value = _state.value.copy(costOfLesson = costOfLesson)
    }

    fun updateCostPeriod(costPeriod: String) {
        _state.value = _state.value.copy(costPeriod = costPeriod)
    }

    fun updateWorkGraphic(workGraphic: String) {
        _state.value = _state.value.copy(workGraphic = workGraphic)
    }

    fun updateAbout(about: String) {
        _state.value = _state.value.copy(about = about)
    }

    fun updateIsSelectedDoc(isSelectedDoc: Boolean) {
        _state.value = _state.value.copy(isSelectedDoc = isSelectedDoc)
    }

    fun updateIsSelectedDorCertReq(isSelectedDorCertReq: Boolean) {
        _state.value = _state.value.copy(isSelectedDorCertReq = isSelectedDorCertReq)
    }

    fun updateIsSelectedAbilityMedCert(isSelectedAbilityMedCert: Boolean) {
        _state.value = _state.value.copy(isSelectedAbilityMedCert = isSelectedAbilityMedCert)
    }

    fun updateIsSelectedCerfFromOtherDocs(isSelectedCerfFromOtherDocs: Boolean) {
        _state.value = _state.value.copy(isSelectedCerfFromOtherDocs = isSelectedCerfFromOtherDocs)
    }

    fun updateCheckedCash(checkedCash: ToggleableState) {
        _state.value = _state.value.copy(checkedCash = checkedCash)
    }

    fun updateCheckedCard(checkedCard: ToggleableState) {
        _state.value = _state.value.copy(checkedCard = checkedCard)
    }

    fun updateCheckedOnlinePayment(checkedOnlinePayment: ToggleableState) {
        _state.value = _state.value.copy(checkedOnlinePayment = checkedOnlinePayment)
    }

    fun updateCheckedQR(checkedQR: ToggleableState) {
        _state.value = _state.value.copy(checkedQR = checkedQR)
    }

    fun updateSiteAddress(siteAddress: String) {
        _state.value = _state.value.copy(siteAddress = siteAddress)
    }

    fun updateEmail(email: String) {
        _state.value = _state.value.copy(email = email)
    }

    fun updatePhone(phone: String) {
        _state.value = _state.value.copy(phone = phone)
    }

    fun updateVk(vk: String) {
        _state.value = _state.value.copy(vk = vk)
    }

    fun updateTelegram(telegram: String) {
        _state.value = _state.value.copy(telegram = telegram)
    }

    fun updateOk(ok: String) {
        _state.value = _state.value.copy(ok = ok)
    }

    fun updateYoutube(youtube: String) {
        _state.value = _state.value.copy(youtube = youtube)
    }

    fun updateRuTube(ruTube: String) {
        _state.value = _state.value.copy(ruTube = ruTube)
    }

    fun updateDzen(dzen: String) {
        _state.value = _state.value.copy(dzen = dzen)
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
        _state.value = _state.value.copy(
            sectionName = resetValue,
            uriList = uriList,
            selectedSport = resetValue,
            address = resetValue,
            ageOfClient = ageOfClient,
            costOfLesson = resetValue,
            costPeriod = costPeriod,
            workGraphic = workGraphic,
            about = resetValue,
            isSelectedDoc = isSelected,
            isSelectedDorCertReq = isSelected,
            isSelectedAbilityMedCert = isSelected,
            isSelectedCerfFromOtherDocs = isSelected,
            checkedCash = checked,
            checkedCard = checked,
            checkedOnlinePayment = checked,
            checkedQR = checked,
            siteAddress = resetValue,
            email = resetValue,
            phone = resetValue,
            vk = resetValue,
            telegram = resetValue,
            ok = resetValue,
            youtube = resetValue,
            ruTube = resetValue,
            dzen = resetValue
        )
    }
}