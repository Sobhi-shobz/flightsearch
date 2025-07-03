package com.example.flightsearch.data

data class Flight(
    val id: Int,
    val airline: String,
    val departure: String,
    val destination: String,
    val date: String, // e.g., "2025-07-05"
    val price: Double,
    val duration: String, // e.g., "3h 45m"
    val stops: Int
)
