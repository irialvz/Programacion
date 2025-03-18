/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja7.ejer8;

import ejercicios.UNIDAD7.hoja7.ejer8.excepciones.nombreExcepcion;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
public class pruebaContacto {

    public static int menu() {
        Scanner teclado = new Scanner(System.in);
        int resultado;
        System.out.println("(1) Borrar todos los contactos que no tienen teléfono y mostrar de nuevo la lista.");
        System.out.println("(2) Borrar todos los contactos que no tienen email y mostrar de nuevo la lista.");
        System.out.println("(3) Mostrar lista");
        System.out.println("(4) Fin");
        System.out.println("Opcion? ");
        resultado = teclado.nextInt();
        return resultado;
    }

    public static void main(String[] args) {
        try {
            Contacto prueba1 = new Contacto("Pepe", 680554776, "pepe@correo.com");
            Contacto prueba2 = new Contacto("iria", null, "iria@correo.com");
            Contacto prueba3 = new Contacto("Luis", null, null);
            Contacto prueba4 = new Contacto("Marta", 665287528, "marta@correo.com");

            Contacto.guardarLista(prueba1);
            Contacto.guardarLista(prueba2);
            Contacto.guardarLista(prueba3);
            Contacto.guardarLista(prueba4);
            System.out.println(Contacto.mostrarLista());
        } catch (nombreExcepcion ex) {
            System.out.println(ex.getMessage());
        }
        int Opcion;
        do {
            Opcion = menu();
            switch (Opcion) {
                case 1: //BORRAR CONTACTO CON TELEFONO NULL
                    Contacto.eliminarContactoTelefono();
                    System.out.println(Contacto.mostrarLista());
                    break;
                case 2:
                    Contacto.eliminarContactoEmail();
                    System.out.println(Contacto.mostrarLista());
                case 3:
                    System.out.println(Contacto.mostrarLista());
                case 4:
                    System.out.println("Saliendo...");
                    break;
            }

        } while (Opcion != 4);

    }
}
