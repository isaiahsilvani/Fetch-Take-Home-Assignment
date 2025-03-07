package com.example.fetchtakehomeassignment.ui.viewmodels

import com.example.fetchtakehomeassignment.domain.model.ListItem

sealed class ListItemsUIState {
    data class Success(val data: List<ListItem>) : ListItemsUIState()
    data class Error(val errorMessage: String) : ListItemsUIState()
    data object Loading : ListItemsUIState()
    data object Empty : ListItemsUIState()
}