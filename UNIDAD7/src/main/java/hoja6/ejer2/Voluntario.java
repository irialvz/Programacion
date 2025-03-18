/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja6.ejer2;

import ejercicios.UNIDAD7.hoja6.ejer2.excepciones.caracteresExcepcion;
import java.util.ArrayList;

/**
 *
 * @author iriia
 */
public class Voluntario extends Cooperante implements Empleable {
    private String ong;
    private String clase = "";
    private double remuneracion = 0;
    
    public Voluntario(String nombre, String dni, String pais,String ong) throws caracteresExcepcion {
        super(nombre, dni, pais);
        if (ong.isEmpty()){
            throw new caracteresExcepcion("La ong no puede estar vacia");
        }
        this.ong = ong;
    }

    public String getOng() {
        return ong;
    }

    public void setOng(String ong) {
        this.ong = ong;
    }

    @Override
    public String toString() {
        return "Voluntario{" + super.toString()+"ong=" + ong + '}';
    }

    @Override
    public String enviarApais() {
        this.clase = "turista";
        return "El voluntario va en clase turista";
    }

    @Override
    public double despedir() {
        this.remuneracion += 10;
        return this.remuneracion;
    }
    
    
}
