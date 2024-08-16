package com.sportscan.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Co2
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.EmojiFlags
import androidx.compose.material.icons.outlined.Facebook
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.RemoveRedEye
import androidx.compose.material.icons.rounded.LogoDev
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sportscan.R
import com.sportscan.domain.navigation.NavScreens

@Composable
fun RegisterScreen(modifier: Modifier = Modifier, navigateTo: (NavScreens) -> Unit) {
    Column(
        modifier
            .fillMaxSize().background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo), contentDescription = "",
            modifier = Modifier
                .size(290.dp)
                .padding(top = 40.dp),
            contentScale = ContentScale.Fit,
            alignment = Alignment.TopCenter
        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            textStyle = TextStyle(fontSize = 18.sp, fontStyle = FontStyle.Normal),
            leadingIcon = { Icon(imageVector = Icons.Outlined.Email, contentDescription = "") },
            placeholder = { Text(text = "Enter login/email") },
            modifier = Modifier.padding(top = 28.dp)
        )

        OutlinedTextField(
            value = "",
            onValueChange = {},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            textStyle = TextStyle(fontSize = 18.sp, fontStyle = FontStyle.Normal),
            leadingIcon = { Icon(imageVector = Icons.Outlined.Lock, contentDescription = "") },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Outlined.RemoveRedEye,
                    contentDescription = "",
                    modifier = Modifier.clickable {

                    }
                )
            },
            placeholder = { Text(text = "Enter password") },
            modifier = Modifier.padding(top = 16.dp)
        )

        OutlinedTextField(
            value = "",
            onValueChange = {},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            textStyle = TextStyle(fontSize = 18.sp, fontStyle = FontStyle.Normal),
            leadingIcon = { Icon(imageVector = Icons.Outlined.Lock, contentDescription = "") },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Outlined.RemoveRedEye,
                    contentDescription = "",
                    modifier = Modifier.clickable {

                    }
                )
            },
            placeholder = { Text(text = "Repeat password") },
            modifier = Modifier.padding(top = 12.dp)
        )

        Button(
            onClick = { navigateTo.invoke(NavScreens.RegisterScreen) },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Register")
        }

        Text(
            text = "Continue with...",
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(top = 36.dp)
        )

        Row {
            Icon(
                imageVector = Icons.Outlined.Facebook, contentDescription = "",
                modifier = Modifier
                    .size(60.dp)
                    .padding(top = 18.dp),
                tint = Color.Blue
            )
            Icon(
                imageVector = Icons.Outlined.AccountCircle, contentDescription = "",
                modifier = Modifier
                    .size(60.dp)
                    .padding(top = 18.dp),
                tint = Color.Green
            )
            Icon(
                imageVector = Icons.Outlined.Email, contentDescription = "",
                modifier = Modifier
                    .size(60.dp)
                    .padding(top = 18.dp),
                tint = Color.Red
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    RegisterScreen {

    }
}