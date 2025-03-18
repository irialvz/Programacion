/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja5.ejer6.excepciones;

/**
 *
 * @author Alumno
 */
public class error_modelo extends Exception {
    public error_modelo(){
        
    }
    public error_modelo(String mensaje){
        super(mensaje);
    }
    public static final String ERROR_MODELO = "El modelo tiene que tener entre 5 y 30 caracteres";
}
