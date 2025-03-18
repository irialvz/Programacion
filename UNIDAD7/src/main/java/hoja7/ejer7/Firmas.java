/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja7.ejer7;

import ejercicios.UNIDAD7.hoja7.ejer7.excepciones.dni_excepcion;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iriia
 */
public class Firmas {

    private String nombre;
    private String apellido;
    private String dni;
    private ArrayList<Firmas> arrayFirmas = new ArrayList<Firmas>();

    public Firmas(String nombre, String apellido, String dni) throws dni_excepcion {
        if (dni.isEmpty()) {
            mostrarColeccion();
            throw new dni_excepcion(dni_excepcion.DNI_NOVALIDO);
        }
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Firmas{" + "dni=" + dni + '}';
    }

    private static boolean validarDni(String documentoIdentidad) {
        if (documentoIdentidad.length() != 9) {
            return false;
        }
        if (documentoIdentidad.isEmpty()) {
            return false;
        }

        for (int i = 0; i < 7; i++) {
            char caracter = documentoIdentidad.charAt(i);
            if (caracter < '0' || caracter > '9') {
                return false;
            }
        }
        if (documentoIdentidad.charAt(8) < 'A' || documentoIdentidad.charAt(8) > 'Z') {
            return false;
        }
        return true;

    }

    public String mostrarColeccion() {
        if (arrayFirmas.isEmpty()){
            return "La coleccion esta vacia";
        }
        return arrayFirmas.toString();
    }

    public void guardarColeccion(String nombre, String apellido, String dni) throws dni_excepcion {
        for (int i = 0; i < arrayFirmas.size(); i++) {
            if (arrayFirmas.get(i).dni.equals(dni)) {
                throw new dni_excepcion(dni_excepcion.DNI_REPETIDO);
            }
        }
        if (validarDni(dni)) {
            arrayFirmas.add(new Firmas(nombre, apellido, dni));

        }
    }

}
