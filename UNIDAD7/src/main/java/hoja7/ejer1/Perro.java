/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja7.ejer1;

import ejercicios.UNIDAD7.hoja7.ejer1.excepciones.animalExcepcion;

/**
 *
 * @author Alumno
 */
public class Perro extends Animal implements Parlanchin {

    public Perro(String nombre, String raza) throws animalExcepcion {
        super(nombre, raza);
    }

    
    @Override
    public String cuidadoDiario() {
        return " necesita diariamente dormir,hidratarse,alimentarse,jugar,hacer pis y pos...";
    }

    @Override
    public String toString() {
        return "Perro=" + nombre + " de raza " + raza + cuidadoDiario() + " "+ habla() + '}';
    }

    @Override
    public String habla() {
        return "Ladrido: Guau";
    }
    
    
}
