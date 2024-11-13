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

class GeneradorLista{

    private val listaUsuarios = mutableListOf<Usuario>()


    fun agregarUsuario(usuario: Usuario) {
        listaUsuarios.add(usuario)
        println("${usuario.nombre} ha sido agregado a la lista.")
    }

    fun eliminarUsuario(nombre: String) {
        val usuario = listaUsuarios.find { it.nombre == nombre }

        if (usuario != null) {
            listaUsuarios.remove(usuario)
            println("$nombre ha sido eliminado de la lista.")
        } else {
            println("Usuario con el nombre $nombre no encontrado.")
        }
    }

    fun mostrarLista() {
        if (listaUsuarios.isEmpty()) {
            println("La lista de usuarios está vacía.")
        } else {
            println("La lista de usuarios es:")
            listaUsuarios.forEach { it.mostrarDatos() }
        }
    }
}


fun main() {
    // Crear la instancia del manejador de usuarios
    val generLista = GeneradorLista()

    // Crear cinco usuarios
    val usuario1 = Usuario("Rick Riordan", 45, "Sheriff")
    val usuario2 = Usuario("Walter White", 60, referencia = usuario1)
    val usuario3 = Usuario("John Wick", 39, "Cazador")
    val usuario4 = Usuario("Clark Kent", 34)
    val usuario5 = Usuario("Peter Parker", 15, "Estudiante", referencia = usuario3)

    // Agregar los usuarios a la lista
    generLista.agregarUsuario(usuario1)
    generLista.agregarUsuario(usuario2)
    generLista.agregarUsuario(usuario3)
    generLista.agregarUsuario(usuario4)
    generLista.agregarUsuario(usuario5)

    // Mostrar la lista de usuarios
    println("\nLista de usuarios:")
    generLista.mostrarLista()

    // Eliminar un usuario y mostrar la lista nuevamente
    println("\nEliminando al usuario 'Clark Kent':")
    generLista.eliminarUsuario("Clark Kent")

    println("\nLista de usuarios actualizada:")
    generLista.mostrarLista()
}





