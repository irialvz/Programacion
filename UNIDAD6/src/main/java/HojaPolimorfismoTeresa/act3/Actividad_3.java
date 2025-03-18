/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.HojaPolimorfismoTeresa.act3;

/**
 *
 * @author iriia
 */
public class Actividad_3 {

    public static void main(String[] args) {
        PrecioModificable[] precios = new PrecioModificable[6];

        precios[0] = new Libro("Principito", "2000", "Pepito", 10.5);
        precios[1] = new Libro("Caperucita", "1996", "Laura", 12.99);
        precios[2] = new Libro("Los Tres Mosqueteros", "1844", "Alexandre", 29.5);

        precios[3] = new Peliculas("Titanic", "1997", "James", 23.5);
        precios[4] = new Peliculas("Ben-Hur", "1959", "William", 18.99);
        precios[5] = new Peliculas("Los Vengadores", "2012", "Joss", 21.75);

        for (int i = 0; i < precios.length; i++) {
            System.out.println("El precio modificable " + i + " es un " + precios[i].getClass().getSimpleName());
            System.out.println(precios[i].toString());
            System.out.printf("Precios con IVA:  %.2f%n",precios[i].calcularPrecioConIVA() );
            System.out.printf("Precios de oferta (descuento del 10%%): %.2f%n",precios[i].calcularPrecioOferta(10));
            System.out.println("Precios de oferta: " + precios[i].calcularPrecioPorCantidad(100));
            System.out.println();
        }
    }

}
