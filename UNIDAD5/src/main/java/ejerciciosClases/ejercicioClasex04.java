/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD5.ejerciciosClases;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Alumno
 */
public class ejercicioClasex04 {

    public static int[] generarAleatorios(int longitud, int maximo, int minimo) {
        Random aleatorio = new Random();
        int[] vector = new int[longitud];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = aleatorio.nextInt(maximo - minimo + 1) + minimo;
        }
        return vector;
    }

    static int[] fusionar(int[] vector1, int[] vector2) {
        int[] vectorFusion = new int[vector1.length + vector2.length];

        for (int i = 0; i < vector1.length; i++) {
            vectorFusion[i] = vector1[i];
        }

        for (int i = 0; i < vector2.length; i++) {
            vectorFusion[i + vector1.length] = vector2[i];
        }
        return vectorFusion;
    }
    
   /* static int[] intercalar(int[] vector1,int[] vector2){
        
    }*/

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        final int minimo = -1000, maximo = 1000;

        System.out.println("Cantidad de numeros A? ");
        int cantidadA = teclado.nextInt();
        System.out.println("Cantidad de numeros B? ");
        int cantidadB = teclado.nextInt();

        int[] vectorA = new int[cantidadA];
        int[] vectorB = new int[cantidadB];
        int[] vectorFusion;

        vectorA = generarAleatorios(cantidadA, maximo, minimo);
        vectorB = generarAleatorios(cantidadB, maximo, minimo);
        vectorFusion = fusionar(vectorA,vectorB);
        System.out.println("A: " + Arrays.toString(vectorA) + " y B: " + Arrays.toString(vectorB));
        System.out.println("Fusionar: " + Arrays.toString(vectorFusion));
    }
}
