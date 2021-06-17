package com.hidevelopers.sharepal.presentation.ui.introduction

import android.content.IntentSender
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import kotlinx.coroutines.delay
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment

@Composable
fun SplashScreen(
    viewModel: IntroductionViewModel = viewModel(),
    onFinished: () -> Unit
) {
    Surface {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "SharePal")
        }
    }
    produceState(initialValue = 0){
        delay(viewModel.splashScreenDelay)
        onFinished()
    }
}