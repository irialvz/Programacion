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
public class Ejemplo1 {
    public static void main(String[] args) {
        try {
            int dividendo = 10;
            int divisor = 0;
            
            int cociente = dividendo / divisor;
            
            System.out.println("cociente = " + cociente);
        } catch (ArithmeticException ae){
            System.out.println("Excepcion aritmetica" + ae.getMessage());
            ae.printStackTrace();
        }
    
}
}
