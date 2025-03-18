/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja5.Ejer5;

import ejercicios.UNIDAD7.hoja5.Ejer5.excepciones.restricciones;

/**
 *
 * @author Alumno
 */
public class Datos {

    public int cantidad;
    public String palabra;
    public float peso;

    public Datos(int cantidad, String palabra, float peso) throws restricciones {
        if (cantidad < 0 || cantidad == 0) {
            throw new restricciones(restricciones.ERROR_CANTIDAD);
        }
        if (peso < 12 || peso > 25) {
            throw new restricciones(restricciones.ERROR_PESO);
        }
        if (palabra == null || palabra.length() < 10) {
            throw new restricciones(restricciones.ERROR_PALABRA);
        }
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == '$') {
                throw new restricciones(restricciones.ERROR_PALABRA);
            }
        }
        
        this.cantidad = cantidad;
        this.palabra = palabra;
        this.peso = peso;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
    
    
}
