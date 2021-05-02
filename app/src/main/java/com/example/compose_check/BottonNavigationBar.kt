package com.example.compose_check

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun BottomAppBar(selectedBottomBarIndex: MutableState<Int>) {


    Surface(
        elevation = 10.dp,
        color = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painterResource(
                    when (selectedBottomBarIndex.value == 0) {
                        true -> R.drawable.home_fill
                        false -> R.drawable.home
                    }
                ),
                "This is content description",
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(height = 20.dp)
                    .width(width = 20.dp)
                    .clickable {
                        selectedBottomBarIndex.value = 0;

                    }
            )

            Image(
                painterResource(
                    when (selectedBottomBarIndex.value == 1) {
                        true -> R.drawable.search_filled
                        false -> R.drawable.search
                    }
                ),
                contentDescription = "This is content description",
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(height = 20.dp)
                    .width(width = 20.dp)
                    .clickable(
                        onClick = {
                            selectedBottomBarIndex.value = 1;
                        }

                    )
            )

        }


    }

//
//    BottomNavigation {
//        BottomNavigationItem(
//            selected = selectedBottomBarIndex.value == 0,
//            onClick = {
//                selectedBottomBarIndex.value = 0
//            },
//            icon = {
//                Image(
//                    painterResource(
//                        when (selectedBottomBarIndex.value == 0) {
//                            true -> R.drawable.home_fill
//                            false -> R.drawable.home
//                        }
//                    ),
//                    "This is content description",
//                    alignment = Alignment.Center,
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier
//                        .height(height = 20.dp)
//                        .width(width = 20.dp)
//                        .clickable {
//                            selectedBottomBarIndex.value = 0
//
//                        }
//                )
//            },
//            label = { Text("Home") },
//        )
//
//        BottomNavigationItem(
//            selected = selectedBottomBarIndex.value == 1,
//            onClick = {
//                selectedBottomBarIndex.value = 0
//            },
//            icon = {
//                Image(
//                    painterResource(
//                        when (selectedBottomBarIndex.value == 1) {
//                            true -> R.drawable.search_filled
//                            false -> R.drawable.search
//                        }
//                    ),
//                    "This is content description",
//                    alignment = Alignment.Center,
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier
//                        .height(height = 20.dp)
//                        .width(width = 20.dp)
//                        .clickable {
//                            selectedBottomBarIndex.value = 1
//
//                        }
//                )
//            },
//            label = { Text("Search") },
//
//            )
//
//    }
}
