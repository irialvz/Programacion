/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.HojaPolimorfismoTeresa.act2;

import java.util.Random;

/**
 *
 * @author iriia
 */
public class Refresco extends Bebida {

    private boolean tieneGas;
    private double cantAzucar;

    private static final String[] NOMBRES = {
        "limonada",
        "cola",
        "gaseosa",
        "té helado",
        "granizado",
        "ponche"
    };

    private static String generarNombres() {
        int i = new Random().nextInt(NOMBRES.length);
        return NOMBRES[i];
    }

    private static double generarAzucar() {
        return new Random().nextDouble() * ((35.0 - 4.0 + 1) + 4.0);
    }

    public Refresco(String nombre, boolean tieneGas, double cantAzucar) {
        super(generarNombres());
        this.cantAzucar = generarAzucar();
        this.tieneGas = new Random().nextBoolean();
    }

    @Override
    public double calcularPrecio() {
        return 1 + (cantAzucar / 10);
    }

    @Override
    public String toString() {
        return "Refresco{" + super.toString() + ", tieneGas=" + tieneGas + ", cantAzucar=" + cantAzucar + '}';
    }

}
