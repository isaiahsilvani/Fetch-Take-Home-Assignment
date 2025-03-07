package com.example.fetchtakehomeassignment.data.mappers

import com.example.fetchtakehomeassignment.data.dto.ListItemsResponseItem
import com.example.fetchtakehomeassignment.domain.model.ListItem

fun ListItemsResponseItem.mapToListItem() = ListItem(
    id = this.id,
    listId = this.listId,
    name = this.name
)
