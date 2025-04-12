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
import androidx.compose.ui.text.input.KeyboardType.Companion.Uri
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
import com.sportscan.ui.events.ProfileEvents
import com.sportscan.ui.theme.lightBlue
import com.sportscan.ui.theme.orange
import com.sportscan.ui.viewmodels.ProfileViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = koinViewModel()
) {

    val state by viewModel.state.collectAsState()

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
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 14.dp)
        )
        InputProfileField(
            modifier = modifier,
            value = state.sectionName,
            onValueChange = { viewModel.onEvent(ProfileEvents.UpdateSectionName(it)) },
            placeholder = stringResource(R.string.placeholder_section_name),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            )
        )
        InputProfileField(
            modifier = modifier,
            value = state.selectedSport,
            onValueChange = { viewModel.onEvent(ProfileEvents.UpdateSelectedSport(it)) },
            placeholder = stringResource(R.string.placeholder_type_of_sport),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            )
        )
        InputProfileField(
            modifier = modifier,
            value = state.address,
            onValueChange = { viewModel.onEvent(ProfileEvents.UpdateAddress(it)) },
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
                viewModel.onEvent(ProfileEvents.UpdateAgeOfClient(it))
            }, placeholder = stringResource(R.string.placeholder_age_of_client)
        )
        CostOfLesson(
            modifier = modifier,
            value = state.costOfLesson,
            onValueChange = { viewModel.onEvent(ProfileEvents.UpdateCostOfLesson(it)) },
            placeholder = stringResource(R.string.placeholder_cost_of_lesson),
            costPeriod = state.costPeriod,
            onCostPeriodChange = { viewModel.onEvent(ProfileEvents.UpdateCostPeriod(it)) }
        )
        ExposedField(
            modifier = modifier,
            options = listOf(
                stringResource(R.string.monday_friday),
                stringResource(R.string.monday_sunday), "24/7"
            ),
            selectedOption = state.workGraphic,
            onSelectionChange = {
                viewModel.onEvent(ProfileEvents.UpdateWorkGraphic(it))
            },
            placeholder = stringResource(R.string.placeholder_workgraphic)
        )
        InputProfileField(
            modifier = modifier,
            value = state.about,
            onValueChange = { viewModel.onEvent(ProfileEvents.UpdateAbout(it)) },
            placeholder = stringResource(R.string.placeholder_about),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            )
        )
        SectionPhoto(
            modifier = modifier.padding(bottom = 8.dp),
            uriList = state.uriList,
            onImagesSelected = {
                viewModel.onEvent(
                    event = ProfileEvents.UpdateUriList(
                        uris = state.uriList + it
                    )
                )
            }
        )
        Column(
            modifier = modifier.padding(start = 8.dp),
        ) {
            RadioButtonsSelection(
                isSelected = state.isSelectedDoc,
                onSelectionChange = { viewModel.onEvent(ProfileEvents.UpdateIsSelectedDoc(it)) },
                text = stringResource(R.string.med_worker)
            )
            RadioButtonsSelection(
                isSelected = state.isSelectedDorCertReq,
                onSelectionChange = { viewModel.onEvent(ProfileEvents.UpdateIsSelectedDorCertReq(it)) },
                text = stringResource(R.string.doc_cart_req)
            )
            RadioButtonsSelection(
                isSelected = state.isSelectedAbilityMedCert,
                onSelectionChange = {
                    viewModel.onEvent(
                        ProfileEvents.UpdateIsSelectedAbilityMedCert(
                            it
                        )
                    )
                },
                text = stringResource(R.string.reg_doc_cart)
            )
            RadioButtonsSelection(
                isSelected = state.isSelectedCerfFromOtherDocs,
                onSelectionChange = {
                    viewModel.onEvent(
                        ProfileEvents.UpdateIsSelectedCerfFromOtherDocs(
                            it
                        )
                    )
                },
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
                onCheckedChange = { viewModel.onEvent(ProfileEvents.UpdateCheckedCash(it)) }
            )
            PaymentMethodItem(
                text = stringResource(R.string.card),
                checked = state.checkedCard,
                onCheckedChange = { viewModel.onEvent(ProfileEvents.UpdateCheckedCard(it)) }
            )
            PaymentMethodItem(
                text = stringResource(R.string.online_payment),
                checked = state.checkedOnlinePayment,
                onCheckedChange = { viewModel.onEvent(ProfileEvents.UpdateCheckedOnlinePayment(it)) }
            )
            PaymentMethodItem(
                text = stringResource(R.string.qr_code),
                checked = state.checkedQR,
                onCheckedChange = { viewModel.onEvent(ProfileEvents.UpdateCheckedQR(it)) }
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
                onPhoneNumberChanged = { viewModel.onEvent(ProfileEvents.UpdatePhone(it)) },
                mask = "(000) 000-00-00",
                maskNumber = '0'
            )
            InputProfileField(
                modifier = modifier,
                value = state.siteAddress,
                onValueChange = { viewModel.onEvent(ProfileEvents.UpdateSiteAddress(it)) },
                placeholder = stringResource(R.string.placeholder_site_address),
                keyboardOptions = KeyboardOptions(
                    keyboardType = Uri,
                    imeAction = ImeAction.Done
                )
            )
            InputProfileField(
                modifier = modifier,
                value = state.email,
                onValueChange = { viewModel.onEvent(ProfileEvents.UpdateEmail(it)) },
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
                onValueChange = { viewModel.onEvent(ProfileEvents.UpdateVk(it)) },
                placeholder = stringResource(R.string.placeholder_vk),
                leadingIcon = {
                    Image(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_vk),
                        contentDescription = stringResource(R.string.cont_desc_vk)
                    )
                }
            )
            SocialMediaField(
                modifier = modifier,
                value = state.telegram,
                onValueChange = { viewModel.onEvent(ProfileEvents.UpdateTelegram(it)) },
                placeholder = stringResource(R.string.placeholder_telegram),
                leadingIcon = {
                    Image(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_telegram),
                        contentDescription = stringResource(R.string.cont_desc_telegram)
                    )
                }
            )
            SocialMediaField(
                modifier = modifier,
                value = state.ok,
                onValueChange = { viewModel.onEvent(ProfileEvents.UpdateOk(it)) },
                placeholder = stringResource(R.string.placeholder_ok),
                leadingIcon = {
                    Image(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_ok),
                        contentDescription = stringResource(R.string.cont_desc_ok)
                    )
                }
            )
            SocialMediaField(
                modifier = modifier,
                value = state.youtube,
                onValueChange = { viewModel.onEvent(ProfileEvents.UpdateYoutube(it)) },
                placeholder = stringResource(R.string.placeholder_youtube),
                leadingIcon = {
                    Image(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_youtube),
                        contentDescription = stringResource(R.string.cont_desc_youtube)
                    )
                }
            )
            SocialMediaField(
                modifier = modifier,
                value = state.ruTube,
                onValueChange = { viewModel.onEvent(ProfileEvents.UpdateRuTube(it)) },
                placeholder = stringResource(R.string.placeholder_rutube),
                leadingIcon = {
                    Image(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_rutube),
                        contentDescription = stringResource(R.string.cont_desc_rutube)
                    )
                }
            )
            SocialMediaField(
                modifier = modifier,
                value = state.dzen,
                onValueChange = { viewModel.onEvent(ProfileEvents.UpdateDzen(it)) },
                placeholder = stringResource(R.string.placeholder_dzen),
                leadingIcon = {
                    Image(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_dzen),
                        contentDescription = stringResource(R.string.cont_desc_dzen)
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
                onClick = { viewModel.onEvent(ProfileEvents.ResetAllFields()) },
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