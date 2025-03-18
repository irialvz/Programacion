/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja7.ejer9.excepciones;

/**
 *
 * @author Alumno
 */
public class numCuentaExcepcion extends Exception{

    public numCuentaExcepcion() {
    }

    public numCuentaExcepcion(String message) {
        super(message);
    }
    public static final String CC_NOVALIDO = "La cc debe tener este formato: ES76 2077 0024 0031 0257 5766";
    public static final String CC_INEXISTENTE = "La cc no existe";
    
}
