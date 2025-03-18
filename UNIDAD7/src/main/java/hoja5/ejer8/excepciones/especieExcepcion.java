/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja5.ejer8.excepciones;

/**
 *
 * @author iriia
 */
public class especieExcepcion extends Exception {
    public especieExcepcion (){
        
    }
    public especieExcepcion(String mensaje){
        super(mensaje);
    }
    
    public static final String ERROR_ESPECIE = "La especie sólo puede ser: pez, pájaro, perro o gato.";
}
