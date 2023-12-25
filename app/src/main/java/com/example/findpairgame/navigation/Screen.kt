package com.example.findpairgame.navigation

const val SCORE_KEY = "score"
sealed class Screen(val route: String) {
    object HomeScreen: Screen(route = "home_screen/{$SCORE_KEY}"){
        fun passScore(score: Int) : String{
            return this.route.replace(oldValue = "{$SCORE_KEY}", newValue = score.toString())
        }
    }
    object GameScreen: Screen(route = "game_screen/{$SCORE_KEY}"){
        fun passScore(score: Int) : String{
            return this.route.replace(oldValue = "{$SCORE_KEY}", newValue = score.toString())
        }
    }
    object ResultScreen: Screen(route = "result_screen/{$SCORE_KEY}"){
        fun passScore(score: Int) : String{
            return this.route.replace(oldValue = "{$SCORE_KEY}", newValue = score.toString())
        }
    }
}