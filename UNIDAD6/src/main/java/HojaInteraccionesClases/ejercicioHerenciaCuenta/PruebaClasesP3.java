/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.HojaInteraccionesClases.ejercicioHerenciaCuenta;

/**
 *
 * @author Alumno
 */
public class PruebaClasesP3 {

    public static void main(String[] args) {
/*        CuentaAhorro ca1 = new CuentaAhorro("323232", "Perro Sanchez", 2.5);
        ca1.ingresarDinero(1000);
        ca1.aplicaInteres();
        String toString = ca1.toString();
        System.out.println(toString);
        ca1.sacarDinero(2000);
        ca1.cambioTitular("Ana Perez");
        ca1.toString();*/

        CuentaCredito cc1 = new CuentaCredito("323130", "Iria Alvarez", -3000);
        cc1.ingresarDinero(1000);
        System.out.println(cc1.toString());
        cc1.retirarDinero(1050);
        cc1.cambioTitular("Ana Perez");
        System.out.println(cc1.toString());
    }
}
