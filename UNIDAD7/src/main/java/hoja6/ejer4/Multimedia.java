/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja6.ejer4;

import ejercicios.UNIDAD7.hoja6.ejer4.excepciones.ejemplarExcepcion;
import ejercicios.UNIDAD7.hoja6.ejer4.excepciones.multimediaExcepcion;

/**
 *
 * @author iriia
 */
public class Multimedia extends Ejemplar {
    private String tipo;
    
    public Multimedia(int codigo, String titulo,String tipo) throws ejemplarExcepcion, multimediaExcepcion {
        super(codigo, titulo, 10);
        if (!tipo.equalsIgnoreCase("video") && !tipo.equalsIgnoreCase("cd") && !tipo.equalsIgnoreCase("dvd")){
            throw new multimediaExcepcion(multimediaExcepcion.TIPO_EXCEPCION);
        }
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Multimedia{" + super.toString() + "tipo=" + tipo + '}';
    }
    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
