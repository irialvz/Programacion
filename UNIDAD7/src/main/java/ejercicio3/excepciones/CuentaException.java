/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.ejercicio3.excepciones;


/**
 *
 * @author iriia
 */
public class CuentaException extends BancoException{
    public CuentaException(){
        
    }
    public CuentaException(String mensaje) {
        super(mensaje);
    }
    public static final String ERROR_ABRIRCUENTA = "Error al abrir cuenta; ";
    public static final String ERROR_CERRARCUENTA = "Error al cerrar cuenta; ";
    public static final String ERROR_ABRIRREPE = "Ya existe el propietario de la cuenta ";
    public static final String ERROR_CERRAR = "No existe el propietario de la cuenta ";

    @Override
    public String toString() {
        return getMessage();
    }
    
    
}
