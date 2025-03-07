package com.example.fetchtakehomeassignment.ui.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchtakehomeassignment.domain.model.ListItem
import com.example.fetchtakehomeassignment.domain.usecase.GetListItemsSortedUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListItemsViewModel(
    private val getListItemsSortedUseCase: GetListItemsSortedUseCase
) : ViewModel() {

    private val _listItems = MutableLiveData(listOf<ListItem>())
    val listItems get() = _listItems

    fun getListItems() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getListItemsSortedUseCase()
            if (result.isSuccessful) {
                Log.e("TEST", "Isaiah - SUCCESSFULL!!!")
                result.body()?.let {
                    _listItems.postValue(it)
                }
            } else {
                Log.e("TEST", "Isaiah - not even successfulll")
            }
        }
    }

}