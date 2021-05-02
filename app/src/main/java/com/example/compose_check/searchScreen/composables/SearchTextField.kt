package com.example.compose_check.searchScreen.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose_check.ui.theme.Purple700
import com.example.compose_check.ui.theme.Shapes


@Composable
fun SearchTextFiled(searchTerm: MutableState<String>) {

    TextField(
        value = searchTerm.value,
        onValueChange = { searchTerm.value = it },
        label = { Text("Search For Country") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(width = 1.dp, color = Purple700, shape = Shapes.small)
    )
}