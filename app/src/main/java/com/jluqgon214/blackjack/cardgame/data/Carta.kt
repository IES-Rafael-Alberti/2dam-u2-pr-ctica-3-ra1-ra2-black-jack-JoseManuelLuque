package com.jluqgon214.blackjack.cardgame.data

import com.jluqgon214.blackjack.R

class Carta(nombre: Naipes, palos: Palos, puntosMin: Int, puntosMax: Int, idDrawable: Int) {
    var nombre = Naipes.As
    var palos = Palos.Picas
    var puntosMin = 1
    var puntosMax = 10
    var idDrawable = R.drawable.reverse
}