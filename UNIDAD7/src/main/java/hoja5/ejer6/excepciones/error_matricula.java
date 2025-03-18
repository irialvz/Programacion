/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja5.ejer6.excepciones;

/**
 *
 * @author Alumno
 */
public class error_matricula extends Exception {
    public error_matricula(){
        
    }
    public error_matricula(String mensaje){
        super(mensaje);
    }
    public static final String ERROR_MATRICULA = "La matricula tiene que ser 4 números, seguidos de 3 letras que no incluya ninguna vocal";
    public static final String ERROR_NOTFOUND = "No se ha encontrado la matricula";
}
