package com.sportscan.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sportscan.ui.events.ProfileEvents
import com.sportscan.ui.states.ProfileState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn


class ProfileViewModel : ViewModel() {

    private val _state = MutableStateFlow(ProfileState())
    val state: StateFlow<ProfileState> = _state.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = ProfileState()
    )

    fun onEvent(event: ProfileEvents) {
        when (event) {


            is ProfileEvents.UpdateUriList ->
                _state.value = _state.value.copy(uriList = event.uris)


            is ProfileEvents.UpdateSectionName ->
                _state.value = _state.value.copy(sectionName = event.sectionName)

            is ProfileEvents.UpdateSelectedSport -> _state.value =
                _state.value.copy(selectedSport = event.selectedSport)

            is ProfileEvents.UpdateAddress -> _state.value =
                _state.value.copy(address = event.address)

            is ProfileEvents.UpdateAgeOfClient -> _state.value =
                _state.value.copy(ageOfClient = event.ageOfClient)

            is ProfileEvents.UpdateCostOfLesson -> _state.value =
                _state.value.copy(costOfLesson = event.costOfLesson)

            is ProfileEvents.UpdateCostPeriod -> _state.value =
                _state.value.copy(costPeriod = event.costPeriod)

            is ProfileEvents.UpdateWorkGraphic -> _state.value =
                _state.value.copy(workGraphic = event.workGraphic)

            is ProfileEvents.UpdateAbout -> _state.value = _state.value.copy(about = event.about)
            is ProfileEvents.UpdateCheckedCard -> _state.value =
                _state.value.copy(checkedCard = event.checkedCard)

            is ProfileEvents.UpdateCheckedCash -> _state.value =
                _state.value.copy(checkedCash = event.checkedCash)

            is ProfileEvents.UpdateCheckedOnlinePayment -> _state.value =
                _state.value.copy(checkedOnlinePayment = event.checkedOnlinePayment)

            is ProfileEvents.UpdateCheckedQR -> _state.value =
                _state.value.copy(checkedQR = event.checkedQR)

            is ProfileEvents.UpdateDzen -> _state.value = _state.value.copy(dzen = event.dzen)
            is ProfileEvents.UpdateEmail -> _state.value = _state.value.copy(email = event.email)
            is ProfileEvents.UpdateIsSelectedAbilityMedCert -> _state.value =
                _state.value.copy(isSelectedAbilityMedCert = event.isSelectedAbilityMedCert)

            is ProfileEvents.UpdateIsSelectedCerfFromOtherDocs -> _state.value =
                _state.value.copy(isSelectedCerfFromOtherDocs = event.isSelectedCerfFromOtherDocs)

            is ProfileEvents.UpdateIsSelectedDoc -> _state.value =
                _state.value.copy(isSelectedDoc = event.isSelectedDoc)

            is ProfileEvents.UpdateIsSelectedDorCertReq -> _state.value =
                _state.value.copy(isSelectedDorCertReq = event.isSelectedDorCertReq)

            is ProfileEvents.UpdateOk -> _state.value = _state.value.copy(ok = event.ok)
            is ProfileEvents.UpdatePhone -> _state.value = _state.value.copy(phone = event.phone)
            is ProfileEvents.UpdateRuTube -> _state.value = _state.value.copy(ruTube = event.ruTube)
            is ProfileEvents.UpdateSiteAddress -> _state.value =
                _state.value.copy(siteAddress = event.siteAddress)

            is ProfileEvents.UpdateTelegram -> _state.value =
                _state.value.copy(telegram = event.telegram)

            is ProfileEvents.UpdateVk -> _state.value = _state.value.copy(vk = event.vk)
            is ProfileEvents.UpdateYoutube -> _state.value =
                _state.value.copy(youtube = event.youtube)

            is ProfileEvents.ResetAllFields -> {
                _state.value = _state.value.copy(
                    sectionName = event.resetValue,
                    uriList = event.uriList,
                    selectedSport = event.resetValue,
                    address = event.resetValue,
                    ageOfClient = event.resetValue,
                    costOfLesson = event.resetValue,
                    costPeriod = event.costPeriod,
                    workGraphic = event.resetValue,
                    about = event.resetValue,
                    isSelectedDoc = event.isSelected,
                    isSelectedDorCertReq = event.isSelected,
                    isSelectedAbilityMedCert = event.isSelected,
                    isSelectedCerfFromOtherDocs = event.isSelected,
                    checkedCash = event.checked,
                    checkedCard = event.checked,
                    checkedOnlinePayment = event.checked,
                    checkedQR = event.checked,
                    siteAddress = event.resetValue,
                    email = event.resetValue,
                    phone = event.resetValue,
                    vk = event.resetValue,
                    telegram = event.resetValue,
                    ok = event.resetValue,
                    youtube = event.resetValue,
                    ruTube = event.resetValue,
                    dzen = event.resetValue
                )
            }
        }
    }
}