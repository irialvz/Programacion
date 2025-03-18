/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.Recursividad;

import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class hoja4_ej5 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe un numero");
        int fibonacci = teclado.nextInt();
        
        System.out.println("Fibonacci " + fibonacci + " = " + funcionFibonacci(fibonacci));
    }
    public static int funcionFibonacci(int fibonacci){
        //Pre: si el numero introducido es 0 o 1, el resultado siempre será 1
        if (fibonacci == 0 || fibonacci == 1){
            return 1;
        } else {
            return funcionFibonacci((fibonacci - 1)) + funcionFibonacci((fibonacci -2));
        }
        
    }
    
}
