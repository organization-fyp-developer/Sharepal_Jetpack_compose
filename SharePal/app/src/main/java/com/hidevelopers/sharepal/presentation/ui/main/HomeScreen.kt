package com.hidevelopers.sharepal.presentation.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.hidevelopers.sharepal.R
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable


@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: MainInfoVIewModel = viewModel(),
    findNavController_SelectDataScreen: NavController,
    findNavController_ReceiveDataScreen: NavController
) {
    Surface(
        color = MaterialTheme.colors.surface
    ) {
        Scaffold(
            topBar = {
                HomeTopBar()
            }
        ) {
            Column {
                StorageCard(
                    occupiedStorage = viewModel.bytesToHuman(viewModel.totalMemory()),
                    totalStorage = viewModel.bytesToHuman(viewModel.totalMemory())
                )

                ButtonCard(
                    findNavController_SelectDataScreen,
                    findNavController_ReceiveDataScreen
                )

                Spacer(modifier = Modifier.padding(10.dp))

                recentFriends()

                latestHistory()
            }
        }
    }
}

@Preview
@Composable
fun HomeTopBar(
) {
    MaterialTheme {
        Column {
            TopAppBar(
                title = {
                    Text(
                        text = "SharePal",
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center
                    )
                },
                backgroundColor = MaterialTheme.colors.surface,
                modifier = Modifier
                    .padding(all = 5.dp),
                elevation = 0.dp,
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Rounded.Menu, contentDescription = "Menu Icon")
                    }
                }
            )
        }
    }
}


@Composable
fun StorageCard(
    occupiedStorage: String,
    totalStorage: String
) {
    Card(
        modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 1.dp
    ) {
        Row(
            modifier = Modifier
                .padding(all = 8.dp)
        ) {
            Column {
                Text(
                    text = "Storage",
                    style = MaterialTheme.typography.h2
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Occupied",
                    style = MaterialTheme.typography.h3
                )
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontSize = 24.sp
                            )
                        ) {
                            append(occupiedStorage)
                        }
                        append("/$totalStorage")
                    },
                    style = MaterialTheme.typography.h3
                )
            }
        }
    }
}

@Composable
fun ButtonCard(
    findNavController_SelectDataScreen: NavController,
    findNavController_ReceiveDataScreen: NavController
) {
    val textSend = "Send"
    val textReceive = "Receive"
    val imageSend = painterResource(id = R.drawable.ic_send_icon)
    val imageReceive = painterResource(id = R.drawable.ic_receive_icon)
    Row(
        Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            backgroundColor = MaterialTheme.colors.surface,
            elevation = 10.dp,
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = 5.dp, top = 5.dp, end = 5.dp, bottom = 5.dp)
        ) {
            buttonDesigns(
                buttonText = textSend,
                imageResource = imageSend,
                findNavController = findNavController_SelectDataScreen
            )
        }

        Card(
            backgroundColor = MaterialTheme.colors.surface,
            elevation = 10.dp,
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = 5.dp, top = 5.dp, end = 5.dp, bottom = 5.dp)
        ) {
            buttonDesigns(
                buttonText = textReceive,
                imageResource = imageReceive,
                findNavController = findNavController_ReceiveDataScreen
            )
        }


    }
}

@Composable
fun buttonDesigns(
    buttonText: String,
    imageResource: Painter,
    findNavController: NavController
) {
    Box {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = imageResource,
                contentDescription = null,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp, vertical = 20.dp)
            )
            FloatingActionButton(
                onClick = {
                    if (buttonText.equals("Send")) findNavController.navigate(R.id.action_mainInfoFragment_to_shareInfoFragment)
                    else if (buttonText.equals("Receive")) findNavController.navigate(R.id.action_mainInfoFragment_to_receiveInfoFragment2)

                },

                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp, start = 15.dp, end = 15.dp)
                    .fillMaxWidth(),
                backgroundColor = MaterialTheme.colors.primary,
                shape = RoundedCornerShape(30)
            ) {
                Text(
                    text = buttonText,
                    style = TextStyle(color = Color.White, fontSize = 20.sp),
                )
            }
        }

    }

}

@Composable
fun recentFriends() {
    Text(text = "Recent Friends")
    Spacer(modifier = Modifier.padding(50.dp))
}

@Composable
fun latestHistory() {
    Text(text = "Latest History")
    Spacer(modifier = Modifier.padding(100.dp))
}