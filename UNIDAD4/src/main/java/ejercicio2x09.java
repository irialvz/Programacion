/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class ejercicio2x09 {

    public static int contarEspacios(String cadena) {
        int contadorEspacio = 0;

        for (int i = 0; i < cadena.length(); i++) {
            char espacio = ' ';
            if (cadena.charAt(i) == espacio) {
                contadorEspacio++;
            }
        }
        return contadorEspacio;
    }

    public static String nombreCompleto() {
        Scanner teclado = new Scanner(System.in);
        String nombreCompleto;
        boolean esValido;
        do {
            System.out.println("Nombre completo?");
            nombreCompleto = teclado.nextLine();

            boolean espacioInicial = nombreCompleto.startsWith(" ");
            boolean espacioFinal = nombreCompleto.endsWith(" ");

            esValido = !espacioInicial && !espacioFinal && (contarEspacios(nombreCompleto) == 2);

            if (espacioInicial) {
                System.out.println("El nombre completo no debe comenzar por un espacio en blanco");
            }
            if (espacioFinal) {
                System.out.println("El nombre completo no debe acabar por un espacio en blanco");
            }
            if (contarEspacios(nombreCompleto) != 2) {
                System.out.println("El nombre completo debe tener 2 espacios en blanco");
            }
        } while (!esValido);
        return nombreCompleto;
    }

    //generado chatgpt
    public static String formatoNombreCompleto(String nombreCompleto) {
        int primerEspacio = nombreCompleto.indexOf(" ");
        int segundoEspacio = nombreCompleto.indexOf(" ", primerEspacio + 1);

        String nombre = nombreCompleto.substring(0, primerEspacio);
        String apellido1 = nombreCompleto.substring(primerEspacio + 1, segundoEspacio);
        String apellido2 = nombreCompleto.substring(segundoEspacio + 1);

        return apellido1 + " " + apellido2 + ", " + nombre;
    }

    public static String inicialesNombreCompleto(String nombreCompleto) {
        String iniciales = "";
        iniciales += Character.toUpperCase(nombreCompleto.charAt(0)); // Inicial del nombre

        int primerEspacio = nombreCompleto.indexOf(" ");
        int segundoEspacio = nombreCompleto.indexOf(" ", primerEspacio + 1);

        iniciales += Character.toUpperCase(nombreCompleto.charAt(primerEspacio + 1)); // Inicial del primer apellido
        iniciales += Character.toUpperCase(nombreCompleto.charAt(segundoEspacio + 1)); // Inicial del segundo apellido

        return iniciales;
    }

    public static void main(String[] args) {
        String cadena = nombreCompleto();
        System.out.println(formatoNombreCompleto(cadena));
        System.out.println(inicialesNombreCompleto(cadena));

    }
}
