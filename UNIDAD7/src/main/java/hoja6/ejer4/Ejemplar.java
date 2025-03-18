/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja6.ejer4;

import ejercicios.UNIDAD7.hoja6.ejer4.excepciones.ejemplarExcepcion;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author iriia
 */
public abstract class Ejemplar {

    protected int codigo;
    protected String titulo;
    protected boolean prestado;
    protected int diasPrestamo;
    protected LocalDate fecha;
    protected static ArrayList<Ejemplar> listadoEjemplar = new ArrayList<>();

    public Ejemplar(int codigo, String titulo, int diasPrestamo) throws ejemplarExcepcion {
        if (codigo < 0) {
            throw new ejemplarExcepcion(ejemplarExcepcion.CODIGO_EXCEPCION);
        }
        if (titulo.isEmpty() || titulo.length() <= 0) {
            throw new ejemplarExcepcion(ejemplarExcepcion.TITULO_EXCEPCION);
        }
        this.fecha = null;
        this.diasPrestamo = diasPrestamo;
        this.codigo = codigo;
        this.titulo = titulo;
        this.prestado = false;
    }

    public boolean prestar() {
        if (prestado) {
            System.out.println("El libro esta actualmente prestado");
            return false;
        }
        this.prestado = true;
        this.fecha = LocalDate.now();
        System.out.println("Fecha de devolucion: " + getFechaDevolucion());
        return true;
    }

    public LocalDate getFechaDevolucion() {
        if (fecha == null) {
            return null;
        }
        return fecha.plusDays(diasPrestamo);
    }

    public static void listadoEjemplar() throws ejemplarExcepcion {
        if (listadoEjemplar.isEmpty()) {
            throw new ejemplarExcepcion(ejemplarExcepcion.TITULO_EXCEPCION);
        }
        for (int i = 0; i < listadoEjemplar.size(); i++) {
            System.out.println(listadoEjemplar.get(i).toString());
        }
    }

    @Override
    public String toString() {
        return "Ejemplar{" + "codigo=" + codigo + ", titulo=" + titulo + ", prestado=" + prestado + '}';
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public static ArrayList<Ejemplar> getListadoEjemplar() {
        return listadoEjemplar;
    }

    public static void setListadoEjemplar(ArrayList<Ejemplar> listadoEjemplar) {
        Ejemplar.listadoEjemplar = listadoEjemplar;
    }

}
