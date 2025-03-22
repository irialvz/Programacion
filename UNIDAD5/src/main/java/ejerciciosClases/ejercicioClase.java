/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Random;

/**
 *
 * @author Alumno
 */
public class ejercicioClase {
    public static int[] generarNumeroRandom (int cantidad,int maximo,int minimo){
        Random aleatorio = new Random();
        int[] vector = new int[cantidad];
        for (int i = 0;i<vector.length;i++){
            vector[i] = aleatorio.nextInt(maximo - minimo + 1) + minimo;
        }
        return vector;
    }
    
    public static void main(String[] args){
        final int cantidadA = 20,cantidadB = 100;
        final int minimoA = 1, minimoB = 1000;
        final int maximoA = 100, maximoB = 9999;
        int [] vectorA = generarNumeroRandom(cantidadA,maximoA,minimoB);
        int [] vectorB = generarNumeroRandom(cantidadA,maximoA,minimoB);
    }
}
