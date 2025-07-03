package com.example.flightsearch.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.flightsearch.viewmodel.FlightViewModel

@Composable
fun FlightSearchScreen(viewModel: FlightViewModel) {
    var departure by remember { mutableStateOf("") }
    var destination by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }

    val flights by viewModel.flights.collectAsState()

    Column(Modifier.padding(16.dp)) {
        Text("Flight Search", style = MaterialTheme.typography.titleLarge)

        OutlinedTextField(value = departure, onValueChange = { departure = it }, label = { Text("Departure City") })
        OutlinedTextField(value = destination, onValueChange = { destination = it }, label = { Text("Destination") })
        OutlinedTextField(value = date, onValueChange = { date = it }, label = { Text("Date (YYYY-MM-DD)") })

        Button(
            onClick = { viewModel.search(departure, destination, date) },
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Text("Search Flights")
        }

        FlightFilters(viewModel)

        LazyColumn {
            items(flights.size) { i ->
                FlightCard(flight = flights[i])
            }
        }
    }
}
