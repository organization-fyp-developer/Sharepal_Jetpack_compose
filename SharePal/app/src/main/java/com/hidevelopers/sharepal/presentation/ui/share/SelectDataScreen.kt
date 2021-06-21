package com.hidevelopers.sharepal.presentation.ui.share

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import kotlinx.coroutines.flow.channelFlow


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
    val titles = listOf("FILES", "VIDEOS", "APPS", "PHOTOS", "MUSIC")
    var stateScroll = rememberScrollState()

    Column {
        ScrollableTabRow(
            selectedTabIndex = state,
            edgePadding = 0.dp,
            backgroundColor = MaterialTheme.colors.surface,
            modifier = Modifier
                .height(30.dp)
                .padding(0.dp),
        ) {
            titles.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = state == index,
                    onClick = { state = index }
                )
            }
        }

        when (state) {

            0 -> {
                allFilesOfAndroid(state)
            }
            1 -> {
                allVideos(state)
            }
            2 -> {
                allAppsInstalled(state)
            }
            3 -> {
                val painter = painterResource(R.drawable.antman)
                val description = "It is Ant-man"

                Column(
                    modifier = Modifier.verticalScroll(stateScroll)
                ) {

                    for (i in 1..10) {
                    Row {
                        allPhotos(
                            painter = painter,
                            contentDescription = description,
                            modifier = Modifier.weight(1f)
                            )
                        allPhotos(
                            painter = painter,
                            contentDescription = description,
                            modifier = Modifier.weight(1f)

                        )
                        allPhotos(
                            painter = painter,
                            contentDescription = description,
                            modifier = Modifier.weight(1f)

                        )
                    }
                    }




                }

            }

            4 -> {
                allAudioFiles(state)
            }
        }
    }
}

@Composable
fun allFilesOfAndroid(state: Int) {
    Text(
        text = "Tab ${state + 1} is Selected"
    )
}

@Composable
fun allVideos(state: Int) {
    Text(
        text = "Tab ${state + 1} is Selected"
    )
}

@Composable
fun allAppsInstalled(state: Int) {
    Text(
        text = "Tab ${state + 1} is Selected"
    )
}

@Composable
fun allPhotos(
    painter: Painter,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    var isChecked = remember { mutableStateOf(false) }


        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(5.dp)
                .size(120.dp),
            shape = RoundedCornerShape(15.dp),
            elevation = 5.dp
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.2f)
            ) {
                Image(
                    painter = painter,
                    contentDescription = contentDescription,
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .fillMaxHeight(0.21f)
                        .fillMaxWidth(1f)
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.DarkGray,
                                    Color.Transparent
                                ),
                                startY = 0f
                            )
                        ),
                )
                Box(
                    modifier = Modifier
                        .padding(all = 7.dp)
                        .background(
                            color = Color.Transparent
                        )
                        .size(25.dp)
                        .align(Alignment.TopEnd)
                ) {
                    Checkbox(
                        checked = isChecked.value,
                        onCheckedChange = {
                            isChecked.value = it
                        },
                        //   colors = CheckboxDefaults.colors(MaterialTheme.colors.surface),
                        modifier = Modifier.fillMaxSize(),

                    )
                }

            }
        }
    }



@Composable
fun allAudioFiles(state: Int) {
    Text(
        text = "Tab ${state + 1} is Selected"
    )
}

