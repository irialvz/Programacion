/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD5;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author iriia
 */
public class ejercicio2x03 {

    public static int[][] generarMatriz(int fila, int columna, int minimo, int maximo) {
        Random aleatorio = new Random();
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

    public static void intercambiarFilas(int[][] matriz,int filaX,int filaY) {
        int auxiliar;
        //fila X = preguntarFila, filaY = preguntarFila2
        for (int j = 0; j != matriz[filaX].length; j++) {
            auxiliar = matriz[filaX][j];
            matriz[filaX][j] = matriz[filaY][j]; //rempleza el valor de la fila X por el valor de la fila Y
            matriz[filaY][j] = auxiliar;
        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int[][] matriz = generarMatriz(8, 8, 1, 100);
        int preguntarFila, preguntarFila2;

        System.out.println("MATRIZ ANTES DEL INTERCAMBIO");
        mostrarMatriz(matriz);

        do {
            System.out.println("Fila 1?");
            preguntarFila = teclado.nextInt();
            if (preguntarFila < 0 || preguntarFila > 7) {
                System.out.println("La fila debe estar comprendida entre 0 y 7");
            }
        } while (preguntarFila < 0 || preguntarFila > 7);

        do {
            System.out.println("Fila 2?");
            preguntarFila2 = teclado.nextInt();

            if (preguntarFila2 < 0 || preguntarFila2 > 7) {
                System.out.println("La fila debe estar comprendida entre 0 y 7");
            }

        } while (preguntarFila2 < 0 || preguntarFila2 > 7);
        intercambiarFilas(matriz,preguntarFila,preguntarFila2);
        System.out.println("MATRIZ DESPUES DEL INTERCAMBIO");
        mostrarMatriz(matriz);
        
    }
}
