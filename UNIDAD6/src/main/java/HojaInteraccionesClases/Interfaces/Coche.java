/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.HojaInteraccionesClases.Interfaces;


/**
 *
 * @author Alumno
 */
public class Coche extends Vehiculo{
    public Coche(String matricula, double maxLitrosDeposito, double consumoMedio, double velocidadMax) {
        super(matricula, maxLitrosDeposito, consumoMedio, velocidadMax);
    }
    @Override
    public void recorrerDistancia(double kilometros) {
        if (motorArrancado == false) {
            System.out.println("El motor del coche no esta arrancado");
        } else if (motorArrancado == true && velocidadActual == 0) {
            System.out.println("La velocidad actual  del coche es de " + velocidadActual);
        } else if (kilometros <= 0) {
            System.out.println("El valor es negativo o igual a cero");
        }

        double consumoInstantaneo = consumoMedio100km * (1 + (velocidadActual - 100) / 100);
        double litrosNecesarios = kilometros * consumoInstantaneo / 100;

        if (litrosNecesarios <= numLitrosActual) {
            numLitrosActual -= litrosNecesarios;
            kilometraje = kilometros;
            System.out.println("El coche con matricula " + matricula + " ha recorrido " + kilometraje + " kilometros");
            if (numLitrosActual <= maxLitrosReserva) {
                estaEnReserva = true;
                System.out.println("El coche con matricula " + matricula + " esta en reserva");
            }
        }else {
            double distanciaReal = 100 * numLitrosActual / consumoInstantaneo;
            kilometraje = +distanciaReal;
            numLitrosActual = 0;
            estaEnReserva = true;

            System.out.println("El coche con matricula " + matricula + " ha recorrido " + kilometraje);
            System.out.println("El coche con matricula " + matricula + " esta sin combustible");
            System.out.println("El coche con matricula " + matricula + " esta parado");
        }
    }
}
