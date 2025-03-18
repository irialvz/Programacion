/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.HojaInteraccionesClases.ejercicioAsociacionN;

/**
 *
 * @author iriia
 */
public class PruebaClasesP2 {
    public static void main(String[] args){
        Persona iria = new Persona ("iria","Alvarez","12345678V");
        Coche miFerrari = new Coche("1234ABC",50,200,7.5);
        Coche miPorsche = new Coche("ABC1234",60,220,6.5);
        
        
        iria.compraCoche(miPorsche);
        iria.compraCoche(miFerrari);
        miFerrari.repostar(20);
        miPorsche.repostar(20);
        
        
        iria.imprimirDatosPersonales();
        iria.eligeCocheEnUso(0);
        iria.usaCoche(100, 200);
        
    }
}
