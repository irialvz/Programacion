/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;

/**
 *
 * @author iriia
 */
public class ejercicio2x04 {
//Lee por teclado una frase de maximo 60 caracteres

    public static String leerFrase() {
        Scanner teclado = new Scanner(System.in);
        int limite = 60;
        String cadena;

        do {
            System.out.print("Frase? ");
            cadena = teclado.nextLine();

            if (cadena.length() > limite) {
                System.out.println("La frase debe tener 60 caracteres maximo");
            }
        } while (cadena.length() > limite);
        return cadena;
    }

    public static void posicionPar(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            if (i % 2 == 0) {
                System.out.print(cadena.charAt(i));
            }

        }
    }
        public static void posicionImpar(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            if (i % 2 != 0) {
                System.out.print(cadena.charAt(i));
            }

        }
    }
    public static void main(String[] args){
        String frase = leerFrase();
        System.out.println("Los caracteres de posiciones pares de la frase son:");
        posicionPar(frase);
        System.out.println();
        System.out.println("Los caracteres de posiciones impares de la frase son:");
        posicionImpar(frase);
    }
}
