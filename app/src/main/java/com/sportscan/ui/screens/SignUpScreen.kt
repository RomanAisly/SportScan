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
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sportscan.domain.navigation.NavScreens
import com.sportscan.ui.components.GradientButton
import com.sportscan.ui.components.LoginTextField
import com.sportscan.ui.components.PasswordTextField
import com.sportscan.ui.theme.authElements
import com.sportscan.ui.theme.gradButtAutDisabled
import com.sportscan.ui.theme.gradButtAutEnable
import com.sportscan.ui.theme.gradLogoText
import com.sportscan.ui.viewmodels.SignUpScreenViewModel

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    navigateTo: (NavScreens) -> Unit,
    signUpViewModel: SignUpScreenViewModel = viewModel()
) {
    val login by signUpViewModel.login.collectAsState()
    val password by signUpViewModel.password.collectAsState()
    val repeatPassword by signUpViewModel.repeatPassword.collectAsState()

    var passwordVisible by remember { mutableStateOf(false) }
    var checked by remember { mutableStateOf(ToggleableState.Off) }

    Column(
        modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .systemBarsPadding()
            .padding(14.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Column(
            modifier = modifier.padding(bottom = 160.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "ActivityScan",
                fontSize = 30.sp,
                style = TextStyle(
                    brush = gradLogoText
                ),
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "sports",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }

        LoginTextField(
            modifier = modifier
                .fillMaxWidth()
                .padding(),
            value = login,
            onValueChange = signUpViewModel::updateLogin,
            placeholder = "Enter email"
        )

        PasswordTextField(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            value = password,
            onValueChange = signUpViewModel::updatePassword,
            placeholder = "Enter password",
            passwordVisible = passwordVisible,
            onPasswordVisibilityToggle = {
                passwordVisible =
                    !passwordVisible
            }
        )
        PasswordTextField(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            value = repeatPassword,
            onValueChange = signUpViewModel::updateRepeatPassword,
            placeholder = "Repeat password",
            passwordVisible = passwordVisible,
            onPasswordVisibilityToggle = {
                passwordVisible =
                    !passwordVisible
            }
        )

        Row(
            modifier
                .fillMaxWidth()
                .padding(top = 74.dp, bottom = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TriStateCheckbox(
                state = checked,
                onClick = {
                    checked = if (checked == ToggleableState.Off) {
                        ToggleableState.On
                    } else {
                        ToggleableState.Off
                    }
                },
                colors = CheckboxDefaults.colors(
                    checkmarkColor = if (isSystemInDarkTheme()) {
                        authElements
                    } else {
                        Color.White
                    },
                    checkedColor = if (isSystemInDarkTheme()) {
                        Color.White
                    } else {
                        authElements
                    },
                    uncheckedColor = authElements,
                )
            )
            BasicText(
                text = buildAnnotatedString {
                    append("I accept the terms of the ")
                    withLink(
                        LinkAnnotation.Url(
                            "",
                            TextLinkStyles(
                                style = SpanStyle(
                                    color = if (isSystemInDarkTheme()) {
                                        Color.Blue
                                    } else {
                                        authElements
                                    },
                                    textDecoration = TextDecoration.Underline
                                )
                            )
                        )
                    ) {
                        append(" User Agreement")
                    }
                },
                style = TextStyle(color = MaterialTheme.colorScheme.onSurface, fontSize = 14.sp)
            )
        }

        GradientButton(
            onClick = { navigateTo.invoke(NavScreens.ProfileScreen) },
            text = "Register",
            gradient = if (login.isNotEmpty() && password.isNotEmpty() && repeatPassword.isNotEmpty()) {
                gradButtAutEnable
            } else {
                gradButtAutDisabled
            },
            enabled = login.isNotEmpty() && password.isNotEmpty() && repeatPassword.isNotEmpty(),
        )

        Row(
            modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Already have an account?",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = "Enter",
                fontSize = 16.sp,
                color = if (isSystemInDarkTheme()) {
                    Color.Blue
                } else {
                    authElements
                },
                modifier = modifier
                    .clickable {
                        navigateTo.invoke(NavScreens.LoginScreen)
                    }
                    .padding(start = 25.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    SignUpScreen(navigateTo = {})
}