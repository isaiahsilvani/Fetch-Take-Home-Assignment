package com.example.fetchtakehomeassignment.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchtakehomeassignment.domain.model.ListItem
import com.example.fetchtakehomeassignment.domain.usecase.GetListItemsSortedUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class ListItemsViewModel(
    private val getListItemsSortedUseCase: GetListItemsSortedUseCase
) : ViewModel() {

    companion object {
        private const val UNEXPECTED_ERROR_OCCURED = "An unexpected error occurred: "
        private const val EMPTY_RESPONSE_BODY = "Empty response body"
    }

    private val _listItems = MutableLiveData<ListItemsUIState>(ListItemsUIState.Empty)
    val listItems: MutableLiveData<ListItemsUIState> get() = _listItems

    fun getListItems() {
        viewModelScope.launch(Dispatchers.IO) {
            _listItems.postValue(ListItemsUIState.Loading) // Set loading state

            try {
                val response = getListItemsSortedUseCase()
                processResponse(response)
            } catch (e: Exception) {
                _listItems.postValue(ListItemsUIState.Error(UNEXPECTED_ERROR_OCCURED + e.message))
            }
        }
    }

    private fun processResponse(response: Response<List<ListItem>>) {
        if (response.isSuccessful) {
            response.body()?.let { data ->
                if (data.isNotEmpty()){
                    _listItems.postValue(ListItemsUIState.Success(data))
                } else {
                    _listItems.postValue(ListItemsUIState.Empty)
                }
            } ?: run {
                _listItems.postValue(ListItemsUIState.Error(EMPTY_RESPONSE_BODY))
            }
        } else {
            _listItems.postValue(ListItemsUIState.Error(response.message()))
        }
    }
}
