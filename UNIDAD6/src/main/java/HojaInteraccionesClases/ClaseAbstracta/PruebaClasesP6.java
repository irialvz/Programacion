/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.HojaInteraccionesClases.ClaseAbstracta;

/**
 *
 * @author Alumno
 */
public class PruebaClasesP6 {
    public static void main(String[] args) {
        Coche miCoche = new Coche("4544-FNJ",60,5.9,180);
        Camion miCamion = new Camion("8899-ZTR",100,9.4,170,1000);
        //Repostamos
        miCoche.repostar(20);
        miCamion.repostar(20);
        //Cargamos el camion
        miCamion.carga(1000);
        //Arrancamos ambos motoroes
        miCoche.arrancarMotor();
        miCamion.arrancarMotor();
        //Fijamos velocidad y distancia en coche
        miCoche.fijarVelocidad(100);
        miCoche.recorrerDistancia(100);
        //Fijamos velocidad y distancia en camion
        miCamion.fijarVelocidad(100);
        miCamion.recorrerDistancia(100);
        System.out.println("Litros actuales del camion " + miCamion.numLitrosActual);
        System.out.println("Litros actuales del coche " + miCoche.numLitrosActual);
    }
}
