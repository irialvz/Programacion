/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.pruebaExcepciones.teresa.act2x01v2.excepciones;


/**
 *
 * @author iriia
 */
public class ExcepcionUsuario extends RuntimeException {

    public static final String EXCEPCION_USUARIO = "Error al crear usuario";
    public static final String EXCEPCION_CARACTERES = "contraseña no tiene entre 6 y 20 caracteres.";
    public static final String EXCEPCION_PUNTOS = "número de puntos negativo.";

    public ExcepcionUsuario(String mensaje) {
        super(mensaje);
    }

}
