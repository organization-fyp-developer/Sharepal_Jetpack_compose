package com.hidevelopers.sharepal.presentation.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.findNavController
import com.hidevelopers.sharepal.presentation.theme.SharepalTheme

class MainInfoFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                SharepalTheme {
                    val navController = rememberNavController()
                    val openSelectDataScreen = findNavController()
                    val openReceiveDataScreen = findNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "home_screen"
                    ){
                        composable(route = "home_screen"){
                            HomeScreen(
                                navController = navController,
                                findNavController_SelectDataScreen = openSelectDataScreen,
                                findNavController_ReceiveDataScreen = openReceiveDataScreen
                            )
                        }
                    }
                }
            }
        }
    }
}