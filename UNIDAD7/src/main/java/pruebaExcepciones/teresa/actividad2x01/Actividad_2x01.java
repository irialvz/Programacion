/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.pruebaExcepciones.teresa.actividad2x01;

import java.util.Scanner;

/**
 *
 * @author iriia
 */
public class Actividad_2x01 {

    public static int menu() {
        Scanner teclado = new Scanner(System.in);
        int resultado;
        System.out.println("(0) Salir del programa");
        System.out.println("(1) Insertar un usuario en la clientela");
        System.out.println("(2) Consultar todos los usuarios de la clientela");
        System.out.println("(3) Eliminar un usuario,por posicion,de la clientela");
        System.out.println("Opcion? ");
        resultado = teclado.nextInt();
        return resultado;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        do {
            opcion = menu();
            switch (opcion) {
                case 0:
                    System.out.println("Saliendo....");
                    break;
                case 1:
                    /*Insertar un usuario en la clientela.*/
                    System.out.print("Nombre: ");
                    String nombre = teclado.nextLine(); // Leer el nombre

                    System.out.print("Contraseña: ");
                    String contraseña = teclado.nextLine(); // Leer la contraseña

                    System.out.print("Número de puntos: ");
                    int numPuntos = teclado.nextInt(); // Leer el número de puntos
                    teclado.nextLine(); // Limpiar el buffer de entrada

                    try {
                        Usuario usuarioInsertar = new Usuario(nombre, contraseña, numPuntos);
                      //  Clientela.agregar(usuarioInsertar); // Agregar el usuario a la lista
                        System.out.println("Usuario insertado con éxito.");
                    } catch (ExcepcionUsuario eu) {
                        System.out.println(eu.getClass());
                        System.out.println(eu.getMessage());
                    } catch (ExcepcionClientela ec) {
                        System.out.println(ec.getClass());
                        System.out.println(ec.getMessage());
                    }
                    break;

                case 2:/*Consultar todos los usuarios de la clientela*/
                    try {
                       // System.out.println(Clientela);
                    } catch (ExcepcionClientela ec) {
                        System.out.println(ec.getMessage());
                    }
                    break;

                case 3:/*Eliminar un usuario,por posicion,de la clientela
                    System.out.println("Posicion: ");
                    int posicion = teclado.nextInt();
                    try {
                        Clientela
                    }*/
                    


            }
        } while (opcion != 0);

    }
}
