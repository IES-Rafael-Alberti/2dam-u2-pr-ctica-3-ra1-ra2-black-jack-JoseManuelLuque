package com.jluqgon214.blackjack.cardgame.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.jluqgon214.blackjack.R

@Composable
fun StartScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(painter = painterResource(id = R.drawable.icono_app), contentDescription = "Icono de la App")

        Button(onClick = { /*TODO*/ }) {
            Text(text = "1 JUGADOR")
        }

        Button(onClick = { /*TODO*/ }) {
            Text(text = "2 JUGADORES")
        }
    }
}