package com.example.fetchtakehomeassignment.data.remote

import com.example.fetchtakehomeassignment.data.dto.ListItemsResponse
import retrofit2.http.GET

interface ListItemsService {

    companion object {
        private const val listItemsEndpoint = "hiring.json"
    }

    @GET(listItemsEndpoint)
    suspend fun getListItems(): ListItemsResponse

}