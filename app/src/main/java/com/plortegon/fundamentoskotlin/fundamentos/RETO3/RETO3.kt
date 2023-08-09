package com.plortegon.fundamentoskotlin.fundamentos.RETO3

class ArticuloSubasta(val nombre: String, val precioBase: Int) {
    private val ofertas = mutableListOf<Pair<String, Int>>()

    fun agregarOferta(ofertante: String, oferta: Int) {
        ofertas.add(Pair(ofertante, oferta))
    }

    fun venderArticulo() {
        if (ofertas.isNotEmpty()) {
            val ofertaGanadora = ofertas.maxByOrNull { it.second }
            if (ofertaGanadora != null) {
                println("¡El artículo '$nombre' ha sido vendido a ${ofertaGanadora.first} por ${ofertaGanadora.second}!")
            }
        } else {
            println("¡El artículo '$nombre' no ha recibido ofertas y será vendido a la casa de subastas por el precio base de $precioBase.")
        }
    }
}

fun main() {
    val subasta = ArticuloSubasta("Pintura", 500)

    subasta.agregarOferta("Ofertante1", 600)
    subasta.agregarOferta("Ofertante2", 550)
    // Puedes agregar más ofertas aquí

    subasta.venderArticulo()
}

