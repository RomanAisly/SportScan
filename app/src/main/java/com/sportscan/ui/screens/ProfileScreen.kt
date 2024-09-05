package com.sportscan.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.ChildCare
import androidx.compose.material.icons.outlined.GraphicEq
import androidx.compose.material.icons.outlined.LockPerson
import androidx.compose.material.icons.outlined.Money
import androidx.compose.material.icons.outlined.Sports
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sportscan.R
import com.sportscan.domain.navigation.NavScreens

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    navigateTo: (NavScreens) -> Unit
) {
    Column(
        modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.map), contentDescription = "",
            modifier
                .fillMaxWidth()
                .padding(6.dp),
            contentScale = ContentScale.FillBounds,
            alignment = Alignment.TopCenter
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(26.dp)
        )

        OutlinedTextField(
            value = "",
            onValueChange = {},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            textStyle = TextStyle(fontSize = 18.sp),
            leadingIcon = { Icon(imageVector = Icons.Outlined.Sports, contentDescription = "") },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Outlined.ArrowDropDown,
                    contentDescription = ""
                )
            },
            placeholder = {
                Text(
                    text = "Choose type of sport",
                    color = MaterialTheme.colorScheme.onSurface,
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        )

        Spacer(modifier = Modifier.height(14.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            textStyle = TextStyle(fontSize = 18.sp),
            leadingIcon = { Icon(imageVector = Icons.Outlined.GraphicEq, contentDescription = "") },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Outlined.ArrowDropDown,
                    contentDescription = ""
                )
            },
            placeholder = {
                Text(
                    text = "Choose work graphic",
                    color = MaterialTheme.colorScheme.onSurface,
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        )

        Spacer(modifier = Modifier.height(14.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            textStyle = TextStyle(fontSize = 18.sp),
            leadingIcon = { Icon(imageVector = Icons.Outlined.Money, contentDescription = "") },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Outlined.ArrowDropDown,
                    contentDescription = ""
                )
            },
            placeholder = {
                Text(
                    text = "Choose cost of the lesson",
                    color = MaterialTheme.colorScheme.onSurface,
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        )

        Spacer(modifier = Modifier.height(14.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            textStyle = TextStyle(fontSize = 18.sp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.LockPerson,
                    contentDescription = ""
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Outlined.ArrowDropDown,
                    contentDescription = ""
                )
            },
            placeholder = {
                Text(
                    text = "Is a sports uniform mandatory?",
                    color = MaterialTheme.colorScheme.onSurface,
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        )

        Spacer(modifier = Modifier.height(14.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            textStyle = TextStyle(fontSize = 18.sp),
            leadingIcon = { Icon(imageVector = Icons.Outlined.ChildCare, contentDescription = "") },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Outlined.ArrowDropDown,
                    contentDescription = ""
                )
            },
            placeholder = {
                Text(
                    text = "Choose age of client",
                    color = MaterialTheme.colorScheme.onSurface,
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        )

        Spacer(modifier = Modifier.height(14.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ProfileScreen {

    }
}