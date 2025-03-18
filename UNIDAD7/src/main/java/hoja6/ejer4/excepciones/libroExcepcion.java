/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja6.ejer4.excepciones;

/**
 *
 * @author iriia
 */
public class libroExcepcion extends Exception{

    public libroExcepcion(String message) {
        super(message);
    }
    public static final String EDITORIAL_EXCEPCION = "La editorial no puede estar vacia";
    public static final String NUMPAG_EXCEPCION = "El numero de paginas no puede ser menor o igual a cero";
    public static final String DIAS_EXCEPCION = "Los libros se pueden prestar durante 15 dias";
    
}
