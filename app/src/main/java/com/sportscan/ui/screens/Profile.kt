package com.sportscan.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Facebook
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
import com.sportscan.ui.components.RadioButtonsSelection
import com.sportscan.ui.components.SectionPhoto
import com.sportscan.ui.components.screenBackground
import com.sportscan.ui.theme.darkGreen
import com.sportscan.ui.viewmodels.ProfileViewModel

@Composable
fun Profile(
    modifier: Modifier = Modifier,
    navigateTo: (NavScreens) -> Unit,
    profileViewModel: ProfileViewModel = viewModel()
) {
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
            SectionPhoto()

            Text(
                text = "Fill in all the fields below to register the section",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = modifier.padding(vertical = 10.dp)
            )

            InputProfileField(
                value = sectionName,
                onValueChange = profileViewModel::updateSectionName,
                placeholder = "Enter the section's name",
                label = "Section's name",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )
            )

            ExposedField(
                options = listOf("Swimming", "Cycling", "Judo", "Football", "Tennis"),
                selectedOption = selectedSport,
                onSelectionChange = {
                    profileViewModel.updateSelectedSport(it)
                },
                icon = painterResource(id = R.drawable.sport_type)
            )

            InputProfileField(
                value = address,
                onValueChange = profileViewModel::updateAddress,
                placeholder = "Enter the address",
                label = "Address",
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
                },
                icon = painterResource(id = R.drawable.age_group),
                tint = darkGreen
            )

            CostOfLesson(
                value = costOfLesson,
                onValueChange = profileViewModel::updateCostOfLesson,
                placeholder = "Enter the cost of lesson",
                label = "Cost of lesson",
                costPeriod = costPeriod,
                onCostPeriodChange = profileViewModel::updateCostPeriod
            )

            ExposedField(
                options = listOf("Monday - Friday", "Monday - Sunday", "24/7"),
                selectedOption = workGraphic,
                onSelectionChange = {
                    profileViewModel.updateWorkGraphic(it)
                },
                icon = painterResource(id = R.drawable.work_graphic),
                tint = Color.Red
            )

            InputProfileField(
                value = about,
                onValueChange = profileViewModel::updateAbout,
                placeholder = "Enter more information about the section",
                label = "About"
            )

            RadioButtonsSelection(
                modifier = modifier.padding(top = 10.dp),
                isSelected = isSelectedDoc,
                onSelectionChange = profileViewModel::updateSelectedDoc,
                text = "Has a medical worker/rescuer?"
            )

            RadioButtonsSelection(
                isSelected = isSelectedDorCertReq,
                onSelectionChange = profileViewModel::updateSelectedDorCertReq,
                text = "Is a doctor's certificate required?"
            )

            RadioButtonsSelection(
                isSelected = isSelectedAbilityMedCert,
                onSelectionChange = profileViewModel::updateSelectedAbilityMedCert,
                text = "Is an ability to perform a medical certificate required?"
            )

            RadioButtonsSelection(
                modifier = modifier.padding(bottom = 8.dp),
                isSelected = isSelectedCerfFromOtherDocs,
                onSelectionChange = profileViewModel::updateSelectedCerfFromOtherDocs,
                text = "Is a certificate from another source required?"
            )

            Column(
                modifier = modifier
                    .wrapContentSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically)
            ) {
                Text(
                    text = "Contact information",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurface
                )

                InputProfileField(
                    value = email,
                    onValueChange = profileViewModel::updateEmail,
                    placeholder = "Enter your email",
                    label = "Email",
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Done
                    )
                )

                InputProfileField(
                    value = phone,
                    onValueChange = profileViewModel::updatePhone,
                    placeholder = "Enter your phone number",
                    label = "Phone number",
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone,
                        imeAction = ImeAction.Done
                    )
                )

                InputProfileField(
                    value = siteAddress,
                    onValueChange = profileViewModel::updateSiteAddress,
                    placeholder = "Enter the site address",
                    label = "Site address"
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Rounded.Facebook,
                            contentDescription = "",
                            tint = Color.Blue
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Rounded.Facebook,
                            contentDescription = "",
                            tint = Color.Red
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Rounded.Facebook,
                            contentDescription = "",
                            tint = Color.Green
                        )
                    }
                }
            }


            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = { profileViewModel.updateAllFields() }) { Text(text = "Reset") }
                Button(onClick = {}) { Text(text = "Save") }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Preview() {
    Profile(navigateTo = {})
}