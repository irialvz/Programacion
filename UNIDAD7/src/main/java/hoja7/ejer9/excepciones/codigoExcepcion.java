/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja7.ejer9.excepciones;

/**
 *
 * @author Alumno
 */
public class codigoExcepcion extends Exception{

    public codigoExcepcion() {
    }

    public codigoExcepcion(String message) {
        super(message);
    }
    public static final String CODIGO_NOVALIDO = "El codigo debe ser mayor a 0";
    public static final String CODIGO_EXISTENTE = "El codigo ya existe";
    
}
