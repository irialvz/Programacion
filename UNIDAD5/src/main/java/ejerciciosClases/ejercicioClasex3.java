/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD5.ejerciciosClases;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class ejercicioClasex3 {
     public static int[] generarNumeroRandom (int cantidad,int maximo,int minimo){
        Random aleatorio = new Random();
        int[] vector = new int[cantidad];
        for (int i = 0;i<vector.length;i++){
            vector[i] = aleatorio.nextInt(maximo - minimo + 1) + minimo;
        }
        return vector;
    }
    
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        final int cantidad = 20,minimo = 1,maximo = 100;
        int[] vector = generarNumeroRandom(cantidad,maximo,minimo);
    }
    
    
    public static boolean esPrimo(int numero){
        if (numero % 1 == 0 && numero % numero == 0){
            return true;
        }
        return false;
    }
   /* public static int[] generarVectorPrimo(int[] vector){
        int[] vectorPrimos;
        /*if (esPrimo) {
            
        }
    }*/
}
