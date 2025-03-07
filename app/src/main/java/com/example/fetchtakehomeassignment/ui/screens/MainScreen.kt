package com.example.fetchtakehomeassignment.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.fetchtakehomeassignment.ui.components.CenteredCircularProgressIndicator
import com.example.fetchtakehomeassignment.ui.components.ListItemsLazyColumn
import com.example.fetchtakehomeassignment.ui.viewmodels.ListItemsViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    listItemsViewModel: ListItemsViewModel
) {
    val listItems = listItemsViewModel.listItems.observeAsState()

    if (listItems.value.isNullOrEmpty()) {
        // display loading spinner while waiting for data
        CenteredCircularProgressIndicator()
    } else {
        ListItemsLazyColumn(listItems.value)
    }
}