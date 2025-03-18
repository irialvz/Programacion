/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.ejerciciosTeresa.ejercicio5;

/**
 *
 * @author iriia
 */
public class Alumno {

    private String nombreApellidos;
    //private int numeroExpediente;
    private Calificacion[] calificaciones;

    public Alumno(String nombreApellidos, int numeroExpediente) {
        this.nombreApellidos = nombreApellidos;
     //   this.numeroExpediente = numeroExpediente;
        this.calificaciones = new Calificacion[6];
    }

    //Getters y Setter de nombreApellidos
    public String getNombreApellidos() {
        return nombreApellidos;
    }

    public void setNombreApellidos(String nombreApellidos) {
        this.nombreApellidos = nombreApellidos;
    }

    //Getter y Setter de calificaciones
    public Calificacion[] getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(Calificacion[] calificaciones) {
        this.calificaciones = calificaciones;
    }

    //metodos
    public boolean insertar(Calificacion calificacion) {
        for (int i = 0; i < calificaciones.length; i++) {
            if (calificaciones[i] == null) {
                calificaciones[i] = calificacion;
                return true;
            }
        }
        return false;
    }

    public Calificacion consultarMejorNota() {
        if (calificaciones == null || calificaciones.length == 0) {
            return null;
        }
        Calificacion mejorNota = calificaciones[0];
        for (int i = 1; i < calificaciones.length; i++) {
            if (calificaciones[i] != null && calificaciones[i].getCalificacion() > mejorNota.getCalificacion()) {
                mejorNota = calificaciones[i];
            }
        }
        return mejorNota;
    }

    public double consultarCalificacion(String modulo) {
        for (int i = 0; i < calificaciones.length; i++) {
            if (calificaciones[i] != null && calificaciones[i].getModulo().equalsIgnoreCase(modulo)) {
                return calificaciones[i].getCalificacion();
            }
        }
        return 0;

  }

}
