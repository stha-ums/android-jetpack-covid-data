package com.example.compose_check.searchScreen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.blongho.country_data.World
import com.example.compose_check.models.apiModels.Data


@Composable
fun SingleCountryDisplay(navController: NavHostController, countryData: Data) {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth()
                .clickable {
                    navController.currentBackStackEntry?.arguments?.putSerializable(
                        "country",
                        countryData
                    )
                    navController.navigate("CountryDetail")
                }
        ) {
            Image(
                painterResource(World.getFlagOf(countryData.country_code)),
                "This is content description",
                alignment = Alignment.Center,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .height(height = 20.dp)
                    .width(width = 30.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = countryData.location!!)
        }
    }


}

