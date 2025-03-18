/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.HojaInteraccionesClases.Interfaces;

/**
 *
 * @author iriia
 */
public class PruebaClasesP8 {

    public static void main(String[] args) {
        /**
         * Creará 5 personas (p1, p2… p5) y un autobús con 30 plazas para
         * pasajeros.
         */
        Persona p1 = new Persona("Iria", "Alvarez", "12345678A");
        Persona p2 = new Persona("Bego", "Solis", "98745632S");
        Persona p3 = new Persona("Bruno", "Alvarez", "96325874P");
        Persona p4 = new Persona("Xiomara", "Ratto", "14785236O");
        Persona p5 = new Persona("Juan", "Pasamar", "35789654M");
        Autobus aut1 = new Autobus("ABC123", 100, 10, 120, 30);

        // El autobús repostará 40 litros, arrancará los motores y a
        //continuación subirán tres personas (p1-p3). 
        aut1.repostar(40);
        aut1.arrancarMotor();
        aut1.subirPasajero(p1);
        aut1.subirPasajero(p2);
        aut1.subirPasajero(p3);
        aut1.getEstadoOcupacion();

        // A continuación el autobús fijará la velocidad a 60 km/h,
        // recorrerá 10 km y bajará la velocidad a cero. 
        aut1.fijarVelocidad(60);
        aut1.recorrerDistancia(10);
        aut1.fijarVelocidad(0);

        // Ahora se baja el pasajero p2 y sube el p4.
        aut1.bajarPasajero(p2);
        aut1.subirPasajero(p4);
        aut1.getEstadoOcupacion();

        // A continuación el autobús fijará la velocidad a 80 km/h,
        // recorrerá 20 km y bajará la velocidad a cero
        aut1.fijarVelocidad(80);
        aut1.recorrerDistancia(20);
        aut1.fijarVelocidad(0);

        aut1.subirPasajero(p5);
        aut1.getEstadoOcupacion();
        
        
        aut1.fijarVelocidad(30);
        aut1.recorrerDistancia(70);
        aut1.fijarVelocidad(0);
        
        aut1.bajarPasajero(p5);
        aut1.bajarPasajero(p4);
        aut1.bajarPasajero(p1);
        aut1.bajarPasajero(p3);
    }

}
