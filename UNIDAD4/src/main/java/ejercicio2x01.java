/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD4;

import java.util.Scanner;

/**
 * ESTE PROGRAMA LEE UNA FRASE E INDICA LAS MAYUSCULAS Y MINUSCULAS ENCONTRADAS
 *
 * @author iriia
 */
public class ejercicio2x01 {

    public static String leerFrase() {
        Scanner teclado = new Scanner(System.in);
        String cadena;
        int limite = 60;

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
        int contadorMayusculas = 0, contadorMinusculas = 0;
        String cadena, letrasMayusculas = "", letrasMinusculas = "";
        cadena = leerFrase();
        //recorre la cadena letra por letra
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            //si el caracter recogido es igual a alguna mayuscula, el contador se incrementa y se guarda el caracter
            if (caracter >= 'A' && caracter <= 'Z' || caracter == 'Ñ') {
                contadorMayusculas++;
                letrasMayusculas += caracter;
            } else if (caracter >= 'a' && caracter <= 'z' || caracter == 'ñ') {
                contadorMinusculas++;
                letrasMinusculas = letrasMinusculas + caracter;
            }
        }
        System.out.print("La frase tiene " + contadorMayusculas + " letras mayusculas.");
        System.out.println();
        System.out.println("Letras mayusculas: " + letrasMayusculas);
        
        System.out.print("La frase tiene " + contadorMinusculas + " letras minusculas.");
        System.out.println();
        System.out.print("Letras minusculas: " + letrasMinusculas);
    }
}
