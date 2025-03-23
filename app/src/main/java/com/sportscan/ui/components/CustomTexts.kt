package com.sportscan.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun SimpleText(
    modifier: Modifier = Modifier,
    text: String,
    textSize: TextUnit = 14.sp,
    textWeight: FontWeight = FontWeight.Normal,
    textAlign: TextAlign = TextAlign.Start,
    textColor: Color = MaterialTheme.colorScheme.onSurface
) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = textSize,
            fontWeight = textWeight,
            textAlign = textAlign,
            color = textColor,
        ),
        modifier = modifier
    )
}