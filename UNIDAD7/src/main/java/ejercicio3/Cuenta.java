/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.ejercicio3;

import ejercicios.UNIDAD7.ejercicio3.excepciones.ClienteSinCuentaException;
import ejercicios.UNIDAD7.ejercicio3.excepciones.CuentaBloqueadaException;
import ejercicios.UNIDAD7.ejercicio3.excepciones.SaldoInsuficienteException;


/**
 *
 * @author iriia
 */
public class Cuenta {

    private String numero;
    private String titular; //Titular deberia ser clase Cliente
    protected Sucursal sucursal;
    protected double saldo;
    protected boolean bloqueada;

    public Cuenta(String numero, String titular) {
        this.numero = numero;
        this.titular = titular;
    }

    public double getSaldo() { //consultarSaldo()
        return saldo;
    }

    public void ingresarDinero(double cantidad) throws CuentaBloqueadaException{
        if (bloqueada) {
            throw new CuentaBloqueadaException(CuentaBloqueadaException.EXCEPCION_INGRESAR + CuentaBloqueadaException.EXCEPCION_BLOQUEADA);
        } else {
            System.out.println("Añadiendo " + cantidad + " a la cuenta....");
            saldo = +cantidad;
        }
    }

    public void sacarDinero(double cantidad)  throws SaldoInsuficienteException,CuentaBloqueadaException{
        if (cantidad <= 0 || saldo < cantidad) {
            throw new SaldoInsuficienteException(SaldoInsuficienteException.EXCEPCION_RETIRAR + SaldoInsuficienteException.EXCEPCION_INSUFICIENTE);
        } else if (bloqueada) {
            throw new CuentaBloqueadaException(CuentaBloqueadaException.EXCEPCION_RETIRAR + CuentaBloqueadaException.EXCEPCION_BLOQUEADA);
        } else {
            System.out.println("Retirando " + cantidad + " de la cuenta");
            saldo = saldo - cantidad;
        }
    }

    public void cambioTitular(String nuevoTitular) throws CuentaBloqueadaException {
        if (bloqueada) {
            throw new CuentaBloqueadaException(CuentaBloqueadaException.EXCEPCION_BLOQUEADA);
        } else if (nuevoTitular.equals("") == true) {
            System.out.println("La cadena esta vacia");
        } else {
            this.titular = nuevoTitular;
        }
    }

     void bloquear() {
        if (bloqueada) {
            System.out.println("La cuenta ya estaba bloqueada");
        } else {
            System.out.println("bloqueando cuenta...");
            bloqueada = true;
        }
    }

    void desbloquear() {
        if (!bloqueada) {
            System.out.println("La cuenta no estaba bloqueda");
        } else {
            System.out.println("desbloqueando cuenta...");
            bloqueada = false;
        }
    }

    @Override
    public String toString() {
        return "[Numero de cuenta: " + numero + ", titular: " + titular + ", saldo: "
                + saldo + ", bloqueada: " + bloqueada + " ]";
    }

    public String getNumeroCuenta() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    Sucursal getSucursal() {
        return sucursal;
    }
    
}
