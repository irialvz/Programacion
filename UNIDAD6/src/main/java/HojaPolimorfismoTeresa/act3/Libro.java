/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.HojaPolimorfismoTeresa.act3;

/**
 *
 * @author iriia
 */
public class Libro implements PrecioModificable {
    private String titulo;
    private String anyoPubli;
    private String autor;
    private double precioBase;

    public Libro(String titulo, String anyoPubli, String autor, double precioBase) {
        this.titulo = titulo;
        this.anyoPubli = anyoPubli;
        this.autor = autor;
        this.precioBase = precioBase;
    }

    @Override
    public String toString() {
        return "Libro{" + "titulo=" + titulo + ", año publicacion=" + anyoPubli + ", autor=" + autor + ", precioBase=" + precioBase + '}';
    }
    @Override
    public double calcularPrecioConIVA() {
        return precioBase * 1.04;   
    }

    @Override
    public double calcularPrecioOferta(double descuento) {
        return precioBase * (1 - descuento / 100);
    }
    
    @Override
    public double calcularPrecioPorCantidad(int cantidad) {
        cantidad = 100;
        double descuento = 0;
        if (cantidad >= 10 && cantidad < 100){
            descuento = 4;
        } else if (cantidad >= 100 && cantidad < 1000){
            descuento = 8;
        } else if (cantidad >= 1000){
            descuento = 16;
        }
        
        return precioBase + (1 - descuento / 100);
    }

    
    
}
