package com.example.fetchtakehomeassignment.domain.repository

import com.example.fetchtakehomeassignment.domain.model.ListItem
import retrofit2.Response

interface ListItemsRepo {

    suspend fun getListItems(): Response<List<ListItem>?>

}