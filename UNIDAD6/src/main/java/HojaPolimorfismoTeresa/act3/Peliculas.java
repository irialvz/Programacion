/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.HojaPolimorfismoTeresa.act3;

/**
 *
 * @author iriia
 */
public class Peliculas implements PrecioModificable {

    private String titulo;
    private String anyoEstreno;
    private String director;
    private double precioBase;

    public Peliculas(String titulo, String anyoEstreno, String director, double precioBase) {
        this.titulo = titulo;
        this.anyoEstreno = anyoEstreno;
        this.director = director;
        this.precioBase = precioBase;
    }

    @Override
    public String toString() {
        return "Peliculas{" + "titulo=" + titulo + ", año estreno=" + anyoEstreno + ", director=" + director + ", precioBase=" + precioBase + '}';
    }

    @Override
    public double calcularPrecioConIVA() {
        return precioBase * 1.1;
    }

    @Override
    public double calcularPrecioOferta(double descuento) {
        return precioBase * (1 - descuento / 100);
    }
    
    @Override
    public double calcularPrecioPorCantidad(int cantidad) {
        cantidad = 100;
        double descuento = 0;
        if (cantidad >= 5 && cantidad < 49){
            descuento = 3;
        } else if (cantidad >= 50 && cantidad < 499){
            descuento = 6;
        } else if (cantidad >= 500){
            descuento = 12;
        }
        
        return precioBase + (1 - descuento / 100);
    }


}
