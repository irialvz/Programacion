/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.ejercicio3;

import ejercicios.UNIDAD7.ejercicio3.excepciones.CuentaException;
import java.util.Vector;

/**
 *
 * @author Alumno
 */
public class Sucursal {

    private String nombre;
    private String direccion;
    private Vector cuentas;
    //La clase Vector es como una tabla capaz de redimensionarse
    private int ultimoNumCuenta;
    //Representa el ult. num cuenta usado

    public Sucursal(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.ultimoNumCuenta = 0;
        cuentas = new Vector();
    }

    public void bloquearCuenta(Cuenta c) {
        c.bloquear();
    }

    public void desbloquearCuenta(Cuenta c) {
        c.desbloquear();
    }

    public void abrirCuenta(Cliente cli) throws CuentaException {
        if (!cli.tieneCuentaAbierta()) {
            throw new CuentaException(CuentaException.ERROR_ABRIRCUENTA + CuentaException.ERROR_ABRIRREPE);
        }
        ultimoNumCuenta++;
        String numeroDeCuenta = String.valueOf(ultimoNumCuenta);

        Cuenta newCuenta = new Cuenta(numeroDeCuenta, cli.nombre);
        cli.setCuenta(newCuenta);
        cuentas.add(newCuenta);
    }

    public void cerrarCuenta(Cliente cli) throws CuentaException {
        if (!cli.tieneCuentaAbierta()) {
            throw new CuentaException(CuentaException.ERROR_CERRARCUENTA + CuentaException.ERROR_CERRAR);
        }
        Cuenta c = cli.getCuenta();
        cli.setCuenta(null);
        cuentas.add(c);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

}
