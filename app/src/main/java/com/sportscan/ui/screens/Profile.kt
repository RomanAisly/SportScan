package com.sportscan.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Sports
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sportscan.domain.navigation.NavScreens
import com.sportscan.ui.components.CostOfLessonField
import com.sportscan.ui.components.SelectionField
import com.sportscan.ui.components.WorkGraphic
import com.sportscan.ui.components.screenBackground
import com.sportscan.ui.viewmodels.ProfileViewModel

@Composable
fun Profile(
    modifier: Modifier = Modifier,
    navigateTo: (NavScreens) -> Unit,
    profileViewModel: ProfileViewModel = viewModel()
) {

    val isExpanded by profileViewModel.isExpanded.collectAsState()

    val selectedSport by profileViewModel.selectedSport.collectAsState()
    val ageClient by profileViewModel.ageOfClient.collectAsState()
    val costOfLesson by profileViewModel.costOfLesson.collectAsState()
    val fromHour by profileViewModel.from.collectAsState()
    val toHour by profileViewModel.to.collectAsState()
    val day by profileViewModel.day.collectAsState()


    Column(
        modifier
            .fillMaxSize()
            .padding(14.dp)
            .systemBarsPadding()
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
            modifier = modifier.padding(bottom = 50.dp)
        )

        SelectionField(
            isExpanded = isExpanded,
            onExpansionChange = profileViewModel::updateIsExpanded,
            options = listOf("Swimming", "Cycling", "Judo", "Football", "Tennis"),
            selectedOption = selectedSport,
            onSelectionChange = {
                profileViewModel.updateSelectedSport(it)
            },
            icon = Icons.Rounded.Sports
        )

        SelectionField(
            isExpanded = isExpanded,
            onExpansionChange = profileViewModel::updateIsExpanded,
            options = listOf("0-6", "6-12", "12-16", "18+"),
            selectedOption = ageClient,
            onSelectionChange = {
                profileViewModel.updateAgeOfClient(it)
            },
            icon = Icons.Rounded.Person
        )

        CostOfLessonField(
            modifier = modifier,
            isExpanded = isExpanded,
            onExpansionChange = profileViewModel::updateIsExpanded,
            options = listOf("per/Day", "per/Week", "per/Month", "per/Year"),
            value = costOfLesson,
            onValueChange = profileViewModel::updateCostOfLesson,
            onMoneyChange = { profileViewModel.updateCostOfLesson(it) }
        )

        WorkGraphic(
            modifier = modifier,
            isExpanded = isExpanded,
            onExpansionChange = profileViewModel::updateIsExpanded,
            options = listOf(
                "Monday",
                "Tuesday",
                "Wednesday",
                "Fourday",
                "Friday",
                "Saturday",
                "Sunday"
            ),
            fromHour = fromHour,
            toHour = toHour,
            value = day,
            fromHourChange = profileViewModel::updateFrom,
            toHourChange = profileViewModel::updateTo,
            onGraphicChange = { profileViewModel.updateDay(it) }
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Preview() {
    Profile(navigateTo = {})
}