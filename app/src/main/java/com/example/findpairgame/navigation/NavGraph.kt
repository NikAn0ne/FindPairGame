package com.example.findpairgame.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.findpairgame.Screens.MainScreen
import com.example.findpairgame.Screens.ResultScreen
import com.example.findpairgame.model.PictureViewModel
import com.example.findpairgame.Screens.GameScreen


@Composable
fun SetupNavGraph(
    navController: NavHostController,
    viewModel: PictureViewModel
){
    NavHost(navController = navController,
        startDestination = Screen.HomeScreen.route){
        composable(
            route = Screen.HomeScreen.route
        ){
            MainScreen(navController)
        }
        composable(
            route = Screen.GameScreen.route
        ){
            GameScreen(viewModel = viewModel, navController = navController)
        }
        composable(
            route = Screen.ResultScreen.route
        ){
            ResultScreen(navController)
        }
    }
}