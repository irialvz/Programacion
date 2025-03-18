/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja6.ejer4.excepciones;

/**
 *
 * @author iriia
 */
public class multimediaExcepcion extends Exception {

    public multimediaExcepcion(String message) {
        super(message);
    }
    public static final String TIPO_EXCEPCION = "El tipo debe ser video o dvd o cd";
    public static final String TITULO_EXCEPCION = "El titulo no puede estar vacio";
    public static final String LISTADO_EXCEPCION = "El listado esta vacio";

}
