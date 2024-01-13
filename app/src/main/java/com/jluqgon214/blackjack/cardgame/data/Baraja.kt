package com.jluqgon214.blackjack.cardgame.data

import android.content.Context
import androidx.compose.runtime.ProvidableCompositionLocal

/**
 * Métodos:
 *
 * - crearBaraja() => Generar la lista de 52 cartas de la baraja.
 * - barajar() => Desordenar las cartas de la lista de cartas de la baraja (shuffle)
 * - dameCarta() => Retorna la última carta de la lista de cartas y la elimina de la baraja.
 */
class Baraja {
    companion object {
        var listaCartas = ArrayList<Carta>()
        fun crearBaraja(context: Context) {
            for (palo in Palos.values()) {
                for ((indice, numero) in Naipes.values().withIndex()) {
                    val carta =
                        Carta(
                            numero,
                            palo,
                            indice + 1,
                            asignarValor(indice + 1),
                            asignarId(context)
                        )
                    listaCartas.add(carta)
                }
            }
        }

        private fun asignarValor(numero: Int): Int {
            return when {
                numero == 1 -> 11 // As
                numero > 10 -> 10 // Figuras (Jota, Reina, Rey)
                else -> numero
            }
        }

        fun asignarId(context: Context):    Int {
            var nombre = ""
            for (carta in listaCartas) {
                if (carta.palos.name == "Picas") {
                    nombre += "p"
                }
                if (carta.palos.name == "Trebloes") {
                    nombre += "t"
                }
                if (carta.palos.name == "Diamantes") {
                    nombre += "r"
                }
                if (carta.palos.name == "Corazones") {
                    nombre += "c"
                }
                if (carta.nombre.name == "As") {
                    nombre += "1"
                }
                if (carta.nombre.name == "Dos") {
                    nombre += "2"
                }
                if (carta.nombre.name == "Tres") {
                    nombre += "3"
                }
                if (carta.nombre.name == "Cuatro") {
                    nombre += "4"
                }
                if (carta.nombre.name == "Cinco") {
                    nombre += "5"
                }
                if (carta.nombre.name == "Seis") {
                    nombre += "6"
                }
                if (carta.nombre.name == "Siete") {
                    nombre += "7"
                }
                if (carta.nombre.name == "Ocho") {
                    nombre += "8"
                }
                if (carta.nombre.name == "Nueve") {
                    nombre += "9"
                }
                if (carta.nombre.name == "Diez") {
                    nombre += "10"
                }
                if (carta.nombre.name == "Jota") {
                    nombre += "11"
                }
                if (carta.nombre.name == "Reina") {
                    nombre += "12"
                }
                if (carta.nombre.name == "Rey") {
                    nombre += "13"
                }
            }
            return context.resources.getIdentifier(
                nombre,
                "drawable",
                context.packageName
            )

        }

        fun barajar() {
            listaCartas.shuffle()
        }

        fun dameCarta(): Carta {
            val carta = listaCartas.last()
            listaCartas.removeLast()
            return carta
        }

        fun borrarBaraja() {
            listaCartas.clear()
        }

        fun startGame(context: Context) {
            crearBaraja(context)
            barajar()
        }
    }
}