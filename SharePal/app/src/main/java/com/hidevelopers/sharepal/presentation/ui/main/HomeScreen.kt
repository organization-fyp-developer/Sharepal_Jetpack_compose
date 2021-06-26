package com.hidevelopers.sharepal.presentation.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
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


@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: MainInfoVIewModel = viewModel()
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

                ButtonCard()
            }
        }
    }
}

@Composable
fun HomeTopBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        elevation = 4.dp,
        modifier = Modifier
            .padding(
                start = 20.dp,
                end = 20.dp,
                top = 20.dp,
                bottom = 5.dp
            ),
        title = {
            Text(
                text = "ShareP al"
            )
        }
    )
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
fun ButtonCard() {
    Card(
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 1.dp
    ) {
        Row {
            FloatingActionButton(onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(all = 5.dp),
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_receive_icon),
                    contentDescription = null
                )
            }
        }
    }
}