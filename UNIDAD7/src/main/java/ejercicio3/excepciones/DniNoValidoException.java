/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.ejercicio3.excepciones;

/**
 *
 * @author Alumno
 */
public class DniNoValidoException extends BancoException {
    public DniNoValidoException(){
        
    }
    public DniNoValidoException(String mensaje) {
        super(mensaje);
    }
    public static final String DNI_NOVALIDO = ("DNI no valido");
    @Override
    public String toString() {
        return getMessage();
    }
}
