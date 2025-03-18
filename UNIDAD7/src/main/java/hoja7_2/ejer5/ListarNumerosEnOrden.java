/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja7_2.ejer5;

import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author iriia
 */
public class ListarNumerosEnOrden {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int numero;
        TreeSet<Integer> numeros = new TreeSet<>();
        do {
            System.out.println("Numero? (-9999 para salir)");
            numero = teclado.nextInt();
            if (numero != -9999) 
                numeros.add(numero);
        } while (numero != -9999);
        
        System.out.println(numeros);
    }
    
}
