/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.ejercicios03.ejercicio3CuentaCorriente;

import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class PruebaCuentaCorriente {

    public static int escribirMenu() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("1) Ingresar en la cuenta 001");
        System.out.println("2) Ingresar en la cuenta 002");
        System.out.println("3) Retirar de la cuenta 001");
        System.out.println("4) Retirar de la cuenta 002");
        System.out.println("5) Visualizar ambas cuentas");
        System.out.println("6) Fin");
        System.out.println("Opcion:");
        int opcion = teclado.nextInt();
        return opcion;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        CuentaCorriente cuenta1 = new CuentaCorriente("78945AB");
        CuentaCorriente cuenta2 = new CuentaCorriente("45661PQ");
        int opcion;
        /// para el examen: SACAR A UNA FUNCION APARTE EL MENU
        // USAR DO Y SWITCH EN VEZ DE IF
        do {
            opcion = escribirMenu();
            double ingreso, retirada;

            switch (opcion) {
                case 6:
                    break;
                case 1:
                    System.out.println("Ingreso de...?");
                    ingreso = teclado.nextDouble();
                    cuenta1.ingresaEfectivo(ingreso);
                    System.out.println(cuenta1.toString());
                    break;
                case 2:
                    System.out.println("Ingreso de...?");
                    ingreso = teclado.nextDouble();
                    cuenta2.ingresaEfectivo(ingreso);
                    System.out.println(cuenta2.toString());
                    break;
                case 3:
                    System.out.println("¿Cuantia de retirada?");
                    retirada = teclado.nextDouble();
                    cuenta1.retiraEfectivo(retirada);
                    System.out.println(cuenta1.toString());
                    break;
                case 4:
                    System.out.println("¿Cuantia de retirada?");
                    retirada = teclado.nextDouble();
                    cuenta2.retiraEfectivo(retirada);
                    System.out.println(cuenta2.toString());
                    break;
                case 5:
                    System.out.println("MOSTRANDO CUENTAS...");
                    System.out.println(cuenta1.toString());
                    System.out.println(cuenta2.toString());
            }
        } while (opcion != 6);
    }
}
