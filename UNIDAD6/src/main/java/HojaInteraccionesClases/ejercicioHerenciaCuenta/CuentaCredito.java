/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.HojaInteraccionesClases.ejercicioHerenciaCuenta;

/**
 *
 * @author iriia
 */
public class CuentaCredito extends Cuenta {

    private double limiteCredito;

    public CuentaCredito(String numero, String titular, double limite) {
        super(numero, titular);
        if (limite >= 0) {
            this.limiteCredito = -1000;
        } else {
            this.limiteCredito = limite;
        }
    }

    public void retirarDinero(double cantidad) {
        if (!bloqueada && limiteCredito < 0) {
            System.out.println("Retirando " + cantidad + "de la cuenta con " + saldo + " euros de saldo");
            saldo -= cantidad;

        }
    }
}
