/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author iriia
 */
public class ejercicio1x04 {

    public static void main(String[] args) {
        int[] vectoresGenerados = generarRandom();
        int mediaAritmetica = sacarMedia(vectoresGenerados);
        int contadorInferior = 0, contadorIgual = 0, contadorSuperior = 0;
        
        System.out.println("VECTOR: " + Arrays.toString(vectoresGenerados));
        System.out.println("Media " + mediaAritmetica);
        
        for (int i=0;i < vectoresGenerados.length;i++){
            if (vectoresGenerados[i] < mediaAritmetica){
                contadorInferior++;
            } else if (vectoresGenerados[i] > mediaAritmetica) {
                contadorSuperior++;
            } else {
                contadorIgual++;
            }
        }
        
            System.out.println("Numero de Elementos Inferiores a la media " + contadorInferior);
            System.out.println("Numero de Elementos iguales a la media " + contadorIgual);
            System.out.println("Numero de Elementos superiores a la media " + contadorSuperior);
    }

    public static int[] generarRandom (){
        Random aleatorio = new Random();
        int[] numeros = new int[15];

        for (int i = 0; i < numeros.length; i++) {
           //genera numero aleatorio
            numeros[i] = aleatorio.nextInt(21) + 10;
        }
        return numeros;
    }

    static int sacarMedia(int[] vectoresGenerados) {
        int suma = 0;
        for (int i = 0; i < vectoresGenerados.length;i++){
            suma += vectoresGenerados[i];
        }
        return suma /vectoresGenerados.length;
    }
}
