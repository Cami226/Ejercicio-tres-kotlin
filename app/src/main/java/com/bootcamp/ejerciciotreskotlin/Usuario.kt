package com.bootcamp.ejerciciotreskotlin


class Usuario(
    val nombre: String,
    val edad: Int,
    val trabajo: String? = null,
    val referencia: Usuario? = null
) {
    // Función para mostrar los datos del usuario en consola
    fun mostrarDatos() {
        println("Nombre: $nombre.")
        println("Edad: $edad años.")
        println("Trabajo: ${trabajo ?: "No especificado"}.")
        if (referencia != null) {
            println("Fue citado por: ${referencia.nombre} de ${referencia.edad} años.")
        } else {
            println("No tiene referencia.")
        }
        println()
    }
}

fun main() {
    // Crear dos instancias de Usuario
    val usuario1 = Usuario("Rick", 40, "Sheriff")
    val usuario2 = Usuario("Walter", 30, referencia = usuario1)

    // Mostrar los datos de los usuarios
    usuario1.mostrarDatos()
    usuario2.mostrarDatos()
}
