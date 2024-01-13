package com.jluqgon214.blackjack.cardgame.data

class Jugador() {
    var mano = mutableListOf<Carta>()

    fun getPoints(): Int{
        var puntos = 0
        for (carta in mano){
            puntos += carta.puntosMin
        }
        return puntos
    }
}