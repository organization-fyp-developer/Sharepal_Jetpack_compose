package com.hidevelopers.sharepal.presentation.ui.receive

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun ReceiveDataScreen(
    navController: NavHostController
){
    Surface(
        color = MaterialTheme.colors.surface
    ){
        Text(text = "Welcome to Receive Data Screen")
    }
}