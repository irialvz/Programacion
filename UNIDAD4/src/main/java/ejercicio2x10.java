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
public class ejercicio2x10 {

    public static int contarEspacios(String cadena) {
        char espacio = ' ';
        int contadorEspacios = 0;

        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            if (caracter == espacio) {
                contadorEspacios++;
            }
        }
        return contadorEspacios;
    }
    
    public static int contarPalabras(String cadena){
        int contadorPalabras = 0;
        boolean enPalabra = false;
        char espacio = ' ';
        
        for (int i = 0; i < cadena.length();i++){
            char caracter = cadena.charAt(i);
            
            if (caracter == espacio){
                enPalabra = false;                
            } else if (!enPalabra) {
                contadorPalabras++;
                enPalabra = true;
            }
        }
    return contadorPalabras;    
    }

    public static String leerFrase() {
        Scanner teclado = new Scanner(System.in);
        final int MINIMO = 10, MAXIMO = 60;
        String cadena;
        do {
            System.out.println("Frase? ");
            cadena = teclado.nextLine();

            if (cadena.length() < MINIMO || cadena.length() > MAXIMO) {
                System.out.printf("La frase debe tener %d caracteres como minimo", MINIMO);
                System.out.printf("La frase debe tener %d caracteres como maximo", MAXIMO);
            }
        } while (cadena.length() < MINIMO || cadena.length() > MAXIMO);
        return cadena;
    }
    
   
    public static void main(String[] args){
        String cadena = leerFrase();
        int cantidadPalabras = contarPalabras(cadena);
        int cantidadEspacios = contarEspacios(cadena);
        
        System.out.println("El numero de espacios es de: " + cantidadEspacios + " espacios");
        System.out.println("El numero de palabras es de: " + cantidadPalabras + " palabras");
        
    }
}
