/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class ejercicio2x06 {
    public static String leerFrase(){
        Scanner teclado = new Scanner(System.in);
        final int LIMITE = 60, MINIMO = 5;
        String cadena;
        do {
            System.out.print("Frase? ");
            cadena = teclado.nextLine();

            if (cadena.length() < MINIMO || cadena.length() > LIMITE){
                System.out.println("La cadena debe tener minimo 5 caracteres y maximo 40 caracteres");
            }
        } while (cadena.length() < MINIMO || cadena.length() > LIMITE);
        return cadena;
    }

    public static void main(String[] args){
        String cadena = leerFrase(), acumulado = "";

        for (int i = 0; i < cadena.length();i++){
            acumulado += cadena.charAt(i);
            System.out.println(acumulado);
        }
    }
}
