package com.sportscan.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sportscan.R
import com.sportscan.domain.navigation.NavScreens
import com.sportscan.ui.components.CostOfLesson
import com.sportscan.ui.components.ExposedField
import com.sportscan.ui.components.InputProfileField
import com.sportscan.ui.components.LogoElements
import com.sportscan.ui.components.PaymentMethodItem
import com.sportscan.ui.components.RadioButtonsSelection
import com.sportscan.ui.components.SectionPhoto
import com.sportscan.ui.components.gradLogo
import com.sportscan.ui.components.screenBackground
import com.sportscan.ui.theme.gradMed
import com.sportscan.ui.viewmodels.ProfileViewModel

@Composable
fun Profile(
    modifier: Modifier = Modifier,
    navigateTo: (NavScreens) -> Unit,
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
    val email by profileViewModel.email.collectAsState()
    val phone by profileViewModel.phone.collectAsState()
    val siteAddress by profileViewModel.siteAddress.collectAsState()

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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            LogoElements(modifier = modifier.padding(top = 30.dp))

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
                    profileViewModel.updateAgeOfClient(it) }
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
                    profileViewModel.updateWorkGraphic(it)}
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
                uriList = uriList,
                onImagesSelected = profileViewModel::updateUriList
            )

            Column(
                modifier = modifier
                    .padding(vertical = 10.dp)
                    .padding(horizontal = 10.dp)
                    .border(
                        width = 2.dp,
                        brush = gradMed,
                        shape = MaterialTheme.shapes.large
                    )
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally
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

            Column(
                modifier = modifier
                    .border(
                        width = 2.dp,
                        brush = gradLogo(),
                        shape = MaterialTheme.shapes.large
                    )
                    .padding(12.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.payment_methods),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = modifier.padding(vertical = 6.dp)
                )

                Row {
                    Column {
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
                    }

                    Column {
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
                }
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
                    )
                )

                InputProfileField(
                    value = siteAddress,
                    onValueChange = profileViewModel::updateSiteAddress,
                    placeholder = stringResource(R.string.placeholder_site_address),
                    label = stringResource(R.string.label_site_address)
                )

                Text(
                    text = "Social media links",
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 18.sp,
                    modifier = modifier.padding(vertical = 6.dp)
                )

            }


            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = { profileViewModel.updateAllFields() }) {
                    Text(
                        text = stringResource(
                            R.string.button_reset
                        )
                    )
                }
                Button(onClick = {}) { Text(text = stringResource(R.string.button_save)) }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    Profile(navigateTo = {})
}