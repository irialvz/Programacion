/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja6.ejer2;

import ejercicios.UNIDAD7.hoja6.ejer2.excepciones.caracteresExcepcion;
import java.util.ArrayList;

/**
 *
 * @author iriia
 */
public class Cooperante {

    protected String nombre;
    protected String dni;
    protected String pais;

    public Cooperante(String nombre, String dni, String pais) throws caracteresExcepcion {
        if (nombre.isBlank()) {
            throw new caracteresExcepcion("El nombre no puede estar vacio");
        }
        if (!validarDni(dni)) {
            throw new caracteresExcepcion("El DNI no es valido");
        }
        if (pais.isBlank()){
            throw new caracteresExcepcion("El pais no puede estar vacio");
        }
        this.nombre = nombre;
        this.dni = dni;
        this.pais = pais;
    }

    public static boolean validarDni(String documentoIdentidad) {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Cooperante{" + "nombre=" + nombre + ", dni=" + dni + ", pais=" + pais + '}';
    }
    

}
