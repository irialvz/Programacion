/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.ejerciciosTeresa.ejercicio5;

/**
 *
 * @author iriia
 */
public class Calificacion {
    private String modulo;
    private double calificacion;
    
    public Calificacion (String modulo, double calificacion){
        this.modulo = modulo;
        this.calificacion = calificacion;
    }

    public String getModulo() {
        return modulo;
    }

    public double getCalificacion() {
        return calificacion;
    }

    @Override
    public String toString() {
        return "Calificacion{" + "modulo=" + modulo + ", calificacion=" + calificacion + '}';
    }
    
    
    
}
