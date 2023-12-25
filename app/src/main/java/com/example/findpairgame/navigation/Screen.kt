package com.example.findpairgame.navigation

sealed class Screen(val route: String) {
    object HomeScreen: Screen(route = "home_screen")
    object GameScreen: Screen(route = "game_screen")
    object ResultScreen: Screen(route = "result_screen")
}