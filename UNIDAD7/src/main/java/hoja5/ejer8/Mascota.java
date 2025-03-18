/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja5.ejer8;

import ejercicios.UNIDAD7.hoja5.ejer8.excepciones.codClienteExcepcion;
import ejercicios.UNIDAD7.hoja5.ejer8.excepciones.edadExcepcion;
import ejercicios.UNIDAD7.hoja5.ejer8.excepciones.especieExcepcion;
import ejercicios.UNIDAD7.hoja5.ejer8.excepciones.nombreExcepcion;

/**
 *
 * @author iriia
 */
public class Mascota {

    private String nombre;
    private String codCliente;
    private String especie;
    private int edad;

    public Mascota(String nombre, String codCliente, String especie, int edad) throws nombreExcepcion, codClienteExcepcion, especieExcepcion, edadExcepcion {
        if (nombre.length() < 5 || nombre.length() > 25) {
            throw new nombreExcepcion(nombreExcepcion.CARACTERESNOMBRES);
        }
        if(!validarCodigo(codCliente)){
            throw new codClienteExcepcion(codClienteExcepcion.ERRORCOD);
        }
        if (!especie.equalsIgnoreCase("perro") && !especie.equalsIgnoreCase("gato") && !especie.equalsIgnoreCase("pez") && !especie.equalsIgnoreCase("pajaro")){
            throw new especieExcepcion(especieExcepcion.ERROR_ESPECIE);
        }
        if (edad < 0){
            throw new edadExcepcion (edadExcepcion.ERROR_EDAD);
        }

        this.nombre = nombre;
        this.codCliente = codCliente;
        this.especie = especie;
        this.edad = edad;
    }

    public static boolean validarCodigo(String codigo) {
        if (codigo.length() > 5){
            return false;
        }
        char primerCaracter = codigo.charAt(0);
        if (primerCaracter < 'A' || primerCaracter > 'Z'){
            return false;
        }
        for (int i = 1; i < 4; i++) {
            char caracter = codigo.charAt(i);
            if (caracter < '0' || caracter > '9') {
                return false;
            }
        }
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Mascota{" + "nombre=" + nombre + ", codCliente=" + codCliente + ", especie=" + especie + ", edad=" + edad + '}';
    }

    
}
