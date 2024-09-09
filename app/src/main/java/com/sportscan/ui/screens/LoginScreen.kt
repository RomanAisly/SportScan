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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sportscan.domain.navigation.NavScreens
import com.sportscan.ui.components.GradientButton
import com.sportscan.ui.components.LoginTextField
import com.sportscan.ui.components.Logo
import com.sportscan.ui.components.PasswordTextField
import com.sportscan.ui.components.authTextColor
import com.sportscan.ui.components.forgPassTextColor
import com.sportscan.ui.components.gradButtDisable
import com.sportscan.ui.theme.gradButtAutEnable
import com.sportscan.ui.theme.gradLogoDark
import com.sportscan.ui.theme.gradLogoLight
import com.sportscan.ui.viewmodels.LoginScreeViewModel

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navigateTo: (NavScreens) -> Unit,
    loginViewModel: LoginScreeViewModel = viewModel()
) {
    val login by loginViewModel.login.collectAsState()
    val password by loginViewModel.password.collectAsState()

    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .systemBarsPadding()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Logo(
            modifier = modifier.padding(bottom = 120.dp),
            gradient = if (isSystemInDarkTheme()) gradLogoDark else gradLogoLight
        )

        LoginTextField(
            modifier = modifier
                .fillMaxWidth()
                .padding(),
            value = login,
            onValueChange = loginViewModel::updateLogin,
            placeholder = "Enter email"
        )

        PasswordTextField(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            value = password,
            onValueChange = loginViewModel::updatePassword,
            placeholder = "Enter password",
            passwordVisible = passwordVisible,
            onPasswordVisibilityToggle = {
                passwordVisible =
                    !passwordVisible
            }
        )

        Text(
            text = "Forgot password?",
            fontSize = 16.sp,
            color = forgPassTextColor(),
            modifier = Modifier
                .padding(top = 18.dp)
                .align(Alignment.End)
                .clickable { },
        )

        GradientButton(
            onClick = { navigateTo.invoke(NavScreens.ProfileScreen) },
            text = "Enter",
            enabled = login.isNotEmpty() && password.isNotEmpty(),
            gradient = if (login.isNotEmpty() && password.isNotEmpty())
                gradButtAutEnable
            else gradButtDisable(),
            modifier = modifier.padding(top = 62.dp),
        )

        Row(
            modifier
                .fillMaxWidth()
                .padding(top = 18.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Don't have an account?",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = "Register",
                fontSize = 16.sp,
                color = authTextColor(),
                modifier = Modifier.clickable { navigateTo.invoke(NavScreens.SignUpScreen) }
            )
        }
    }
}


@PreviewLightDark
@Composable
private fun Preview() {
    LoginScreen(navigateTo = {})
}