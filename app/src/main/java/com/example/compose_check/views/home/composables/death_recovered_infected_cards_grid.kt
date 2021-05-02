package com.example.compose_check.views.home.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.compose_check.models.dataWidgetModel.WidgetModel
import com.example.compose_check.ui.theme.deathColor
import com.example.compose_check.ui.theme.infectedColor
import com.example.compose_check.ui.theme.recoveredColor

@Composable
fun DeathRecoveredInfectedDataGrid(
    deathGlobal: WidgetModel,
    recoveredGlobal: WidgetModel,
    infectedGlobal: WidgetModel,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row {
            DataWidgets(deathGlobal.value, deathGlobal.title, deathColor, "All time")
            DataWidgets(recoveredGlobal.value, recoveredGlobal.title, recoveredColor, "All time")
            DataWidgets(infectedGlobal.value, infectedGlobal.title, infectedColor, "All time")
        }
    }
}
