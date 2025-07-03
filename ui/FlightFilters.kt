package com.example.flightsearch.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.flightsearch.viewmodel.FlightViewModel

@Composable
fun FlightFilters(viewModel: FlightViewModel) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        Button(onClick = { viewModel.filterByStops(0) }) {
            Text("Non-stop only")
        }
        Button(onClick = { viewModel.sortByPrice() }) {
            Text("Sort by Price")
        }
        Button(onClick = { viewModel.sortByDuration() }) {
            Text("Sort by Duration")
        }
    }
}
