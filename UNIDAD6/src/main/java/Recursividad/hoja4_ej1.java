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
public class hoja4_ej1 {
    public static void main(String[] args) {
        int numero;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un numero;");
        numero = teclado.nextInt();
        
        System.out.println("El numero factorial de " + numero + " es " + factorial(numero));
    }
    public static int factorial (int num){
        // Pre: el numero debe ser mayor que 0
        if (num == 0 || num == 1){
            return 1;
        } else {
            return num * factorial(num -1);
            // el programa se ira llamando asi mismo hasta que llegue a 1 e ira calculandose hasta 
            //llegar al num introducido
        }
    }
}
