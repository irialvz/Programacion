/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
public class PruebaEjer4 {

    public static void main(String[] args) {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        final int limite = 5;
        int numerador = 0, denominador = 0,resultado;
        int numIntentos = 0;

        for (int i = 0; i < limite; i++) {
            try {

                System.out.print("Numerador " + i + "? ");
                numerador = Integer.parseInt(teclado.readLine());
                if (numerador == 0 || numerador < 0){
                    throw new ArithmeticException();
                }
                System.out.print("Denominador" + i + "? ");
                denominador = Integer.parseInt(teclado.readLine());;
                if (denominador == 0 || denominador < 0){
                    throw new ArithmeticException();
                }
                resultado = numerador / denominador;
                System.out.println("----------- El resultado es de " + resultado);
            } catch (ArithmeticException ae) {
                System.out.println("Division invalida,intentalo de nuevo");
                i--;
                numIntentos++;
            } catch (IOException ex) {
                System.out.println("Error entrada/salida");
            }
        }

        System.out.println("El numero de intentos fallidos es de " + numIntentos);
    }
}
