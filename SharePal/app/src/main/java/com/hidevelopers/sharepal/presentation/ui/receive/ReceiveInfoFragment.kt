package com.hidevelopers.sharepal.presentation.ui.receive

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hidevelopers.sharepal.presentation.theme.SharepalTheme

class ReceiveInfoFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                SharepalTheme {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "receive_data_screen"
                    ){
                       composable(
                           route = "receive_data_screen"
                       ){
                           ReceiveDataScreen(navController)
                       }
                    }
                }
            }
        }
    }
}