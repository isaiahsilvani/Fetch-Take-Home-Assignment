package com.example.fetchtakehomeassignment.data.remote

import com.example.fetchtakehomeassignment.data.dto.ListItemsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ListItemsService {

    companion object {
        private const val LIST_ITEMS_ENDPOINT = "hiring.json"
    }

    @GET(LIST_ITEMS_ENDPOINT)
    suspend fun getListItems(): Response<ListItemsResponse>

}
