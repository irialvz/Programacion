/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja7_2.ejer8;

import ejercicios.UNIDAD7.hoja7_2.ejer7.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author iriia
 */
public class AlumnosPorNotas {

    public static void main(String[] args) {
        String apellido;
        int nota;
        Scanner teclado = new Scanner(System.in);
        TreeMap<String, Integer> notasAlumnos = new TreeMap<>();
        do {
            System.out.println("Apellido del alumno?");
            apellido = teclado.nextLine();
            if (apellido.equals("*")) {
                break;
            }
            System.out.println("Nota? ");
            nota = teclado.nextInt();
            teclado.nextLine();

            notasAlumnos.put(apellido, nota);
        } while (!apellido.equals("*"));

        System.out.println(notasAlumnos);

        List<Map.Entry<String, Integer>> listaAlumnos = new ArrayList<>(notasAlumnos.entrySet());
        Collections.sort(listaAlumnos, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }

        });
        System.out.println("Supuestamente ordenados por notas");
        System.out.println(listaAlumnos.toString());
    }

}
