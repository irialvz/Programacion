/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.HojaInteraccionesClases.ClaseAbstracta;

/**
 *
 * @author Alumno
 */
public abstract class Vehiculo {
    //atributos independientes del estado
    protected String matricula;
    protected double maxLitrosDeposito;
    protected double maxLitrosReserva;
    protected double velocidadMaxima;
    protected double consumoMedio100km;
    //atributos que definen el estado del coche
    protected boolean motorArrancado;
    protected boolean estaEnReserva;
    protected double numLitrosActual;
    protected double velocidadActual;
    protected double kilometraje;
    protected Persona propietario;
    
    public Vehiculo (String matricula, double maxLitrosDeposito,double consumoMedio, 
            double velocidadMax){
                this.matricula = matricula;
        if (maxLitrosDeposito <= 0) {
            this.maxLitrosDeposito = 50;
        } else {
            this.maxLitrosDeposito = maxLitrosDeposito;
        }
        if (consumoMedio100km <= 0) {
            this.consumoMedio100km = 7.5;
        } else {
            this.consumoMedio100km = consumoMedio;
        }
        if (velocidadMaxima >= 0) {
            this.velocidadMaxima = velocidadMax;
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
        } else if (!motorArrancado) {
            System.out.println("El vehiculo con matricula " + matricula + " ha arrancado");
            motorArrancado = true;
        } else if (numLitrosActual == 0.0) {
            System.out.println("No queda combustible, imposible arrancar");
            motorArrancado = false;
        } else if (estaEnReserva) {
            System.out.println("El vehiculo con matricula " + matricula + " esta en reserva de combustible");
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
            System.out.println("El vehiculo con matricula " + matricula + " tiene " + numLitrosActual + " litros de combustible");
            System.out.println("El vehiculo con matricula " + matricula + " ha rebosado el deposito");
            numLitrosActual = +litros;
            System.out.println("El vehiculo con matricula " + matricula + " tiene " + numLitrosActual + " litros");

        } else if (litros <= 0) {
            numLitrosActual = numLitrosActual;
            System.out.println("El vehiculo con matricula " + matricula + " tiene " + numLitrosActual + " litros");

        } else {
            System.out.println("El vehiculo con matricula " + matricula + " tiene " + numLitrosActual + " litros");
            numLitrosActual = +litros;
            System.out.println("El vehiculo con matricula " + matricula + " tiene " + numLitrosActual + " litros");
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

    /**
     *
     * @param kilometros
     */
    public abstract void recorrerDistancia(double kilometros);

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
