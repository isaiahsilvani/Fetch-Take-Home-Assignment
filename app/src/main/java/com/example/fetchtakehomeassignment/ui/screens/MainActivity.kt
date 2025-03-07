package com.example.fetchtakehomeassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.fetchtakehomeassignment.ui.screens.MainScreen
import com.example.fetchtakehomeassignment.ui.theme.FetchTakeHomeAssignmentTheme
import com.example.fetchtakehomeassignment.ui.viewmodels.ListItemsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val listItemsViewModel: ListItemsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
        enableEdgeToEdge()
        setContent {
            FetchTakeHomeAssignmentTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding), listItemsViewModel)
                }
            }
        }
    }

    private fun initData() {
        listItemsViewModel.getListItems()
    }
}
