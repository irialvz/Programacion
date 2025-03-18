/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.pruebagui.ejercicio5;

import java.util.Random;

/**
 *
 * @author Alumno
 */
public class CocheImportado extends Coche {

    Random aleatorio = new Random();
    private double impuestoHomologacion;

    public CocheImportado(String marca, String modelo, double precio) {
        super(marca, modelo, precio);
        this.impuestoHomologacion = aleatorio.nextDouble(5000);
    }

    @Override
    public double precioTotal() {
        return super.precioTotal() + this.impuestoHomologacion;
    }

    @Override
    public String toString() {
        return "CocheImportado{" + super.toString() + "e impuestoHomologacion=" + impuestoHomologacion +'}';
    }

    public double getImpuestoHomologacion() {
        return impuestoHomologacion;
    }
    
    

}
