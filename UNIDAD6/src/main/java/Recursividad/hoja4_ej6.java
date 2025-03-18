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
public class hoja4_ej6 {
    public static void main(String[] args) {
        //int origen,auxiliar,destino;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce la cantidad de discos de la torre: ");
        int discos = teclado.nextInt();
        
        hanoi(discos,"origen","auxiliar","destino");
    }
    public static void hanoi(int discos,String o,String a,String d){
        if (discos == 1){
            System.out.println("Mueve un disco de" + o + " a " + d); 
        } else {
            hanoi(discos-1,o,d,a);
            hanoi(1,o,a,d);
            hanoi(discos-1,o,a,d);
        }
    }
}
