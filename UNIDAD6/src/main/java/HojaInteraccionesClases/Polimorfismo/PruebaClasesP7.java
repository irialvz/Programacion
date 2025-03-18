/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.HojaInteraccionesClases.Polimorfismo;

/**
 *
 * @author Alumno
 */
public class PruebaClasesP7 {
    public static void main(String[] args) {
        Persona p1 = new Persona("Iria","Alvarez","12345678V");
        Persona p2 = new Persona("Begoña","Solis","98745612A");
        Coche miFerrari = new Coche("4544-FNJ",60,5.9,180);
        Camion miTruck = new Camion("8899-ZTR",100,9.4,170,1000);
        Radar autoviaMadrid = new Radar("autoviaMadrid",60);
        
        p1.compraVehiculo(miFerrari);
        p2.compraVehiculo(miTruck);
        
        miFerrari.repostar(20);
        miTruck.repostar(20);
        
        p1.usaVehiculo(100, 100);
      p2.usaVehiculo(60, 70);
        
        autoviaMadrid.pasaVehiculo(miFerrari);
        autoviaMadrid.pasaVehiculo(miTruck);
    }
}
