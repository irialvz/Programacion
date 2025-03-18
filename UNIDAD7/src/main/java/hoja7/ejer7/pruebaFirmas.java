/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja7.ejer7;

import ejercicios.UNIDAD7.hoja7.ejer7.excepciones.dni_excepcion;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iriia
 */
public class pruebaFirmas {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String nombre,apellido,dni;
        do {
            System.out.println("Nombre? ");
             nombre = teclado.nextLine();
            System.out.println("Apellido? ");
             apellido = teclado.nextLine();
            System.out.println("Dni? ");
             dni = teclado.nextLine();
            try {
                Firmas firmas = new Firmas(nombre, apellido, dni);
                firmas.guardarColeccion(nombre, apellido, dni);
                System.out.println(firmas.mostrarColeccion());
            } catch (dni_excepcion ex) {
                System.out.println(ex.getMessage());
            }
        } while (!nombre.isEmpty() || !apellido.isEmpty() || !dni.isEmpty());


    }

}
