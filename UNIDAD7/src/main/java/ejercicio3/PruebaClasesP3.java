/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.ejercicio3;

import ejercicios.UNIDAD7.ejercicio3.excepciones.ClienteSinCuentaException;
import ejercicios.UNIDAD7.ejercicio3.excepciones.CuentaBloqueadaException;
import ejercicios.UNIDAD7.ejercicio3.excepciones.DniNoValidoException;

/**
 *
 * @author iriia
 */
public class PruebaClasesP3 {

    public static void main(String[] args) throws DniNoValidoException, ClienteSinCuentaException, CuentaBloqueadaException {
        Sucursal s1 = new Sucursal("BBVA", "Bilbao");
        // Cliente c1 = new Cliente("28748205", 'E', "Begonya", "Solis");
        //Cliente c2 = new Cliente("28748206", 'T', "Bruno", "Alvarez");

        //c1.ingresarDinero(200);
        //c2.ingresarDinero(600);
        try {
            Cliente c1 = new Cliente("28748205", 'E', "Begonya", "Solis");
            c1.ingresarDinero(200);
        } catch (ClienteSinCuentaException csce) {
            System.out.println("error: " + csce.getMessage());
        } catch (CuentaBloqueadaException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        try {
            Cliente c2 = new Cliente("28748206", 'T', "Bruno", "Alvarez");
            c2.ingresarDinero(600);
        } catch (ClienteSinCuentaException csce) {
            System.out.println("error: " + csce.getMessage());
        } catch (CuentaBloqueadaException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
