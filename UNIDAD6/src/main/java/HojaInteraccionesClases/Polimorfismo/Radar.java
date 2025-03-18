/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.HojaInteraccionesClases.Polimorfismo;

/**
 *
 * @author Alumno
 */
public class Radar {
    private double velocidadLimite ;
    private String ubicacion;
    
    public Radar (String ubicacion, double velocidadLimite) {
        this.ubicacion = ubicacion;
        if (velocidadLimite >= 0){
            this.velocidadLimite = velocidadLimite;
        } else {
            this.velocidadLimite = 100;
        }
    }
    
    public void pasaVehiculo (Vehiculo v){
        if (v.velocidadActual > velocidadLimite + 15){
            imponeMulta(v);
        }
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    private void imponeMulta (Vehiculo v) {
        System.out.println("Velocidad maxima permitida de ubicacion" + velocidadLimite + " km/h");
        System.out.println("Velocidad del vehiculo " + v.matricula + ": " + v.velocidadActual + " km/h");
        System.out.println("Se sanciona al propietario " + v.getPropietario().getNombre() + v.getPropietario().getApellidos() + v.getPropietario().getDni());
    }
}
