package com.example.fetchtakehomeassignment.data.repository

import android.util.Log
import com.example.fetchtakehomeassignment.data.mappers.mapToListItem
import com.example.fetchtakehomeassignment.data.remote.ListItemsService
import com.example.fetchtakehomeassignment.domain.model.ListItem
import com.example.fetchtakehomeassignment.domain.repository.ListItemsRepo
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response

class ListItemsRepoImpl(
    private val listItemsService: ListItemsService
) : ListItemsRepo {
    override suspend fun getListItems(): Response<List<ListItem>?> {
        try {
            listItemsService.getListItems().let { response ->
                if (response.isSuccessful) {
                    val listItems = response.body()?.map {
                        it.mapToListItem()
                    }
                    Log.e("TEST", "Isaiah - success!")
                    return Response.success(listItems)
                } else {
                    // Capture and convert the error body to string.
                    response.errorBody()?.let { errorBody ->
                        val errorString = errorBody.string()
                        return Response.error(response.code(), createErrorResponseBody(errorString))
                    } ?: run {
                        return Response.error(response.code(), createErrorResponseBody("Unknown error"))
                    }
                }
            }
        } catch (e: Exception) {
            return Response.error(500, createErrorResponseBody(e.message ?: "Unknown error"))
        }
    }
}

// Helper function to create a ResponseBody for error case
fun createErrorResponseBody(errorMessage: String): ResponseBody {
    return errorMessage.toResponseBody("application/json".toMediaTypeOrNull())
}