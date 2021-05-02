package com.example.compose_check.views.home.homescreen

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose_check.models.apiModels.AllCountryDataModel
import com.example.compose_check.models.dataWidgetModel.WidgetModel
import com.example.compose_check.views.home.composables.DeathRecoveredInfectedDataGrid
import com.example.compose_check.views.home.composables.WhoPageLinkLunchWidgetWithImage


@Composable
fun HomeScreen(context: Context, allCountryData: MutableState<AllCountryDataModel>) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {

        WhoPageLinkLunchWidgetWithImage(context = context)
        val (dead, recovered, infected) = getGlobal(allCountryData)
        Text("Global", modifier = Modifier.padding(horizontal = 16.dp))

        DeathRecoveredInfectedDataGrid(
            deathGlobal = WidgetModel(dead, "Death"),
            recoveredGlobal = WidgetModel(recovered, "Recovered"),
            infectedGlobal = WidgetModel(infected, "Infected"),
        )

//        Text("Your Country", modifier = Modifier.padding(horizontal = 16.dp))
//
//        DeathRecoveredInfectedDataGrid(
//            deathGlobal = WidgetModel(Random.nextInt(), "Death"),
//            recoveredGlobal = WidgetModel(Random.nextInt(), "Recovered"),
//            infectedGlobal = WidgetModel(Random.nextInt(), "Infected"),
//        )
//
//        Text("Most Case", modifier = Modifier.padding(horizontal = 16.dp))
//
//        DeathRecoveredInfectedDataGrid(
//            deathGlobal = WidgetModel(Random.nextInt(), "Death"),
//            recoveredGlobal = WidgetModel(Random.nextInt(), "Recovered"),
//            infectedGlobal = WidgetModel(Random.nextInt(), "Infected"),
//        )

    }
}

data class GlobalData(val death: Int, val recovered: Int, val infected: Int)

fun getGlobal(allCountryData: MutableState<AllCountryDataModel>): GlobalData {
    var death = 0
    var recovered = 0
    var infected = 0

    allCountryData.value.data?.forEach {
        death += it.dead!!
        recovered += it.recovered!!
        infected += it.confirmed!!
    }

    return GlobalData(death = death, recovered = recovered, infected = infected)
}