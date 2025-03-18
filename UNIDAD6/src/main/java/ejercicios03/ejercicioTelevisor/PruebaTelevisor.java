/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.ejercicios03.ejercicioTelevisor;

/**
 *
 * @author iriia
 */
public class PruebaTelevisor {
    public static void main(String[] args){
        Televisor t1 = new Televisor("Sony","Trinitron 4",2201);
        System.out.println("CARACTERISTICAS DEL TELEVISOR: " + t1);
        
        t1.encender();
        t1.bajarCanal();
        t1.seleccionarCanal(23);
        t1.subirCanal();
        t1.cambiarVolumen(300);
        t1.cambiarVolumen(50);
        System.out.println(t1);
        t1.apagar();
        t1.seleccionarCanal(60);
        t1.apagar();
    }
}
