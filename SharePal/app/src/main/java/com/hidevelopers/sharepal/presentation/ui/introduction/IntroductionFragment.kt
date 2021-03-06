package com.hidevelopers.sharepal.presentation.ui.introduction

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.findNavController
import com.hidevelopers.sharepal.R
import com.hidevelopers.sharepal.presentation.theme.SharepalTheme
import timber.log.Timber

class IntroductionFragment : Fragment() {

    @SuppressLint("LogNotTimber")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return ComposeView(requireContext()).apply {
            setContent {
                SharepalTheme {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "splash_screen"
                    ){
                        composable(route = "splash_screen"){
                            SplashScreen {
                                if (checkBoardingFinished()){
                                    findNavController().navigate(R.id.viewMainInfo)
                                }else{
                                    navController.popBackStack()
                                    navController.navigate("contract_permission_screen")
                                }
                            }
                        }
                        composable(route = "contract_permission_screen"){
                            ContractPermissionScreen(navController = navController)
                        }
                        composable(route = "profile_screen"){
                            ProfileScreen {
                                onBoardingFinished()
                                findNavController().navigate(R.id.viewMainInfo)
                            }
                        }
                    }
                }
            }
        }
    }

    private fun onBoardingFinished() {
        val sharePref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharePref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }

    private fun checkBoardingFinished(): Boolean =
        requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
            .getBoolean("Finished", false)
}
