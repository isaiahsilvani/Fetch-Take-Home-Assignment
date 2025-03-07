package com.example.fetchtakehomeassignment.domain.usecase

import com.example.fetchtakehomeassignment.data.repository.createErrorResponseBody
import com.example.fetchtakehomeassignment.domain.model.ListItem
import com.example.fetchtakehomeassignment.domain.repository.ListItemsRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

/**
 * Gets the list items from the API, while filtering out items have null or blank 'name' field,
 * and grouping the items by listId
 */
class GetListItemsSortedUseCase(
    private val listItemsRepo: ListItemsRepo
) {
    suspend operator fun invoke(): Response<List<ListItem>> {
        val response = listItemsRepo.getListItems()
        if (response.isSuccessful) {
            return withContext(Dispatchers.Default) {
                val items = response.body()
                    ?.filter { !it.name.isNullOrEmpty() }
                    ?.groupBy { it.listId }
                    ?.entries
                    ?.sortedBy { it.key } // Sort by listId (key)
                    ?.flatMap { (_, group) ->
                        group.sortedBy { it.id }
                    }

                Response.success(items)
            }
        } else {
            return Response.error(response.code(), createErrorResponseBody(
                response.errorBody()?.string() ?: "Unknown Error")
            )
        }
    }
}