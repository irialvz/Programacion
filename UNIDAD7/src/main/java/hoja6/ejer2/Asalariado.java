/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja6.ejer2;

import ejercicios.UNIDAD7.hoja6.ejer2.excepciones.caracteresExcepcion;

/**
 *
 * @author iriia
 */
public class Asalariado extends Cooperante implements Empleable {

    private double sueldo;
    private String clase = "";
    private double remuneracion = 0;

    public Asalariado(String nombre, String dni, String pais, double sueldo) throws caracteresExcepcion {
        super(nombre, dni, pais);
        if (sueldo <= 0) {
            throw new caracteresExcepcion("El sueldo no puede ser menor o igual a cero");
        }
        this.sueldo = sueldo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Asalariado{" + super.toString() + "sueldo=" + sueldo + '}';
    }

    @Override
    public String enviarApais() {
        this.clase = "primera clase";
        return "El asalariado viaja en " + this.clase;
    }

    @Override
    public double despedir() {
        this.remuneracion += 100;
        return this.remuneracion;
    }

}
