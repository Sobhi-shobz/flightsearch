package com.example.flightsearch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.flightsearch.ui.FlightSearchScreen
import com.example.flightsearch.viewmodel.FlightViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: FlightViewModel = viewModel()
            FlightSearchScreen(viewModel)
        }
    }
}
