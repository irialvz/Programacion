/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD5;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author iriia
 */
public class ejercicio1x01 {

    public static void main(String[] args) {
        int[] vector = leerNumeros();
        int[] minimo = sacarMinimo(vector);
        int[] maximo = sacarMaximo(vector);
        //Saca los vectores introducidos
        System.out.println("VECTOR:" + Arrays.toString(vector));

        //muestra el minimo y su posicion
        System.out.println("Minimo:" + minimo[0]);
        System.out.println("Posicion minimo:" + minimo[1]);

        System.out.println("Maximo:" + maximo[0]);
        System.out.println("Posicion minimo:" + maximo[1]);

    }

    public static int[] leerNumeros() {
        Scanner teclado = new Scanner(System.in);
        int[] numeros;
        numeros = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.println("Numero entero " + i + "?");
            numeros[i] = teclado.nextInt();
        }
        return numeros;
    }

    static int[] sacarMinimo(int[] vector) {
        int minimo = vector[0];
        int posicionMinimo = 0;

        for (int i = 0; i < vector.length; i++) {
            if (vector[i] < minimo) {
                minimo = vector[i];
                posicionMinimo = i;
            }
        }
        return new int[]{minimo, posicionMinimo};
    }

    static int[] sacarMaximo(int[] vector) {
        int maximo = vector[0];
        int posicionMaximo = 0;

        for (int i = 0; i < vector.length; i++) {
            if (vector[i] > maximo) {
                maximo = vector[i];
                posicionMaximo = i;
            }
        }
        return new int[]{maximo, posicionMaximo};
    }

}
