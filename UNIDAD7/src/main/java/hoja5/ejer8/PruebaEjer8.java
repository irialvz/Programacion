/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja5.ejer8;

import static ejercicios.UNIDAD7.hoja5.ejer8.Mascota.validarCodigo;
import ejercicios.UNIDAD7.hoja5.ejer8.excepciones.codClienteExcepcion;
import ejercicios.UNIDAD7.hoja5.ejer8.excepciones.edadExcepcion;
import ejercicios.UNIDAD7.hoja5.ejer8.excepciones.especieExcepcion;
import ejercicios.UNIDAD7.hoja5.ejer8.excepciones.nombreExcepcion;
import java.util.Scanner;

/**
 *
 * @author iriia
 */
public class PruebaEjer8 {

    public static int menu() {
        Scanner teclado = new Scanner(System.in);
        int resultado;
        System.out.println("(1) Dar de alta");
        System.out.println("(2) Dar de baja");
        System.out.println("(3) Consultar datos");
        System.out.println("(4) Modificar datos");
        System.out.println("(5) Listado mascotas");
        System.out.println("(6) Listado clientes");
        System.out.println("(7) Fin");
        System.out.println("Opcion? ");
        resultado = teclado.nextInt();
        return resultado;
    }

    public static void main(String[] args) throws nombreExcepcion, codClienteExcepcion, especieExcepcion, edadExcepcion {
        Scanner teclado = new Scanner(System.in);
        final int maxMascotas = 100;
        Mascota arrayMascotas[] = new Mascota[maxMascotas];
        //Mascota arrayClientes[] = new Mascota[maxMascotas];
        String nombre, especie, codCliente;
        int edad;

        int Opcion, cantidadMascotas = 0, cantidadClientes = 0;
        do {
            Opcion = menu();
            switch (Opcion) {
                case 7:
                    System.out.println("Saliendo..");
                    break;
                case 1: {
                    nombre = "";
                    especie = "";
                    edad = 0;

                    // Validar nommbre
                    while (true) {
                        try {
                            System.out.print("Nombre? ");
                            nombre = teclado.nextLine();
                            if (nombre.isEmpty()) {
                                throw new nombreExcepcion("El nombre no puede estar vacío.");
                            } else if (nombre.length() < 5 || nombre.length() > 30) {
                                throw new nombreExcepcion(nombreExcepcion.CARACTERESNOMBRES);
                            }
                            break; // Salir del bucle si el nombre es válido
                        } catch (nombreExcepcion ne) {
                            System.out.println(ne.getMessage()); // Mostrar mensaje de error
                        }
                    }
                    // Validar codCliente
                    while (true) {
                        try {
                            System.out.print("Codigo cliente? ");
                            codCliente = teclado.nextLine();
                            if (codCliente.isEmpty()) {
                                throw new codClienteExcepcion("El codigo de cliente no puede estar vacio");
                            }
                            if (!validarCodigo(codCliente)) {
                                throw new codClienteExcepcion(codClienteExcepcion.ERRORCOD);
                            }
                            break; // Salir del bucle si el nombre es válido
                        } catch (codClienteExcepcion ne) {
                            System.out.println(ne.getMessage()); // Mostrar mensaje de error
                        }
                    }

                    // Validar especie usando el método existente
                    while (true) {
                        try {
                            System.out.print("Especie? ");
                            especie = teclado.nextLine();
                            if (especie.isEmpty()) {
                                throw new nombreExcepcion("La especie no puede estar en vacio");
                            }
                            if (!especie.equalsIgnoreCase("perro") && !especie.equalsIgnoreCase("gato") && !especie.equalsIgnoreCase("pez") && !especie.equalsIgnoreCase("pajaro")) {
                                throw new especieExcepcion(especieExcepcion.ERROR_ESPECIE);
                            }

                            break; // Salir del bucle si la matrícula es válida
                        } catch (especieExcepcion em) {
                            System.out.println(em.getMessage()); // Mostrar mensaje de error
                        }
                    }

                    // Validar edad
                    while (true) {
                        try {
                            System.out.print("Edad? ");
                            edad = teclado.nextInt();
                            if (edad < 0) {
                                throw new edadExcepcion(edadExcepcion.ERROR_EDAD);
                            }
                            break; // Salir del bucle si los kilómetros son válidos
                        } catch (edadExcepcion ek) {
                            System.out.println(ek.getMessage()); // Mostrar mensaje de error
                        }
                    }

                    // Si todos los datos son válidos, registrar el coche
                    arrayMascotas[cantidadMascotas] = new Mascota(nombre, codCliente, especie, edad);
                    cantidadMascotas++;
                    cantidadClientes++;
                    System.out.println("Se ha registrado la mascota con éxito.");
                }
                break;

                case 2: {
                    try {
                        System.out.print("Cliente para dar de baja? ");
                        String codigoBaja = teclado.nextLine();
                        boolean codigoEncontrado = false;

                        for (int i = 0; i < cantidadClientes; i++) {
                            if (codigoBaja.isEmpty()) {
                                throw new codClienteExcepcion("El codigo no puede estar vacio");
                            } else if (arrayMascotas[i].getCodCliente().equalsIgnoreCase(codigoBaja)) {
                                codigoEncontrado = true;
                                arrayMascotas[i] = null;
                                cantidadMascotas--;
                                System.out.println("Cliente dado de baja correctamente");
                                break;
                            } else if (!codigoEncontrado) {
                                throw new codClienteExcepcion("El cliente no ha sido encontrado");
                            } else if (!validarCodigo(codigoBaja)) {
                                throw new codClienteExcepcion(codClienteExcepcion.ERRORCOD);
                            }
                        }
                    } catch (codClienteExcepcion em) {
                        System.out.println(em.getMessage());
                    }

                }

                break;
                case 3:
                    try {
                        System.out.print("Mascota a consultar? ");
                        String mascotaBuscar = teclado.nextLine();
                        boolean mascotaEncontrada = false;
                        for (int i = 0; i < cantidadMascotas; i++) {
                            if (arrayMascotas[i].getNombre().equalsIgnoreCase(mascotaBuscar)) {
                                mascotaEncontrada = true;
                                System.out.println(arrayMascotas[i].toString());
                            } else if (mascotaBuscar.isEmpty()) {
                                throw new nombreExcepcion("El nombre no puede estar vacio");
                            } else if (mascotaBuscar.length() < 5 || mascotaBuscar.length() > 25) {
                                throw new nombreExcepcion(nombreExcepcion.CARACTERESNOMBRES);
                            } else if (!mascotaEncontrada) {
                                throw new nombreExcepcion("La mascota no ha sifo encontrada");
                            }
                        }

                    } catch (nombreExcepcion em) {
                        System.out.println(em.getMessage());
                    }

                    break;
                case 4:
                    try {
                        System.out.println("Nombre de la mascota a modificar");
                        String mascotaModificar = teclado.nextLine();
                        boolean mascotaEncontrada = false;
                        int nuevaEdad = 0;
                        for (int i = 0; i < cantidadMascotas; i++) {
                            if (arrayMascotas[i].getNombre().equalsIgnoreCase(mascotaModificar)) {
                                mascotaEncontrada = true;
                                System.out.println("Nueva edad?");
                                nuevaEdad = teclado.nextInt();
                                arrayMascotas[i].setEdad(nuevaEdad);
                                System.out.println(arrayMascotas[i].getEdad());
                                System.out.println("Se ha registrado con exito la nueva edad");
                            } else if (mascotaModificar.isEmpty()) {
                                throw new nombreExcepcion("El nombre no puede estar vacio");
                            } else if (nuevaEdad < 0) {
                                throw new edadExcepcion(edadExcepcion.ERROR_EDAD);
                            } else if (!mascotaEncontrada) {
                                throw new nombreExcepcion("No se ha encontrado la mascota");
                            }
                        }
                    } catch (edadExcepcion em) {
                        System.out.println(em.getMessage());
                    } catch (nombreExcepcion en) {
                        System.out.println(en.getMessage());
                    }
                    break;
                //mostrar listado mascotas
                case 5:
                    try {
                        System.out.println("LISTADO DE MASCOTAS");
                        for (int i = 0; i < cantidadMascotas; i++) {
                            System.out.println(arrayMascotas[i].toString());
                        }
                        if (cantidadMascotas == 0) {
                            throw new nombreExcepcion("no hay ninguna mascota registrada todavia");
                        }
                    } catch (nombreExcepcion en) {
                        System.out.println(en.getMessage());
                    }
                    break;
                //mostrar listado clientes + mascotas
                case 6:
                    String codigoCliente;
                    try {
                        System.out.println("LISTADO DE CLIENTES Y SUS MASCOTAS");
                        System.out.println("Codigo de cliente? ");
                        codigoCliente = teclado.nextLine();
                        if (codigoCliente.isEmpty()) {
                            throw new codClienteExcepcion("No puedes incluir un codigo vacio");
                        }
                        for (int i = 0; i < cantidadMascotas; i++) {
                            if (arrayMascotas[i].getCodCliente().equalsIgnoreCase(codigoCliente)) {
                                System.out.println("El cliente con codigo de cliente " + codigoCliente + " tiene la mascota: ");
                                System.out.println(arrayMascotas[i].getNombre() + arrayMascotas[i].getEspecie() + arrayMascotas[i].getEdad());
                            } else {
                                throw new codClienteExcepcion("No se ha encontrado el codigo de Cliente");
                            }
                        }

                    } catch (codClienteExcepcion en) {
                        System.out.println(en.getMessage());
                    } 
                    break;
            }

        } while (Opcion
                != 7);

    }

}
