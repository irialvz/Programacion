/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author iriia
 */
public class ejercicio1x06 {
    static int[] fusionar(int[] vector1, int[]vector2){
    int [] vectorFusion = new int[vector1.length + vector2.length];
    
    for (int i=0; i<vector1.length;i++){
        vectorFusion[i] = vector1[i];
    }
    
    for (int i=0;i < vector2.length;i++){
        vectorFusion[i + vector1.length] = vector2[i];
    }
    return vectorFusion;
}
    public static int[] rellenarVectores(int capacidad,int maximo,int minimo) {
        Random aleatorio = new Random();
        int[] vector = new int[capacidad];
        for (int i = 0; i < vector.length;i++){
            vector[i] = aleatorio.nextInt(maximo - minimo + 1) + minimo;
        }
        return vector;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int capacidadA,capacidadB;
        final int maximo = 1000;
        final int minimo = -1000;
        
        System.out.println("Capacidad del vector A? ");
        capacidadA = teclado.nextInt();
        System.out.println("Capacidad del vector B? ");
        capacidadB = teclado.nextInt();

        int[] vectorRandomA = rellenarVectores(capacidadA,maximo,minimo);
        int[] vectorRandomB = rellenarVectores(capacidadB,maximo,minimo);
        int[] vectorFusion = fusionar(vectorRandomA,vectorRandomB);
        
        System.out.println("Vector A");
        System.out.println(Arrays.toString(vectorRandomA));
        System.out.println("Vector B");
        System.out.println(Arrays.toString(vectorRandomB));
        
        System.out.println("VECTOR FUSION:");
        System.out.println(Arrays.toString(vectorFusion));
    }
}
