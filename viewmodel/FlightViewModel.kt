package com.example.flightsearch.viewmodel

import androidx.lifecycle.ViewModel
import com.example.flightsearch.data.Flight
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FlightViewModel : ViewModel() {
    private val _flights = MutableStateFlow<List<Flight>>(sampleFlights())
    val flights: StateFlow<List<Flight>> = _flights

    private var currentFilter: (Flight) -> Boolean = { true }
    private var currentSort: (List<Flight>) -> List<Flight> = { it }

    fun search(departure: String, destination: String, date: String) {
        _flights.value = currentSort(sampleFlights().filter {
            it.departure.contains(departure, true) &&
            it.destination.contains(destination, true) &&
            it.date == date
        }.filter(currentFilter))
    }

    fun filterByStops(maxStops: Int) {
        currentFilter = { it.stops <= maxStops }
        _flights.value = currentSort(_flights.value.filter(currentFilter))
    }

    fun sortByPrice() {
        currentSort = { it.sortedBy { f -> f.price } }
        _flights.value = currentSort(_flights.value)
    }

    fun sortByDuration() {
        currentSort = { it.sortedBy { f -> f.duration.replace("h", "").replace("m", "").replace(" ", "").toIntOrNull() ?: 0 } }
        _flights.value = currentSort(_flights.value)
    }
}

private fun sampleFlights(): List<Flight> = listOf(
    Flight(1, "IndiGo", "Delhi", "Mumbai", "2025-07-05", 4500.0, "2h 10m", 0),
    Flight(2, "Air India", "Delhi", "Mumbai", "2025-07-05", 5600.0, "2h 30m", 1),
    Flight(3, "SpiceJet", "Delhi", "Chennai", "2025-07-05", 6000.0, "3h 45m", 0),
    Flight(4, "Vistara", "Delhi", "Mumbai", "2025-07-05", 4900.0, "2h 25m", 0),
)
