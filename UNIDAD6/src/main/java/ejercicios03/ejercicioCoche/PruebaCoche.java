/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.ejercicios03.ejercicioCoche;

/**
 *
 * @author iriia
 */
public class PruebaCoche {
    public static void main(String[] args){
        Coche miCoche = new Coche("5466-FNZ",60,7.1,200);
        miCoche.repostar(15);
        miCoche.arrancarMotor();
        miCoche.fijarVelocidad(80);
        miCoche.recorrerDistancia(10);
        miCoche.fijarVelocidad(120);
        miCoche.recorrerDistancia(300);
    }
}
