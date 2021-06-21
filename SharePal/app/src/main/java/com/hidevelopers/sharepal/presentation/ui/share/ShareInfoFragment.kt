package com.hidevelopers.sharepal.presentation.ui.share

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

class ShareInfoFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                SharepalTheme {
                    val navController = rememberNavController()
                    val openHomePage = findNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "select_data_screen"
                    ){
                        composable(
                            route = "select_data_screen"
                        ){
                            SelectDataScreen(
                                navController = navController,
                                findNavController_openHomePage = openHomePage
                            )
                        }
                    }
                }
            }
        }
    }
}