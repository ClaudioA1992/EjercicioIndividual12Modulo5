package cl.awakelab.ejercicioindividual12modulo5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

fun main() {

    println("Ingresar cantidad de usuarios")
    val cantidadUsuarios = readln().toInt()

    var usuarios = mutableListOf<Usuario>()

    for(i in 1..cantidadUsuarios) {
        var usuario: Usuario = Usuario()
        usuarios.add(usuario)
    }

    usuarios.sortBy { u -> u.edad }

    for(i in 0..cantidadUsuarios-1) {
        println(usuarios.get(i).nombre)
        println(usuarios.get(i).apellido)
        println(usuarios.get(i).edad)
        println(usuarios.get(i).correo)
        println(usuarios.get(i).sistemaDeSalud)
        println("-------------------------------------")
    }

}

class Usuario {

    var nombre: String = ""
    var apellido: String = ""
    var edad: Int = 0
    var correo: String = ""
    var sistemaDeSalud: String = ""


    constructor() {
        println("Ingresa nombre de usuario")
        nombre = readln()
        while(nombre.isNullOrBlank()) {
            println("Ingresa un nombre válido")
            nombre = readln()
        }
        println("Ingresa apellido de usuario")
        apellido = readln()
        while(apellido.isNullOrBlank()) {
            println("Ingresa un apellido válido")
            apellido = readln()
        }
        println("Ingresa edad de usuario")
        edad = Integer.parseInt(readln())
        while(edad == 0) {
            println("Ingresa una edad válida")
            edad = Integer.parseInt(readln())
        }
        println("Ingresa correo de usuario")
        correo = readLine()!!
        var correoValido: Boolean = validarEmail(correo)
        //var correoValido: Boolean = true
        while(!correoValido) {
            println("Ingresa un correo válido")
            correo = readln()
            correoValido = validarEmail(correo)
        }
        println("Ingrese sistema de salud")
        println("Opción 1: Fonasa")
        println("Opción 2: Isapre")
        println("Opción 3: Particular")
        var sistSalud: Int = Integer.parseInt(readln())
        while(sistSalud != 1 && sistSalud != 2 && sistSalud != 3) {
            println("Ingresa una opción válida")
            println("Ingrese sistema de salud")
            println("Opción 1: Fonasa")
            println("Opción 2: Isapre")
            println("Opción 3: Particular")
            sistSalud = Integer.parseInt(readln())
        }
        when(sistSalud) {
            1-> sistemaDeSalud = "Fonasa"
            2-> sistemaDeSalud = "Isapre"
            3-> sistemaDeSalud = "Particular"
        }

    }


    fun validarEmail(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
        var isValid: Boolean = email.matches(emailRegex.toRegex())
        if(isValid) {
            println("Correo válido")
        } else {
            println("Correo inválido")
        }
        return isValid
    }


}