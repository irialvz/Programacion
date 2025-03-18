/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.HojaInteraccionesClases.ejercicioHerenciaCuenta;

/**
 *
 * @author Alumno
 */
public class CuentaAhorro extends Cuenta {

    private double interes;

    public CuentaAhorro(String numero, String titular, double interes) {
        super(numero, titular);
        if (interes >= 0 && interes <= 100) {
            this.interes = interes / 100;
        } else {
            this.interes = 0;
        }
    }

    public void aplicaInteres() {
        if (!bloqueada) {
            getSaldo();
            double saldoIntereses = saldo * interes;
            ingresarDinero(saldoIntereses);
        }
    }

    public void setInteres(double interes) {
        if (interes >= 0 && interes <= 100) {
            this.interes = interes / 100;
        } else {
            this.interes = this.interes;
        }
    }

    public double getInteres() {
        return interes * 100;
    }


}
