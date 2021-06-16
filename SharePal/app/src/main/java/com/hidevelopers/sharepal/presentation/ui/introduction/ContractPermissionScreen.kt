package com.hidevelopers.sharepal.presentation.ui.introduction


import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontStyle
import androidx.navigation.NavController

import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ContractPermissionScreen(
    navController: NavController,
    viewModel: IntroductionViewModel = viewModel()
) {
    Column {
        Button(onClick = {  }) {
            Text(text = "AGREE AND CONTINUE")
        }
    }
}