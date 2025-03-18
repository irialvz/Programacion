/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja5.Ejer5.excepciones;

/**
 *
 * @author Alumno
 */
public class restricciones extends Exception {
    public restricciones(String mensaje){
        super(mensaje);
    }
    public static final String ERROR_CANTIDAD = "La cantidad no puede ser igual o inferior a cero";
    public static final String ERROR_PESO = "El peso tiene que estar entre 12 y 25(incluidos)";
    public static final String ERROR_PALABRA = "La palabra no puede ser nula y tiene que tener menos de 10 caracteres. No puede tener el carácter '$'";
}
