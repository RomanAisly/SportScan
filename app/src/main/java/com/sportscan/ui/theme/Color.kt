package com.sportscan.ui.theme

import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val ButtAuth = Color(0xFFFF9800)

val gradButtAuth = Brush.horizontalGradient(
    colors = listOf(
        Color(0xFFF0B012),
        Color(0xFFF77103)
    ), 
    tileMode = TileMode.Mirror
)

val gradButtAuth2 = Brush.radialGradient(
    colors = listOf(
        Color(0xFF0885E7),
        Color(0xFF09E60D)
    ),
    tileMode = TileMode.Mirror
)

val gradButtAuth3 = Brush.radialGradient(
    colors = listOf(
        Color(0xFFE21264),
        Color(0xFF1CBACA)
    ),
    tileMode = TileMode.Mirror
)

val gradButtAuth4 = Brush.radialGradient(
    colors = listOf(
        Color(0xFF0C6494),
        Color(0xFFE0A81C)
    ),
    tileMode = TileMode.Mirror
)

val gradButtAuth5 = Brush.horizontalGradient(
    colors = listOf(
        Color(0xFF0F41F3),
        Color(0xFFFC0303)
    ),
    tileMode = TileMode.Mirror
)