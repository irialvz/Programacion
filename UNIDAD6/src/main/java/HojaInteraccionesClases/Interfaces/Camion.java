/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.HojaInteraccionesClases.Interfaces;


/**
 *
 * @author Alumno
 */
public class Camion extends Vehiculo {

    protected double kilosMaxCarga;
    protected double kilosCargaActual;

    public Camion(String matricula, double maxLitrosDeposito, double consumoMedio, 
            double velocidadMax,double cargaMaxima) {
        super(matricula, maxLitrosDeposito, consumoMedio, velocidadMax);
        kilosMaxCarga = cargaMaxima;
    }

    @Override
    public void recorrerDistancia(double kilometros) {
        if (motorArrancado == false) {
            System.out.println("El motor del camion no esta arrancado");
        } else if (motorArrancado == true && velocidadActual == 0) {
            System.out.println("La velocidad actual del camion es de " + velocidadActual);
        } else if (kilometros <= 0) {
            System.out.println("El valor es negativo o igual a cero");
        }

    double factorCarga = 2 - ((kilosMaxCarga - kilosCargaActual) / kilosMaxCarga);
    double consumoInstantaneo = factorCarga * consumoMedio100km * (1 + (velocidadActual - 100) / 100);

    double litrosNecesarios = kilometros * consumoInstantaneo / 100;

        if (litrosNecesarios <= numLitrosActual) {
            numLitrosActual -= litrosNecesarios;
            kilometraje = kilometros;
            System.out.println("El camion con matricula " + matricula + " ha recorrido " + kilometraje + " kilometros");
            if (numLitrosActual <= maxLitrosReserva) {
                estaEnReserva = true;
                System.out.println("El camion con matricula " + matricula + " esta en reserva");
            }
        } else {
            double distanciaReal = 100 * numLitrosActual / consumoInstantaneo;
            kilometraje = +distanciaReal;
            numLitrosActual = 0;
            estaEnReserva = true;

            System.out.println("El camion con matricula " + matricula + " ha recorrido " + kilometraje);
            System.out.println("El camion con matricula " + matricula + " esta sin combustible");
            System.out.println("El camion con matricula " + matricula + " esta parado");
        }
    }

    public void carga(double kilos) {
        if (kilos <= 0) {
            System.out.println("Cantidad de kilos no validos");
        } else if (kilosCargaActual + kilos > kilosMaxCarga) {
            System.out.println("Maximo de carga superado, no se puede exceder");
        } else if (velocidadActual > 0) {
            System.out.println("El camion debe estar parado para poder cargarlo o descargarlo");
        } else {
            System.out.println("Cargando " + kilos + " kilos en la carga de " + kilosCargaActual+ " kilos");
            kilosCargaActual += kilos;
        }
    }

    public void descarga(double kilos) {
        if (kilos <= 0) {
            System.out.println("Cantidad de kilos no validos");
        } else if (kilos > kilosMaxCarga) {
            System.out.println("Maximo de carga superado, no se puede exceder");
        } else if (velocidadActual > 0) {
            System.out.println("El camion debe estar parado para poder cargarlo o descargarlo");
        } else {
            System.out.println("Descargando " + kilos + " kilos de la carga de " + kilosCargaActual +" kilos");
            kilosCargaActual -= kilos;
        }
    }

    public double getKilosCargaActual() {
        return kilosCargaActual;
    }
    
}
