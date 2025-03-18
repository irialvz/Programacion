/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.ejercicios03.ejercicios3x05;

import java.util.Scanner;

/**
 *
 * @author iriia
 */
public class PruebaFecha {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Año?");
        int año = teclado.nextInt();
        System.out.println("Mes?");
        int mes = teclado.nextInt();
        System.out.println("Dia?");
        int dia = teclado.nextInt();
        
        Fecha f1 = new Fecha(dia,mes,año);
        f1.esCorrecta(dia, mes, año);
        if (f1.esCorrecta(dia, mes, año)){
            System.out.println(f1.toString());
        }
        
    }
    
}
