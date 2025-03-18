/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja5.ejer9.excepciones;

/**
 *
 * @author Alumno
 */
public class codPostalExcepcion extends Exception{

    public codPostalExcepcion() {
    }

    public codPostalExcepcion(String message) {
        super(message);
    }
    public static final String ERROR_DIGITOS = "El codigoPostal debe tener maximo 5 digitos numericos";
    
}
