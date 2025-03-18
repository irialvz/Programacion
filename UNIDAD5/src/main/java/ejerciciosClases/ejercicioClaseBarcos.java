/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD5.ejerciciosClases;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Alumno
 */
public class ejercicioClaseBarcos {

    public static char[][] generarMatrizGuiones(int filas, int columnas) {
        char[][] matriz = new char[filas][columnas];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) { //mientras que j sea menor que el numero de columnas de la matrizz
                matriz[i][j] = '-';
            }
        }
        return matriz;
    }

    public static void mostrarMatriz(char[][] matriz) {
        final int fila = 4, columna = 6;
        for (int i = 0; i < fila; i++) {

            for (int j = 0; j < columna; j++) {
                //System.out.print("[");
                System.out.print(matriz[i][j] + ",");

            }
            System.out.print("]");
            System.out.println();
        }
    }

   /* public static char[][] generarEquis(char[][]matriz,int numEquis){
        Random aleatorio = new Random();
        int fila,columna;
        for (int i = 0; i < numEquis;i++){
            do {
                fila = aleatorio.nextInt(matriz.length);
            }
    
        }
    }*/
    public static void main(String[] args) {
        char[][] matriz = generarMatrizGuiones(4, 6);
        mostrarMatriz(matriz);
        //char[][] equis = generarEquis(matriz,5);
    }
}
