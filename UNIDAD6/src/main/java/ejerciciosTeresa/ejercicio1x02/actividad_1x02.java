/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.ejerciciosTeresa.ejercicio1x02;
import java.util.Scanner;
/**
 *
 * @author iriia
 */
public class actividad_1x02 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        System.out.println("PERSONA 1");
        System.out.print("Nombre? ");
        String nombre = teclado.nextLine();

        System.out.print("Apellido? ");
        String apellido = teclado.nextLine();

        System.out.print("Edad? ");
        int edad = teclado.nextInt();

        System.out.print("altura? ");
        int altura = teclado.nextInt();
        teclado.nextLine();
        
        System.out.print("Esta activo? (true o false)");
        boolean chambeador = teclado.nextBoolean();
        teclado.nextLine();

        Persona p1 = new Persona(nombre, apellido, edad, altura, chambeador);
        System.out.println(p1);

        System.out.println("-------------------------------");

        System.out.println("PERSONA 2");
        System.out.print("Nombre? ");
        String nombre2 = teclado.nextLine();

        System.out.print("Apellido? ");
        String apellido2 = teclado.nextLine();

        System.out.print("edad? ");
        int edad2 = teclado.nextInt();
        teclado.nextLine();
        
        System.out.print("altura? ");
        int altura2 = teclado.nextInt();
        teclado.nextLine();

        Persona p2 = new Persona(nombre2, apellido2, edad2,altura2);
        System.out.println(p2);

        System.out.println("-------------------------------");

        System.out.println("PERSONA 3");
        Persona p3 = new Persona();
        System.out.println(p3);
        teclado.close();
    }
}
