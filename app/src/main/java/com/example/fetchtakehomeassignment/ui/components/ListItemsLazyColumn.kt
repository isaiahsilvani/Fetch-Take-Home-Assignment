package com.example.fetchtakehomeassignment.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fetchtakehomeassignment.R
import com.example.fetchtakehomeassignment.domain.model.ListItem
import com.example.fetchtakehomeassignment.ui.util.getString

@Composable
fun ListItemsLazyColumn(
    listItems: List<ListItem>?,
    modifier: Modifier = Modifier
) {
    if (listItems != null) {
        Surface {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2), // 2 columns
                modifier = modifier.fillMaxSize(),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(listItems) { item ->
                    ListItemCard(
                        item.name,
                        item.id,
                        item.listId
                    )
                }
            }
        }
    } else {
        Text(getString(R.string.loading))
    }
}

@Preview
@Composable
fun PreviewListItemsLazyColumn() {
    ListItemsLazyColumn(
        listOf(
            ListItem(121, 13, "test"),
            ListItem(123, 817, "test2"),
        )
    )
}