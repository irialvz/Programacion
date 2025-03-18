/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.HojaInteraccionesClases.Interfaces;

/**
 *
 * @author iriia
 */
public class Autobus extends Vehiculo implements TransportaPasajeros {

    private int numPlazas;
    private int numPasajerosActual;
    private Persona asientos[];

    public Autobus(String matricula, double maxLitrosDeposito, double consumoMedio, double velocidadMax, int numPlazas) {
        super(matricula, maxLitrosDeposito, consumoMedio, velocidadMax);
        if (numPlazas > 0) {
            this.numPlazas = numPlazas;
            asientos = new Persona[numPlazas];
        } else {
            this.numPlazas = 10;
            asientos = new Persona[numPlazas];
        }
    }

    @Override
    public void recorrerDistancia(double kilometros) {
        if (motorArrancado == false) {
            System.out.println("El motor del autobus no esta arrancado");
        } else if (motorArrancado == true && velocidadActual == 0) {
            System.out.println("La velocidad actual del autobus es de " + velocidadActual);
        } else if (kilometros <= 0) {
            System.out.println("El valor es negativo o igual a cero");
        }

        double factorCarga = 2 - ((numPlazas - numPasajerosActual) / numPlazas);
        double consumoInstantaneo = factorCarga * consumoMedio100km * (1 + (velocidadActual - 100) / 100);

        double litrosNecesarios = kilometros * consumoInstantaneo / 100;

        if (litrosNecesarios <= numLitrosActual) {
            numLitrosActual -= litrosNecesarios;
            kilometraje = kilometros;
            System.out.println("El autobus con matricula " + matricula + " ha recorrido " + kilometraje + " kilometros");
            if (numLitrosActual <= maxLitrosReserva) {
                estaEnReserva = true;
                System.out.println("El autobus con matricula " + matricula + " esta en reserva");
            }
        } else {
            double distanciaReal = 100 * numLitrosActual / consumoInstantaneo;
            kilometraje = +distanciaReal;
            numLitrosActual = 0;
            estaEnReserva = true;

            System.out.println("El autobus con matricula " + matricula + " ha recorrido " + kilometraje);
            System.out.println("El autobus con matricula " + matricula + " esta sin combustible");
            System.out.println("El autobus con matricula " + matricula + " esta parado");
        }
    }

    @Override
    public boolean subirPasajero(Persona p) {
        if (velocidadActual == 0 && numPasajerosActual < numPlazas) {
            for (int i = 0; i < asientos.length; i++) {
                if (asientos[i] == null) {
                    asientos[i] = p;
                    numPasajerosActual++;
                    System.out.println("El pasajero " + p.getNombre() + " " + p.getApellidos() + " se ha subido al autobus");
                    return true;
                }
            }
        } else {
            System.out.println("El autobus esta completo, no puede subir la persona");
        }
        return false;
    }

    @Override
    public boolean bajarPasajero(Persona p) {
        if (velocidadActual == 0 && numPasajerosActual > 0) {
            for (int i = 0; i < asientos.length; i++) {
                if (asientos[i] != null && asientos[i].equals(p)) {
                    asientos[i] = null;
                    numPasajerosActual--;
                    System.out.println("El pasajero " + p.getNombre() + " " + p.getApellidos() + " se ha bajado del autobus");
                    return true;
                }
            }
            System.out.println("El pasajero no esta en el autobus");
        } else {
            System.out.println("El autobus esta vacio, no puede bajar nadie");
        }
        return false;
    }

    @Override
    public Persona[] getEstadoOcupacion() {
        return asientos;
    }

    @Override
    public int getNumActualPasajeros() {
        return numPlazas;
    }

    @Override
    public int getNumMaximoPasajeros() {
        return numPasajerosActual;
    }

    @Override
    public int getNumPlazasLibres() {
        return numPlazas - numPasajerosActual;
    }

}
