/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja7.ejer2;

import ejercicios.UNIDAD7.hoja7.ejer2.excepciones.animalExcepcion;

/**
 *
 * @author Alumno
 */
public abstract class Animal {
    protected String nombre;
    protected String raza;

    public Animal(String nombre, String raza) throws animalExcepcion {
        if (nombre.length() < 0 || nombre.isEmpty()){
            throw new animalExcepcion(animalExcepcion.NOMBRE_EXCEPCION);
        }
        if (raza.length() < 0 || raza.isEmpty()){
            throw new animalExcepcion(animalExcepcion.RAZA_EXCEPCION);
        }        
        this.nombre = nombre;
        this.raza = raza;
    }
    
    public abstract String cuidadoDiario();
    public abstract String toString();
    
     
    
}
