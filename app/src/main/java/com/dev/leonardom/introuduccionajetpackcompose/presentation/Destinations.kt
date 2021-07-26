package com.dev.leonardom.introuduccionajetpackcompose.presentation

sealed class Destinations(
    val route: String
) {
    object Pantalla1: Destinations("pantalla1")
    object Pantalla2: Destinations("pantalla2/?newText={newText}") {
        fun createRoute(newText: String) = "pantalla2/?newText=$newText"
    }
}
