/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.pruebaExcepciones.teresa.actividad2x01;

/**
 *
 * @author Alumno
 */
public class Usuario {

    protected String nombre;
    protected String contrasenia;
    protected int numPuntos;

    public Usuario(String nombre, String contrasenia, int numPuntos) {
        if (contrasenia.length() < 6 || contrasenia.length() > 20) {
            throw new ExcepcionUsuario(ExcepcionUsuario.EXCEPCION_CARACTERES);
        }

        if (numPuntos < 0) {
            throw new ExcepcionUsuario(ExcepcionUsuario.EXCEPCION_PUNTOS);
        }
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.numPuntos = numPuntos;

    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", contrasenia=" + contrasenia + ", numPuntos=" + numPuntos + '}';
    }

    public String getNombre() {
        return nombre;
    }
    
    

}
