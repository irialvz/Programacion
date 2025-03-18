/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja6.ejer1;

import ejercicios.UNIDAD7.hoja6.ejer1.excepciones.caracteresExcepcion;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
public class PruebaEjer1 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String nombre = "", apellido = "", ciudad = "", curso = "", departamento = "", respuesta = "";
        int edad = 0, numeroAlumno = 0, numeroDocente = 0;
        boolean correcto = false, repetir = true;
        final float CANTIDAD = 0.2f;
        while (repetir) {

            while (!correcto) {
                try {
                    System.out.print("Nombre? ");
                    nombre = teclado.nextLine();
                    if (nombre.isBlank()) {
                        throw new caracteresExcepcion("El nombre debe tener mas de 1 caracter");
                    }
                    break;
                } catch (caracteresExcepcion e) {
                    System.out.println(e.getMessage());
                    correcto = false;
                }
            }
            while (!correcto) {
                try {
                    System.out.print("Apellido? ");
                    apellido = teclado.nextLine();
                    if (apellido.isBlank()) {
                        throw new caracteresExcepcion("El apellido debe tener mas de 1 caracter");
                    }
                    break;
                } catch (caracteresExcepcion e) {
                    System.out.println(e.getMessage());
                    correcto = false;
                }
            }
            while (!correcto) {
                try {
                    System.out.print("Ciudad? ");
                    ciudad = teclado.nextLine();
                    if (ciudad.isBlank()) {
                        throw new caracteresExcepcion("La ciudad debe tener mas de 1 caracter");
                    }
                    break;
                } catch (caracteresExcepcion e) {
                    System.out.println(e.getMessage());
                    correcto = false;
                }
            }
            while (!correcto) {
                try {
                    System.out.print("Edad? ");
                    edad = teclado.nextInt();
                    teclado.nextLine();
                    if (edad < 0) {
                        throw new caracteresExcepcion("La edad debe ser mayor a 0");
                    }
                    break;
                } catch (caracteresExcepcion e) {
                    System.out.println(e.getMessage());
                    correcto = false;
                }
            }
            System.out.println("Eres alumno o docente? ");
            respuesta = teclado.nextLine();

            if (respuesta.equalsIgnoreCase("alumno")) {
                System.out.println("Curso? ");
                curso = teclado.nextLine();
                System.out.println("Nota? ");
                int nota = teclado.nextInt();
                teclado.nextLine();
                try {
                    Alumno alumno = new Alumno(nombre, apellido, edad, ciudad, curso, numeroAlumno,nota);
                    System.out.println(alumno.toString());
                    alumno.prosperar(CANTIDAD);
                } catch (caracteresExcepcion ex) {
                    System.out.println(ex.getMessage());
                }
                System.out.println("Tu numero de alumno es el " + numeroAlumno);
                numeroAlumno++;

            } else if (respuesta.equalsIgnoreCase("docente")) {
                System.out.println("Departamento? ");
                departamento = teclado.nextLine();
                System.out.println("Sueldo? ");
                int sueldo = teclado.nextInt();
                teclado.nextLine();
                try {
                    Profesor docente = new Profesor(nombre, apellido, edad, ciudad, departamento, numeroDocente,sueldo);
                    System.out.println(docente.toString());
                    docente.prosperar(CANTIDAD);
                } catch (caracteresExcepcion ex) {
                    System.out.println(ex.getMessage());
                }
                System.out.println("Tu numero de docente es el " + numeroDocente);
                numeroDocente++;
            }
            
            
            System.out.println("Agregar otra persona? (si/no)");
            respuesta = teclado.nextLine();
            if (!respuesta.equalsIgnoreCase("si")){
                repetir = false;
                System.out.println("Fin del programa");
            }
        }
    }

}
