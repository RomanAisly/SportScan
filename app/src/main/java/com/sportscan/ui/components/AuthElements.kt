package com.sportscan.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sportscan.ui.theme.authElements
import com.sportscan.ui.theme.borderOutlinedTextField
import com.sportscan.ui.theme.darkBlue
import com.sportscan.ui.theme.gradButtAutDisabled
import com.sportscan.ui.theme.gradButtAutDisabled2
import com.sportscan.ui.theme.gradLogoDark
import com.sportscan.ui.theme.gradLogoLight
import com.sportscan.ui.theme.lightBlue
import com.sportscan.ui.theme.lightWhite


@Composable
fun Logo(modifier: Modifier = Modifier, gradient: Brush) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "ActivityScan",
            fontSize = 30.sp,
            style = TextStyle(
                brush = gradient
            ),
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = "sports",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun LoginTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier
) {
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
            }
        ),
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
            unfocusedContainerColor = authInputField(),
            focusedContainerColor = authInputField()
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

    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
            }
        ),
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
            unfocusedTrailingIconColor = Color.Transparent,
            unfocusedContainerColor = authInputField(),
            focusedContainerColor = authInputField()
        )
    )
}

@Composable
fun GradientButton(
    onClick: () -> Unit,
    text: String,
    enabled: Boolean,
    gradient: Brush,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier
            .fillMaxWidth()
            .heightIn(46.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(46.dp)
                .background(gradient, shape = MaterialTheme.shapes.extraLarge)
                .padding(vertical = 12.dp),
            contentAlignment = Alignment.TopCenter,
        ) {
            Text(
                text = text,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }
    }
}


@Composable
fun authInputField() = if (isSystemInDarkTheme()) Color.Black else lightWhite

@Composable
fun screenBackground() = if (isSystemInDarkTheme()) darkBlue else Color.White

@Composable
fun authTextColor() = if (isSystemInDarkTheme()) lightBlue else Color.Blue

@Composable
fun foregPassTextColor() = if (isSystemInDarkTheme()) lightBlue else Color.LightGray

@Composable
fun gradLogo() = if (isSystemInDarkTheme()) gradLogoDark else gradLogoLight

@Composable
fun gradButtDisable() = if (isSystemInDarkTheme()) gradButtAutDisabled2 else gradButtAutDisabled