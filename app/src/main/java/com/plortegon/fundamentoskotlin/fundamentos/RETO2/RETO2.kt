package com.plortegon.fundamentoskotlin.fundamentos.RETO3

class cancion(val titulo: String, val artista: String, val año: Int, var reproducciones: Int)

class album(val tipoMusica: String) {
    private val canciones = mutableListOf<cancion>()

    fun agregarCancion(titulo: String, artista: String, año: Int, reproducciones: Int) {
        val cancion = cancion(titulo, artista, año, reproducciones)
        canciones.add(cancion)
    }

    fun mostrarTotalReproducciones() {
        val totalReproducciones = canciones.sumBy { it.reproducciones }
        println("Total de reproducciones del álbum: $totalReproducciones")
    }

    fun mostrarCancionMasPopular() {
        val cancionMasPopular = canciones.maxByOrNull { it.reproducciones }
        if (cancionMasPopular != null) {
            println("La canción más popular del álbum es '${cancionMasPopular.titulo}' con ${cancionMasPopular.reproducciones} reproducciones.")
        } else {
            println("No hay canciones en este álbum.")
        }
    }

    fun mostrarPopularidadCanciones() {
        println("Popularidad de las canciones del álbum:")
        for (cancion in canciones) {
            val popularidad = if (cancion.reproducciones >= 1000) "popular" else "poco popular"
            println("${cancion.titulo}, interpretada por ${cancion.artista}, es $popularidad con ${cancion.reproducciones} reproducciones")
        }
    }

    fun imprimirDescripcionesCanciones() {
        println("Descripciones de canciones del álbum:")
        for (cancion in canciones) {
            println("${cancion.titulo}, interpretada por ${cancion.artista}, se lanzó en ${cancion.año}, ${cancion.reproducciones} reproducciones.")
        }
    }
}

fun main() {
    val album = album("Pop")

    album.agregarCancion("Canción 1", "Artista 1", 2021, 1200)
    album.agregarCancion("Canción 2", "Artista 2", 2022, 800)

    album.mostrarTotalReproducciones()
    album.mostrarCancionMasPopular()
    album.mostrarPopularidadCanciones()
    album.imprimirDescripcionesCanciones()
}