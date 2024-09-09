package com.sportscan.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sportscan.R
import com.sportscan.domain.navigation.NavScreens

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navigateTo: (NavScreens) -> Unit) {
    Column(
        modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .systemBarsPadding()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            FloatingActionButton(
                onClick = { navigateTo.invoke(NavScreens.ProfileScreen) },
                modifier
                    .wrapContentSize()
                    .size(40.dp),
                shape = RoundedCornerShape(30.dp),
                containerColor = Color.DarkGray,
                contentColor = Color.White
            ) {
                Icon(
                    imageVector = Icons.Rounded.AccountCircle,
                    contentDescription = "",
                    modifier.wrapContentSize()
                )
            }
            FloatingActionButton(
                onClick = { },
                modifier
                    .wrapContentSize()
                    .size(40.dp),
                shape = RoundedCornerShape(30.dp),
                containerColor = Color.DarkGray,
                contentColor = Color.White
            ) {
                Icon(
                    imageVector = Icons.Rounded.Settings, contentDescription = "",
                    modifier.wrapContentSize()
                )
            }

        }
        Image(
            painter = painterResource(id = R.drawable.map), contentDescription = "",
            contentScale = ContentScale.FillBounds,
            alignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .size(300.dp)
                .padding(4.dp)
        )
        LazyColumn {
            items(8) {

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    HomeScreen {

    }
}