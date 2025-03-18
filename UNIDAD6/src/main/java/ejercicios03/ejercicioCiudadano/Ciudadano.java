/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.ejercicios03.ejercicioCiudadano;

/**
 *
 * @author iriia
 */
public class Ciudadano {
    private String nombre;
    private String apellidos;
    private int dni;
    private char letra;
    private boolean casado;
    
    public Ciudadano (String nombre, String apellidos,int dni,char letra,boolean casado){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.letra = letra;
        this.casado = casado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getDni() {
        return dni;
    }

    public char getLetra() {
        return letra;
    }

    public boolean isCasado() {
        return casado;
    }
    
    
}
