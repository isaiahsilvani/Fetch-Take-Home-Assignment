package com.example.fetchtakehomeassignment.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.fetchtakehomeassignment.domain.model.ListItem

@Composable
fun ListItemsLazyColumn(
    listItems: List<ListItem>?,
    modifier: Modifier = Modifier
) {
    if (listItems != null) {
        Surface {
            LazyColumn {
                items(listItems) { items ->
                    ListItemCard(
                        items.name,
                        items.id,
                        items.listId
                    )
                }
            }
        }
    } else {
        Text("Loading...")
    }
}