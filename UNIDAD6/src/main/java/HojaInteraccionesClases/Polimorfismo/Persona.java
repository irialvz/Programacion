/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.HojaInteraccionesClases.Polimorfismo;

/**
 *
 * @author Alumno
 */
public class Persona {

    private String nombre;
    private String apellidos;
    private String dni;
    private Vehiculo vehiculos[];
    private int numVehiculosActual;
    private int vehiculoEnUso;

    public Persona(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.vehiculos = new Vehiculo[10];

    }

    public void compraVehiculo(Vehiculo coche) {
        if (numVehiculosActual < vehiculos.length) { //comprobar que entran los coches
            vehiculos[numVehiculosActual] = coche;
            coche.serPropietario(this);
            numVehiculosActual++;
        } else {
            System.out.println("Error: no se pueden tener mas de " + vehiculos.length + " coches");
        }

    }

    public void eligeVehiculoEnUso(int numero) {
        if (numero >= 0 && numero <= numVehiculosActual) {
            vehiculoEnUso = numero;
            System.out.println("Coche seleccionado " + vehiculos[vehiculoEnUso].getMatricula());
        } else {
            System.out.println("Error: num coche invalido");
        }
    }

    public void usaVehiculo(double distancia, double velocidad) {
        if (vehiculoEnUso >= 0 && vehiculoEnUso < numVehiculosActual) {
            Vehiculo vehiculoActual = vehiculos[vehiculoEnUso];
            if (vehiculoActual instanceof Coche) {
                Coche cocheActual = (Coche) vehiculoActual;
                cocheActual.arrancarMotor();
                cocheActual.fijarVelocidad(velocidad);
                cocheActual.recorrerDistancia(distancia);
            } else if (vehiculoActual instanceof Camion){
                Camion camionActual = (Camion) vehiculoActual;
                camionActual.arrancarMotor();
                camionActual.fijarVelocidad(velocidad);
                camionActual.recorrerDistancia(distancia);                
            }

        } else {
            System.out.println("Error,no posee ningun coche");
        }
    }

    public Coche getCoches() {
        /*  if (cocheEnUso >= 0 && cocheEnUso < numCochesActual) {*/
        return (Coche) this.vehiculos[vehiculoEnUso];
        /* } else {
            System.out.println("Error,no posee ningun coche");
            return null;
        }*/
    }

    public boolean poseeCoche() {
        return numVehiculosActual > 0; //si es mayor que 0 devuelve true
    }

    public String getDni() {
        return this.dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void imprimirDatosPersonales() {
        System.out.println("{Nombre: " + nombre + ", apellidos: " + apellidos
                + ", DNI: " + dni + "]");
        if (numVehiculosActual > 0) {
            System.out.println("Coches propios: ");
            for (int i = 0; i < numVehiculosActual; i++) {
                System.out.println("Matricula " + vehiculos[i].getMatricula());
            }
        } else {
            System.out.println("No tiene coche brum brum");
        }
    }
}
