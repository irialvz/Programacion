/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.ejercicios03.ejercicio3x04;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author iriia
 */
public class PruebaAlumno {

    public static double obtenerMedia(Alumno[] alumnos) {
        double sumaNotas = 0;
        
        for (int i = 0; i < alumnos.length; i++) {
            sumaNotas += alumnos[i].getNota();
        }
        return sumaNotas / alumnos.length;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Alumno[] alumnos = new Alumno[5];
        double sumaNotas = 0;

        for (int i = 0; i < alumnos.length; i++) {
            System.out.print("Alunmo " + i + "?");
            String nombre = teclado.nextLine();
            alumnos[i] = new Alumno(nombre);
        }
        for (int i = 0; i < alumnos.length; i++) {
            System.out.println("Nota del alumno " + i);
            double notas = teclado.nextDouble();
            alumnos[i].ponNota(notas);
        }

        System.out.println(Arrays.toString(alumnos));
        System.out.println("La media de las notas es de " + obtenerMedia(alumnos));
        System.out.println("LOS ALUMNOS CON LA NOTA MAS ALTA QUE LA MEDIA SON:");
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i].getNota() > obtenerMedia(alumnos)) {
                System.out.print(alumnos[i].getNombre() + ",");
            }
        }
        System.out.println();
        Alumno peorNota = alumnos[0];
        
        for (int i = 0; i < alumnos.length;i++){
            if (alumnos[i].getNota() < peorNota.getNota()){
                peorNota = alumnos[i];
            }
        }
        System.out.println("El alumno con peor nota es " + peorNota);
    }
}
