/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja5.ejer9.excepciones;

/**
 *
 * @author Alumno
 */
public class nombreExcepcion extends Exception{

    public nombreExcepcion() {
    }

    public nombreExcepcion(String message) {
        super(message);
    }
    public static final String ERROR_CARACTERES = "El nombre debe tener maximo 25 caracteres";
    
}
