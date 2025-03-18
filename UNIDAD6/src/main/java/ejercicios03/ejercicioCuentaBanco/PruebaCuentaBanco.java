/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.ejercicios03.ejercicioCuentaBanco;

/**
 *
 * @author iriia
 */
public class PruebaCuentaBanco {

    public static void main(String[] args) {
        CuentaBanco c1 = new CuentaBanco("1234", "Iria Alvarez Solis");
        System.out.println(c1);

        c1.sacarDinero(10);
        c1.ingresarDinero(20);
        System.out.println(c1);
        c1.sacarDinero(10);
        c1.cambioTitular("Juan Pasamar");
        System.out.println(c1);
        c1.bloquear();
        c1.cambioTitular("Iria Alvarez Solis");
        System.out.println(c1);

    }
}
