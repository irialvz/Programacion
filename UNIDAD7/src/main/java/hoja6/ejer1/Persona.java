/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja6.ejer1;

import ejercicios.UNIDAD7.hoja6.ejer1.excepciones.caracteresExcepcion;

/**
 *
 * @author Alumno
 */
public abstract class Persona {

    protected String nombre;
    protected String apellido;
    protected int edad;
    //protected String dni;
    protected String ciudad;

    public Persona(String nombre, String apellido, int edad,/* String dni, */String ciudad) throws caracteresExcepcion {
        if (nombre.isBlank()) {
            throw new caracteresExcepcion("El nombre debe haber mas de 1 caracter");
        }
        if (apellido.isBlank()) {
            throw new caracteresExcepcion("El apellido debe haber mas de 1 caracter");
        }
        if (edad < 0) {
            throw new caracteresExcepcion("La edad debe ser mayor a 0");
        }
        /*
        if (dni.length() != 9) {
            throw new caracteresExcepcion("El dni debe tener 9 caracteres");
        }*/
        if (ciudad.isBlank()) {
            throw new caracteresExcepcion("La ciudad debe tener mas de 1 caracter");
        }
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
      //  this.dni = dni;
        this.ciudad = ciudad;
    }

    public abstract void prosperar(float cantidad);
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
/*
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
*/
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", ciudad=" + ciudad + '}';
    }
    

}
