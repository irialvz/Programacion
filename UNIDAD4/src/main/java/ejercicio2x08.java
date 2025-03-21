/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;
//FALTA EL ESPACIO EN BLANCO ENTRE NOMBRE Y APELLIDO
/**
 *
 * @author iriia
 */
public class ejercicio2x08 {


    public static int contarEspacios(String nombreCompleto) {
        char espacio = ' ';
        int contarEspacios = 0;
        for (int i = 0; i < nombreCompleto.length();i++){
            if (nombreCompleto.charAt(i) == espacio){
                contarEspacios++;
            }
    }
    return contarEspacios;
}
    public static String nombreCompleto(int numero) {
        Scanner teclado = new Scanner(System.in);
        String nombreCompleto;
        boolean esValido;

        do {
            System.out.println("Nombre completo " + numero + "? ");
            nombreCompleto = teclado.nextLine();

            boolean espacioInicial = nombreCompleto.startsWith(" ");
            boolean espacioFinal = nombreCompleto.endsWith(" ");

            esValido = !espacioInicial && !espacioFinal && (contarEspacios(nombreCompleto) == 1);

            if(espacioInicial){
                System.out.println("El nombre completo no debe comenzar con espacio");
            }
            if (espacioFinal){
                System.out.println("El nombre completo no debe acabar con espacio");
            }
        } while (!esValido);
        return nombreCompleto;
    }

    public static void main(String[] args) {
        String nombreCompleto1 = nombreCompleto(1);
        String nombreCompleto2 = nombreCompleto(2);

        int espacio1 = nombreCompleto1.indexOf(" ");
        String nombre1 = nombreCompleto1.substring(0,espacio1);
        String apellido1 = nombreCompleto1.substring(espacio1+1); //+1 para que no se añada el espacio

        int espacio2 = nombreCompleto2.indexOf(" ");
        String nombre2 = nombreCompleto2.substring(0,espacio2);
        String apellido2 = nombreCompleto2.substring(espacio2+1); //+1 para que no se añada el espacio

        System.out.println("NOMBRE INVERTIDOS");
        System.out.println("Nombre invertido 1: " + nombre1 + " " + apellido2);
        System.out.println("Nombre invertido 2: " + nombre2 + " " + apellido1);
    }
}
