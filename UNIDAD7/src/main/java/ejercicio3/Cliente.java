/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.ejercicio3;

import ejercicios.UNIDAD7.ejercicio3.excepciones.ClienteSinCuentaException;
import ejercicios.UNIDAD7.ejercicio3.excepciones.CuentaBloqueadaException;
import ejercicios.UNIDAD7.ejercicio3.excepciones.DniNoValidoException;
import ejercicios.UNIDAD7.ejercicio3.excepciones.SaldoInsuficienteException;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
public class Cliente {

    protected String numeroDni;
    protected char letraDni;
    protected String nombre;
    protected String apellidos;
    private Cuenta cuenta;

    public Cliente(String numeroDni, char letraDni, String nombre, String apellidos) throws DniNoValidoException {
        if (!compruebaDni(numeroDni,letraDni)) {
            throw new DniNoValidoException(DniNoValidoException.DNI_NOVALIDO);
        }

        this.numeroDni = numeroDni;
        this.letraDni = letraDni;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public void ingresarDinero(double cantidad) throws ClienteSinCuentaException, CuentaBloqueadaException {
        if ( cuenta == null) {
            throw new ClienteSinCuentaException(ClienteSinCuentaException.EXCEPCION_SINCUENTA);
        }

        try {
            cuenta.ingresarDinero(cantidad);
        } catch (ejercicios.UNIDAD7.ejercicio3.excepciones.CuentaBloqueadaException ex) {
            throw new CuentaBloqueadaException(CuentaBloqueadaException.EXCEPCION_INGRESAR + CuentaBloqueadaException.EXCEPCION_BLOQUEADA);
        }
    }

    public void retirarDinero(double cantidad) throws ClienteSinCuentaException, CuentaBloqueadaException, SaldoInsuficienteException {
        if (!this.nombre.equalsIgnoreCase(cuenta.getTitular())) {
            throw new ClienteSinCuentaException(ClienteSinCuentaException.EXCEPCION_SINCUENTA);
        }

        try {
            cuenta.sacarDinero(cantidad);
        } catch (CuentaBloqueadaException ex) {
            throw new CuentaBloqueadaException(CuentaBloqueadaException.EXCEPCION_RETIRAR + CuentaBloqueadaException.EXCEPCION_BLOQUEADA);
        } catch (SaldoInsuficienteException ex) {
            throw new SaldoInsuficienteException(SaldoInsuficienteException.EXCEPCION_RETIRAR + SaldoInsuficienteException.EXCEPCION_INSUFICIENTE);
        }
    }

    public double consultarSaldo() throws ClienteSinCuentaException {
        if (cuenta == null) {
            throw new ClienteSinCuentaException(ClienteSinCuentaException.EXCEPCION_SINCUENTA);
        }
        return cuenta.getSaldo();
    }

    public String getDni() {
        return "DNI: " + this.numeroDni + this.letraDni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public boolean tieneCuentaAbierta() {
        return cuenta != null;

    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    private boolean compruebaDni(String num, char letra) {
        String tablaLetras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int i, calculo = 0, pos;

        // El número de cifras debe ser 8, si es  
        // menor se debe rellenar con ceros 
        if (num.length() != 8) {
            return false;
        } else {
            for (i = 0; i < 8; i++) {
                calculo = calculo * 10 + (num.charAt(i) - '0');
            }
            pos = calculo % 23;
            return tablaLetras.charAt(pos) == letra;
        }
    }


}
