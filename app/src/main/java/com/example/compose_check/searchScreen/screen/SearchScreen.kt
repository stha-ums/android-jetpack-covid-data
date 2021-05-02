package com.example.compose_check.searchScreen.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.example.compose_check.models.apiModels.AllCountryDataModel
import com.example.compose_check.models.apiModels.Data
import com.example.compose_check.searchScreen.composables.SearchTextFiled
import com.example.compose_check.searchScreen.composables.SingleCountryDisplay
import java.util.*

@Composable
fun SearchScreen(
    navController: NavHostController,
    allCountryData: MutableState<AllCountryDataModel>
) {

    val searchTerm = remember {
        mutableStateOf(value = "")
    }

    val searchResults = remember {
        mutableStateOf(value = mutableListOf<Data>())
    }

    if (searchTerm.value.isEmpty()) {
        searchResults.value = allCountryData.value.data!!.toMutableList()
    } else {
        searchResults.value.clear()
        allCountryData.value.data?.forEach {
            if (it.location?.toLowerCase(Locale.ROOT)
                    ?.contains(searchTerm.value.toLowerCase(Locale.ROOT)) == true
            ) {
                searchResults.value.add(it)
            }
        }

    }

    Column {
        SearchTextFiled(searchTerm = searchTerm)
        LazyColumn {
            itemsIndexed(searchResults.value) { _, item ->
                SingleCountryDisplay(
                    navController = navController,
                    countryData = item
                )
            }

        }
    }

}