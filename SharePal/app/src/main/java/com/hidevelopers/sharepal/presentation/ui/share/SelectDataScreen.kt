package com.hidevelopers.sharepal.presentation.ui.share

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.hidevelopers.sharepal.R

// Main Method
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
            },
            bottomBar = {
                SelectDataBottomBar()
            }
        ) {
            TabsBar()
        }

    }
}

// Top Navigation bar,
// Design and Functionality
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

// Design and Functionality of TabBar
@Composable
fun TabsBar() {
    var state by remember { mutableStateOf(0) }
    val titles = listOf("FILES", "VIDEOS", "APPS", "PHOTOS", "MUSIC")

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
                AllFilesOfAndroid(state)
            }
            1 -> {
                DisplayThumbnailItems()
            }
            2 -> {
                DisplayAppsInstalled()
            }
            3 -> {
                DisplayThumbnailItems()
            }

            4 -> {
                DisplayAudioItems()
            }
        }
    }
}

@Composable
fun AllFilesOfAndroid(state: Int) {
    Text(
        text = "Tab ${state + 1} is Selected"
    )
}



// How Photos or Videos displayed,
// described in "ThumbnailTabDesign" method
@Composable
fun ThumbnailTabDesign(
    painter: Painter,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    var isChecked by remember { mutableStateOf(false) }


    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp)
            .size(120.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp,

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
                    .fillMaxWidth()
                    .fillMaxHeight(0.22f)
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
                    checked = isChecked,
                    onCheckedChange = {
                        isChecked = it
                    },
                    modifier = Modifier.fillMaxSize(),

                    )
            }

        }
    }
}

// Display Image and Video files When Photo/Video tab is clicked
@Composable
fun DisplayThumbnailItems() {
    val painter = painterResource(R.drawable.antman)
    val description = "It is Ant-man"
    LazyColumn {
        item {
            for (i in 1..100) {
                Row {
                    ThumbnailTabDesign(
                        painter = painter,
                        contentDescription = description,
                        modifier = Modifier
                            .weight(1f)
                    )
                    ThumbnailTabDesign(
                        painter = painter,
                        contentDescription = description,
                        modifier = Modifier
                            .weight(1f)

                    )
                    ThumbnailTabDesign(
                        painter = painter,
                        contentDescription = description,
                        modifier = Modifier
                            .weight(1f)

                    )
                }
            }
        }
    }
}

// How Audio files are Displayed,
// described in "AudioFilesTabDesign" method
@Composable
fun AudioFilesTabDesign(
    painter: Painter,
    contentDescription: String
) {
    var isChecked by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .size(80.dp),
        shape = RoundedCornerShape(0.dp),
        backgroundColor = MaterialTheme.colors.surface,

        ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        )
        {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box {

                }
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .background(Color.Transparent)
                        .padding(vertical = 15.dp, horizontal = 10.dp),
                    shape = RoundedCornerShape(15.dp),
                    elevation = 5.dp
                ) {
                    Image(
                        painter = painter,
                        contentDescription = contentDescription,
                        contentScale = ContentScale.Crop
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(4f),
                ) {
                    Column(
                        modifier = Modifier
                            .background(Color.Transparent)
                            .fillMaxSize()
                            .padding(5.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start

                    ) {
                        Text(
                            text = "Song Name"
                        )
                        Spacer(modifier = Modifier.padding(vertical = 2.dp))
                        Text(
                            text = "Song Size"
                        )

                    }
                }

                Box(
                    modifier = Modifier
                        .background(Color.Transparent)
                        .weight(0.7f)
                ) {
                    Checkbox(
                        checked = isChecked,
                        onCheckedChange = {
                            isChecked = it
                        },
                        modifier = Modifier
                            .fillMaxSize()
                    )

                }


            }
        }

    }
}

// Display Audio Files when Music Tab is clicked
@Composable
fun DisplayAudioItems() {
    LazyColumn {
        item {
            for (i in 1..50) {
                AudioFilesTabDesign(
                    painter = painterResource(R.drawable.antman),
                    contentDescription = "This is an Ant-man"
                )
            }
        }

    }
}

// How Apk. files are displayed
// described in "ApkFilesTabDesign" method
@Composable
fun ApkFilesTabDesign(modifier: Modifier = Modifier) {
    var isChecked by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp)
            .size(100.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp,

        ) {
        Box(
            modifier = Modifier
                .fillMaxHeight(0.5f)
        ) {
            Icon(
                Icons.Filled.Android,
                contentDescription = "Android Icon",
                modifier = Modifier
                    .size(80.dp)
                    .align(Alignment.TopCenter)
                    .padding(1.dp)
            )
            Text(
                text = "App Name",
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(5.dp),
                fontWeight = FontWeight.Bold
            )
            Box(
                modifier = Modifier
                    .padding(all = 10.dp)
                    .background(
                        color = Color.Transparent
                    )
                    .size(10.dp)
                    .align(Alignment.TopEnd)
            ) {
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = {
                        isChecked = it
                    }

                )
            }

        }
    }
}
// Display installed Apps when Apps Tab is clicked
@Composable
fun DisplayAppsInstalled(){
    LazyColumn {
        item {
            for (i in 1..100){
                Row {
                    ApkFilesTabDesign(
                        modifier = Modifier
                            .weight(1f)
                    )
                    ApkFilesTabDesign(
                        modifier = Modifier
                            .weight(1f)
                    )
                    ApkFilesTabDesign(
                        modifier = Modifier
                            .weight(1f)
                    )
                }
            }
        }
    }
}

// Bottom Navigation Ba
@Composable
fun SelectDataBottomBar() {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 20.dp,
        shape = RoundedCornerShape(
            topStart = 20.dp,
            topEnd = 20.dp,
            bottomEnd = 0.dp,
            bottomStart = 0.dp
        ),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .height(60.dp)
                    .align(Alignment.CenterEnd)
                    .fillMaxWidth(0.45f)
                    .padding(top = 10.dp, bottom = 8.dp, start = 5.dp, end = 5.dp),
                elevation = FloatingActionButtonDefaults.elevation(0.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "SEND",
                    fontWeight = FontWeight.ExtraBold
                )
            }

            TextButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .align(Alignment.CenterStart)
            ) {
                Text(
                    text = "file selected"
                )

            }
        }


    }
}