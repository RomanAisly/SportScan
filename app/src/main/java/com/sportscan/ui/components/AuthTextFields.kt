package com.sportscan.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.sportscan.ui.screens.LoginScreen
import com.sportscan.ui.theme.authElements
import com.sportscan.ui.theme.borderOutlinedTextField

@Composable
fun LoginTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        textStyle = TextStyle(fontSize = 18.sp),
        placeholder = { Text(text = placeholder) },
        shape = MaterialTheme.shapes.extraLarge,
        colors = TextFieldDefaults.colors(
            focusedTextColor = if (isSystemInDarkTheme()) {
                Color.White
            } else {
                authElements
            },
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = borderOutlinedTextField,
            errorContainerColor = Color.Red,
        ),
    )
}

@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    passwordVisible: Boolean,
    onPasswordVisibilityToggle: () -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        textStyle = TextStyle(fontSize = 18.sp),
        trailingIcon = {
            val iconVisibilityPassword = if (passwordVisible) {
                Icons.Outlined.Visibility
            } else {
                Icons.Outlined.VisibilityOff
            }
            Icon(
                imageVector = iconVisibilityPassword,
                contentDescription = if (passwordVisible) "Hide password" else "Show password",
                modifier = Modifier.clickable { onPasswordVisibilityToggle() }
            )
        },
        visualTransformation = if (passwordVisible) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        placeholder = { Text(text = placeholder) },
        shape = MaterialTheme.shapes.extraLarge,
        colors = TextFieldDefaults.colors(
            focusedTextColor = if (isSystemInDarkTheme()) {
                Color.White
            } else {
                authElements
            },
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = borderOutlinedTextField,
            errorContainerColor = Color.Red,
            errorTextColor = Color.Red,
            errorIndicatorColor = Color.Red,
            focusedTrailingIconColor = if (isSystemInDarkTheme()) {
                Color.White
            } else {
                authElements
            },
            unfocusedTrailingIconColor = Color.Transparent
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    LoginScreen(navigateTo = {})
}