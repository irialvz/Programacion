/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class ejercicio2x05 {

    public static int menu() {
        Scanner teclado = new Scanner(System.in);
        int resultado;
        System.out.println("(0) Salir del programa");
        System.out.println("(1) Convertir en mayuscula");
        System.out.println("(2) Convertir en minuscula");
        System.out.println("Opcion? ");
        resultado = teclado.nextInt();
        return resultado;
    }

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
        int opcion = menu();
        String frase;
        if (opcion == 1){
            frase = leerFrase();
            String mayuscula = frase.toUpperCase();
            System.out.println("Frase en mayusculas " + mayuscula);
        }
        if (opcion == 2){
            frase = leerFrase();
            String minuscula = frase.toLowerCase();
            System.out.println("Frase en minusculas " + minuscula);
        }
        if (opcion == 0) {
            System.out.println("La opcion de menu debe ser 1 o 2");
        }

    }
}
