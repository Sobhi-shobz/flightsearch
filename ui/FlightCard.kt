package com.example.flightsearch.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.flightsearch.data.Flight

@Composable
fun FlightCard(flight: Flight) {
    Card(Modifier.padding(8.dp).fillMaxWidth(), elevation = CardDefaults.cardElevation(6.dp)) {
        Column(Modifier.padding(16.dp)) {
            Text("Airline: ${flight.airline}", style = MaterialTheme.typography.titleMedium)
            Text("From: ${flight.departure}  →  ${flight.destination}")
            Text("Date: ${flight.date}")
            Text("Price: ₹${flight.price}")
            Text("Duration: ${flight.duration}")
            Text("Stops: ${flight.stops}")

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { /* Booking logic or navigation */ }) {
                Text("Book Now")
            }
        }
    }
}
