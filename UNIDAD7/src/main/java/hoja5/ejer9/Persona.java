/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja5.ejer9;

import ejercicios.UNIDAD7.hoja5.ejer9.excepciones.nombreExcepcion;
import ejercicios.UNIDAD7.hoja5.ejer9.excepciones.ciudadExcepcion;
import ejercicios.UNIDAD7.hoja5.ejer9.excepciones.codPostalExcepcion;
import ejercicios.UNIDAD7.hoja5.ejer9.excepciones.docIdentidadExcepcion;
import ejercicios.UNIDAD7.hoja5.ejer9.excepciones.fechaExcepcion;

/**
 *
 * @author Alumno
 */
public class Persona {

    private String nombre;
    private String ciudad;
    private String codigoPostal;
    private String documentoIdentidad;
    private Fecha fechaNacimiento;

    public Persona(String nombre, String ciudad, String codigoPostal, String documentoIdentidad, int dia, int mes, int anyo) throws nombreExcepcion, ciudadExcepcion, codPostalExcepcion, docIdentidadExcepcion, fechaExcepcion {
        if (nombre.length() < 0 || nombre.length() > 25) {
            throw new nombreExcepcion(nombreExcepcion.ERROR_CARACTERES);
        }
        if (ciudad.length() < 0 || ciudad.length() > 25) {
            throw new ciudadExcepcion(ciudadExcepcion.ERROR_CARACTERES);
        }
        if (!validarCodigoPostal(codigoPostal)) {
            throw new codPostalExcepcion(codPostalExcepcion.ERROR_DIGITOS);
        }
        if (!validarDni(documentoIdentidad)) {
            throw new docIdentidadExcepcion(docIdentidadExcepcion.ERROR_VALIDACION);
        }
        try {
            this.fechaNacimiento = new Fecha(dia, mes, anyo);
        } catch (IllegalArgumentException e) {
            throw new fechaExcepcion(fechaExcepcion.ERROR_FECHA);
        }

        this.nombre = nombre;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.documentoIdentidad = documentoIdentidad;

    }

    public static boolean validarCodigoPostal(String codigoPostal) {
        if (codigoPostal.length() != 5) {
            return false;
        }
        if (codigoPostal.isEmpty()) {
            return false;
        }

        for (int i = 0; i < codigoPostal.length(); i++) {
            char caracter = codigoPostal.charAt(i);
            if (caracter < '0' || caracter > '9') {
                return false;
            }
        }
        return true;

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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", ciudad=" + ciudad + ", codigoPostal=" + codigoPostal + ", documentoIdentidad=" + documentoIdentidad + ", fechaNacimiento=" + fechaNacimiento + '}';
    }

    
}
