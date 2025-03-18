/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.ejercicios03.ejercicio3x04;

/**
 *
 * @author iriia
 */
public class Alumno {

    private String nombre;
    private double nota;
    private int edad;

    public Alumno(String nombre) {
        this.nombre = nombre;
    }

    public void ponNota(double nota) { //setNota
        if (nota < 0) {
            this.nota = 0;
        } else {
            this.nota = nota;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public double getNota() {
        return nota;
    }
    
    public String toString(){
        return "[Nombre del alumno: " + nombre + ", nota: " + nota + ", edad: " + edad + "]\n"; 
    }
}
