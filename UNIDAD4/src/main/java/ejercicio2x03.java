/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD4;

import java.util.Scanner;

/**
 * ESTE PROGRAMA LEE UNA FRASE Y SACA EL NUM DE VOCALES Y COSONANTES Y LOS SACA
 * POR PANTALLA
 *
 * @author iriia
 */
public class ejercicio2x03 {

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

    public static void main(String[] args) {
        int contadorVocales = 0, contadorConsonantes = 0;
        String vocales = "", consonantes = "";
        String cadena = leerFrase();
        
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);

            //Si la posicion de caracter es vocal devolvera un numero mayor o igual que 0 representado la posicion
            // si es vocal se incrementara y guardara el caracter, si no es vocal devolvera un -1 ya que no hay vocal
            if ("AEIOUaeiouÁÉÍÓÚáéíóú".indexOf(caracter) != -1) {
                contadorVocales++;
                vocales += caracter;
            } else if ("BCDFGHJKLMNÑPQRSTVWXYZbcdfghjklmnñpqrstvwxyz".indexOf(caracter) != -1) {
                contadorConsonantes++;
                consonantes += caracter;
            }
        }
        System.out.println("La frase tiene " + contadorVocales + " letras vocales");
        System.out.println("Letras vocales " + vocales);
        System.out.println("La frase tiene " + contadorConsonantes + " letras consonantes");
        System.out.println("Letras consonanes " + consonantes);

    }

}
