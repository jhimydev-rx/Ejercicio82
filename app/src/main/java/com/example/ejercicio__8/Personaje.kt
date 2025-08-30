package com.example.ejercicio__8

abstract class Personaje(
    val nombre: String,
    var vida: Int
) {
    val estaVivo: Boolean get() = vida > 0

    abstract fun presentarse(): String

    open fun recibirDanio(cantidad: Int): String {
        vida -= cantidad
        if (vida < 0) vida = 0
        return "$nombre recibió $cantidad de daño. Vida restante: $vida"
    }
}