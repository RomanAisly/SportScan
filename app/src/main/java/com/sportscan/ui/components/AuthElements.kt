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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sportscan.R
import com.sportscan.ui.theme.authElements
import com.sportscan.ui.theme.borderOutlinedTextField
import com.sportscan.ui.theme.darkBlue
import com.sportscan.ui.theme.errorColor
import com.sportscan.ui.theme.gradButtAutDisabled
import com.sportscan.ui.theme.gradButtAutDisabled2
import com.sportscan.ui.theme.gradLogoDark
import com.sportscan.ui.theme.gradLogoLight
import com.sportscan.ui.theme.lightBlue
import com.sportscan.ui.theme.lightWhite
import com.sportscan.ui.theme.transparent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun Logo(modifier: Modifier = Modifier, gradient: Brush) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(R.string.app_name),
            fontSize = 30.sp,
            style = TextStyle(
                brush = gradient
            ),
            fontWeight = FontWeight.SemiBold
        )
        SimpleText(
            text = stringResource(R.string.profile_logo_small_text),
            textSize = 16.sp,
            textWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun LoginTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    supportingText: @Composable () -> Unit = {},
    isError: Boolean = false
) {
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
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
        supportingText = { if (isError) supportingText() },
        isError = isError,
        shape = MaterialTheme.shapes.extraLarge,
        colors = TextFieldDefaults.colors(
            focusedTextColor = focusedFieldContent(),
            unfocusedIndicatorColor = transparent,
            focusedIndicatorColor = borderOutlinedTextField,
            errorContainerColor = errorColor,
            errorTextColor = errorColor,
            errorIndicatorColor = errorColor,
            unfocusedContainerColor = authInputField(),
            focusedContainerColor = authInputField()
        )
    )
}

@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    passwordVisible: Boolean,
    onPasswordVisibilityToggle: () -> Unit,
    supportingText: @Composable () -> Unit = {},
    isError: Boolean = false
) {
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
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
                contentDescription = if (passwordVisible) stringResource(R.string.cont_desc_hide_password) else stringResource(
                    R.string.cont_desc_show_password
                ),
                modifier = Modifier.clickable { onPasswordVisibilityToggle() }
            )
        },
        visualTransformation = if (passwordVisible) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        placeholder = { Text(text = placeholder) },
        supportingText = { if (isError) supportingText() },
        isError = isError,
        shape = MaterialTheme.shapes.extraLarge,
        colors = TextFieldDefaults.colors(
            focusedTextColor = focusedFieldContent(),
            unfocusedIndicatorColor = transparent,
            focusedIndicatorColor = borderOutlinedTextField,
            errorContainerColor = errorColor,
            errorTextColor = errorColor,
            errorIndicatorColor = errorColor,
            focusedTrailingIconColor = focusedFieldContent(),
            unfocusedTrailingIconColor = transparent,
            unfocusedContainerColor = authInputField(),
            focusedContainerColor = authInputField()
        )
    )
}

@Composable
fun GradientButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    enabled: Boolean = true,
    gradient: Brush,
) {
    val coroutineScope = rememberCoroutineScope()
    var isLoading by remember { mutableStateOf(false) }

    Button(
        onClick = {
            coroutineScope.launch(Dispatchers.Main) {
                isLoading = true
                delay(3000)
                isLoading = false
                onClick()
            }
        },
        enabled = enabled,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(46.dp)
                .background(gradient, shape = MaterialTheme.shapes.extraLarge)
                .padding(vertical = 12.dp),
            contentAlignment = Alignment.Center,
        ) {
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(26.dp),
                    trackColor = Color.Cyan,
                    strokeWidth = 3.dp,
                    strokeCap = StrokeCap.Round
                )
            } else {
                SimpleText(
                    text = text,
                    textSize = 18.sp,
                    textWeight = FontWeight.SemiBold,
                    textColor = darkBlue
                )
            }
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
fun forePassTextColor() = if (isSystemInDarkTheme()) lightBlue else Color.LightGray

@Composable
fun gradLogo() = if (isSystemInDarkTheme()) gradLogoDark else gradLogoLight

@Composable
fun gradButtDisable() = if (isSystemInDarkTheme()) gradButtAutDisabled2 else gradButtAutDisabled

@Composable
fun focusedFieldContent() = if (isSystemInDarkTheme()) Color.White else authElements