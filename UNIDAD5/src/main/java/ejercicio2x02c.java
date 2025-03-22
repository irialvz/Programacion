/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Random;

/**
 *
 * @author iriia
 */
public class ejercicio2x02c {

    public static int[][] generarMatriz() {
        Random aleatorio = new Random();
        final int fila = 8, columna = 8, minimo = 1, maximo = 100;
        int[][] matriz = new int[fila][columna];
//numero de filas: matriz.length
//numero de columnas matriz[i].length
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) { //mientras que j sea menor que el numero de columnas de la matrizz
                matriz[i][j] = aleatorio.nextInt(maximo - minimo + 1) + minimo;
            }
        }
        return matriz;
    }

    public static void mostrarMatriz(int[][] matriz) {
        final int fila = 8, columna = 8;
        for (int i = 0; i < fila; i++) {

            for (int j = 0; j < columna; j++) {
                //System.out.print("[");
                System.out.print(matriz[i][j] + ",\t");

            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static void sumarFila(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            int sumaFilas = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                sumaFilas += matriz[i][j];
            }
            System.out.printf("Suma de las filas %d:%d %n ", i + 1, sumaFilas);
        }
    }

    public static void sumarColumnas(int[][] matriz) {
        for (int j = 0; j < matriz[0].length; j++) {
            int sumaColumnas = 0;
            for (int i = 0; i < matriz.length; i++) {
                sumaColumnas += matriz[i][j];
            }
            System.out.printf("Suma de las columnas %d:%d %n ", j + 1, sumaColumnas);
        }
    }

    public static void main(String[] args) {
        int[][] matriz = generarMatriz();
        mostrarMatriz(matriz);
        sumarFila(matriz);
        sumarColumnas(matriz);
    }
}
