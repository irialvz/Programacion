/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.pruebaExcepciones.teresa.act2x01v2.excepciones;


/**
 *
 * @author iriia
 */
public class ExcepcionClientela extends RuntimeException {

    public static final String EXCEPCION_INSERTAR = "Error al insertar usuario: ";
    public static final String EXCEPCION_ELIMINAR = "Error al eliminar usuario: ";
    public static final String EXCEPCION_INSERTAR_LLENO = "vector de usuarios lleno";
    public static final String EXCEPCION_INSERTAR_REPETIDO = "nombre de usuario repetido";
    public static final String EXCEPCION_ELIMINAR_VACIO = "vector de usuarios vacío.";
    public static final String EXCEPCION_ELIMINAR_NO_ENCONTRADO = "posición no indica usuario en la clientela.";

    public ExcepcionClientela(String mensaje) {
        super(mensaje);
    }

}
