package com.sportscan.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.sportscan.R

@SuppressLint("SuspiciousIndentation")
@Composable
fun TrailingIconAnim(modifier: Modifier = Modifier, isPlaying: Boolean) {

    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.trailing_icon_anim))

    val progress by animateLottieCompositionAsState(
        composition,
        iterations = 1,
        isPlaying = isPlaying,
        restartOnPlay = true
    )
    LottieAnimation(
        composition = composition,
        progress = { progress },
        modifier = modifier.size(58.dp)
    )

}