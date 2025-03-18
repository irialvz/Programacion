/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.pruebagui.ejercicio5;

import java.util.ArrayList;

/**
 *
 * @author Alumno
 */
public class Concesionario {

    private Coche[] arrayCoches;
    private ArrayList<Venta> ventas;
    private double iva;

    public Concesionario(int num) {
        this.arrayCoches = new Coche[num];
        this.ventas = new ArrayList<>();
        this.iva = 0.21;
        inicializarCoches();
    }

    private void inicializarCoches() {
        int i = 0;
        if (i < arrayCoches.length) {
            arrayCoches[i++] = new Coche("Seat", "Panda", 15000);
        }
        if (i < arrayCoches.length) {
            arrayCoches[i++] = new CocheImportado("Ferrari", "T-R", 65000);
        }
        if (i < arrayCoches.length) {
            arrayCoches[i++] = new Coche("Seat", "Toledo", 21000);
        }
        if (i < arrayCoches.length) {
            arrayCoches[i++] = new CocheImportado("Jaguar", "XK", 41000);
        }
        if (i < arrayCoches.length) {
            arrayCoches[i++] = new CocheImportado("Porsche", "GT3", 44000);
        }
    }

    public void venderCoche(Coche coche) {
        for (int i = 0; i < arrayCoches.length; i++) {
            if (arrayCoches[i] == null) {
                arrayCoches[i] = coche;
                break;
            }
        }
    }

    public void bajaCoche(String marca, String modelo) {
        for (int i = 0; i < arrayCoches.length; i++) {
            if (arrayCoches[i].getMarca().equalsIgnoreCase(marca) && arrayCoches[i].getModelo().equalsIgnoreCase(modelo) && arrayCoches[i].isEstaVenta()) {
                arrayCoches[i].setEstaVenta(false);
                System.out.println("El coche ha cambiado a no disponible");
                break;
            }
        }
    }

    public void comprarCoche(String marca, String modelo) {
        for (int i = 0; i < arrayCoches.length; i++) {
            if (arrayCoches[i].getMarca().equalsIgnoreCase(marca) && arrayCoches[i].getModelo().equalsIgnoreCase(modelo) && arrayCoches[i].isEstaVenta()) {
                Venta venta = new Venta(arrayCoches[i],iva);
                ventas.add(venta);
                arrayCoches[i] = null;
                System.out.println("El coche se ha comprado correctamente");
                break;
            }
        }
    }
    public void listarCochesNac(){
        for (int i = 0;i < arrayCoches.length;i++){
            if (arrayCoches[i] instanceof Coche){
                System.out.println(arrayCoches[i].toString());
            }
        }
    }
    public void listarCochesImp(){
        for (int i = 0;i < arrayCoches.length;i++){
            if (arrayCoches[i] instanceof CocheImportado){
                System.out.println(arrayCoches[i].toString());
            }
        }
    }
    
    
}
