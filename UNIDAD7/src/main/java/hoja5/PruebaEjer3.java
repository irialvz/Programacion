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
public class PruebaEjer3 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        final int limite = 5;
        int numerador = 0, denominador = 0,resultado;
        int numIntentos = 0;

        for (int i = 0; i < limite; i++) {
            try {

                System.out.print("Numerador " + i + "? ");
                numerador = teclado.nextInt();
                if (numerador == 0 || numerador < 0){
                    throw new ArithmeticException();
                }
                System.out.print("Denominador" + i + "? ");
                denominador = teclado.nextInt();
                if (denominador == 0 || denominador < 0){
                    throw new ArithmeticException();
                }
                resultado = numerador / denominador;
                System.out.println("----------- El resultado es de " + resultado);
            } catch (ArithmeticException ae) {
                System.out.println("Division invalida,intentalo de nuevo");
                i--;
                numIntentos++;
            }
        }

        System.out.println("El numero de intentos fallidos es de " + numIntentos);
    }
}
