package com.plortegon.fundamentoskotlin.fundamentos.RETO4

class RETO4 {
}
class Plato(val nombre: String, val descripcion: String, var precio: Double)

class MenuRestaurante {
    private val categorias = mutableMapOf<String, MutableList<Plato>>()

    init {
        categorias["Entradas"] = mutableListOf()
        categorias["Platos Fuertes"] = mutableListOf()
        categorias["Postres"] = mutableListOf()
        categorias["Bebidas"] = mutableListOf()
    }

    fun agregarPlato(categoria: String, nombre: String, descripcion: String, precio: Double) {
        categorias[categoria]?.add(Plato(nombre, descripcion, precio))
    }

    fun mostrarMenu() {
        println(" Menú del Restaurante ")
        for ((categoria, platos) in categorias) {
            println("\n$categoria:")
            platos.forEachIndexed { index, plato ->
                println("${index + 1}. ${plato.nombre} - ${plato.precio} - ${plato.descripcion}")
            }
        }
    }

}

fun main() {
    val menu = MenuRestaurante()

    var continuar = true
    while (continuar) {
        println("\nMenú del Restaurante ")
        println("1. Agregar plato")
        println("2. Mostrar menú")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                println("\nSeleccione una categoría:")
                println("1. Entradas")
                println("2. Platos Fuertes")
                println("3. Postres")
                println("4. Bebidas")
                print("Seleccione una categoría: ")
                val categoria = when (readLine()?.toIntOrNull()) {
                    1 -> "Entradas"
                    2 -> "Platos Fuertes"
                    3 -> "Postres"
                    4 -> "Bebidas"
                    else -> continue
                }

                println("\nIngrese el nombre del plato:")
                val nombre = readLine() ?: continue
                println("Ingrese la descripción del plato:")
                val descripcion = readLine() ?: continue
                println("Ingrese el precio del plato:")
                val precioStr = readLine() ?: continue
                val precio = precioStr.toDoubleOrNull() ?: continue

                menu.agregarPlato(categoria, nombre, descripcion, precio)

                println("Plato agregado exitosamente.")
            }
            2 -> menu.mostrarMenu()
            else -> continue
        }
    }
}