/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja7.ejer11.excepciones;

/**
 *
 * @author iriia
 */
public class vacioExcepcion extends Exception{

    public vacioExcepcion() {
    }

    public vacioExcepcion(String message) {
        super(message);
    }
    public static final String DESCRIPCION_VACIA = "La descripcion no puede estar vacia";
    public static final String TIPO_VACIO = "El tipo no puede estar vacio";
    
    
}
