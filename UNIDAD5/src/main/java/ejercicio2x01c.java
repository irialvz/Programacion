/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author iriia
 */
public class ejercicio2x01c {

    public static int[][] leerNumeros(int filas,int columnas) {
        Scanner teclado = new Scanner(System.in);
        int[][] numero = new int[filas][columnas];

        for (int i = 0; i < numero.length; i++) {
            for (int j = 0; j < numero[i].length; j++) {
                System.out.println("Numero entero (" + i + "," + j + ")?");
                numero[i][j] = teclado.nextInt();
            }
        }
        return numero;
    }
    public static void mostrarNumero(int[][]matriz){
        System.out.println("MATRIZ: " + Arrays.deepToString(matriz));
    }

    public static void sacarMinimo(int[][] matriz) {
        int minimo = matriz[0][0];
        int minFila = 0, minColumna = 0, filas = 4, columnas = 4;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] < minimo) {
                    minimo = matriz[i][j];
                    minFila = i;
                    minColumna = j;
                }
            }
        }
        System.out.println("El minimo de la matriz es: " + minimo);
        System.out.println("con posicion (" + minFila + "," + minColumna + ")");
    }
        public static void sacarMaximo(int[][] matriz) {
        int maximo = matriz[0][0];
        int maxFila = 0, maxColumna = 0, filas = 4, columnas = 4;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] > maximo) {
                    maximo = matriz[i][j];
                    maxFila = i;
                    maxColumna = j;
                }
            }
        }
        System.out.println("El minimo de la matriz es: " + maximo);
        System.out.println("con posicion (" + maxFila + "," + maxColumna + ")");
    }

    public static void main(String[] args) {
        int[][] matriz = leerNumeros(4,4);
        mostrarNumero(matriz);
        sacarMinimo(matriz);
        sacarMaximo(matriz);
    }
}