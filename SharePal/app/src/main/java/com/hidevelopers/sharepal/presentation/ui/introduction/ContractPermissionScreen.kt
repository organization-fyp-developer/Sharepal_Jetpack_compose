package com.hidevelopers.sharepal.presentation.ui.introduction


import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.core.content.ContextCompat
import androidx.navigation.NavController

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState

@SuppressLint("LogNotTimber")
@Composable
fun ContractPermissionScreen(
    navController: NavController,
    viewModel: IntroductionViewModel = viewModel()
) {ExampleScreen()
    Column {
        Button(onClick = {

            navController.navigate(route = "profile_screen")
        }) {
            Text(text = "AGREE AND CONTINUE")
        }
    }
}
@Composable
fun ExampleScreen() {
    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            // Permission Accepted: Do something
            Log.d("ExampleScreen","PERMISSION GRANTED")

        } else {
            // Permission Denied: Do something
            Log.d("ExampleScreen","PERMISSION DENIED")
        }
    }
    val context = LocalContext.current

    Button(
        onClick = {
            // Check permission
            when (PackageManager.PERMISSION_GRANTED) {
                ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ) -> {
                    // Some works that require permission
                    Log.d("ExampleScreen","Code requires permission")
                }
                else -> {
                    // Asking for permission
                    launcher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
                }
            }
        }
    ) {
        Text(text = "Check and Request Permission")
    }
}