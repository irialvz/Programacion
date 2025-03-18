/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja7.ejer9;

import ejercicios.UNIDAD7.hoja7.ejer9.excepciones.codigoExcepcion;
import ejercicios.UNIDAD7.hoja7.ejer9.excepciones.listaExcepcion;
import ejercicios.UNIDAD7.hoja7.ejer9.excepciones.nombreExcepcion;
import ejercicios.UNIDAD7.hoja7.ejer9.excepciones.numCuentaExcepcion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Alumno
 */
public class CuentaCorriente {

    public String numCuenta;
    private double saldo;
    private static List<Titular> listaTitular = new ArrayList<>();
    private static List<CuentaCorriente> listaCc = new ArrayList<>();
    private int numeroTitulares;

    public CuentaCorriente(String numCuenta, double saldo) throws numCuentaExcepcion {
        if (!validarNumCuenta(numCuenta)) {
            throw new numCuentaExcepcion(numCuentaExcepcion.CC_NOVALIDO);
        }
        this.numCuenta = numCuenta;
        this.saldo = saldo;
        this.listaTitular = new ArrayList<>(10);
        this.numeroTitulares = 0;
    }

    public static boolean validarNumCuenta(String numCuenta) {
        if (numCuenta.length() != 24) {
            return false;
        }
        if ((numCuenta.charAt(0) < 'A' || numCuenta.charAt(0) > 'Z') || 
            (numCuenta.charAt(1) < 'A' || numCuenta.charAt(1) > 'Z')) {
            return false;
        }
        for (int i = 2; i < 24; i++) {
            char caracter = numCuenta.charAt(i);
            if (caracter < '0' || caracter > '9') return false;
        }
        return true;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "CuentaCorriente{" + 
                "numCuenta=" + numCuenta + 
                ", saldo=" + saldo + 
                '}';
    }

    public void altaTitular(Titular titular) throws numCuentaExcepcion, codigoExcepcion, nombreExcepcion {
        if (numeroTitulares >= 10) {
            throw new codigoExcepcion("El numero de titulares es 10 o más");
        }
        for (int i = 0; i < numeroTitulares; i++) {
            if (listaTitular.get(i).getCodigo() == titular.getCodigo()) {
                throw new codigoExcepcion(codigoExcepcion.CODIGO_EXISTENTE);
            }
        }
        listaTitular.add(titular);
        numeroTitulares++;
    }

    public String mostrarListadoCc() throws listaExcepcion {
        if (listaCc.isEmpty()) {
            throw new listaExcepcion(listaExcepcion.LISTADO_VACIO);
        }
        listaCc.sort((o1, o2) -> {
            if (o2.getSaldo() < o1.getSaldo()) {
                return -1;
            }
            if (o1.getSaldo() == o2.getSaldo()) {
                return o1.getNumCuenta().compareTo(o2.getNumCuenta());
            } else {
                return 1;
            }
        });
        return listaCc.toString();
    }

    public String mostrarListadoTitulares() throws listaExcepcion {
        if (listaTitular.isEmpty()) {
            throw new listaExcepcion(listaExcepcion.LISTADO_VACIO);
        }
        return listaTitular.toString();
    }
}

