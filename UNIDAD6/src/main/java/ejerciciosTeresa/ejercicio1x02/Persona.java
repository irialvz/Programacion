/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.ejerciciosTeresa.ejercicio1x02;

/**
 *
 * @author iriia
 */
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private int altura;
    private boolean activo;
    
    public Persona (String nombre_ , String apellido_ , int edad_ , int altura_ , boolean activo_){
        nombre = nombre_;
        apellido = apellido_;
        edad = edad_;
        altura = altura_;
        activo = activo_;
    }
    
    public Persona (String nombre_ , String apellido_ , int edad_ , int altura_) {
        //this(nombre_,apellido_,edad_,altura_,false);
        nombre = nombre_;
        apellido = apellido_;
        edad = edad_;
        altura = altura_;
        activo = false;
    }
    
    public Persona () {
        this("Recien","nacido",0,50,false);
    }
    
    //antes estaba getEstado, asi que cambiarlo por toString	
    public String toString(){
        return "[Estado: nombre= " + nombre + ", apellido= " + apellido + ", edad= " + edad + 
                ", altura= " + altura + ", activo= " + activo + "]";
    }
    
}
