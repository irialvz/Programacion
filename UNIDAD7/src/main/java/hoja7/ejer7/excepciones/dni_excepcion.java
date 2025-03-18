/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja7.ejer7.excepciones;

/**
 *
 * @author iriia
 */
public class dni_excepcion extends Exception{

    public dni_excepcion() {
    }

    public dni_excepcion(String message) {
        super(message);
    }
    public static final String DNI_NOVALIDO = ("El DNI no es valido");
    public static final String DNI_REPETIDO = ("El DNI ya esta en la base de datos");
    
}
