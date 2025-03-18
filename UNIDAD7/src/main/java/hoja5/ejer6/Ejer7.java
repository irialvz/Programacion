/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja5.ejer6;

import static ejercicios.UNIDAD7.hoja5.ejer6.Coche.validarMatricula;
import ejercicios.UNIDAD7.hoja5.ejer6.excepciones.error_km;
import ejercicios.UNIDAD7.hoja5.ejer6.excepciones.error_matricula;
import ejercicios.UNIDAD7.hoja5.ejer6.excepciones.error_modelo;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
public class Ejer7 {

    public static int menu() {
        Scanner teclado = new Scanner(System.in);
        int resultado;
        System.out.println("(1) Dar de alta");
        System.out.println("(2) Dar de baja");
        System.out.println("(3) Consultar datos");
        System.out.println("(4) Modificar datos");
        System.out.println("(5) Fin");
        System.out.println("Opcion? ");
        resultado = teclado.nextInt();
        return resultado;
    }

    public static void main(String[] args) throws error_modelo, error_km, error_matricula {
        Scanner teclado = new Scanner(System.in);
        final int maxCoches = 100;
        Coche arrayCoches[] = new Coche[maxCoches];
        String matricula, modelo;
        long kilometros;

        int Opcion, cantidadCoches = 0;
        do {
            Opcion = menu();
            switch (Opcion) {
                case 5:
                    System.out.println("Saliendo..");
                    break;
                case 1: {
                    modelo = "";
                    matricula = "";
                    kilometros = 0;

                    // Validar modelo
                    while (true) {
                        try {
                            System.out.print("Modelo? ");
                            modelo = teclado.nextLine();
                            if (modelo.isEmpty()) {
                                throw new error_modelo("El modelo no puede estar vacío.");
                            } else if (modelo.length() < 5 || modelo.length() >30){
                                throw new error_modelo(error_modelo.ERROR_MODELO);
                            }
                            break; // Salir del bucle si el modelo es válido
                        } catch (error_modelo em) {
                            System.out.println(em.getMessage()); // Mostrar mensaje de error
                        }
                    }

                    // Validar matrícula usando el método existente
                    while (true) {
                        try {
                            System.out.print("Matrícula? ");
                            matricula = teclado.nextLine();
                            if (!validarMatricula(matricula)) {
                                throw new error_matricula(error_matricula.ERROR_MATRICULA);
                            } // Llama al método que valida la matrícula

                            break; // Salir del bucle si la matrícula es válida
                        } catch (error_matricula em) {
                            System.out.println(em.getMessage()); // Mostrar mensaje de error
                        }
                    }

                    // Validar kilómetros
                    while (true) {
                        try {
                            System.out.print("Kilómetros? ");
                            kilometros = Long.parseLong(teclado.nextLine()); // Convertir a número
                            if (kilometros < 0) {
                                throw new error_km("Los kilómetros no pueden ser negativos.");
                            }
                            break; // Salir del bucle si los kilómetros son válidos
                        } catch (error_km ek) {
                            System.out.println(ek.getMessage()); // Mostrar mensaje de error
                        }
                    }

                    // Si todos los datos son válidos, registrar el coche
                    arrayCoches[cantidadCoches] = new Coche(modelo, matricula, kilometros);
                    cantidadCoches++;
                    System.out.println("Se ha registrado el coche con éxito.");
                }
                break;

                case 2: {
                    try {
                        System.out.print("Matricula para dar de baja? ");
                        String matriculaBaja = teclado.nextLine();
                        boolean matriculaEncontrada = false;

                        for (int i = 0; i < cantidadCoches; i++) {
                            if (arrayCoches[i].getMatricula().equalsIgnoreCase(matriculaBaja)) {
                                matriculaEncontrada = true;
                                arrayCoches[i] = null;
                                cantidadCoches--;
                                System.out.println("Coche dado de baja correctamente");
                                break;
                            } else if (!matriculaEncontrada) {
                                throw new error_matricula(error_matricula.ERROR_NOTFOUND);
                            } else if (!validarMatricula(matriculaBaja)) {
                                throw new error_matricula(error_matricula.ERROR_MATRICULA);
                            }
                        }
                    } catch (error_matricula em) {
                        System.out.println(em.getMessage());
                    }

                }

                break;
                case 3:
                    try {
                        System.out.print("Matricula a consultar? ");
                        String matriculaBuscar = teclado.nextLine();
                        boolean matriculaEncontrada = false;
                        for (int i = 0; i < cantidadCoches; i++) {
                            if (arrayCoches[i].getMatricula().equalsIgnoreCase(matriculaBuscar)) {
                                matriculaEncontrada = true;
                                System.out.println(arrayCoches[i].toString());
                            } else if (!matriculaEncontrada) {
                                throw new error_matricula(error_matricula.ERROR_NOTFOUND);
                            } else if (!validarMatricula(matriculaBuscar)) {
                                throw new error_matricula(error_matricula.ERROR_MATRICULA);
                            }
                        }

                    } catch (error_matricula em) {
                        System.out.println(em.getMessage());
                    }

                    break;
                case 4:
                    try {
                        System.out.println("Matricula a modificar");
                        String matriculaModificar = teclado.nextLine();
                        boolean matriculaEncontrada = false;

                        for (int i = 0; i < cantidadCoches; i++) {
                            if (arrayCoches[i].getMatricula().equalsIgnoreCase(matriculaModificar)) {
                                matriculaEncontrada = true;
                                System.out.println("Nueva matricula?");
                                String nuevaMatricula = teclado.nextLine();
                                arrayCoches[i].setMatricula(nuevaMatricula);
                                System.out.println(arrayCoches[i].getMatricula());
                                System.out.println("Se ha registrado con exito la nueva matricula");
                            } else if (!matriculaEncontrada) {
                                throw new error_matricula(error_matricula.ERROR_NOTFOUND);
                            } else if (!validarMatricula(matriculaModificar)) {
                                throw new error_matricula(error_matricula.ERROR_MATRICULA);
                            }
                        }
                    } catch (error_matricula em) {
                        System.out.println(em.getMessage());
                    }

                    break;
            }

        } while (Opcion
                != 5);

    }

}
