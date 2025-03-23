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
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    profileViewModel: ProfileViewModel = koinViewModel()
) {

    val state by profileViewModel.state.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
            .background(screenBackground()),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        LogoElements()

        SimpleText(
            text = stringResource(R.string.header_text_profile),
            textSize = 20.sp,
            textWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            modifier = modifier.fillMaxWidth().padding(vertical = 14.dp)
        )
        InputProfileField(
            modifier = modifier,
            value = state.sectionName,
            onValueChange = profileViewModel::updateSectionName,
            placeholder = stringResource(R.string.placeholder_section_name),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            )
        )
        InputProfileField(
            modifier = modifier,
            value = state.selectedSport,
            onValueChange = profileViewModel::updateSelectedSport,
            placeholder = stringResource(R.string.placeholder_type_of_sport),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            )
        )
        InputProfileField(
            modifier = modifier,
            value = state.address,
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
            selectedOption = state.ageOfClient,
            onSelectionChange = {
                profileViewModel.updateAgeOfClient(it)
            }
        )
        CostOfLesson(
            modifier = modifier,
            value = state.costOfLesson,
            onValueChange = profileViewModel::updateCostOfLesson,
            placeholder = stringResource(R.string.placeholder_cost_of_lesson),
            costPeriod = state.costPeriod,
            onCostPeriodChange = profileViewModel::updateCostPeriod
        )
        ExposedField(
            modifier = modifier,
            options = listOf(
                stringResource(R.string.monday_friday),
                stringResource(R.string.monday_sunday), "24/7"
            ),
            selectedOption = state.workGraphic,
            onSelectionChange = {
                profileViewModel.updateWorkGraphic(it)
            }
        )
        InputProfileField(
            modifier = modifier,
            value = state.about,
            onValueChange = profileViewModel::updateAbout,
            placeholder = stringResource(R.string.placeholder_about),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            )
        )
        SectionPhoto(
            modifier = modifier.padding(bottom = 8.dp),
            uriList = state.uriList,
            onImagesSelected = profileViewModel::updateUriList
        )
        Column(
            modifier = modifier.padding(start = 8.dp),
        ) {
            RadioButtonsSelection(
                isSelected = state.isSelectedDoc,
                onSelectionChange = profileViewModel::updateIsSelectedDoc,
                text = stringResource(R.string.med_worker)
            )
            RadioButtonsSelection(
                isSelected = state.isSelectedDorCertReq,
                onSelectionChange = profileViewModel::updateIsSelectedDorCertReq,
                text = stringResource(R.string.doc_cart_req)
            )
            RadioButtonsSelection(
                isSelected = state.isSelectedAbilityMedCert,
                onSelectionChange = profileViewModel::updateIsSelectedAbilityMedCert,
                text = stringResource(R.string.reg_doc_cart)
            )
            RadioButtonsSelection(
                isSelected = state.isSelectedCerfFromOtherDocs,
                onSelectionChange = profileViewModel::updateIsSelectedCerfFromOtherDocs,
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
                checked = state.checkedCash,
                onCheckedChange = profileViewModel::updateCheckedCash
            )
            PaymentMethodItem(
                text = stringResource(R.string.card),
                checked = state.checkedCard,
                onCheckedChange = profileViewModel::updateCheckedCard
            )
            PaymentMethodItem(
                text = stringResource(R.string.online_payment),
                checked = state.checkedOnlinePayment,
                onCheckedChange = profileViewModel::updateCheckedOnlinePayment
            )
            PaymentMethodItem(
                text = stringResource(R.string.qr_code),
                checked = state.checkedQR,
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
                phoneNumber = state.phone,
                onPhoneNumberChanged = profileViewModel::updatePhone,
                mask = "(000) 000-00-00",
                maskNumber = '0'
            )
            InputProfileField(
                modifier = modifier,
                value = state.siteAddress,
                onValueChange = profileViewModel::updateSiteAddress,
                placeholder = stringResource(R.string.placeholder_site_address),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Uri,
                    imeAction = ImeAction.Done
                )
            )
            InputProfileField(
                modifier = modifier,
                value = state.email,
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
                value = state.vk,
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
                value = state.telegram,
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
                value = state.ok,
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
                value = state.youtube,
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
                value = state.ruTube,
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
                value = state.dzen,
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
                onClick = profileViewModel::updateAllFields,
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