package com.hidevelopers.sharepal.presentation.ui.introduction


import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontStyle
import androidx.navigation.NavController

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState

@SuppressLint("LogNotTimber")
@Composable
fun ContractPermissionScreen(
    navController: NavController,
    viewModel: IntroductionViewModel = viewModel()
) {
    Column {
        Button(onClick = {

            navController.navigate(route = "profile_screen")
        }) {
            Text(text = "AGREE AND CONTINUE")
        }
    }
}