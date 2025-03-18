/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja6.ejer4.excepciones;

/**
 *
 * @author iriia
 */
public class ejemplarExcepcion extends Exception{

    public ejemplarExcepcion(String message) {
        super(message);
    }
    public static final String CODIGO_EXCEPCION = "El codigo no puede ser menor de 0";
    public static final String TITULO_EXCEPCION = "El titulo no puede estar vacio";
    public static final String LISTADO_EXCEPCION = "El listado esta vacio";
    public static final String PRESTADO_EXCEPCION = "El ejemplar esta actualmente prestado";
    
}
