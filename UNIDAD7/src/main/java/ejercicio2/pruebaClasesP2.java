/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.ejercicio2;

/**
 *
 * @author iriia
 */
public class pruebaClasesP2 {

    public static void main(String[] args) {
        Cuenta c1 = new Cuenta("111111", "Iria Alvarez");
        try {
            c1.ingresarDinero(2000);
            c1.sacarDinero(100);
            System.out.println(c1.getSaldo());
            c1.sacarDinero(3000);
        } catch (SaldoInsuficienteException ex) {
            System.out.println("Saldo insuficiente de la cuenta " + c1.numero + " con titular " + c1.titular);
        } catch (CuentaBloqueadaException ex) {
            System.out.println("La cuenta " + c1.numero + " con titular " + c1.titular + " esta bloqueada");
        }

    }
}

