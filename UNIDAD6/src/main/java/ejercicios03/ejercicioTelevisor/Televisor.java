package ejercicios.UNIDAD6.ejercicios03.ejercicioTelevisor;

public class Televisor {

    public String marca;
    public String modelo;
    public int anio;
    public boolean panoramica;
    public boolean stereo;
    public boolean encendida;
    public int volumen;
    public int canal;

    public Televisor(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        if (anio < 1950 | anio > 2200) {
            System.out.println("El numero debe estar comprendido entre 1950 y 2200");
            this.anio = 2000;
        } else {
            this.anio = anio;
        }
    }

    public void encender() {
        if (encendida) {
            System.out.println("El televisor ya estaba encendido");
        } else {
            encendida = true;
            System.out.println("El televisor se ha encendido");
        }
    }

    public void apagar() {
        if (!encendida) {
            System.out.println("El televisor ya esta apagado");
        } else {
            encendida = false;
            System.out.println("Televisor se ha apagado");
        }
    }

    public String toString() {
        return "[marca; " + marca + ", modelo: " + modelo + ", anio: " + anio + ", panoramica: " + panoramica
                + ",stereo: " + stereo + "\n,encendida: " + encendida + ",volumen: " + volumen + ",canal: " + canal + "]";
    }

    public void seleccionarCanal(int nuevoCanal) {
        if (nuevoCanal < 0 || nuevoCanal > 99) {
            System.out.println("El valor" + nuevoCanal + "esta fuera del rango permitido");
        } else if (!encendida) {
            System.out.println("Televisor apagado");
        } else {
            this.canal = nuevoCanal;
            System.out.println("Estas en el canal " + nuevoCanal);
        }
    }

    public int getCanal() {
        if (!encendida){
            System.out.println("error");
            return -1;
    } else {
        return canal;
            
        }
    }

    public void subirCanal() {
        int canalSiguiente;
        if (!encendida) {
            System.out.println("Televisor apagado");
        } else {
            System.out.println("CANAL ACTUAL: " + canal);
            canalSiguiente = canal + 1;
            if (canalSiguiente < 0 || canalSiguiente > 99) {
                System.out.println("El valor esta fuera del rango permitido");
            } else {
                System.out.println("CANAL SIGUIENTE: " + (canal + 1));
            }
        }
    }

    public void bajarCanal() {
        int canalAnterior;
        if (!encendida) {
            System.out.println("Televisor apagado");
        } else {
            System.out.println("CANAL ACTUAL: " + canal);
            canalAnterior = canal - 1;
            if (canalAnterior < 0 || canalAnterior > 99) {
                System.out.println("El valor esta fuera del rango permitido");
            } else {
                System.out.println("CANAL ANTERIOR: " + canalAnterior);
            }

        }
    }

    public void cambiarVolumen(int nuevoVolumen) {
        if (nuevoVolumen < 0 || nuevoVolumen > 100) {
            System.out.println("El valor " + nuevoVolumen + " esta fuera del rango permitido");
        } else if (!encendida) {
            System.out.println("Televisio apagada");
        } else {
            this.volumen = nuevoVolumen;
            System.out.println("El volumen esta a " + nuevoVolumen);
        }
    }
}
