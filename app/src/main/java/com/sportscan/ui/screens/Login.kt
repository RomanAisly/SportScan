package com.sportscan.ui.screens

import android.content.res.Configuration
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
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
import com.sportscan.ui.components.forePassTextColor
import com.sportscan.ui.components.gradButtDisable
import com.sportscan.ui.components.screenBackground
import com.sportscan.ui.theme.gradButtAutEnable
import com.sportscan.ui.theme.gradLogoDark
import com.sportscan.ui.theme.gradLogoLight
import com.sportscan.ui.viewmodels.LoginViewModel

@Composable
fun Login(
    modifier: Modifier = Modifier,
    navigateTo: (NavScreens) -> Unit,
    loginViewModel: LoginViewModel = viewModel()
) {
    val configuration = LocalConfiguration.current
    val login by loginViewModel.login.collectAsState()
    val password by loginViewModel.password.collectAsState()
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
        Scaffold { paddingValues ->
            Column(
                modifier
                    .fillMaxSize()
                    .padding(
                        top = paddingValues.calculateTopPadding(),
                        bottom = paddingValues.calculateBottomPadding(),
                    )
                    .verticalScroll(rememberScrollState())
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
                    value = login,
                    onValueChange = loginViewModel::updateLogin,
                    placeholder = stringResource(R.string.placeholder_login_field),
                    supportingText = {
                        Text(
                            text = stringResource(R.string.sub_text_login_invalid),
                            color = MaterialTheme.colorScheme.error
                        )
                    },
                    isError = false // TODO: проверка через бэк
                )

                PasswordTextField(
                    modifier = modifier,
                    value = password,
                    onValueChange = loginViewModel::updatePassword,
                    placeholder = stringResource(R.string.placeholder_password_field),
                    passwordVisible = passwordVisible,
                    onPasswordVisibilityToggle = {
                        passwordVisible =
                            !passwordVisible
                    },
                    supportingText = {
                        Text(
                            text = stringResource(R.string.sub_text_password_invalid),
                            color = MaterialTheme.colorScheme.error
                        )
                    },
                    isError = false // TODO: проверка через бэк
                )

                Text(
                    text = stringResource(R.string.password_recovery),
                    fontSize = 16.sp,
                    color = forePassTextColor(),
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(end = 16.dp)
                        .clickable { },
                )

                GradientButton(
                    onClick = { navigateTo.invoke(NavScreens.ProfileScreen) },
                    text = stringResource(R.string.login_button),
                    enabled = login.isNotEmpty() && password.isNotEmpty(),
                    gradient = if (login.isNotEmpty() && password.isNotEmpty())
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

                    Text(
                        text = stringResource(R.string.sign_up_if_no_account),
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Text(
                        text = stringResource(R.string.sign_up_button),
                        fontSize = 16.sp,
                        color = authTextColor(),
                        modifier = Modifier.clickable { navigateTo.invoke(NavScreens.SignUpScreen) }
                    )
                }
            }
        }
    } else {
        Scaffold { paddingValues ->
            Column(
                modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(screenBackground()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {

                Logo(
                    modifier = modifier.padding(vertical = 20.dp),
                    gradient = if (isSystemInDarkTheme()) gradLogoDark else gradLogoLight
                )
                Row(
                    modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        LoginTextField(
                            modifier = modifier,
                            value = login,
                            onValueChange = loginViewModel::updateLogin,
                            placeholder = stringResource(R.string.placeholder_login_field),
                            supportingText = {
                                Text(
                                    text = stringResource(R.string.sub_text_login_invalid),
                                    color = MaterialTheme.colorScheme.error
                                )
                            },
                            isError = false // TODO: проверка через бэк
                        )

                        PasswordTextField(
                            modifier = modifier,
                            value = password,
                            onValueChange = loginViewModel::updatePassword,
                            placeholder = stringResource(R.string.placeholder_password_field),
                            passwordVisible = passwordVisible,
                            onPasswordVisibilityToggle = {
                                passwordVisible =
                                    !passwordVisible
                            },
                            supportingText = {
                                Text(
                                    text = stringResource(R.string.sub_text_password_invalid),
                                    color = MaterialTheme.colorScheme.error
                                )
                            },
                            isError = false // TODO: проверка через бэк
                        )

                        Text(
                            text = stringResource(R.string.password_recovery),
                            fontSize = 16.sp,
                            color = forePassTextColor(),
                            modifier = Modifier
                                .clickable { },
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(18.dp, Alignment.Top)
                    ) {
                        GradientButton(
                            onClick = { navigateTo.invoke(NavScreens.ProfileScreen) },
                            text = stringResource(R.string.login_button),
                            enabled = login.isNotEmpty() && password.isNotEmpty(),
                            gradient = if (login.isNotEmpty() && password.isNotEmpty())
                                gradButtAutEnable
                            else gradButtDisable(),
                            modifier = modifier.padding(top = 35.dp)
                        )

                        Text(
                            text = stringResource(R.string.sign_up_if_no_account),
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Text(
                            text = stringResource(R.string.sign_up_button),
                            fontSize = 16.sp,
                            color = authTextColor(),
                            modifier = Modifier.clickable { navigateTo.invoke(NavScreens.SignUpScreen) }
                        )
                    }
                }
            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Preview() {
    Login(navigateTo = {})
}