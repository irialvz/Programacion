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
public class hoja4_ej4 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int[] cadenas = new int[5];
        for (int i = 0; i < cadenas.length; i++) {
            System.out.println("Introduce numero " + i);
            cadenas[i] = teclado.nextInt();
        }

        if (estaOrdenado(cadenas, 0)){
            System.out.println("La cadena esta ordenada de menor a mayor");
        } else {
            System.out.println("La cadena no esta ordenada de menor a mayor");
        }
    }

    public static boolean estaOrdenado(int[] cadena, int indice) {
        if (indice >= cadena.length - 1) {
            return true;
        }
        if (cadena[indice] > cadena[indice + 1]) {
            return false;
        }
        return estaOrdenado(cadena,indice +1);
    }
}
