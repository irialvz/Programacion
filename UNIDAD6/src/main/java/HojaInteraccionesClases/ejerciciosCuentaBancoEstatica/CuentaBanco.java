/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.HojaInteraccionesClases.ejerciciosCuentaBancoEstatica;

/**
 *
 * @author Alumno
 */
public class CuentaBanco {
    public static int NumeroTotalCuentas= 0;
    public static int SumaSaldosCuentas = 0;
    public String numero;
    public String titular;
    public double saldo;
    public boolean bloqueada;

    public CuentaBanco(String numero, String titular) {
        this.numero = numero;
        this.titular = titular;
    }

    public double getSaldo() { //consultarSaldo()
        return saldo;
    }
    public void ingresarDinero (double cantidad){
       if (cantidad <= 0){
           System.out.println("No se puede agregar ese valor");
       } else if (bloqueada){
           System.out.println("La cuenta esta bloqueada");
       } else {
           System.out.println("Añadiendo " + cantidad + " a la cuenta....");
           saldo =+ cantidad;            
       }
    }
    public void sacarDinero(double cantidad){
        if (cantidad <= 0 || saldo < cantidad){
            System.out.println("No se puede retirar ese valor,no tienes ni un duro");
        } else if (bloqueada){
            System.out.println("La cuenta esta bloqueada");
        } else {
            System.out.println("Retirando " + cantidad + " de la cuenta");
            saldo = saldo - cantidad;
        }
    }
    
    public void cambioTitular(String nuevoTitular){
        if (bloqueada){
            System.out.println("La cuenta esta bloqueada");
        } else if (nuevoTitular.equals("") == true){
            System.out.println("La cadena esta vacia");
        } else {
            this.titular = nuevoTitular;
        }
    }
    
    public void bloquear(){
        if (bloqueada){
            System.out.println("La cuenta ya estaba bloqueada");
        } else {
            System.out.println("bloqueando cuenta...");
            bloqueada = true;
        }
    }
    public void desbloquear(){
        if(!bloqueada){
            System.out.println("La cuenta no estaba bloqueda");
        } else {
            System.out.println("desbloqueando cuenta...");
            bloqueada = false;
        }
    }
    public String toString(){
        return "[Numero de cuenta: " + numero + ", titular: " + titular + ", saldo: " 
                + saldo + ", bloqueada: " + bloqueada + " ]";
    }
}
