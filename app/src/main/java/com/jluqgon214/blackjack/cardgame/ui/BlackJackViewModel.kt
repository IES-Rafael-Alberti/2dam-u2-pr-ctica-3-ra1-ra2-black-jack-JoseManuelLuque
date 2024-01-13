package com.jluqgon214.blackjack.cardgame.ui

import android.app.Application
import android.content.Context
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.jluqgon214.blackjack.R
import com.jluqgon214.blackjack.cardgame.data.Baraja
import com.jluqgon214.blackjack.cardgame.data.Carta
import com.jluqgon214.blackjack.cardgame.data.Jugador
import com.jluqgon214.blackjack.cardgame.data.Naipes
import com.jluqgon214.blackjack.cardgame.data.Palos

class BlackJackViewModel(application: Application) : AndroidViewModel(application) {
    val cartaReverse = MutableLiveData<Carta>()

    val turnoActual = MutableLiveData(true)
    init {
        cartaReverse.value = Carta(Naipes.As, Palos.Diamantes, 1, 11, R.drawable.reverse)
        Baraja.startGame(context = application)
    }

    var jugador1 = MutableLiveData(Jugador())

    fun asignarCarta() {
        jugadorActual().mano.add(Baraja.dameCarta())
    }

    var jugador2 = MutableLiveData(Jugador())

    fun jugadorActual(): Jugador{
        if (turnoActual.value!!) {
            return jugador1.value!!
        }
        else{
            return jugador2.value!!
        }
    }
}
