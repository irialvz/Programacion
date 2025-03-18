package ejercicios.UNIDAD6.ejerciciosTeresa.ejercicio2x01;

public class Cuenta {
    private int numero;
    private String cliente;
    private float saldo;

    public Cuenta(int numero, String cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = 0;
    }

    public String obtenerEstado() {
        return "[Cuenta numero " + this.numero + " de " + this.cliente +
                " con saldo " + this.saldo + "]";
        
        //String.format para asignar los decimales despues del punto, un printf basicamente
    }

    public boolean ingresar(float importe) {
        boolean realizado = false;

        if (importe > 0) {
            this.saldo += importe;
            realizado = true;
        }

        return realizado;
    }

    public boolean retirar(float importe) {
        boolean realizado = false;

        if (importe > 0 && importe <= this.saldo) {
            this.saldo -= importe;
            realizado = true;
        }

        return realizado;
    }

    public boolean transferir(float importe, Cuenta cuentaDest) {
        boolean realizado = false;

        if (importe > 0 && importe <= this.saldo) {
            this.saldo -= importe;
            cuentaDest.saldo += importe;
            realizado = true;
        }

        return realizado;
    }
}
