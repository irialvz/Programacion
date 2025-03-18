/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.HojaPolimorfismoTeresa.act2;

/**
 *
 * @author iriia
 */
public abstract class Alcoholica extends Bebida{
    protected double gradoAlc;

    public Alcoholica(String nombre,double gradoAlc) {
        super(nombre);
        this.gradoAlc = gradoAlc;
    }

    @Override
    public String toString() {
        return "Alcoholica{" + super.toString()+ "gradoAlc=" + gradoAlc + '}';
    }
    
    
    
}
