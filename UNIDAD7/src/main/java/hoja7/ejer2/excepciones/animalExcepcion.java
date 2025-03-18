/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja7.ejer2.excepciones;

/**
 *
 * @author Alumno
 */
public class animalExcepcion extends Exception {

    public animalExcepcion(String message) {
        super(message);
    }

    public animalExcepcion() {
    }
    public static final String NOMBRE_EXCEPCION = "El nombre no puede estar vacio";
    public static final String RAZA_EXCEPCION = "La raza no puede estar vacia";
    
}
