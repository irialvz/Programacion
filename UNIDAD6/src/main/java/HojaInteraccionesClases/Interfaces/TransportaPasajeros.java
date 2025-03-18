/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ejercicios.UNIDAD6.HojaInteraccionesClases.Interfaces;

/**
 *
 * @author iriia
 */
public interface TransportaPasajeros {
    public boolean subirPasajero (Persona p);
    public boolean bajarPasajero (Persona p);
    public Persona[] getEstadoOcupacion ();
    public int getNumActualPasajeros ();
    public int getNumMaximoPasajeros ();
    public int getNumPlazasLibres ();
}
