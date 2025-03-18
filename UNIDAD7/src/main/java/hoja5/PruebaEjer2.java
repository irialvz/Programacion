/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja5;

import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class PruebaEjer2 {

    static int sacarMedia(int[] vectoresGenerados) {
        int suma = 0;
        for (int i = 0; i < vectoresGenerados.length; i++) {
            suma += vectoresGenerados[i];
        }
        return suma / vectoresGenerados.length;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        final int limite = 5;
        String numeros;
        int[] arrayNum = new int[5];
        int numIntentos = 0;

        for (int i = 0; i < limite; i++) {
            try {
                System.out.print("Numero " + i + "? ");
                numeros = teclado.nextLine();
                arrayNum[i] = Integer.parseInt(numeros);
            } catch (NumberFormatException nfe) {
                System.out.println("Numero no valido, introduce una nueva");
                i--;
                numIntentos++;
            }

        }
        System.out.println("La media de los numeros " + sacarMedia(arrayNum));
        for (int i = 0; i < arrayNum.length;i++){
             if (arrayNum[i] >= sacarMedia(arrayNum)){
                 System.out.println("El numero " + arrayNum[i] + " es mayor o igual a la media de todos los numeros");
             }
        }
        System.out.println("El numero de intentos fallidos es de " + numIntentos);

    }
}
