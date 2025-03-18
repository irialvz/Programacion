/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.HojaPolimorfismoTeresa.act2;

import java.util.Scanner;

/**
 *
 * @author iriia
 */
public class Actividad_2x02 {
    public static int menu() {
        Scanner teclado = new Scanner(System.in);
        int resultado;
        System.out.println("(0) Salir del programa");
        System.out.println("(1) Rellenar el inventario con bebidas generadas de forma aleatoria");
        System.out.println("(2) Consultar todas las bebidas del inventario");
        System.out.println("(3) Consultar los refrescos del inventario");
        System.out.println("(4) Consultar las bebidas fermentadas del inventario");
        System.out.println("(5) Consultar las bebidas destiladas del inventario");
        System.out.println("(6) Consultar las bebidas con precio comprendido entre dos limites");
        System.out.println("(7) Calcular el numero de refrescos gaseosos del inventario");
        System.out.println("Opcion? ");
        resultado = teclado.nextInt();
        return resultado;
    }
    public static void main(String[] args) {
        int Opcion;
        do {
            Opcion = menu();
            switch (Opcion) {
                case 0:
                    System.out.println("Saliendo..");
                    break;
                case 1:

                    break;
                case 2:
                   break;
                case 3:
                   break;
                case 4:
                   break;
                case 5:
          }
        } while (Opcion != 0);
    }
    
}
