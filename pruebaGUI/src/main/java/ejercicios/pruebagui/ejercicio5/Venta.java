/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.pruebagui.ejercicio5;

/**
 *
 * @author Alumno
 */
public class Venta {

    private Coche cocheVendido;
    private double iva;
    private double precioTotal;

    public Venta(Coche cocheVendido, double ival) {
        this.cocheVendido = cocheVendido;
        this.iva = iva;
        this.precioTotal = cocheVendido.precioTotal();
    }

    public Coche getCocheVendido() {
        return cocheVendido;
    }

    public double getIva() {
        return iva;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    @Override
    public String toString() {
        return "Venta{" + "cocheVendido=" + cocheVendido.getMarca() + cocheVendido.getModelo() + ", iva aplicado =" + iva * 100 + ", precio Total=" + precioTotal + '}';
    }
    

}
