package com.example.ejercicio__8

class Enemigo(nombre: String, vida: Int, var fuerza: Int) :
    Personaje(nombre, vida), Peleador {


    constructor(nombre: String) : this(nombre, 80, 15)

    override fun presentarse(): String =
        "Soy el enemigo $nombre con $vida de vida y fuerza $fuerza."

    override fun atacar(objetivo: Personaje): String {
        return "$nombre golpea a ${objetivo.nombre} causando $fuerza de dano" +
                objetivo.recibirDanio(fuerza)
    }
}