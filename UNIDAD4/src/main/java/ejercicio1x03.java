/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;

/**
 * lee por teclado un caracter y dice si es un signo de puntuacion o no
 * @author iriia
 */
public class ejercicio1x03 {
    public static boolean esSignoPuntuacion (char caracter){
        return caracter == '.' || caracter == ';' || caracter == ':' || caracter == '-' || caracter == '"' ||
                caracter == '(' || caracter == ',' || caracter == ')' || caracter == '[' || caracter == ']' || caracter == '"' ||
                caracter == '¿' || caracter == '?' || caracter == '!' || caracter == '¡' ;
    }
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Caracter? ");
        char caracter = teclado.next().charAt(0);
        if (esSignoPuntuacion(caracter)){
            System.out.printf("El caracter %s es un signo de puntuacion",caracter);
        } else {
            System.out.printf("El caracter %s no es un signo de puntuacion",caracter);
        }
    }
}
