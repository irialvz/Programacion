/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.HojaInteraccionesClases.ejercicioAsociacion1;

/**
 *
 * @author Alumno
 */
public class PruebaClasesP1 {

    public static void main(String[] args) {
        Coche c1 = new Coche("4567HB", 180, 250, 25);
        Persona p1 = new Persona("Iria", "Alvarez Solis", "1234567A");

        p1.usaCoche(10, 60);
        p1.compraCoche(c1);
        c1.repostar(20);
        p1.usaCoche(10, 60);
        
    }
}
