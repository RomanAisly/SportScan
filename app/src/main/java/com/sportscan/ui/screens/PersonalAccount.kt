package com.sportscan.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChildCare
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
import com.sportscan.ui.components.DropDownItem
import com.sportscan.ui.components.DropMenuSelectionField
import com.sportscan.ui.components.SelectionField
import com.sportscan.ui.components.screenBackground
import com.sportscan.ui.viewmodels.PersonalAccountViewModel

@Composable
fun PersonalAccount(
    modifier: Modifier = Modifier,
    navigateTo: (NavScreens) -> Unit,
    personalAccountViewModel: PersonalAccountViewModel = viewModel()
) {

    val age by personalAccountViewModel.age.collectAsState()

    Column(
        modifier
            .fillMaxSize()
            .padding(14.dp)
            .systemBarsPadding()
            .background(screenBackground()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Fill in all the fields below to register the section",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            modifier = modifier.padding(bottom = 50.dp)
        )

        SelectionField(
            icon = Icons.Outlined.ChildCare,
            text = "Age",
            launchDropMenu = {
                DropMenuSelectionField(
                    expanded = true,
                    onDismissRequest = {
                        personalAccountViewModel.updateAge("16")
                    },
                    items = listOf(
                        DropDownItem(
                            text = "16",
                            onClick = { }
                        ),
                        DropDownItem(
                            text = "17",
                            onClick = { }
                        ),
                        DropDownItem(
                            text = "18",
                            onClick = { }
                        ),
                        DropDownItem(
                            text = "19",
                            onClick = { }
                        )
                    ))
            }
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Preview() {
    PersonalAccount(navigateTo = {})
}