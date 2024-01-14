package com.jluqgon214.blackjack.cardgame.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.jluqgon214.blackjack.cardgame.data.Baraja

@Composable
fun BlackJackScreen(
    navController: NavHostController,
    blackJackViewModel: BlackJackViewModel
) {
    navController.navigate("BlackJackLayout")
}


@Composable
fun BlackJackLayout(navController: NavHostController, blackJackViewModel: BlackJackViewModel) {
    Column(
        Modifier
            .fillMaxSize()
            .size(250.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        for (carta in blackJackViewModel.jugadorActual().mano) {
            mostrarCarta(idCarta = carta.idDrawable)
        }
    }

    Row(
        Modifier
            .fillMaxSize()
            .padding(bottom = 20.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            if (Baraja.listaCartas.isEmpty()) {
                Log.d("Exception", "Baraja de cartas Vacia")
            } else {
                blackJackViewModel.asignarCarta()
                Log.d(
                    "Yo mismo",
                    "$blackJackViewModel.cartaActual.value ${Baraja.listaCartas.size}"
                )
            }

        }, Modifier.padding(10.dp)) {
            Text(text = "Dame Carta")
        }
        Button(onClick = {
            Baraja.borrarBaraja()
            //Baraja.crearBaraja()
            Baraja.barajar()
        }, Modifier.padding(10.dp)) {
            Text(text = "Reiniciar")
        }
    }

}

@Composable
fun mostrarCarta(idCarta: Int) {
    Image(
        painter = painterResource(id = idCarta),
        contentDescription = "Carta",
        Modifier.size(250.dp)
    )
}