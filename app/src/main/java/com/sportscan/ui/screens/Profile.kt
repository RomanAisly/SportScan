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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sportscan.R
import com.sportscan.ui.components.CostOfLesson
import com.sportscan.ui.components.ExposedField
import com.sportscan.ui.components.InputProfileField
import com.sportscan.ui.components.LogoElements
import com.sportscan.ui.components.PaymentMethodItem
import com.sportscan.ui.components.RadioButtonsSelection
import com.sportscan.ui.components.SectionPhoto
import com.sportscan.ui.components.SocialMediaField
import com.sportscan.ui.components.gradLogo
import com.sportscan.ui.components.screenBackground
import com.sportscan.ui.theme.lightBlue
import com.sportscan.ui.theme.orange
import com.sportscan.ui.viewmodels.ProfileViewModel

@Composable
fun Profile(
    modifier: Modifier = Modifier,
    profileViewModel: ProfileViewModel = viewModel()
) {

    val uriList by profileViewModel.uriList.collectAsState()
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

    Scaffold { paddingValues ->
        Column(
            modifier
                .fillMaxSize()
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding()
                )
                .verticalScroll(state = rememberScrollState())
                .background(screenBackground()),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            LogoElements(
                modifier = modifier
                    .padding(top = 30.dp)
                    .padding(horizontal = 20.dp)
            )

            Text(
                text = stringResource(R.string.header_text_profile),
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = modifier.padding(vertical = 10.dp)
            )


            InputProfileField(
                value = sectionName,
                onValueChange = profileViewModel::updateSectionName,
                placeholder = stringResource(R.string.placeholder_section_name),
                label = stringResource(R.string.label_section_name),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )
            )

            InputProfileField(
                value = selectedSport,
                onValueChange = profileViewModel::updateSelectedSport,
                placeholder = stringResource(R.string.placeholder_type_of_sport),
                label = stringResource(R.string.label_type_of_sport),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )
            )

            InputProfileField(
                value = address,
                onValueChange = profileViewModel::updateAddress,
                placeholder = stringResource(R.string.placeholder_address),
                label = stringResource(R.string.label_address),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )
            )

            ExposedField(
                options = listOf("0-6", "6-12", "12-16", "18+"),
                selectedOption = ageClient,
                onSelectionChange = {
                    profileViewModel.updateAgeOfClient(it)
                }
            )

            CostOfLesson(
                value = costOfLesson,
                onValueChange = profileViewModel::updateCostOfLesson,
                placeholder = stringResource(R.string.placeholder_cost_of_lesson),
                label = stringResource(R.string.label_cost_of_lesson),
                costPeriod = costPeriod,
                onCostPeriodChange = profileViewModel::updateCostPeriod
            )

            ExposedField(
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
                value = about,
                onValueChange = profileViewModel::updateAbout,
                placeholder = stringResource(R.string.placeholder_about),
                label = stringResource(R.string.label_about),
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
                Text(
                    text = stringResource(R.string.payment_methods),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurface,
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
                    .padding(10.dp)
                    .border(
                        width = 2.dp,
                        brush = gradLogo(),
                        shape = MaterialTheme.shapes.large
                    )
                    .padding(vertical = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterVertically)
            ) {
                Text(
                    text = stringResource(R.string.contact_information),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = modifier.padding(vertical = 6.dp)
                )

                InputProfileField(
                    value = siteAddress,
                    onValueChange = profileViewModel::updateSiteAddress,
                    placeholder = stringResource(R.string.placeholder_site_address),
                    label = stringResource(R.string.label_site_address),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Uri,
                        imeAction = ImeAction.Done
                    )
                )

                InputProfileField(
                    value = email,
                    onValueChange = profileViewModel::updateEmail,
                    placeholder = stringResource(R.string.placeholder_login_field),
                    label = stringResource(R.string.label_email),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Done
                    )
                )

                InputProfileField(
                    value = phone,
                    onValueChange = profileViewModel::updatePhone,
                    placeholder = stringResource(R.string.placeholder_cont_phone_number),
                    label = stringResource(R.string.label_phone_number),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone,
                        imeAction = ImeAction.Done
                    ),
                    prefix = { Text(text = "+7") }
                )


                Text(
                    text = stringResource(R.string.social_media_links),
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 18.sp,
                    modifier = modifier.padding(vertical = 6.dp)
                )

                SocialMediaField(
                    value = vk,
                    onValueChange = profileViewModel::updateVk,
                    placeholder = stringResource(R.string.placeholder_vk),
                    label = stringResource(R.string.label_vk),
                    leadingIcon = {
                        Image(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_vk),
                            contentDescription = stringResource(R.string.label_vk)
                        )
                    }
                )

                SocialMediaField(
                    value = telegram,
                    onValueChange = profileViewModel::updateTelegram,
                    placeholder = stringResource(R.string.placeholder_telegram),
                    label = stringResource(R.string.label_telegram),
                    leadingIcon = {
                        Image(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_telegram),
                            contentDescription = stringResource(R.string.label_telegram)
                        )
                    }
                )

                SocialMediaField(
                    value = ok,
                    onValueChange = profileViewModel::updateOk,
                    placeholder = stringResource(R.string.placeholder_ok),
                    label = stringResource(R.string.label_ok),
                    leadingIcon = {
                        Image(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_ok),
                            contentDescription = stringResource(R.string.label_ok)
                        )
                    }
                )

                SocialMediaField(
                    value = youtube,
                    onValueChange = profileViewModel::updateYoutube,
                    placeholder = stringResource(R.string.placeholder_youtube),
                    label = stringResource(R.string.label_youtube),
                    leadingIcon = {
                        Image(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_youtube),
                            contentDescription = stringResource(R.string.label_youtube)
                        )
                    }
                )

                SocialMediaField(
                    value = ruTube,
                    onValueChange = profileViewModel::updateRuTube,
                    placeholder = stringResource(R.string.placeholder_rutube),
                    label = stringResource(R.string.label_rutube),
                    leadingIcon = {
                        Image(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_rutube),
                            contentDescription = stringResource(R.string.label_rutube)
                        )
                    }
                )

                SocialMediaField(
                    value = dzen,
                    onValueChange = profileViewModel::updateDzen,
                    placeholder = stringResource(R.string.placeholder_dzen),
                    label = stringResource(R.string.label_dzen),
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
                    Text(
                        text = stringResource(
                            R.string.button_reset
                        ),
                        color = MaterialTheme.colorScheme.onSurface
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
                    Text(
                        text = stringResource(R.string.button_save),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    Profile()
}