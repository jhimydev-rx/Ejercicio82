package com.example.ejercicio__8



class Heroe(nombre: String, vida: Int, var poder: Int) :
    Personaje(nombre, vida), Peleador {


    constructor(nombre: String) : this(nombre, 100, 20)

    override fun presentarse(): String =
        "Soy el heroe $nombre con $vida de vida y poder $poder."

    override fun atacar(objetivo: Personaje): String {
        return "$nombre ataca a ${objetivo.nombre} causando $poder de danio.\n" +
                objetivo.recibirDanio(poder)
    }
}
