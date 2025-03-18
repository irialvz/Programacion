/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja5.ejer8.excepciones;

/**
 *
 * @author iriia
 */
public class edadExcepcion extends Exception {

    public edadExcepcion() {
    }
    
    public edadExcepcion(String mensaje) {
        super(mensaje);
    }
    
    public static final String ERROR_EDAD = "La edad tiene que ser igual o superior a 0";
}
