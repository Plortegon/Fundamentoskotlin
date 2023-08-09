package com.plortegon.fundamentoskotlin.fundamentos.RETO1

class Notificaciones {
    private val notificaciones = mutableMapOf<String, Int>()

    fun agregarNotificaciones(celular: String, cantidad: Int) {
        notificaciones[celular] = cantidad
    }

    fun generarMensajeResumen(celular: String): String {
        val cantidad = notificaciones[celular] ?: 0
        return when {
            cantidad == 0 -> "No hay mensajes disponibles para $celular"
            cantidad < 100 -> "Tienes $cantidad notificaciones en $celular"
            else -> "Tienes 99+ notificaciones en $celular"
        }
    }
}

fun main() {
    val notificaciones = Notificaciones()

    notificaciones.agregarNotificaciones("Teléfono1", 75)
    notificaciones.agregarNotificaciones("Teléfono2", 112)

    // Generar mensajes de resumen
    println(notificaciones.generarMensajeResumen("Teléfono1"))
    println(notificaciones.generarMensajeResumen("Teléfono2"))
    println(notificaciones.generarMensajeResumen("Teléfono3"))
}