package com.jluqgon214.blackjack

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
        fun crearBaraja() {
            for (palo in Palos.values()) {
                for ((indice, numero) in Naipes.values().withIndex()) {
                    val carta =
                        Carta(numero, palo, indice + 1, asignarValor(indice + 1), R.drawable.c1)
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

        private fun asignarImagen(numero: Int, palo: Palos): Int {
            return "${palo.name[0].lowercaseChar()}${numero}".toInt()
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

        fun startGame() {
            crearBaraja()
            barajar()
        }
    }
}