package com.sportscan.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sportscan.R
import com.sportscan.domain.navigation.NavScreens
import com.sportscan.ui.viewmodels.LoginScreeViewModel

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier, navigateTo: (NavScreens) -> Unit,
    loginViewModel: LoginScreeViewModel = viewModel()
) {
    val login by loginViewModel.login.collectAsState()
    val password by loginViewModel.password.collectAsState()

    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.logo), contentDescription = "",
            modifier = Modifier
                .size(270.dp),
            contentScale = ContentScale.FillBounds
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(26.dp)
        )

        OutlinedTextField(
            value = login,
            onValueChange = login.let { loginViewModel::updateLogin },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            textStyle = TextStyle(fontSize = 18.sp),
            leadingIcon = { Icon(imageVector = Icons.Outlined.Email, contentDescription = "") },
            placeholder = { Text(text = "Enter login/email") }
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = password.let { loginViewModel::updatePassword },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            textStyle = TextStyle(fontSize = 18.sp),
            leadingIcon = { Icon(imageVector = Icons.Outlined.Lock, contentDescription = "") },
            trailingIcon = {
                val iconVisibilityPassword = if (passwordVisible) {
                    Icons.Outlined.Visibility
                } else {
                    Icons.Outlined.VisibilityOff
                }
                Icon(
                    imageVector = iconVisibilityPassword,
                    contentDescription = if (passwordVisible) "Hide password" else "Show password",
                    modifier = Modifier.clickable { passwordVisible = !passwordVisible }
                )
            },
            modifier = Modifier
                .padding(top = 10.dp),
            visualTransformation = if (passwordVisible) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            placeholder = { Text(text = "Enter password") }
        )

        Text(
            text = "Forgot password?",
            modifier = Modifier
                .padding(top = 16.dp, end = 16.dp)
                .align(Alignment.End)
                .clickable { },
            fontSize = 14.sp,
            color = Color.Blue
        )

        Button(
            onClick = { navigateTo.invoke(NavScreens.HomeScreen) },
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Text(text = "Enter")
        }

        Text(
            text = "Don't have an account?",
            modifier = Modifier.padding(top = 26.dp),
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSurface
        )

        Button(
            onClick = { navigateTo.invoke(NavScreens.RegisterScreen) },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Register")
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    LoginScreen(navigateTo = {})
}