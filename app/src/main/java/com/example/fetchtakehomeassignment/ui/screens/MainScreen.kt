package com.example.fetchtakehomeassignment.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fetchtakehomeassignment.R
import com.example.fetchtakehomeassignment.ui.components.CenteredCircularProgressIndicator
import com.example.fetchtakehomeassignment.ui.components.ListItemsLazyColumn
import com.example.fetchtakehomeassignment.ui.util.getString
import com.example.fetchtakehomeassignment.ui.viewmodels.ListItemsUIState
import com.example.fetchtakehomeassignment.ui.viewmodels.ListItemsViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    listItemsViewModel: ListItemsViewModel
) {
    val listItemsState = listItemsViewModel.listItems.observeAsState(ListItemsUIState.Empty) // provide default value

    Box(modifier = Modifier.fillMaxSize()) {
        when (val state = listItemsState.value) {
            is ListItemsUIState.Loading -> {
                CenteredCircularProgressIndicator()
            }
            is ListItemsUIState.Success -> {
                ListItemsLazyColumn(state.data)
            }
            is ListItemsUIState.Error -> {
                Text(
                    text = state.errorMessage,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(16.dp)
                )
            }
            is ListItemsUIState.Empty -> {
                Text(
                    text = getString(R.string.empty_response),
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(16.dp)
                )
            }
        }
    }
}
