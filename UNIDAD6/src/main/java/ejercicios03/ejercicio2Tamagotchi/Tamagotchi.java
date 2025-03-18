/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.ejercicios03.ejercicio2Tamagotchi;

/**
 *
 * @author Alumno
 */
public class Tamagotchi {

    private String nombre;
    private int cantidadVida;
    private int maxVida;

    public Tamagotchi(String nombre, int maxVida) {
        this.nombre = nombre;
        this.maxVida = maxVida;
        this.cantidadVida = 0;
    }

    public String toString() {
        return "[Nombre " + nombre + ",cantidad de vida " + cantidadVida
                + ",maxVida " + maxVida + "]";
    }

    public void juega() {
        for (int i = 0; i <= 5; i++) {
            if (cantidadVida >= 1) {
                System.out.println("Estoy jugando");
                cantidadVida--;
            }
        }
    }

    public void come() {
        for (int i = 0; i <= 5; i++) {
            if (cantidadVida < maxVida) {
                System.out.println("Estoy comiendo");
                cantidadVida++;
            }
        }
    }
}
