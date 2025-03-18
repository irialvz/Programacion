package ejercicios.UNIDAD6.ejerciciosTeresa.ejercicio1x01;

import java.util.Scanner;

/**
 *
 * @author iriia
 */
public class actividad_1x01 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("VIDEOJUEGO 1");
        System.out.print("Nombre? ");
        String nombre = teclado.nextLine();

        System.out.print("Desarrollador? ");
        String desarrollador = teclado.nextLine();

        System.out.print("año? ");
        int año = teclado.nextInt();

        System.out.print("numero maximo de jugadores? ");
        int maxJugadores = teclado.nextInt();
        teclado.nextLine();

        Videojuego v1 = new Videojuego(nombre, desarrollador, año, maxJugadores);
        System.out.println(v1.getEstado());

        System.out.println("-------------------------------");

        System.out.println("VIDEOJUEGO 2");
        System.out.print("Nombre? ");
        String nombre2 = teclado.nextLine();

        System.out.print("Desarrollador? ");
        String desarrollador2 = teclado.nextLine();

        System.out.print("año? ");
        int año2 = teclado.nextInt();
        teclado.nextLine();

        Videojuego v2 = new Videojuego(nombre2, desarrollador2, año2);
        System.out.println(v2.getEstado());

        System.out.println("-------------------------------");

        System.out.println("VIDEOJUEGO 3");
        System.out.print("Nombre? ");
        String nombre3 = teclado.nextLine();

        System.out.print("Desarrollador? ");
        String desarrollador3 = teclado.nextLine();

        Videojuego v3 = new Videojuego(nombre3, desarrollador3);
        System.out.println(v3.getEstado());
    teclado.close();
    }
}
