/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja7.ejer9;

import ejercicios.UNIDAD7.hoja7.ejer9.excepciones.codigoExcepcion;
import ejercicios.UNIDAD7.hoja7.ejer9.excepciones.nombreExcepcion;

/**
 *
 * @author Alumno
 */
public class Titular {
    private int codigo;
    private String nombre;

    public Titular(int codigo, String nombre,String numCuenta) throws codigoExcepcion, nombreExcepcion {
        if (codigo<0){
            throw new codigoExcepcion(codigoExcepcion.CODIGO_NOVALIDO);
        }
        if (nombre.isEmpty() || nombre == null){
            throw new nombreExcepcion(nombreExcepcion.NOMBRE_NOVALIDO);
        }
        this.codigo = codigo;
        this.nombre = nombre;
      
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Titular{" + "codigo=" + codigo + ", nombre=" + nombre + '}';
    }
    
    
    
    
}
