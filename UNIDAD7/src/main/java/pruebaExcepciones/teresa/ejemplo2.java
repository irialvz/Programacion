/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.pruebaExcepciones.teresa;

import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class ejemplo2 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int dividendo, divisor, cociente = 0;
        String cadDividendo, cadDivisor;

        boolean error = true;
        int numeroIntentos = 0;

        while (error && numeroIntentos <= 5) {
            try {
                System.out.println("Dividendo?");
                cadDividendo = teclado.nextLine();
                dividendo = Integer.parseInt(cadDividendo); //convertir de caracter a num
                System.out.println("Divisor? ");
                cadDivisor = teclado.nextLine();
                divisor = Integer.parseInt(cadDivisor);

                cociente = dividendo / divisor;
                error = false;
                numeroIntentos++;
            } catch (NumberFormatException nfe) {
                System.out.println("Caracteres no numericos");
                error = true;
                numeroIntentos++;
            } catch (ArithmeticException ae) {
                System.out.println("Error de division por cero");
                error = true;
                numeroIntentos++;
            }
        }
        System.out.println("cociente = " + cociente);
        System.out.println("Numero de intentos " + numeroIntentos);

    }

}
