/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja6.ejer2;

import static ejercicios.UNIDAD7.hoja6.ejer2.Cooperante.validarDni;
import ejercicios.UNIDAD7.hoja6.ejer2.excepciones.caracteresExcepcion;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iriia
 */
public class PruebaEjer2 {

    public static int menu() {
        Scanner teclado = new Scanner(System.in);
        int resultado;
        System.out.println("(1) Alta Asalariado");
        System.out.println("(2) Alta Voluntario");
        System.out.println("(3) Listado Asalariados");
        System.out.println("(4) Listado Cooperante");
        System.out.println("(5) Listado Voluntarios");
        System.out.println("(6) Fin");
        System.out.println("Opcion? ");
        resultado = teclado.nextInt();
        //teclado.nextLine();
        return resultado;
    }

    public static void main(String[] args) throws caracteresExcepcion {
        Scanner teclado = new Scanner(System.in);
        String nombre = "",
                dni = "",
                pais = "",
                ong = "";
        double sueldo = 0.0;
        int opcion;
        do {
            opcion = menu();
            switch (opcion) {
                case 6:
                    System.out.println("Saliendo....");
                    break;
                case 1: //DAR DE ALTA UN ASALARIADO

                    try {
                        System.out.println("Nombre? ");
                        nombre = teclado.nextLine();
                        if (nombre.isBlank()) {
                            throw new caracteresExcepcion("El nombre no puede estar vacio");
                        }
                    } catch (caracteresExcepcion ce) {
                        System.out.println(ce.getMessage());
                    }
                    try {
                        System.out.println("Dni? ");
                        dni = teclado.nextLine();
                        if (!validarDni(dni)) {
                            throw new caracteresExcepcion("El DNI no es valido");
                        }
                    } catch (caracteresExcepcion ce) {
                        System.out.println(ce.getMessage());
                    }
                    try {
                        System.out.println("Pais? ");
                        pais = teclado.nextLine();
                        if (pais.isBlank()) {
                            throw new caracteresExcepcion("El pais no puede estar vacio");
                        }
                    } catch (caracteresExcepcion ce) {
                        System.out.println(ce.getMessage());
                    }
                    try {
                        System.out.println("Sueldo? ");
                        sueldo = teclado.nextDouble();
                        teclado.nextLine();

                        if (sueldo <= 0) {
                            throw new caracteresExcepcion("El sueldo no puede ser menor o igual a cero");
                        }
                    } catch (caracteresExcepcion ce) {
                        System.out.println(ce.getMessage());
                    }

                    Asalariado nuevoAsalariado = new Asalariado(nombre, dni, pais, sueldo);
                    Personal.listadoPersonal.add(nuevoAsalariado);
                    break;

                case 2: //DAR DE ALTA UN ADOSADO
                    try {
                        System.out.println("Nombre? ");
                        nombre = teclado.nextLine();
                        if (nombre.isBlank()) {
                            throw new caracteresExcepcion("El nombre no puede estar vacio");
                        }
                    } catch (caracteresExcepcion ce) {
                        System.out.println(ce.getMessage());
                    }
                    try {
                        System.out.println("Dni? ");
                        dni = teclado.nextLine();
                        if (!validarDni(dni)) {
                            throw new caracteresExcepcion("El DNI no es valido");
                        }
                    } catch (caracteresExcepcion ce) {
                        System.out.println(ce.getMessage());
                    }
                    try {
                        System.out.println("Pais? ");
                        pais = teclado.nextLine();
                        if (pais.isBlank()) {
                            throw new caracteresExcepcion("El pais no puede estar vacio");
                        }
                    } catch (caracteresExcepcion ce) {
                        System.out.println(ce.getMessage());
                    }
                    try {
                        System.out.println("Ong? ");
                        ong = teclado.nextLine();
                        if (ong.isEmpty()) {
                            throw new caracteresExcepcion("La ong no puede estar vacia");
                        }
                    } catch (caracteresExcepcion ce) {
                        System.out.println(ce.getMessage());
                    }

                    Voluntario nuevoVoluntario = new Voluntario(nombre, dni, pais, ong);
                    Personal.listadoPersonal.add(nuevoVoluntario);
                    break;
                case 3:                         //LISTADO DE ASALARIADOS
                    try {
                        Personal.listadoAsalariados();
                    } catch (caracteresExcepcion ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 4://LSITADO VIVIENDAS
                    try {
                        Personal.listadoCooperante();
                    } catch (caracteresExcepcion ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 5://LSITADO VOLUNTARIO
                    try {
                        Personal.listadoVoluntario();
                    } catch (caracteresExcepcion ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }
        } while (opcion != 6);

    }
}
