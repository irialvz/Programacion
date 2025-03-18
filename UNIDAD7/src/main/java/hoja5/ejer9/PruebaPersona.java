/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja5.ejer9;

import static ejercicios.UNIDAD7.hoja5.ejer9.Persona.validarCodigoPostal;
import static ejercicios.UNIDAD7.hoja5.ejer9.Persona.validarDni;
import ejercicios.UNIDAD7.hoja5.ejer9.excepciones.ciudadExcepcion;
import ejercicios.UNIDAD7.hoja5.ejer9.excepciones.codPostalExcepcion;
import ejercicios.UNIDAD7.hoja5.ejer9.excepciones.docIdentidadExcepcion;
import ejercicios.UNIDAD7.hoja5.ejer9.excepciones.fechaExcepcion;
import ejercicios.UNIDAD7.hoja5.ejer9.excepciones.nombreExcepcion;
import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class PruebaPersona {

    public static void main(String[] args) throws ciudadExcepcion, codPostalExcepcion, docIdentidadExcepcion, fechaExcepcion, nombreExcepcion {
        Scanner teclado = new Scanner(System.in);
        String nombre = "", ciudad = "", codigoPostal = "", documentoIdentidad = "";
        int dia = 0, mes = 0, anyo = 0, contadorFallos = 0;
        Fecha fecha;
        boolean correcto = false;

        while (!correcto && contadorFallos <= 3) {
            try {
                System.out.print("Nombre? ");
                nombre = teclado.nextLine();
                if (nombre.isEmpty()) {
                    throw new nombreExcepcion("El nombre no puede estar vacio");
                } else if (nombre.length() < 0 || nombre.length() > 25) {
                    throw new nombreExcepcion(nombreExcepcion.ERROR_CARACTERES);
                }
                break;
            } catch (nombreExcepcion e) {
                System.out.println(e.getMessage());
                correcto = false;
                contadorFallos++;
                System.out.println("Contador de fallos " + contadorFallos);
            }
        }
        while (!correcto && contadorFallos <= 3) {
            try {
                System.out.print("Ciudad? ");
                ciudad = teclado.nextLine();
                if (ciudad.isEmpty()) {
                    throw new ciudadExcepcion("La ciudad no puede estar vacia");
                } else if (ciudad.length() < 0 || ciudad.length() > 25) {
                    throw new ciudadExcepcion(ciudadExcepcion.ERROR_CARACTERES);
                }
                break;
            } catch (ciudadExcepcion e) {
                System.out.println(e.getMessage());
                correcto = false;
                contadorFallos++;
                System.out.println("Contador de fallos " + contadorFallos);
            }
        }
        while (!correcto && contadorFallos <= 3) {
            try {
                System.out.print("Codigo postal? ");
                codigoPostal = teclado.nextLine();

                if (codigoPostal.isEmpty()) {
                    throw new codPostalExcepcion("El codigo postal no puede estar vacio");
                } else if (codigoPostal.length() < 0 || codigoPostal.length() > 25) {
                    throw new codPostalExcepcion(codPostalExcepcion.ERROR_DIGITOS);
                } else if (!validarCodigoPostal(codigoPostal)) {
                    throw new codPostalExcepcion("El codigo postal no es valido");
                }
                break;
            } catch (codPostalExcepcion e) {
                System.out.println(e.getMessage());
                correcto = false;
                contadorFallos++;
                System.out.println("Contador de fallos " + contadorFallos);
            }
        }
        while (!correcto && contadorFallos <= 3) {
            try {
                System.out.print("Numero de documento de identidad? ");
                documentoIdentidad = teclado.nextLine();

                if (documentoIdentidad.isEmpty()) {
                    throw new docIdentidadExcepcion("El documento de identidad no puede estar vacio");
                } else if (documentoIdentidad.length() < 0 || documentoIdentidad.length() > 25) {
                    throw new docIdentidadExcepcion(docIdentidadExcepcion.ERROR_VALIDACION);
                } else if (!validarDni(documentoIdentidad)) {
                    throw new docIdentidadExcepcion("El documento de identidad no es valido");
                }
                break;
            } catch (docIdentidadExcepcion e) {
                System.out.println(e.getMessage());
                correcto = false;
                contadorFallos++;
                System.out.println("Contador de fallos " + contadorFallos);
            }
        }
        while (!correcto && contadorFallos <= 3) {
            try {
                System.out.println("INTRODUCE FECHA NACIMIENTO");
                System.out.print("Dia de nacimiento? ");
                dia = teclado.nextInt();

                if (dia < 0 || dia > 31) {
                    throw new fechaExcepcion("El dia debe estar en un rango de 1 a 31");
                }
                break;
            } catch (fechaExcepcion e) {
                System.out.println(e.getMessage());
                correcto = false;
                contadorFallos++;
                System.out.println("Contador de fallos " + contadorFallos);
            }
        }
        while (!correcto) {
            try {
                System.out.print("Mes de nacimiento? ");
                mes = teclado.nextInt();

                if (mes < 1 || mes > 31) {
                    throw new fechaExcepcion("El mes debe estar en un rango de 1 a 31");
                }
                break;
            } catch (fechaExcepcion e) {
                System.out.println(e.getMessage());
                correcto = false;
                contadorFallos++;
                System.out.println("Contador de fallos " + contadorFallos);
            }
        }
        while (!correcto && contadorFallos <= 3) {
            try {
                System.out.print("Año de nacimiento? ");
                anyo = teclado.nextInt();

                if (anyo < 1980 || anyo > 2025) {
                    throw new fechaExcepcion("El año debe estar en un rango de 1980 a 2025");
                }
                break;
            } catch (fechaExcepcion e) {
                System.out.println(e.getMessage());
                correcto = false;
                contadorFallos++;
                System.out.println("Contador de fallos " + contadorFallos);
            }
        }

        try {
            fecha = new Fecha(dia, mes, anyo);
        } catch (fechaExcepcion e) {
            System.out.println("Fecha invalida: " + e.getMessage());
        }

        Persona prueba = new Persona(nombre, ciudad, codigoPostal, documentoIdentidad, dia, mes, anyo);
        System.out.println(prueba.toString());
        while (!correcto && contadorFallos <= 3) {
            try {
                System.out.println("Cambia la fecha de nacimiento, por favor");
                System.out.print("Dia de nacimiento? ");
                dia = teclado.nextInt();

                if (dia < 0 || dia > 31) {
                    throw new fechaExcepcion("El dia debe estar en un rango de 1 a 31");
                }
                System.out.print("Mes de nacimiento? ");
                mes = teclado.nextInt();

                if (mes < 1 || mes > 31) {
                    throw new fechaExcepcion("El mes debe estar en un rango de 1 a 31");
                }
                System.out.print("Año de nacimiento? ");
                anyo = teclado.nextInt();

                if (anyo < 1980 || anyo > 2025) {
                    throw new fechaExcepcion("El año debe estar en un rango de 1980 a 2025");
                }
                break;
            } catch (fechaExcepcion e) {
                System.out.println(e.getMessage());
                correcto = false;
                contadorFallos++;
                System.out.println("Contador de fallos " + contadorFallos);
            }
        }

        prueba = new Persona(nombre, ciudad, codigoPostal, documentoIdentidad, dia, mes, anyo);
        System.out.println("Nueva prueba " + prueba.toString());
    }
}
