/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class ejercicio2x04 {

    public static double[][] generarMatrizReales(int alumnos, int asignaturas, double minimo, double maximo) {
        Random aleatorio = new Random();
        double[][] notas = new double[alumnos][asignaturas];

        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[i].length; j++) {
                notas[i][j] = aleatorio.nextDouble(maximo - minimo + 1) + minimo;

            }
        }
        return notas;
    }

    public static double sacarMediaAlumno(double[][] matriz, int alumno) {
        double suma = 0;
        for (int i = 0; i < matriz[alumno].length; i++) {
            suma += matriz[alumno][i];
        }
        return suma / matriz[alumno].length;
    }

    public static double sacarMediaAsignatura(double[][] matriz, int asignatura) {
        double suma = 0;
        for (int i = 0; i < matriz[asignatura].length; i++) {
            suma += matriz[i][asignatura];
        }
        return suma / matriz[asignatura].length;
    }

    public static int preguntarAlumnos() {
        Scanner teclado = new Scanner(System.in);
        int numAlumnos;
        do {
            System.out.print("Numero de alumnos? ");
            numAlumnos = teclado.nextInt();

            if (numAlumnos < 0) {
                System.out.println("Error: debe ser positivo");
            }
        } while (numAlumnos < 0);
        return numAlumnos;
    }

    public static int preguntarAsignaturas() {
        Scanner teclado = new Scanner(System.in);
        int numAsignaturas;
        do {
            System.out.print("Numero de asignaturas? ");
            numAsignaturas = teclado.nextInt();

            if (numAsignaturas < 0) {
                System.out.println("Error: debe ser positivo");
            }
        } while (numAsignaturas < 0);
        return numAsignaturas;
    }

    public static void mostrarMatriz(double[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[0].length; j++) {
                //System.out.print("[");
                System.out.printf("%8.2f", matriz[i][j]);

            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static void sacarMenu(double[][] matriz) {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("0: Salir del programa");
            System.out.println("1: Visualizar en consola la matriz de notas");
            System.out.println("2. Leer por teclado un alumno y visualizar en consola la media de este alumno");
            System.out.println("3. Leer por teclado una asignatura y visualizar en consola la media de esta asignatura");
            System.out.print("Opcion (0-3?) ");
            opcion = teclado.nextInt();

            if (opcion == 1) {
                mostrarMatriz(matriz);

            } else if (opcion == 2) {
                int alumno;
                do {
                    System.out.print("Alumno?  ");
                    alumno = teclado.nextInt();
                    if (alumno < 0 || alumno >= matriz.length) {
                        System.out.printf("El alumno debe estar comprendido entre 0 y %d%n", matriz.length - 1);
                    }
                } while (alumno < 0 || alumno >= matriz.length);
                double mediaAlumno = sacarMediaAlumno(matriz, alumno);

                System.out.printf("La media del alumno %d es %.2f%n", alumno, mediaAlumno);

            } else if (opcion == 3) {
                int asignatura;
                do {
                    System.out.print("Asignatura?  ");
                    asignatura = teclado.nextInt();
                    if (asignatura < 0 || asignatura >= matriz[0].length) { //matriz[0] porque son las columnas
                        System.out.printf("La asignatura debe estar comprendida entre 0 y %d%n", matriz[0].length);
                    }
                } while (asignatura < 0 || asignatura >= matriz[0].length);
                double mediaAsignatura = sacarMediaAsignatura(matriz, asignatura);
                System.out.printf("La media de la asignatura %d es %.2f%n", asignatura, mediaAsignatura);
            }
        } while (opcion != 0);
    }

    public static void main(String[] args) {
        int alumnos = preguntarAlumnos();
        int asignaturas = preguntarAsignaturas();
        double[][] matriz = generarMatrizReales(alumnos, asignaturas, 0.0, 10.0);
        sacarMenu(matriz);
    }
}