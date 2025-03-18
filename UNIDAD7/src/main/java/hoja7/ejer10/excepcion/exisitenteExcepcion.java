/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja7.ejer10.excepcion;

/**
 *
 * @author Alumno
 */
public class exisitenteExcepcion extends Exception{

    public exisitenteExcepcion() {
    }

    public exisitenteExcepcion(String message) {
        super(message);
    }
    public static final String VALORCLAVE_EXISTENTE = "La clave o el valor ya existe en el diccionario";
    
}
