/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD4;

import java.util.Scanner;

/**
 * ESTE PROGRAMA LEE UNA FRASE Y MUESTRA LOS SIMBOLOS ENCONTRADOS
 *
 * @author iriia
 */
public class ejercicio2x02 {

    public static String leerFrase() {
        Scanner teclado = new Scanner(System.in);
        int limite = 60;
        String cadena;

        //este bucle realiza la primer pregunta, MIENTRAS QUE la cadena es mayor a 60 se repetirá
        do {
            System.out.print("Frase? ");
            cadena = teclado.nextLine();

            if (cadena.length() > limite) {
                System.out.print("La frase debe tener 60 caracteres como maximo");
            }
        } while (cadena.length() > limite);
        return cadena;
    }

    public static void main(String[] args) {
        String cadena,simbolos = "";
        int contadorSimbolos = 0;
        cadena = leerFrase();
        //recorre la cadena letra por letra
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            //si el caracter recogido es igual a alguna mayuscula, el contador se incrementa y se guarda el caracter
            if (caracter == '.' || caracter == ',' || caracter == ':' || caracter == ';' || caracter == '"' || caracter == '-' || caracter == '(' || caracter == ')' || caracter == '[' || caracter == ']' || caracter == '{' || caracter == '}') {
                contadorSimbolos++;
                simbolos += caracter;
            }
        }
        System.out.print("La frase tiene " + contadorSimbolos + " signos de puntuacion.");
        System.out.println();
        System.out.println("Signos de puntuacion: " + simbolos);

    }
}
