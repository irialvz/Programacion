/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja6.ejer4;

import ejercicios.UNIDAD7.hoja6.ejer4.excepciones.ejemplarExcepcion;
import ejercicios.UNIDAD7.hoja6.ejer4.excepciones.libroExcepcion;
import ejercicios.UNIDAD7.hoja6.ejer4.excepciones.multimediaExcepcion;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iriia
 */
public class PruebaEjer4 {

    public static int menu() {
        Scanner teclado = new Scanner(System.in);
        int resultado;
        System.out.println("(1) Mostrar listado");
        System.out.println("(2) Prestar ejemplar");
        System.out.println("(3) Fin");
        System.out.println("Opcion? ");
        resultado = teclado.nextInt();
        return resultado;
    }

    public static void main(String[] args) throws ejemplarExcepcion {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        
        try {
            Ejemplar.listadoEjemplar.add(new Libro(01, "Don Quijote", "Edelvives", 400));
        } catch (libroExcepcion ex) {
            System.out.println(ex.getMessage());
        }
        try {
            Ejemplar.listadoEjemplar.add(new Multimedia(01, "Pelicula Rio2", "dvd"));
        } catch (multimediaExcepcion ex) {
            System.out.println(ex.getMessage());
        }
        try {
            Ejemplar.listadoEjemplar.add(new Libro(02, "Ataque a los titanes 1", "Norma Editorial", 50));
        } catch (libroExcepcion ex) {
            System.out.println(ex.getMessage());
        }
        try {
            Ejemplar.listadoEjemplar.add(new Multimedia(02, "Aqui no hay quien viva", "video"));
        } catch (multimediaExcepcion ex) {
            System.out.println(ex.getMessage());
        }
        try {
            Ejemplar.listadoEjemplar.add(new Libro(03, "Lalaland", "Papapapa", 300));
        } catch (libroExcepcion ex) {
            System.out.println(ex.getMessage());
        }

        do {
            opcion = menu();
            switch (opcion) {
                case 3:
                    System.out.println("Saliendo....");
                    break;
                case 1: //SACAR LISTADO
                    try {
                        Ejemplar.listadoEjemplar();
                    } catch (ejemplarExcepcion ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 2: //PRESTAR EJEMPLAR
                    try {
                        System.out.println("Codigo ejemplar a prestar?");
                        int codigoPrestar = teclado.nextInt();

                        for (int i = 0; i < Ejemplar.listadoEjemplar.size(); i++) {
                            Ejemplar e = Ejemplar.listadoEjemplar.get(i);
                            if (Ejemplar.listadoEjemplar.get(i).codigo == codigoPrestar && !Ejemplar.listadoEjemplar.get(i).isPrestado()) {
                                if (e.prestar()) {
                                    System.out.println("Prestado del ejemplar "+ Ejemplar.listadoEjemplar.get(i).getTitulo()+" exitoso");
                                } else {
                                    throw new ejemplarExcepcion(ejemplarExcepcion.PRESTADO_EXCEPCION);
                                }
                            }
                        }
                    } catch (ejemplarExcepcion ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }

        } while (opcion != 3);

    }
}
