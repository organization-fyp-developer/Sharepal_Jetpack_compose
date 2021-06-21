package com.hidevelopers.sharepal.presentation.ui.share

import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.hidevelopers.sharepal.R
import androidx.compose.foundation.layout.Column
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import javax.annotation.meta.When


@Composable
fun SelectDataScreen(
    navController: NavHostController,
    findNavController_openHomePage: NavController,
) {
    Surface(
        color = MaterialTheme.colors.surface
    ) {
        Scaffold(
            topBar = {
                SelectDataTopBar(
                    goto_homePage = findNavController_openHomePage
                )
            }
        ) {
            Column {

             tabsBar()


            }
        }
    }
}


@Composable
fun SelectDataTopBar(
    goto_homePage: NavController
) {
    MaterialTheme {
        Column {
            TopAppBar(
                title = {
                    Text(
                        text = "Select Files",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                },
                backgroundColor = MaterialTheme.colors.surface,
                elevation = 0.dp,
                navigationIcon = {
                    IconButton(onClick = {
                        goto_homePage.navigate(R.id.action_shareInfoFragment_to_mainInfoFragment)
                    }) {
                        Icon(Icons.Rounded.ArrowBack, contentDescription = "Menu Icon")
                    }
                }
            )

        }
    }
}

@Composable
fun tabsBar() {
    var state by remember { mutableStateOf(0) }
    val titles = listOf("RECENT", "FILES", "VIDEOS", "APPS", "PHOTOS", "MUSIC")
    Column {
        ScrollableTabRow(
            selectedTabIndex = state,
            edgePadding = 0.dp,
            backgroundColor = MaterialTheme.colors.surface,
            modifier = Modifier
                .height(30.dp)
                .padding(0.dp),
        ){
            titles.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = state == index,
                    onClick = { state = index }
                )
            }
        }

        when(state){
            0 -> {
                recentFiles()
            }
            1 -> {
                allFilesOfAndroid()
            }
            2 -> {
                allVideos()
            }
            3 -> {
                allAppsInstalled()
            }
            4 -> {
                allPhotos()
            }
            5 -> {
                allAudioFiles()
            }
        }

    }
}
@Composable
fun recentFiles(){

}

@Composable
fun allFilesOfAndroid(){

}

@Composable
fun allVideos(){

}

@Composable
fun allAppsInstalled(){

}

@Composable
fun allPhotos(){

}

@Composable
fun allAudioFiles(){

}

