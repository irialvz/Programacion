/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja7.ejer1;

import ejercicios.UNIDAD7.hoja7.ejer1.excepciones.animalExcepcion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
public class PruebaEjer1 {

    public static int menu() {
        Scanner teclado = new Scanner(System.in);
        int resultado;
        System.out.println("(1) Mostrar listado");
        System.out.println("(2) Eliminar Animal");
        System.out.println("(3) Fin");
        System.out.println("Opcion? ");
        resultado = teclado.nextInt();
        return resultado;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        String nombreEliminar = "";
        ArrayList<Animal> listadoAnimales = new ArrayList<Animal>();

        // CREACION DE LOS OBJETOS
        try {
            listadoAnimales.add(new Perro("Bob", "Pastor de aguas"));
        } catch (animalExcepcion ex) {
            System.out.println(ex.getMessage());
        }
        try {
            listadoAnimales.add(new Perro("Rita", "Pastor de aguas"));
        } catch (animalExcepcion ex) {
            System.out.println(ex.getMessage());
        }
        try {
            listadoAnimales.add(new Perro("Judas", "Pastor Aleman"));
        } catch (animalExcepcion ex) {
            System.out.println(ex.getMessage());
        }
        try {
            listadoAnimales.add(new Gato("Michu", "Blanco"));
        } catch (animalExcepcion ex) {
            System.out.println(ex.getMessage());
        }
        try {
            listadoAnimales.add(new Gato("Rati", "Gris"));
        } catch (animalExcepcion ex) {
            System.out.println(ex.getMessage());
        }
        try {
            listadoAnimales.add(new Gato("Yato", "Gris Oscuro"));
        } catch (animalExcepcion ex) {
            System.out.println(ex.getMessage());
        }
        try {
            listadoAnimales.add(new Caballo("Pepe", "Marron"));
        } catch (animalExcepcion ex) {
            System.out.println(ex.getMessage());
        }
        try {
            listadoAnimales.add(new Caballo("Pepo", "Blanco"));
        } catch (animalExcepcion ex) {
            System.out.println(ex.getMessage());
        }
        try {
            listadoAnimales.add(new Caballo("Pepa", "Negro"));
        } catch (animalExcepcion ex) {
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
                        mostrarListado(listadoAnimales);
                    } catch (animalExcepcion ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 2: //PRESTAR EJEMPLAR
                    try {
                        System.out.println("Nombre del animal a eliminar?");
                        nombreEliminar = teclado.nextLine();

                        eliminarAnimalListado(listadoAnimales, nombreEliminar);
                        mostrarListado(listadoAnimales);
                        break;
                    } catch (animalExcepcion ex) {
                        System.out.println(ex.getMessage());
                    }

            }
        } while (opcion != 3);
    }

    public static void mostrarListado(ArrayList<Animal> listadoAnimales) throws animalExcepcion {
        if (listadoAnimales.isEmpty()) {
            throw new animalExcepcion("La lista de animales esta vacia");
        }
        for (int i = 0; i < listadoAnimales.size(); i++) {
            Animal an = listadoAnimales.get(i);
            System.out.println("El animal de tipo: " + an.getClass().getSimpleName()
                    + "\n\t Nombre: " + an.nombre
                    + "\n\t Raza: " + an.raza + an.cuidadoDiario());
            if (an instanceof Parlanchin) {
                System.out.println("\t" + ((Parlanchin) an).habla() + "\n");
            } else {
                System.out.println("\tEl habla no procede\n");
            }
        }
    }

    public static void eliminarAnimalListado(ArrayList<Animal> listadoAnimales, String nombreEliminar) throws animalExcepcion {
        if (listadoAnimales.isEmpty()) {
            throw new animalExcepcion("La lista de animales esta vacia");
        }
        Iterator<Animal> iterador = listadoAnimales.iterator();
        boolean encontrado = false;

        while (iterador.hasNext()) {
            Animal an = iterador.next();
            if (an.nombre.equals(nombreEliminar)) {
                iterador.remove();
                encontrado = true;
                System.out.println("Se ha eliminado correctamente");
                break;
            }
        }
        if (!encontrado) {
            throw new animalExcepcion("No se ha encontrado el animal en la lista");
        }
    }

}
