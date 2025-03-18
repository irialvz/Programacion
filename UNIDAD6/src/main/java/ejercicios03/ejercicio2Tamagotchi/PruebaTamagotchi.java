/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.ejercicios03.ejercicio2Tamagotchi;

/**
 *
 * @author Alumno
 */
public class PruebaTamagotchi {
    public static void main(String[] args){
        Tamagotchi pepe = new Tamagotchi("pepe",5);
        System.out.println(pepe);
        pepe.come();
        pepe.juega();
    }
}
