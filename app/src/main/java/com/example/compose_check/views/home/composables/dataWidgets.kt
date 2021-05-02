package com.example.compose_check.views.home.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DataWidgets(value: Int, title: String?, color: Color, subTitle: String? = null) {
    Card(
        elevation = 8.dp,
        modifier = Modifier
            .size(width = 150.dp, height = 100.dp)
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = color,
                ),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = value.toString())
                if (title != null) {
                    Text(text = title)
                }
                if (subTitle != null) Spacer(modifier = Modifier.height(5.dp))
                if (subTitle != null) Divider()
                if (subTitle != null) Text(text = subTitle)

            }
        }
    }
}

@Preview
@Composable
fun ColumnDemo() {
    DataWidgets(673, "Death", Color(250, 124, 123))
}