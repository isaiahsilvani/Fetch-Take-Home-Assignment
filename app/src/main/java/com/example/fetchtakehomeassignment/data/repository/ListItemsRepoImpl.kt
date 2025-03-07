package com.example.fetchtakehomeassignment.data.repository

import android.util.Log
import com.example.fetchtakehomeassignment.data.remote.ListItemsService

class ListItemsRepoImpl(
    private val listItemsService: ListItemsService
) {
    suspend fun getListItems() {
        val response = listItemsService.getListItems()
    }
}