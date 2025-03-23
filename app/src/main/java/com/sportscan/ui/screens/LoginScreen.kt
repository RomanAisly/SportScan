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
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
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
import com.sportscan.ui.components.forePassTextColor
import com.sportscan.ui.components.gradButtDisable
import com.sportscan.ui.components.screenBackground
import com.sportscan.ui.theme.gradButtAutEnable
import com.sportscan.ui.theme.gradLogoDark
import com.sportscan.ui.theme.gradLogoLight
import com.sportscan.ui.viewmodels.LoginViewModel
import com.sportscan.utils.ResultData
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navigateTo: (NavScreens) -> Unit,
    viewModel: LoginViewModel = koinViewModel()
) {
    val context = LocalContext.current
    val state by viewModel.state.collectAsState()

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
            .background(screenBackground()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(18.dp, Alignment.CenterVertically)
    ) {
        Logo(
            modifier = modifier.padding(bottom = 90.dp),
            gradient = if (isSystemInDarkTheme()) gradLogoDark else gradLogoLight
        )
        LoginTextField(
            modifier = modifier,
            value = state.login,
            onValueChange = viewModel::updateLogin,
            placeholder = stringResource(R.string.placeholder_login_field),
            supportingText = {
                SimpleText(
                    text = stringResource(R.string.sub_text_login_invalid),
                    textSize = 14.sp,
                    textColor = MaterialTheme.colorScheme.error
                )
            },
            isError = false // TODO: проверка через бэк
        )
        PasswordTextField(
            modifier = modifier,
            value = state.password,
            onValueChange = viewModel::updatePassword,
            placeholder = stringResource(R.string.placeholder_password_field),
            passwordVisible = state.isPasswordVisible,
            onPasswordVisibilityToggle = { viewModel.updatePasswordVisibility(state.isPasswordVisible) },
            supportingText = {
                SimpleText(
                    text = stringResource(R.string.sub_text_password_invalid),
                    textSize = 14.sp,
                    textColor = MaterialTheme.colorScheme.error
                )
            },
            isError = false // TODO: проверка через бэк
        )
        SimpleText(
            text = stringResource(R.string.password_recovery),
            textSize = 16.sp,
            textColor = forePassTextColor(),
            modifier = modifier
                .align(Alignment.End)
                .padding(end = 16.dp)
                .clickable { }
        )
        GradientButton(
            onClick = {
                viewModel.login()
            },
            text = stringResource(R.string.login_button),
            enabled = state.login.isNotEmpty() && state.password.isNotEmpty(),
            gradient = if (state.login.isNotEmpty() && state.password.isNotEmpty())
                gradButtAutEnable
            else gradButtDisable(),
            modifier = modifier.padding(top = 35.dp)
        )
        Row(
            modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            SimpleText(
                text = stringResource(R.string.sign_up_if_no_account),
                textSize = 16.sp
            )
            SimpleText(
                text = stringResource(R.string.sign_up_button),
                textSize = 16.sp,
                textColor = authTextColor(),
                modifier = modifier.clickable { navigateTo(NavScreens.SignUpScreen) }
            )
        }
    }
}