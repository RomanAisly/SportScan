package com.sportscan.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.sportscan.R

@Composable
fun LottieAnim1(modifier: Modifier = Modifier) {
    Box(modifier = modifier.size(80.dp), contentAlignment = Alignment.Center) {

        val lottieComposition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.ball_anim))
        val process by animateLottieCompositionAsState(
            composition = lottieComposition,
            iterations = LottieConstants.IterateForever,
            isPlaying = true,
            speed = 1f,
        )

        LottieAnimation(
            composition = lottieComposition,
            progress = { process }
        )
    }
}


@Composable
fun LottieAnim2(modifier: Modifier = Modifier) {
    Box(modifier = modifier.size(80.dp), contentAlignment = Alignment.Center) {

        val lottieComposition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.bicyclist_anim))
        val process by animateLottieCompositionAsState(
            composition = lottieComposition,
            iterations = LottieConstants.IterateForever,
            isPlaying = true,
            speed = 1f,
        )

        LottieAnimation(
            composition = lottieComposition,
            progress = { process }
        )
    }
}