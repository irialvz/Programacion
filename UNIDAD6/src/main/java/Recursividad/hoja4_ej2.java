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
public class hoja4_ej2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce numero A:");
        int numA = teclado.nextInt();
        System.out.println("Introduce numero B");
        int numB = teclado.nextInt();
        
        System.out.println("El maximo comun divisor de los numeros " + numA + " y " + numB + " es " + maxcd(numA,numB));
    }
    public static int maxcd (int numA ,int numB){
        //Pre: cuando el valor de B sea 0, devolvera A
        if (numB == 0){
            return numA;
        }
        return maxcd (numB,numA % numB);
    }
}
