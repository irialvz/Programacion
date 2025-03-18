/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.Recursividad;

import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class hoja4_ej3 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un numero");
        String cadena = teclado.nextLine();
        
        if (esCapicua(cadena)){
            System.out.println("El numero " + cadena  + " es capicua");
        } else {
            System.out.println("El numero " + cadena + " no es capicua");
        }
    }
    public static boolean esCapicua(String cadena){
        if (cadena.length() <= 1){
            return true;
        } else {
            if (cadena.charAt(0) != cadena.charAt(cadena.length() - 1)){
                return false;
            } else {
                return esCapicua(cadena.substring(1, cadena.length() -1));
            }
        }
    }
}
