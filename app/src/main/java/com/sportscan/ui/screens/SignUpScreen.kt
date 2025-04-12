package com.sportscan.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sportscan.R
import com.sportscan.domain.navigation.NavScreens
import com.sportscan.ui.components.GradientButton
import com.sportscan.ui.components.LoginTextField
import com.sportscan.ui.components.Logo
import com.sportscan.ui.components.PasswordTextField
import com.sportscan.ui.components.SimpleText
import com.sportscan.ui.components.authTextColor
import com.sportscan.ui.components.gradButtDisable
import com.sportscan.ui.components.gradLogo
import com.sportscan.ui.components.screenBackground
import com.sportscan.ui.events.SignUpEvents
import com.sportscan.ui.theme.authElements
import com.sportscan.ui.theme.gradButtAutEnable
import com.sportscan.ui.viewmodels.SignUpViewModel
import com.sportscan.utils.ResultData
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    navigateTo: (NavScreens) -> Unit,
    viewModel: SignUpViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsState()
    val isButtonEnabled = state.login.isNotEmpty() &&
            state.password.isNotEmpty() &&
            state.repeatPassword.isNotEmpty() &&
            state.checked == ToggleableState.On
    val context = LocalContext.current

    LaunchedEffect(state.resultData) {
        when (state.resultData) {
            is ResultData.Success<*> -> {
                navigateTo(NavScreens.ProfileScreen)
            }

            is ResultData.Error<*> -> {
                Toast.makeText(
                    context,
                    (state.resultData as ResultData.Error<*>).msg,
                    Toast.LENGTH_SHORT
                ).show()
            }

            else -> {}
        }
    }

    Column(
        modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(screenBackground()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(14.dp, Alignment.CenterVertically)
    ) {
        Logo(
            modifier = modifier.padding(bottom = 90.dp),
            gradient = gradLogo()
        )
        LoginTextField(
            modifier = modifier
                .fillMaxWidth(),
            value = state.login,
            onValueChange = { viewModel.onEvent(SignUpEvents.UpdateLogin(it)) },
            placeholder = stringResource(R.string.placeholder_login_field)
        )
        PasswordTextField(
            modifier = modifier
                .fillMaxWidth(),
            value = state.password,
            onValueChange = { viewModel.onEvent(SignUpEvents.UpdatePassword(it)) },
            placeholder = stringResource(R.string.placeholder_password_field),
            passwordVisible = state.isPasswordVisible,
            onPasswordVisibilityToggle = {
                viewModel.onEvent(
                    SignUpEvents.UpdatePasswordVisibility(
                        state.isPasswordVisible
                    )
                )
            }
        )
        PasswordTextField(
            modifier = modifier
                .fillMaxWidth(),
            value = state.repeatPassword,
            onValueChange = { viewModel.onEvent(SignUpEvents.UpdateRepeatPassword(it)) },
            placeholder = stringResource(R.string.placeholder_repeat_password_field),
            passwordVisible = state.isPasswordVisible,
            onPasswordVisibilityToggle = {
                viewModel.onEvent(
                    SignUpEvents.UpdatePasswordVisibility(
                        state.isPasswordVisible
                    )
                )
            }
        )
        Row(
            modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TriStateCheckbox(
                state = state.checked,
                onClick = {
                    viewModel.onEvent(
                        SignUpEvents.UpdateChecked(
                            when (state.checked) {
                                ToggleableState.On -> ToggleableState.Off
                                ToggleableState.Off -> ToggleableState.On
                                else -> ToggleableState.Indeterminate
                            }
                        )
                    )
                },
                colors = CheckboxDefaults.colors(
                    checkmarkColor = if (isSystemInDarkTheme()) authElements else Color.White,
                    checkedColor = if (isSystemInDarkTheme()) Color.White else authElements,
                    uncheckedColor = authElements,
                )
            )
            BasicText(
                text = buildAnnotatedString {
                    append(stringResource(R.string.accept_terms))
                    withLink(
                        LinkAnnotation.Clickable(
                            tag = "UserAgreement",
                            linkInteractionListener = {

                            },
                            styles = TextLinkStyles(
                                style = SpanStyle(
                                    color = authTextColor(),
                                    textDecoration = TextDecoration.Underline
                                )
                            )
                        )
                    ) {
                        append(stringResource(R.string.user_agreement))
                    }
                },
                style = TextStyle(
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 14.sp
                )
            )
        }
        GradientButton(
            modifier.padding(10.dp),
            onClick = {
                viewModel.onEvent(SignUpEvents.SignUp)
            },
            text = stringResource(R.string.sign_up_button),
            gradient = if (isButtonEnabled) gradButtAutEnable else gradButtDisable(),
            enabled = isButtonEnabled,
        )
        Row(
            modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            SimpleText(
                text = stringResource(R.string.if_has_account),
                textSize = 16.sp,
            )
            SimpleText(
                text = stringResource(R.string.login_button),
                textSize = 16.sp,
                textColor = authTextColor(),
                modifier = modifier
                    .clickable { navigateTo(NavScreens.LoginScreen) }
                    .padding(start = 25.dp)
            )
        }
    }
}