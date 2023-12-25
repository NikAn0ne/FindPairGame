package com.example.findpairgame.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
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
            route = Screen.HomeScreen.route,
            arguments = listOf(navArgument(SCORE_KEY){
                type = NavType.IntType
            })
        ){
            entry ->
            MainScreen(score = entry.arguments?.getInt(SCORE_KEY), navController = navController)
        }
        composable(
            route = Screen.GameScreen.route,
                    arguments = listOf(navArgument(SCORE_KEY){
                type = NavType.IntType
            })
        ){
                entry ->
            GameScreen(score = entry.arguments?.getInt(SCORE_KEY),viewModel = viewModel, navController = navController)
        }
        composable(
            route = Screen.ResultScreen.route,
            arguments = listOf(navArgument(SCORE_KEY){
                type = NavType.IntType
            })
        ){
                entry ->
            ResultScreen(score = entry.arguments?.getInt(SCORE_KEY),navController)
        }
    }
}