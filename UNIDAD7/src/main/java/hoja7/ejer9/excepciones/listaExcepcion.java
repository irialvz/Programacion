/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja7.ejer9.excepciones;

/**
 *
 * @author Alumno
 */
public class listaExcepcion extends Exception{

    public listaExcepcion() {
    }

    public listaExcepcion(String message) {
        super(message);
    }
    public static final String LISTADO_VACIO = "El listado esta vacio";
    
}
