/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja5.ejer6.excepciones;

/**
 *
 * @author Alumno
 */
public class error_km extends Exception {
    public error_km(){
        
    }
    public error_km(String mensaje){
        super(mensaje);
    }
    public static final String ERROR_KM = "Los km tienen que ser igual o superior a cero.";

    public static class ERROR_KM {

        public ERROR_KM() {
        }
    }
}
