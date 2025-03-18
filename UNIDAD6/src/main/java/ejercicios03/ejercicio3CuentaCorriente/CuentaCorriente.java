/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.ejercicios03.ejercicio3CuentaCorriente;

import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class CuentaCorriente {

    private String numCuenta;
    private double saldo;

    public CuentaCorriente(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public void ingresaEfectivo(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("Imposible ingresar esa cantidad");
        } else {
            saldo = +cantidad;
            System.out.println("Ingresando " + cantidad + " euros...");
            System.out.println("Nuevo saldo: " + saldo);
        }
    }

    public boolean retiraEfectivo(double cantidad) {
        if (saldo > cantidad) {
            System.out.println("Retirando dinero...");
            saldo -=cantidad;
            return true;
        } else {
            System.out.println("No hay suficiente dinero en la cuenta");
            return false;
        }
    }

    public String toString() { // visualiza()
        return "[Numero de cuenta " + numCuenta + ", saldo " + saldo + "]";
    }
}
