/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.HojaInteraccionesClases.ejercicioAsociacion1;

/**
 *
 * @author Alumno
 */
public class Persona {
    private String nombre;
    private String apellidos;
    private String dni;
    private Coche cochePropio;
    
    public Persona (String nombre, String apellidos ,String dni){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }
    
    public void compraCoche (Coche coche){
              cochePropio = coche;
              coche.serPropietario(this);
    }
    public void usaCoche (double distancia, double velocidad){
        if (cochePropio != null){
            System.out.println("Posee coche");
            cochePropio.arrancarMotor();
            cochePropio.fijarVelocidad(velocidad);
            cochePropio.recorrerDistancia(distancia);
        } else {
            System.out.println("Error,no posee ningun coche");
        }
    }
    
    public Coche getCocheEnPropiedad(){
        return this.cochePropio;
    }
    public boolean poseeCoche(){
        if (cochePropio != null){
            return true;
        } else {
            return false;
        }
    }
    public void imprimirDatosPersonales(){
        System.out.println("{Nombre: " + nombre + ", apellidos: " + apellidos + 
                ", DNI: " + dni + ", coche propio: " + cochePropio + "]"); 
    }
}
