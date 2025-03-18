/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja5.ejer9.excepciones;

/**
 *
 * @author Alumno
 */
public class ciudadExcepcion extends Exception{

    public ciudadExcepcion() {
    }

    public ciudadExcepcion(String message) {
        super(message);
    }
    public static final String ERROR_CARACTERES = "La ciudad debe tener maximo 25 caracteres";
    
}
