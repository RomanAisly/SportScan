package com.sportscan.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sportscan.R
import com.sportscan.domain.navigation.NavScreens
import com.sportscan.ui.components.GradientButton
import com.sportscan.ui.components.LoginTextField
import com.sportscan.ui.components.Logo
import com.sportscan.ui.components.PasswordTextField
import com.sportscan.ui.components.authTextColor
import com.sportscan.ui.components.gradButtDisable
import com.sportscan.ui.components.gradLogo
import com.sportscan.ui.components.screenBackground
import com.sportscan.ui.theme.authElements
import com.sportscan.ui.theme.gradButtAutEnable
import com.sportscan.ui.viewmodels.SignUpViewModel

@Composable
fun SignUpPortrait(
    modifier: Modifier = Modifier,
    navigateTo: (NavScreens) -> Unit,
    signUpViewModel: SignUpViewModel = viewModel()
) {
    val login by signUpViewModel.login.collectAsState()
    val password by signUpViewModel.password.collectAsState()
    val repeatPassword by signUpViewModel.repeatPassword.collectAsState()
    val checked by signUpViewModel.checked.collectAsState()
    val isButtonEnabled = login.isNotEmpty() &&
            password.isNotEmpty() &&
            repeatPassword.isNotEmpty() &&
            checked == ToggleableState.On
    val passwordVisible by signUpViewModel.isPasswordVisible.collectAsState()

    Scaffold(containerColor = screenBackground()) { paddingValues ->
        Column(
            modifier
                .fillMaxSize()
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding(),
                )
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
                value = login,
                onValueChange = signUpViewModel::updateLogin,
                placeholder = stringResource(R.string.placeholder_login_field)
            )
            PasswordTextField(
                modifier = modifier
                    .fillMaxWidth(),
                value = password,
                onValueChange = signUpViewModel::updatePassword,
                placeholder = stringResource(R.string.placeholder_password_field),
                passwordVisible = passwordVisible,
                onPasswordVisibilityToggle = signUpViewModel::togglePasswordVisibility
            )
            PasswordTextField(
                modifier = modifier
                    .fillMaxWidth(),
                value = repeatPassword,
                onValueChange = signUpViewModel::updateRepeatPassword,
                placeholder = stringResource(R.string.placeholder_repeat_password_field),
                passwordVisible = passwordVisible,
                onPasswordVisibilityToggle = signUpViewModel::togglePasswordVisibility
            )
            Row(
                modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TriStateCheckbox(
                    state = checked,
                    onClick = {
                        signUpViewModel.updateChecked(
                            when (checked) {
                                ToggleableState.On -> ToggleableState.Off
                                else -> ToggleableState.On
                            }
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
                onClick = { navigateTo(NavScreens.ProfileScreen) },
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
                Text(
                    text = stringResource(R.string.if_has_account),
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = stringResource(R.string.login_button),
                    fontSize = 16.sp,
                    color = authTextColor(),
                    modifier = modifier
                        .clickable {
                            navigateTo(NavScreens.LoginScreen)
                        }
                        .padding(start = 25.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    SignUpPortrait(navigateTo = {})
}