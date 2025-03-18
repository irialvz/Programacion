/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.HojaInteraccionesClases.ClaseAbstracta;

/**
 *
 * @author Alumno
 */
public class Persona {

    private String nombre;
    private String apellidos;
    private String dni;
    private Coche coches[];
    private int numCochesActual;
    private int cocheEnUso;

    public Persona(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.coches = new Coche[10];

    }

    public void compraCoche(Coche coche) {
        if (numCochesActual < coches.length) { //comprobar que entran los coches
            coches[numCochesActual] = coche;
            //coche.serPropietario(this);
            numCochesActual++;
        } else {
            System.out.println("Error: no se pueden tener mas de " + coches.length + " coches");
        }

    }

    public void eligeCocheEnUso(int numero) {
        if (numero >= 0 && numero <= numCochesActual) {
            cocheEnUso = numero;
            System.out.println("Coche seleccionado " + coches[cocheEnUso].getMatricula());
        } else {
            System.out.println("Error: num coche invalido");
        }
    }

    public void usaCoche(double distancia, double velocidad) {
        if (cocheEnUso >= 0 && cocheEnUso < numCochesActual) {
            Coche cocheActual = coches[cocheEnUso];
            coches[cocheEnUso].arrancarMotor();
            coches[cocheEnUso].fijarVelocidad(velocidad);
            coches[cocheEnUso].recorrerDistancia(distancia);
        } else {
            System.out.println("Error,no posee ningun coche");
        }
    }

    public Coche getCoches() {
     /*  if (cocheEnUso >= 0 && cocheEnUso < numCochesActual) {*/
            return this.coches[cocheEnUso];
       /* } else {
            System.out.println("Error,no posee ningun coche");
            return null;
        }*/
    }

    public boolean poseeCoche() {
        return numCochesActual > 0; //si es mayor que 0 devuelve true
    }

    public void imprimirDatosPersonales() {
        System.out.println("{Nombre: " + nombre + ", apellidos: " + apellidos
                + ", DNI: " + dni + "]");
        if (numCochesActual > 0){
            System.out.println("Coches propios: ");
            for (int i = 0; i < numCochesActual;i++){
                System.out.println("Matricula " + coches[i].getMatricula());
            }
        } else {
            System.out.println("No tiene coche brum brum");
        }
    }
}
