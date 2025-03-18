/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.ejercicio3.excepciones;

/**
 *
 * @author Alumno
 */
public class SaldoInsuficienteException extends CuentaException {

    public SaldoInsuficienteException() {

    }

    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }
    public static final String EXCEPCION_INSERTAR = "Error al insertar usuario:";
    public static final String EXCEPCION_RETIRAR = "Error al retirar dinero:";
    public static final String EXCEPCION_INGRESAR = "Error al ingresar dinero:";
    public static final String EXCEPCION_INSUFICIENTE = " El saldo es insuficiente";

    @Override
    public String toString() {
        return getMessage();
    }
}
