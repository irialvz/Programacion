/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author iriia
 */
public class ejercicio1x05 {

    public static int[] leerVectores(int longitud,int maximo,int minimo) {
        Random aleatorio = new Random();
        int [] vector = new int[longitud];
        
        for (int i = 0; i < vector.length;i++){
            vector[i] = aleatorio.nextInt(maximo - minimo + 1) + minimo;
        }
        return vector;
    }

    public static void main(String[] args) {
        final int longitud = 8;
        final int maximo = 5;
        final int minimo = 1;
        
        int[] vectorA = leerVectores(longitud,maximo,minimo);
        int[] vectorB = leerVectores(longitud,maximo,minimo);
        
        System.out.println("VECTOR A:");
        System.out.println(Arrays.toString(vectorA));
        System.out.println("VECTOR B:");
        System.out.println(Arrays.toString(vectorB));

        for (int i = 0; i < vectorA.length; i++) {
            int contador = 0;
            for (int j = 0; j < vectorB.length; j++) {
                if (vectorA[i] == vectorB[j]) {
                    contador++;
                }
            }
            System.out.println("El elemento en la posicion " + i
            + " del vector A aparece " + contador + " veces en el vector B");
        }

    }
}
