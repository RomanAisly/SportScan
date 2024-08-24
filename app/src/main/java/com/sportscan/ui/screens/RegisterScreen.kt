package com.sportscan.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sportscan.R
import com.sportscan.domain.navigation.NavScreens
import com.sportscan.ui.theme.ButtAuth
import com.sportscan.ui.viewmodels.RegisterScreenViewModel

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    navigateTo: (NavScreens) -> Unit,
    registerViewModel: RegisterScreenViewModel = viewModel()
) {
    val login by registerViewModel.login.collectAsState()
    val password by registerViewModel.password.collectAsState()
    val repeatPassword by registerViewModel.repeatPassword.collectAsState()

    var passwordVisible by remember { mutableStateOf(false) }
    var checked by remember { mutableStateOf(ToggleableState.Off) }

    Column(
        modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
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
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp),
            value = login,
            onValueChange = login.let { registerViewModel::updateLogin },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            textStyle = TextStyle(fontSize = 18.sp, color = MaterialTheme.colorScheme.onSurface),
            leadingIcon = { Icon(imageVector = Icons.Outlined.Email, contentDescription = "") },
            placeholder = { Text(text = "Enter login/email") },
            shape = RoundedCornerShape(28.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.background,
                unfocusedContainerColor = MaterialTheme.colorScheme.background
            )
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
        )

        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp),
            value = password,
            onValueChange = password.let { registerViewModel::updatePassword },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            textStyle = TextStyle(fontSize = 18.sp, fontStyle = FontStyle.Normal),
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
            visualTransformation = if (passwordVisible) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            placeholder = { Text(text = "Enter password") },
            shape = RoundedCornerShape(28.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.background,
                unfocusedContainerColor = MaterialTheme.colorScheme.background
            )
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(12.dp)
        )

        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp),
            value = repeatPassword,
            onValueChange = repeatPassword.let { registerViewModel::updateRepeatPassword },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            textStyle = TextStyle(fontSize = 18.sp, fontStyle = FontStyle.Normal),
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
            visualTransformation = if (passwordVisible) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            placeholder = { Text(text = "Repeat password") },
            shape = RoundedCornerShape(28.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.background,
                unfocusedContainerColor = MaterialTheme.colorScheme.background
            )
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(14.dp)
        )

        Row(
            modifier.fillMaxWidth(),
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
                    checkmarkColor = Color.Green,
                    checkedColor = MaterialTheme.colorScheme.onPrimary,
                    uncheckedColor = Color.Green,
                )
            )
            Text(
                text = "I accept the terms of the ",
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 16.sp
            )

            Text(
                text = "User Agreement",
                color = Color.Blue,
                fontSize = 16.sp,
                modifier = modifier.clickable {  }
            )
        }
        
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(14.dp)
        )

        @Composable
        fun GradientButton() {
            val gradient = Brush.horizontalGradient(
                colors = listOf(Color.Blue, Color.Green)
            )
        }
        Button(
            onClick = { navigateTo.invoke(NavScreens.ProfileScreen) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = ButtAuth
            )
        ) {
            Text(
                text = "Register",
                fontSize = 17.sp
            )
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
        )

        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
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
                color = Color.Blue
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    RegisterScreen(navigateTo = {})
}