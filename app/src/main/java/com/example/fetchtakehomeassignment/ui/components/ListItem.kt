package com.example.fetchtakehomeassignment.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ListItemCard(
    name: String?,
    id: Int,
    listId: Int
) {
    Surface {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text("$name", modifier = Modifier.paddingFromBaseline(top = 10.dp))
            Text("$id", modifier = Modifier.paddingFromBaseline(top = 10.dp))
            Text("$listId", modifier = Modifier.paddingFromBaseline(top = 10.dp))
        }
    }
}