/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja5.ejer8.excepciones;

/**
 *
 * @author iriia
 */
public class nombreExcepcion extends Exception{
    public nombreExcepcion(){
        
    }
    public nombreExcepcion(String mensaje){
        super(mensaje);
    }
    
    public static final String CARACTERESNOMBRES = "El nombre tiene que tener entre 5 y 25 caracteres";
}
