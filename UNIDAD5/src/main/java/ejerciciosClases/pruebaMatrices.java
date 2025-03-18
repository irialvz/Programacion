/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD5.ejerciciosClases;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class pruebaMatrices {

    public static int[][] generarAleatorios(int filas, int columnas, int maximo, int minimo) {
        Random aleatorio = new Random();
        int[][] matriz = new int[filas][columnas];
//numero de filas: matriz.length
//numero de columnas matriz[i].length
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) { //mientras que j sea menor que el numero de columnas de la matrizz
                matriz[i][j] = aleatorio.nextInt(maximo - minimo + 1) + minimo; 
            }
        }
        return matriz;
    }

    public static void escribirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++){
            System.out.println(Arrays.toString(matriz[i]));
        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        //int[] filas, columnas;
        final int maximo = 10, minimo = 1, filas = 5, columnas = 5;
        
        
        int[][] matriz = generarAleatorios(filas,columnas,maximo,minimo);
        escribirMatriz(matriz);

    }
}
