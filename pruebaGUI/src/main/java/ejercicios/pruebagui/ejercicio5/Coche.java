/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.pruebagui.ejercicio5;

/**
 *
 * @author Alumno
 */
public class Coche {
    private String marca;
    private String modelo;
    private double precio;
    private boolean estaVenta;

    public Coche(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precioTotal();
        this.estaVenta = true;
    }
    
    public double precioTotal(){
        return this.precio * 1.21;
    }

    @Override
    public String toString() {
        return "Coche{" + "marca=" + marca + ", modelo=" + modelo + ", precio S/I=" + precio + ", esta en venta=" + estaVenta + ", precio total " + precioTotal()+'}';
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isEstaVenta() {
        return estaVenta;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setEstaVenta(boolean estaVenta) {
        this.estaVenta = estaVenta;
    }
    
    
    
    
    
}
