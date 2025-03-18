/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja7.ejer6_2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class Carton {

    private int idCarton;
    private static int contadorCartones;

    public Carton() {
        this.idCarton = ++contadorCartones;
    }

     void mostrarMatriz(int[][] matriz) {
        System.out.println("ID DE CARTON " + idCarton);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(matriz[i][j] + " ");

            }
            System.out.println();
        }

    }

     void crearCarton() {
        Random aleatorio = new Random();
        int matrizBingo[][] = new int[3][9];
        //LLENAR MATRIZ NUMEROS
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 3; i++) {
                int x = aleatorio.nextInt(10);
                matrizBingo[i][j] = j * 10 + x;

            }
        }
        //INTRODUCIR HUECOS FILAS
        for (int i = 0; i < 3; i++) {
            Integer[] valores = {0, 1, 2, 3, 4, 5, 6, 7, 8};
            Collections.shuffle(Arrays.asList(valores));

            for (int k = 0; k < 4; k++) {
                matrizBingo[i][valores[k]] = 0;
            }
        }
        mostrarMatriz(matrizBingo);
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("NUMERO DE CARTONES?");
        int numeroCartones = teclado.nextInt();

        for (int i = 0; i < numeroCartones; i++) {
            Carton carton = new Carton();
            carton.crearCarton();
            System.out.println();
        }

    }

}
