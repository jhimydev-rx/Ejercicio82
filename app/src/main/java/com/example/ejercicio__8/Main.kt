package com.example.ejercicio__8
import kotlin.random.Random

fun main() {
    println("Bienvenido al mini juego de batalla")

    // Crear heroe con nombre y vida aleatoria
    print("Ingresa el nombre de tu heroe: ")
    val nombreHeroe = readln()

    // Vida aleatoria entre 80 y 150
    val vidaHeroe = Random.nextInt(80, 151)

    // Poder de ataque elegido por el usuario (con rango)
    print("Poder de ataque (10-30): ")
    val poderHeroe = readln().toIntOrNull()?.coerceIn(10, 30) ?: 20

    val heroe = Heroe(nombreHeroe, vidaHeroe, poderHeroe)
    println("Tu heroe: ${heroe.presentarse()}")

    // Lista de enemigos posibles
    val enemigosDisponibles = listOf(
        Enemigo("Goblin", 80, 15),
        Enemigo("Orco", 120, 25),
        Enemigo("Dragon", 200, 40)
    )

    // Seleccionar un enemigo aleatorio
    val enemigo = enemigosDisponibles.random()
    println("Tu enemigo es: ${enemigo.presentarse()}")

    println("=====================================")

    // Batalla por turnos
    while (heroe.estaVivo && enemigo.estaVivo) {
        println("\nTu turno, que quieres hacer?")
        println("1) Atacar")
        println("2) Pasar turno")
        print("Opcion: ")
        val opcion = readln()

        when (opcion) {
            "1" -> println(heroe.atacar(enemigo))
            "2" -> println("${heroe.nombre} espera el siguiente turno.")
            else -> println("Accion invalida, pierdes el turno.")
        }

        if (!enemigo.estaVivo) break

        // Turno del enemigo
        println(enemigo.atacar(heroe))
        println("-------------------------------------")
        readln() // esperar ENTER para continuar
    }

    println("=====================================")
    if (heroe.estaVivo) {
        println("Ganaste, ${heroe.nombre} sobrevivio a la batalla.")
    } else {
        println("${heroe.nombre} fue derrotado por ${enemigo.nombre}.")
    }
}
