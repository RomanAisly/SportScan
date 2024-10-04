package com.sportscan.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
import com.sportscan.ui.components.screenBackground
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
    val day by profileViewModel.workGraphic.collectAsState()


    Column(
        modifier
            .fillMaxSize()
            .scrollable(
                state = rememberScrollState(),
                orientation = Orientation.Horizontal,
                enabled = true,
            )
            .background(screenBackground()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        Text(
            text = "Fill in all the fields below to register the section",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = modifier.padding(bottom = 50.dp, top = 25.dp)
        )

        InputProfileField(
            value = sectionName,
            onValueChange = profileViewModel::updateSectionName,
            placeholder = "Enter the section's name",
            label = "Section's name"
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
            label = "Address"
        )

        ExposedField(
            options = listOf("0-6", "6-12", "12-16", "18+"),
            selectedOption = ageClient,
            onSelectionChange = {
                profileViewModel.updateAgeOfClient(it)
            },
            icon = painterResource(id = R.drawable.age_group),
            tint = Color.Green
        )

        CostOfLesson(
            value = costOfLesson,
            onValueChange = profileViewModel::updateCostOfLesson,
            placeholder = "Enter the cost of lesson",
            label = "Cost of lesson"
        )

        ExposedField(
            options = listOf("Monday - Friday", "Monday - Sunday", "24/7"),
            selectedOption = day,
            onSelectionChange = {
                profileViewModel.updateWorkGraphic(it)
            },
            icon = painterResource(id = R.drawable.work_graphic),
            tint = Color.Red
        )

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                profileViewModel.updateAllFields()
            }) { Text(text = "Cancel") }
            Button(onClick = {}) { Text(text = "Save") }
        }

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Preview() {
    Profile(navigateTo = {})
}