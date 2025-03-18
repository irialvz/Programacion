/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.ejercicio2;


/**
 *
 * @author iriia
 */
public class Cuenta {

    public String numero;
    public String titular;
    protected double saldo;
    protected boolean bloqueada;

    public Cuenta(String numero, String titular) {
        this.numero = numero;
        this.titular = titular;
    }

    public double getSaldo() { //consultarSaldo()
        return saldo;
    }

    public void ingresarDinero(double cantidad) throws SaldoInsuficienteException,CuentaBloqueadaException{
        if (cantidad <= 0) {
            throw new SaldoInsuficienteException();
        } else if (bloqueada) {
            throw new CuentaBloqueadaException();
        } else {
            System.out.println("Añadiendo " + cantidad + " a la cuenta....");
            saldo = +cantidad;
        }
    }

    public void sacarDinero(double cantidad)  throws SaldoInsuficienteException,CuentaBloqueadaException{
        if (cantidad <= 0 || saldo < cantidad) {
            throw new SaldoInsuficienteException();
        } else if (bloqueada) {
            throw new CuentaBloqueadaException();
        } else {
            System.out.println("Retirando " + cantidad + " de la cuenta");
            saldo = saldo - cantidad;
        }
    }

    public void cambioTitular(String nuevoTitular) {
        if (bloqueada) {
            System.out.println("La cuenta esta bloqueada");
        } else if (nuevoTitular.equals("") == true) {
            System.out.println("La cadena esta vacia");
        } else {
            this.titular = nuevoTitular;
        }
    }

    public void bloquear() {
        if (bloqueada) {
            System.out.println("La cuenta ya estaba bloqueada");
        } else {
            System.out.println("bloqueando cuenta...");
            bloqueada = true;
        }
    }

    public void desbloquear() {
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
}
