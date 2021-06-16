package com.hidevelopers.sharepal.presentation.ui.introduction

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewmodel.compose.viewModel
@Composable
fun ProfileScreen(
    viewModel: IntroductionViewModel = viewModel(),
    onFinished:()->Unit
) {
    Column {
        Button(onClick = {
            onFinished()
        }) {
            Text(text = "SAVE INFORMATION")
        }
    }
}

