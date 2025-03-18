/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD4;

import java.util.Scanner;

/**
 *
 * @author iriia
 */
public class ejercicio2x11 {

    public static String leerFrase() {
        Scanner teclado = new Scanner(System.in);
        String cadena;
        String espacio = " ";

        //este bucle realiza la primer pregunta, MIENTRAS QUE la cadena es mayor a 60 se repetirá
        do {
            System.out.print("palabra? ");
            cadena = teclado.nextLine();

            if (cadena.contains(espacio)) {
                System.out.println("Error: la palabra no debe contener espacios");
            }
        } while (cadena.contains(espacio));
        return cadena;
    }

    public static String invertirPalabra(String cadena) {
        String contenedor = "";
        for (int i = cadena.length() - 1; i >= 0; i--) {
            contenedor += cadena.charAt(i);
        }
        return contenedor;
    }

    public static boolean esPalindrona(String cadenaOriginal, String cadenaInvertida) {
        return (cadenaInvertida.equals(cadenaOriginal));
    }

    public static void main(String[] args) {
        String palabra = leerFrase();
        String invertida = invertirPalabra(palabra);
        System.out.println("Palabra invertida: " + invertida);
        
        boolean palindrona = esPalindrona(palabra,invertida);
        if (palindrona){
            System.out.println("La palabra " + palabra + " es palindrona");
        } else {
            System.out.println("La palabra " + palabra + " no es palindrona");
        }

    }
}
