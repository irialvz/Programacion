/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD5.ejerciciosClases;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Generar un vector con 10 números aleatorios entre 1 y 100
Función: int[] generarAleatorio(int longitud, int minimo, int maximo)
Sacar por pantalla si el vector contiene algún número múltiplo de n, siendo n un número pedido por teclado
Función: boolean contieneMultiplo(int multiplo, int[] vector)
 * @author Iria
 */
public class ejercicioClasex2 {
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
        final int cantidad = 10,minimo = 1,maximo = 100;
        int[] vector = generarNumeroRandom(cantidad,maximo,minimo);
        
        System.out.print("Numero N? ");
        int numeroN = teclado.nextInt();
        
        System.out.println("VECTOR: ");
        System.out.println(Arrays.toString(vector));
        
        
        if (contieneMultiplo(numeroN,vector)){
            System.out.println("Contiene multiplos de " + numeroN);
        } else {
            System.out.println("no contiene multiplos de " + numeroN);
        }
    }
    public static boolean contieneMultiplo (int multiplo,int[] vector){
        int i= 0;
        while (i < vector.length){
            if (vector[i] % multiplo == 0){
                return true;
            }
            i++;
        }
    return false;
    }
}    

