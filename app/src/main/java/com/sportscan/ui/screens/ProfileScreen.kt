package com.sportscan.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sportscan.R
import com.sportscan.ui.components.CostOfLesson
import com.sportscan.ui.components.ExposedField
import com.sportscan.ui.components.InputProfileField
import com.sportscan.ui.components.LogoElements
import com.sportscan.ui.components.PaymentMethodItem
import com.sportscan.ui.components.PhoneField
import com.sportscan.ui.components.RadioButtonsSelection
import com.sportscan.ui.components.SectionPhoto
import com.sportscan.ui.components.SimpleText
import com.sportscan.ui.components.SocialMediaField
import com.sportscan.ui.components.screenBackground
import com.sportscan.ui.theme.lightBlue
import com.sportscan.ui.theme.orange
import com.sportscan.ui.viewmodels.ProfileViewModel

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    profileViewModel: ProfileViewModel = hiltViewModel()
) {

    val uriList by profileViewModel.state.collectAsState()
    val sectionName by profileViewModel.sectionName.collectAsState()
    val selectedSport by profileViewModel.selectedSport.collectAsState()
    val address by profileViewModel.address.collectAsState()
    val ageClient by profileViewModel.ageOfClient.collectAsState()
    val costOfLesson by profileViewModel.costOfLesson.collectAsState()
    val costPeriod by profileViewModel.costPeriod.collectAsState()
    val workGraphic by profileViewModel.workGraphic.collectAsState()
    val about by profileViewModel.about.collectAsState()
    val isSelectedDoc by profileViewModel.isSelectedDoc.collectAsState()
    val isSelectedDorCertReq by profileViewModel.isSelectedDorCertReq.collectAsState()
    val isSelectedAbilityMedCert by profileViewModel.isSelectedAbilityMedCert.collectAsState()
    val isSelectedCerfFromOtherDocs by profileViewModel.isSelectedCerfFromOtherDocs.collectAsState()
    val checkedCash by profileViewModel.checkedCash.collectAsState()
    val checkedCard by profileViewModel.checkedCard.collectAsState()
    val checkedOnlinePayment by profileViewModel.checkedOnlinePayment.collectAsState()
    val checkedQR by profileViewModel.checkedQR.collectAsState()
    val siteAddress by profileViewModel.siteAddress.collectAsState()
    val email by profileViewModel.email.collectAsState()
    val phone by profileViewModel.phone.collectAsState()
    val vk by profileViewModel.vk.collectAsState()
    val telegram by profileViewModel.telegram.collectAsState()
    val ok by profileViewModel.ok.collectAsState()
    val youtube by profileViewModel.youtube.collectAsState()
    val ruTube by profileViewModel.ruTube.collectAsState()
    val dzen by profileViewModel.dzen.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
            .background(screenBackground()),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        LogoElements(
            modifier = modifier
                .padding(top = 30.dp)
                .padding(horizontal = 20.dp)
        )
        SimpleText(
            text = stringResource(R.string.header_text_profile),
            textSize = 20.sp,
            textWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            modifier = modifier.padding(vertical = 10.dp)
        )
        InputProfileField(
            modifier = modifier,
            value = sectionName,
            onValueChange = profileViewModel::updateSectionName,
            placeholder = stringResource(R.string.placeholder_section_name),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            )
        )
        InputProfileField(
            modifier = modifier,
            value = selectedSport,
            onValueChange = profileViewModel::updateSelectedSport,
            placeholder = stringResource(R.string.placeholder_type_of_sport),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            )
        )
        InputProfileField(
            modifier = modifier,
            value = address,
            onValueChange = profileViewModel::updateAddress,
            placeholder = stringResource(R.string.placeholder_address),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            )
        )
        ExposedField(
            modifier = modifier,
            options = listOf("0-6", "6-12", "12-16", "18+"),
            selectedOption = ageClient,
            onSelectionChange = {
                profileViewModel.updateAgeOfClient(it)
            }
        )
        CostOfLesson(
            modifier = modifier,
            value = costOfLesson,
            onValueChange = profileViewModel::updateCostOfLesson,
            placeholder = stringResource(R.string.placeholder_cost_of_lesson),
            costPeriod = costPeriod,
            onCostPeriodChange = profileViewModel::updateCostPeriod
        )
        ExposedField(
            modifier = modifier,
            options = listOf(
                stringResource(R.string.monday_friday),
                stringResource(R.string.monday_sunday), "24/7"
            ),
            selectedOption = workGraphic,
            onSelectionChange = {
                profileViewModel.updateWorkGraphic(it)
            }
        )
        InputProfileField(
            modifier = modifier,
            value = about,
            onValueChange = profileViewModel::updateAbout,
            placeholder = stringResource(R.string.placeholder_about),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            )
        )
        SectionPhoto(
            modifier = modifier.padding(bottom = 8.dp),
            uriList = uriList,
            onImagesSelected = profileViewModel::updateUriList
        )
        Column(
            modifier = modifier.padding(start = 8.dp),
        ) {
            RadioButtonsSelection(
                isSelected = isSelectedDoc,
                onSelectionChange = profileViewModel::updateSelectedDoc,
                text = stringResource(R.string.med_worker)
            )
            RadioButtonsSelection(
                isSelected = isSelectedDorCertReq,
                onSelectionChange = profileViewModel::updateSelectedDorCertReq,
                text = stringResource(R.string.doc_cart_req)
            )
            RadioButtonsSelection(
                isSelected = isSelectedAbilityMedCert,
                onSelectionChange = profileViewModel::updateSelectedAbilityMedCert,
                text = stringResource(R.string.reg_doc_cart)
            )
            RadioButtonsSelection(
                isSelected = isSelectedCerfFromOtherDocs,
                onSelectionChange = profileViewModel::updateSelectedCerfFromOtherDocs,
                text = stringResource(R.string.other_dor_cart_from)
            )
        }
        HorizontalDivider(
            color = MaterialTheme.colorScheme.onSurface,
            thickness = 1.dp,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Column(
            modifier = modifier
                .padding(vertical = 4.dp)
                .padding(horizontal = 20.dp)
        ) {
            SimpleText(
                text = stringResource(R.string.payment_methods),
                textSize = 18.sp,
                textWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(vertical = 6.dp)
            )
            PaymentMethodItem(
                text = stringResource(R.string.cash),
                checked = checkedCash,
                onCheckedChange = profileViewModel::updateCheckedCash
            )
            PaymentMethodItem(
                text = stringResource(R.string.card),
                checked = checkedCard,
                onCheckedChange = profileViewModel::updateCheckedCard
            )
            PaymentMethodItem(
                text = stringResource(R.string.online_payment),
                checked = checkedOnlinePayment,
                onCheckedChange = profileViewModel::updateCheckedOnlinePayment
            )
            PaymentMethodItem(
                text = stringResource(R.string.qr_code),
                checked = checkedQR,
                onCheckedChange = profileViewModel::updateCheckedQR
            )
        }
        Column(
            modifier = modifier
                .padding(vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically)
        ) {
            SimpleText(
                text = stringResource(R.string.contact_information),
                textSize = 18.sp,
                textWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(vertical = 6.dp)
            )
            PhoneField(
                modifier = modifier,
                phoneNumber = phone,
                onPhoneNumberChanged = profileViewModel::updatePhone,
                mask = "(000) 000-00-00",
                maskNumber = '0'
            )
            InputProfileField(
                modifier = modifier,
                value = siteAddress,
                onValueChange = profileViewModel::updateSiteAddress,
                placeholder = stringResource(R.string.placeholder_site_address),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Uri,
                    imeAction = ImeAction.Done
                )
            )
            InputProfileField(
                modifier = modifier,
                value = email,
                onValueChange = profileViewModel::updateEmail,
                placeholder = stringResource(R.string.placeholder_login_field),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done
                )
            )
            SimpleText(
                text = stringResource(R.string.social_media_links),
                textSize = 18.sp,
                textWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(vertical = 6.dp)
            )
            SocialMediaField(
                modifier = modifier,
                value = vk,
                onValueChange = profileViewModel::updateVk,
                placeholder = stringResource(R.string.placeholder_vk),
                leadingIcon = {
                    Image(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_vk),
                        contentDescription = stringResource(R.string.label_vk)
                    )
                }
            )
            SocialMediaField(
                modifier = modifier,
                value = telegram,
                onValueChange = profileViewModel::updateTelegram,
                placeholder = stringResource(R.string.placeholder_telegram),
                leadingIcon = {
                    Image(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_telegram),
                        contentDescription = stringResource(R.string.label_telegram)
                    )
                }
            )
            SocialMediaField(
                modifier = modifier,
                value = ok,
                onValueChange = profileViewModel::updateOk,
                placeholder = stringResource(R.string.placeholder_ok),
                leadingIcon = {
                    Image(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_ok),
                        contentDescription = stringResource(R.string.label_ok)
                    )
                }
            )
            SocialMediaField(
                modifier = modifier,
                value = youtube,
                onValueChange = profileViewModel::updateYoutube,
                placeholder = stringResource(R.string.placeholder_youtube),
                leadingIcon = {
                    Image(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_youtube),
                        contentDescription = stringResource(R.string.label_youtube)
                    )
                }
            )
            SocialMediaField(
                modifier = modifier,
                value = ruTube,
                onValueChange = profileViewModel::updateRuTube,
                placeholder = stringResource(R.string.placeholder_rutube),
                leadingIcon = {
                    Image(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_rutube),
                        contentDescription = stringResource(R.string.label_rutube)
                    )
                }
            )
            SocialMediaField(
                modifier = modifier,
                value = dzen,
                onValueChange = profileViewModel::updateDzen,
                placeholder = stringResource(R.string.placeholder_dzen),
                leadingIcon = {
                    Image(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_dzen),
                        contentDescription = stringResource(R.string.label_dzen)
                    )
                }
            )
        }
        Column(
            modifier = modifier
                .padding(bottom = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Button(
                onClick = { profileViewModel.updateAllFields() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = screenBackground()
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 80.dp)
                    .border(
                        width = 2.dp,
                        color = lightBlue,
                        shape = MaterialTheme.shapes.extraLarge
                    )
            ) {
                SimpleText(
                    text = stringResource(R.string.button_reset)
                )
            }
            Button(
                onClick = {}, colors = ButtonDefaults.buttonColors(
                    containerColor = screenBackground()
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 80.dp)
                    .border(
                        width = 2.dp,
                        color = orange,
                        shape = MaterialTheme.shapes.extraLarge
                    )
            ) {
                SimpleText(
                    text = stringResource(R.string.button_save)
                )
            }
        }
    }
}