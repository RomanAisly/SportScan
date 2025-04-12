package com.sportscan.ui.states

import android.net.Uri
import androidx.compose.ui.state.ToggleableState

data class ProfileState(
    val isLoading: Boolean = false,
    val uriList: List<Uri> = emptyList(),
    val sectionName: String = "",
    val selectedSport: String = "",
    val address: String = "",
    val ageOfClient: String = "",
    val costOfLesson: String = "",
    val costPeriod: String = "в/",
    val workGraphic: String = "",
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
