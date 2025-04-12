package com.sportscan.ui.events

import android.net.Uri
import androidx.compose.ui.state.ToggleableState

sealed interface ProfileEvents {
    data class UpdateUriList(val uris: List<Uri>) : ProfileEvents
    data class UpdateSectionName(val sectionName: String) : ProfileEvents
    data class UpdateSelectedSport(val selectedSport: String) : ProfileEvents
    data class UpdateAddress(val address: String) : ProfileEvents
    data class UpdateAgeOfClient(val ageOfClient: String) : ProfileEvents
    data class UpdateCostOfLesson(val costOfLesson: String) : ProfileEvents
    data class UpdateCostPeriod(val costPeriod: String) : ProfileEvents
    data class UpdateWorkGraphic(val workGraphic: String) : ProfileEvents
    data class UpdateAbout(val about: String) : ProfileEvents
    data class UpdateIsSelectedDoc(val isSelectedDoc: Boolean) : ProfileEvents
    data class UpdateIsSelectedDorCertReq(val isSelectedDorCertReq: Boolean) : ProfileEvents
    data class UpdateIsSelectedAbilityMedCert(val isSelectedAbilityMedCert: Boolean) : ProfileEvents
    data class UpdateIsSelectedCerfFromOtherDocs(val isSelectedCerfFromOtherDocs: Boolean) : ProfileEvents
    data class UpdateCheckedCash(val checkedCash: ToggleableState) : ProfileEvents
    data class UpdateCheckedCard(val checkedCard: ToggleableState) : ProfileEvents
    data class UpdateCheckedOnlinePayment(val checkedOnlinePayment: ToggleableState) : ProfileEvents
    data class UpdateCheckedQR(val checkedQR: ToggleableState) : ProfileEvents
    data class UpdateSiteAddress(val siteAddress: String) : ProfileEvents
    data class UpdateEmail(val email: String) : ProfileEvents
    data class UpdatePhone(val phone: String) : ProfileEvents
    data class UpdateVk(val vk: String) : ProfileEvents
    data class UpdateTelegram(val telegram: String) : ProfileEvents
    data class UpdateOk(val ok: String) : ProfileEvents
    data class UpdateYoutube(val youtube: String) : ProfileEvents
    data class UpdateRuTube(val ruTube: String) : ProfileEvents
    data class UpdateDzen(val dzen: String) : ProfileEvents
    data class ResetAllFields(
        val resetValue: String = "",
        val uriList: List<Uri> = emptyList(),
        val costPeriod: String = "в/",
        val isSelected: Boolean = false,
        val checked: ToggleableState = ToggleableState.Off
    ) : ProfileEvents
}