/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja5.ejer9.excepciones;

/**
 *
 * @author Alumno
 */
public class docIdentidadExcepcion extends Exception{

    public docIdentidadExcepcion() {
    }

    public docIdentidadExcepcion(String message) {
        super(message);
    }
    public static final String ERROR_VALIDACION = "El DNI no es valido,debe ser de 8 caracteres,7 numericos y 1 letra";
    
}
