package com.jluqgon214.blackjack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jluqgon214.blackjack.cardgame.ui.BlackJackLayout
import com.jluqgon214.blackjack.cardgame.ui.BlackJackViewModel
import com.jluqgon214.blackjack.cardgame.ui.BlackJackScreen
import com.jluqgon214.blackjack.cardgame.ui.StartScreen
import com.jluqgon214.blackjack.ui.theme.BlackJackTheme

class MainActivity : ComponentActivity() {
    private val blackJackViewModel by viewModels<BlackJackViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlackJackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController, startDestination = "StartScreen"
                    ){
                        composable(route = "StartScreen") {
                            StartScreen(navController = navController)
                        }
                        composable(route = "BlackJackLayout") {
                            BlackJackLayout(navController, blackJackViewModel)
                        }
                    }
                }
            }
        }
    }
}