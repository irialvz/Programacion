/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja7.ejer2;

import ejercicios.UNIDAD7.hoja7.ejer2.excepciones.animalExcepcion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
public class PruebaEjer2 {

    private static ArrayList<Animal> listadoAnimales = new ArrayList<Animal>();
    private static ListIterator<Animal> iterador;

    public static int menu() {
        Scanner teclado = new Scanner(System.in);
        int resultado;
        System.out.println("(1) Mostrar listado");
        System.out.println("(2) Eliminar Animal");
        System.out.println("(3) Siguiente animal coleccion");
        System.out.println("(4) Anterior animal coleccion");
        System.out.println("(0) Fin");
        System.out.println("Opcion? ");
        resultado = teclado.nextInt();
        return resultado;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        String nombreEliminar = "";

        // CREACION DE LOS OBJETOS
        try {
            listadoAnimales.add(new Perro("Bob", "Pastor de aguas"));
            listadoAnimales.add(new Perro("Rita", "Pastor de aguas"));
            listadoAnimales.add(new Perro("Judas", "Pastor Aleman"));
            listadoAnimales.add(new Gato("Michu", "Blanco"));
            listadoAnimales.add(new Gato("Rati", "Gris"));
            listadoAnimales.add(new Gato("Yato", "Gris Oscuro"));
            listadoAnimales.add(new Caballo("Pepe", "Marron"));
            listadoAnimales.add(new Caballo("Pepo", "Blanco"));
            listadoAnimales.add(new Caballo("Pepa", "Negro"));
        } catch (animalExcepcion ex) {
            System.out.println(ex.getMessage());
        }

        iterador = listadoAnimales.listIterator();
        do {
            opcion = menu();
            switch (opcion) {
                case 0:
                    System.out.println("Saliendo....");
                    break;
                case 1: //SACAR LISTADO 
                    try {
                        mostrarListado();
                    } catch (animalExcepcion ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 2: //PRESTAR EJEMPLAR
                    try {
                        System.out.println("Nombre del animal a eliminar?");
                        nombreEliminar = teclado.nextLine();

                        eliminarAnimalListado(nombreEliminar);
                        mostrarListado();
                        break;
                    } catch (animalExcepcion ex) {
                        System.out.println(ex.getMessage());
                    }
                case 3: //PRESTAR EJEMPLAR
                    try {
                        mostrarSiguiente();
                        break;
                    } catch (animalExcepcion ex) {
                        System.out.println(ex.getMessage());
                    }
                case 4: //PRESTAR EJEMPLAR
                    try {
                        mostrarAnterior();
                        break;
                    } catch (animalExcepcion ex) {
                        System.out.println(ex.getMessage());
                    }

            }
        } while (opcion != 0);
    }

    public static void mostrarAnterior() throws animalExcepcion {
        if (iterador.hasPrevious()) {
            System.out.println(iterador.previous());
        } else {
            throw new animalExcepcion("No hay animal anterior");
        }

    }

    public static void mostrarSiguiente() throws animalExcepcion {
        if (iterador.hasNext()) {
            System.out.println(iterador.next());
        } else {
            throw new animalExcepcion("No hay animal siguiente");
        }

    }

    public static void mostrarListado() throws animalExcepcion {
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

    public static void eliminarAnimalListado(String nombreEliminar) throws animalExcepcion {
        if (listadoAnimales.isEmpty()) {
            throw new animalExcepcion("La lista de animales esta vacia");
        }
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
