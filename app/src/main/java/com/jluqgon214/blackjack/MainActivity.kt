package com.jluqgon214.blackjack

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jluqgon214.blackjack.ui.theme.BlackJackTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<ContactsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlackJackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BlackJack()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BlackJack() {


    var cartaActual by rememberSaveable {
        mutableStateOf(
            Carta(Naipes.As, Palos.Corazones, 1, 11, R.drawable.reverse).toString()
        )
    }

    val card = Carta(Naipes.As, Palos.Corazones, 1, 11, R.drawable.reverse)

    var gameStarted by rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        Modifier
            .fillMaxSize()
            .size(250.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        mostrarCarta(idCarta = card.idDrawable)
    }

    Row(
        Modifier
            .fillMaxSize()
            .padding(bottom = 20.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            if (!gameStarted) {
                Baraja.startGame()
                gameStarted = true
            }
            if (Baraja.listaCartas.isEmpty()) {
                //showToast("No quedan cartas en la baraja")
                Log.d("Exception", "Baraja de cartas Vacia")
            } else {
                cartaActual = Baraja.dameCarta()
                Log.d("Yo mismo", "$cartaActual ${Baraja.listaCartas.size}")
            }

        }, Modifier.padding(10.dp)) {
            Text(text = "Dame Carta")
        }
        Button(onClick = {
            Baraja.borrarBaraja()
            Baraja.crearBaraja()
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