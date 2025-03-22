/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Arrays;
import java.util.Random;

/**
 * Generar un vector con 100 números aleatorios entre 1000 y 9999 y escribir en
 * consola en orden descendente los números capicúas del vector.
 *kljoljooih
 * @author iriia
 */
public class Ejercicioclase3 {

    public static int[] generarAleatorios(int longitud, int maximo, int minimo) {
        Random aleatorio = new Random();
        int[] vector = new int[longitud];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = aleatorio.nextInt(maximo - minimo + 1) + minimo;
        }
        return vector;
    }

    // de mas grande a mas pequeño
    public static void ordenDescendente(int[] vector) {
        int auxiliar;
        for (int i = 0; i < vector.length; i++) {
            for (int j = i + 1; j < vector.length; j++) {
                if (vector[i] < vector[j]) { //si el vector en la posicion de j es mayor que en la posicion i
                    auxiliar = vector[j];
                    vector[j] = vector[i];
                    vector[i] = auxiliar;
                }
            }
        }
    }

    public static boolean esCapicua(int numero) {
        int original = numero;
        int residuo, invertido = 0;
        while (numero != 0) {
            residuo = numero % 10;
            invertido = (invertido * 10) + residuo;
            numero = numero / 10; //numero valdrá el siguiente cociente
        }
        return original == invertido;
    }

    public static void main(String[] args) {
        final int longitud = 100, minimo = 1000, maximo = 9999;
        int[] numeros = generarAleatorios(longitud, maximo, minimo);

        int capicuas[] = new int[longitud];
        int contador = 0;

        for (int i = 0; i < numeros.length; i++) {
            if (esCapicua(numeros[i])) {
                capicuas[contador] = numeros[i];
                contador++; //el contador de capicuas se incrementa para que el siguiente numero a introducir este en el siguiente array
            }
        }
        int[] capicuasFinales = new int[contador]; //redimensiona array

        for (int i = 0; i < contador; i++) {
            capicuasFinales[i] = capicuas[i];
        }

        ordenDescendente(capicuasFinales);

        System.out.println("VECTOR: ");
        System.out.println(Arrays.toString(numeros));
        
        System.out.println("VECTORES ORDENADOS DESCENDENTEMENTE");
        for (int i = 0; i < capicuasFinales.length; i++) {
            System.out.print(capicuasFinales[i] + " ");
        }
    }
}
