/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja6.ejer4;

import ejercicios.UNIDAD7.hoja6.ejer4.excepciones.ejemplarExcepcion;
import ejercicios.UNIDAD7.hoja6.ejer4.excepciones.libroExcepcion;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author iriia
 */
public class Libro extends Ejemplar {

    private String editorial;
    private int numeroPaginas;

    public Libro(int codigo, String titulo,String editorial, int numeroPaginas) throws libroExcepcion, ejemplarExcepcion {
        super(codigo, titulo, 15);
        if (editorial.isEmpty() || editorial.length() <= 0) {
            throw new libroExcepcion(libroExcepcion.EDITORIAL_EXCEPCION);
        }
        if (numeroPaginas <= 0) {
            throw new libroExcepcion(libroExcepcion.NUMPAG_EXCEPCION);
        }
        if (diasPrestamo > 15){
            throw new libroExcepcion(libroExcepcion.DIAS_EXCEPCION);
        }
        
        this.editorial = editorial;
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public String toString() {
        return "Libro{" + super.toString() + "editorial=" + editorial + ", numeroPaginas=" + numeroPaginas + '}';
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

}
