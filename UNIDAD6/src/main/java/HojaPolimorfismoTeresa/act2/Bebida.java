/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.HojaPolimorfismoTeresa.act2;

/**
 *
 * @author iriia
 */
public abstract class Bebida {

    private static int contador = 0;
    protected int codigoID;
    protected String nombre;

    public Bebida(String nombre) {
        this.codigoID = ++contador;
        this.nombre = nombre;
    }

    public int getCodigoID() {
        return codigoID;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double calcularPrecio();

    @Override
    public String toString() {
        return "codigoID=" + codigoID
                + ", nombre=" + nombre
                + ", precio='" + String.format("%.2f", this.calcularPrecio())
                + '}';
    }

    public int compareTo(Bebida b) {
        return this.nombre.compareTo(b.nombre);
    }

}
