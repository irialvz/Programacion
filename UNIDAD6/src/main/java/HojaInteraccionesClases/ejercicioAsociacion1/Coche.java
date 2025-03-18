/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.HojaInteraccionesClases.ejercicioAsociacion1;

/**
 *
 * @author Alumno
 */
public class Coche {

    //atributos independientes del estado
    private String matricula;
    private double maxLitrosDeposito;
    private double maxLitrosReserva;
    private double velocidadMaxima;
    private double consumoMedio100km;
    //atributos que definen el estado del coche
    private boolean motorArrancado;
    private boolean estaEnReserva;
    private double numLitrosActual;
    private double velocidadActual;
    private double kilometraje;
    private Persona propietario;

    public Coche(String matricula, double maxLitrosDeposito, double velocidadMaxima, double consumoMedio100km) {
        this.matricula = matricula;
        if (maxLitrosDeposito <= 0) {
            this.maxLitrosDeposito = 50;
        } else {
            this.maxLitrosDeposito = maxLitrosDeposito;
        }
        if (consumoMedio100km <= 0) {
            this.consumoMedio100km = 7.5;
        } else {
            this.consumoMedio100km = consumoMedio100km;
        }
        if (velocidadMaxima >= 0) {
            this.velocidadMaxima = velocidadMaxima;
        } else {
            this.velocidadMaxima = 180;

        }
    }

    public void setMatricula(String nuevaMatricula) {
        this.matricula = nuevaMatricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getMaxLitrosDeposito() {
        return maxLitrosDeposito;
    }

    public double getMaxLitrosReserva() {
        return maxLitrosReserva;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public double getConsumoMedio100km() {
        return consumoMedio100km;
    }

    public boolean isMotorArrancado() {
        return motorArrancado;
    }

    public boolean isEstaEnReserva() {
        return estaEnReserva;
    }

    public double getNumLitrosActual() {
        return numLitrosActual;
    }

    public double getVelocidadActual() {
        return velocidadActual;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void arrancarMotor() {
        if (motorArrancado == true) {
            System.out.println("El motor ya estaba arrancado");
        } else {
            System.out.println("El coche con matricula " + matricula + " ha arrancado");
            motorArrancado = true;
        }
        if (numLitrosActual == 0.0) {
            System.out.println("No queda combustible, imposible arrancar");
            motorArrancado = false;
        } else if (estaEnReserva) {
            System.out.println("El coche con matricula " + matricula + " esta en reserva de combustible");
            motorArrancado = true;

        }
    }

    public void pararMotor() {
        if (motorArrancado == false) {
            System.out.println("El motor ya estaba parado");
        } else {
            System.out.println("Se ha parado el motor");
            motorArrancado = false;
        }
    }

    public void repostar(double litros) {
        if (numLitrosActual + litros >= maxLitrosDeposito) {
            System.out.println("El coche con matricula " + matricula + " tiene " + numLitrosActual + " litros de combustible");
            System.out.println("El coche con matricula " + matricula + " ha rebosado el deposito");
            numLitrosActual = +litros;
            System.out.println("El coche con matricula " + matricula + " tiene " + numLitrosActual + " litros");

        } else if (litros <= 0) {
            numLitrosActual = numLitrosActual;
            System.out.println("El coche con matricula " + matricula + " tiene " + numLitrosActual + " litros");

        } else {
            System.out.println("El coche con matricula " + matricula + " tiene " + numLitrosActual + " litros");
            numLitrosActual = +litros;
            System.out.println("El coche con matricula " + matricula + " tiene " + numLitrosActual + " litros");
        }
    }

    public void fijarVelocidad(double velocidad) {
        if (motorArrancado == true) {
            velocidadActual = velocidad;
            System.out.println("La velocidad actual es de " + velocidadActual);
        } else {
            System.out.println("El motor no eseta arrancado, la velocidad es de " + velocidadActual);
        }
        if (velocidad > velocidadMaxima) {
            velocidad = velocidadMaxima;
            velocidadActual = velocidad;
            System.out.println("La velocidad actual es de " + velocidadActual);
        } else if (velocidad <= 0) {
            velocidad = 0;
            velocidadActual = velocidad;
            System.out.println("La velocidad actual es de " + velocidadActual);
        }
    }

    public void recorrerDistancia(double kilometros) {
        if (motorArrancado == false) {
            System.out.println("El motor no esta arrancado");
        } else if (motorArrancado == true && velocidadActual == 0) {
            System.out.println("La velocidad actual es de " + velocidadActual);
        } else if (kilometros <= 0) {
            System.out.println("El valor es negativo o igual a cero");
        }

        double consumoInstantaneo = consumoMedio100km * (1 + (velocidadActual - 100) / 100);
        double litrosNecesarios = kilometros * consumoInstantaneo / 100;

        if (motorArrancado == false) {
            System.out.println("El motor no esta arrancado");
        } else if (litrosNecesarios <= numLitrosActual) {
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


    public boolean poseePropietario() {
        if (propietario != null) {
            return true;
        } else {
            return false;
        }
    }

    public Persona getPropietario() {
        return this.propietario;
    }

    public void serPropietario(Persona persona) {
        this.propietario = persona;
    }
}
