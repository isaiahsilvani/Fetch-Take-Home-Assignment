package com.example.fetchtakehomeassignment.domain.usecase

import com.example.fetchtakehomeassignment.data.repository.createErrorResponseBody
import com.example.fetchtakehomeassignment.domain.model.ListItem
import com.example.fetchtakehomeassignment.domain.repository.ListItemsRepo
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

            val items = response.body()
                ?.filter { !it.name.isNullOrEmpty() }
                ?.groupBy { it.listId }
                ?.toSortedMap() // Sort by listId
                ?.flatMap { (_, group) ->
                    group.sortedBy { it.name } // Sort within each group by name
                }

            return Response.success(items)
        } else {
            return Response.error(response.code(), createErrorResponseBody(
                response.errorBody()?.string() ?: "Unknown Error")
            )
        }
    }
}
