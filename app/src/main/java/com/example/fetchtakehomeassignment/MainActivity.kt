package com.example.fetchtakehomeassignment

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.fetchtakehomeassignment.data.remote.ListItemsService
import com.example.fetchtakehomeassignment.data.repository.ListItemsRepoImpl
import com.example.fetchtakehomeassignment.data.util.RetrofitClient
import com.example.fetchtakehomeassignment.domain.repository.ListItemsRepo
import com.example.fetchtakehomeassignment.domain.usecase.GetListItemsSortedUseCase
import com.example.fetchtakehomeassignment.ui.theme.FetchTakeHomeAssignmentTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FetchTakeHomeAssignmentTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        CoroutineScope(Dispatchers.IO).launch {
            Log.e("TEST", "Isiah - do it!")
            val repository : ListItemsRepo = ListItemsRepoImpl(
                RetrofitClient.retrofit.create(ListItemsService::class.java)
            )

            val useCase = GetListItemsSortedUseCase(repository)
            Log.e("TEST", "Isaiah - hell yeaaahhhh")
            useCase()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FetchTakeHomeAssignmentTheme {
        Greeting("Android")
    }
}