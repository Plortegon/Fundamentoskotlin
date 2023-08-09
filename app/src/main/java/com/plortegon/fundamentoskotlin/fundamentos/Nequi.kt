package com.plortegon.fundamentoskotlin.fundamentos
import kotlin.system.exitProcess

class Reto2 {
}
fun main() {
    val nequi = Nequi()
    nequi.run()
}


class Nequi {
    val phoneNumber = "3213446195"
    val password = "1234"
    var balance = 4500

    fun run() {
        var attempts = 3
        while (attempts > 0) {
            if (login()) {
                showBalance()
                showMenu()
                break
            } else {
                attempts--
                if (attempts > 0) {
                    println("¡Upps! Parece que tus datos de acceso no son correctos. Tienes $attempts intentos más.")
                } else {
                    println("Has excedido el número máximo de intentos. La aplicación se cerrará.")
                    exitProcess(0)
                }
            }
        }
    }

    fun login(): Boolean {
        println("Bienvenido a Nequi Colombia")
        print("Ingresa tu número de celular: ")
        val numcelular = readLine()
        print("Ingresa tu clave de 4 dígitos: ")
        val inputPassword = readLine()

        return numcelular == phoneNumber && inputPassword == password
    }

    fun showBalance() {
        println("Saldo Disponible: $balance")
    }

    fun showMenu() {
        while (true) {
            println("\nMenú de opciones:")
            println("1. Sacar dinero")
            println("2. Envía dinero")
            println("3. Recarga saldo")
            println("4. Salir")

            print("Elige una opción: ")
            when (readLine()?.toIntOrNull()) {
                1 -> withdrawMoney()
                2 -> sendMoney()
                3 -> rechargeBalance()
                4 -> {
                    println("¡Hasta luego!")
                    exitProcess(0)
                }
                else -> println("Opción inválida. Por favor, elige una opción válida.")
            }
        }
    }

    private fun withdrawMoney() {
        println("Escoge una opción:")
        println("1. Cajero")
        println("2. Punto físico")
        print("Selecciona una opción: ")
        val option = readLine()?.toIntOrNull()

        if (option == 1 || option == 2) {
            if (balance < 2000) {
                println("No te alcanza para hacer el retiro.")
            } else {
                print("Ingresa el monto que deseas retirar: ")
                val amount = readLine()?.toIntOrNull() ?: 0

                if (amount in 1..balance) {
                    println("Generando código de retiro de 6 dígitos...")
                    val withdrawalCode = (100000..999999).random()
                    println("Código de retiro: $withdrawalCode")
                    balance -= amount
                    println("Retiro exitoso. Nuevo saldo: $balance")
                } else {
                    println("Monto inválido o insuficiente.")
                }
            }
        } else {
            println("Opción inválida.")
        }
    }

    private fun sendMoney() {
        print("Ingresa el número de teléfono al que deseas enviar dinero: ")
        val recipientPhoneNumber = readLine() ?: ""
        print("Ingresa el valor a enviar: ")
        val amount = readLine()?.toIntOrNull() ?: 0

        if (amount > 0 && amount <= balance) {
            balance -= amount
            println("Se ha enviado exitosamente $amount a $recipientPhoneNumber. Nuevo saldo: $balance")
        } else {
            println("Monto inválido o insuficiente para enviar.")
        }
    }

    fun rechargeBalance() {
        print("Ingresa el valor a recargar: ")
        val amount = readLine()?.toIntOrNull() ?: 0

        println("¿Deseas realizar la recarga de $amount? (Sí/No)")
        val confirmation = readLine() ?: ""

        if (confirmation.equals("Sí", ignoreCase = true)) {
            balance += amount
            println("Recarga exitosa. Nuevo saldo: $balance")
        } else {
            println("Recarga cancelada.")
        }
    }
}