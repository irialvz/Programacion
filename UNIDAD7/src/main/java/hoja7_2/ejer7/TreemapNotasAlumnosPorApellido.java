/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja7_2.ejer7;

import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author iriia
 */
public class TreemapNotasAlumnosPorApellido {
    public static void main(String[] args) {
        String apellido;
        int nota;
        Scanner teclado = new Scanner(System.in);
        TreeMap<String,Integer> notasAlumnos = new TreeMap<>();
        do{
            System.out.println("Apellido del alumno?");
            apellido = teclado.nextLine();
            if (apellido.equals("*")) break;
            System.out.println("Nota? ");
            nota = teclado.nextInt();
            teclado.nextLine();
            
            notasAlumnos.put(apellido, nota);
        } while (!apellido.equals("*"));
        
        System.out.println(notasAlumnos);
    }
    
}
