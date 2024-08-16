package com.sportscan.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.RemoveRedEye
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
fun LoginScreen(modifier: Modifier = Modifier, navigateTo: (NavScreens) -> Unit) {
    Column(
        modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
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
        Text(
            text = "Forgot password?",
            modifier = Modifier
                .padding(top = 16.dp, end = 16.dp)
                .align(Alignment.End),
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
    LoginScreen {

    }
}