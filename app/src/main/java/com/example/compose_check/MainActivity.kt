package com.example.compose_check

import CountryDetail
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.blongho.country_data.World
import com.example.compose_check.models.apiModels.AllCountryDataModel
import com.example.compose_check.models.apiModels.Data
import com.example.compose_check.searchScreen.screen.SearchScreen
import com.example.compose_check.ui.theme.Compose_checkTheme
import com.example.compose_check.views.home.homescreen.HomeScreen
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        World.init(applicationContext)
        super.onCreate(savedInstanceState)
        setContent {
            Compose_checkTheme {
                AppNavigator()
            }
        }
    }


    private fun getCovidData(
        allCountryData: MutableState<AllCountryDataModel>,
        errorMessage: MutableState<String>
    ) {
        val queue = Volley.newRequestQueue(this)
        val url = "https://www.trackcorona.live/api/countries"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                allCountryData.value =
                    Json.decodeFromString(AllCountryDataModel.serializer(), response)
            },
            {
                errorMessage.value = it.localizedMessage!!
            })

        queue.add(stringRequest)
    }

    @Composable
    fun AppNavigator() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "DashBoard") {
            composable(route = "DashBoard") {
                DashBoard(navController)
            }
            composable(
                route = "CountryDetail"
            ) {
                val country =
                    navController.previousBackStackEntry?.arguments?.getSerializable("country")

                if (country != null) {
                    CountryDetail(navController = navController, country as Data)
                }

            }
        }
    }

    @Composable
    fun DashBoard(navController: NavHostController) {


        val errorMessage = rememberSaveable {
            mutableStateOf("")
        }

        val allCountryData = rememberSaveable {
            mutableStateOf(AllCountryDataModel(null, null))
        }

        val selectedBottomBarIndex = rememberSaveable {
            mutableStateOf(0)
        }

        // get the covid data
        getCovidData(allCountryData, errorMessage)

        Scaffold(
            backgroundColor = Color.White,
            bottomBar = { BottomAppBar(selectedBottomBarIndex) },
            content = {
                when (errorMessage.value.isNotEmpty()) {
                    true -> Text(errorMessage.value)
                    false -> when (allCountryData.value.data) {
                        null -> Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            CircularProgressIndicator(color = Color.Green)
                        }
                        else -> when (selectedBottomBarIndex.value) {
                            0 ->
                                HomeScreen(this, allCountryData)
                            1 ->
                                SearchScreen(
                                    navController = navController,
                                    allCountryData = allCountryData
                                )
                        }
                    }
                }
            }
        )
    }
}
