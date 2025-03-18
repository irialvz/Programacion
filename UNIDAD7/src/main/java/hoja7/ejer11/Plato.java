/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja7.ejer11;

import ejercicios.UNIDAD7.hoja7.ejer11.excepciones.rangoExcepcion;
import ejercicios.UNIDAD7.hoja7.ejer11.excepciones.vacioExcepcion;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author iriia
 */
public class Plato {
    private String descripcion;
    private int tipo;
    private String[] ingredientes = {"calabaza", "lechuga", "chorizo", "garbanzos", "tomate", "cebolla", "ajo", 
        "merluza", "coliflor", "filete de ternera", "fideos", "macarrones", "lentejas", "berenjena", "leche", "queso", 
        "melocotón", "melón", "jamón", "carne picada", "zanahoria", "bacalao", "setas", "zumo de naranja", 
        "huevos", "gambas", "calamares", "mejjillones", "salmón", "judías verdes", "borraja", "jamón"};
    private ArrayList<Plato> coleccionPlatos = new ArrayList<Plato>();

    public Plato(String descripcion, int tipo) throws vacioExcepcion, rangoExcepcion {
        if (descripcion.isEmpty()){
            throw new vacioExcepcion(vacioExcepcion.DESCRIPCION_VACIA);
        }
        if (tipo < 1 || tipo >3){
            throw new rangoExcepcion(rangoExcepcion.NUMERO_RANGO);
        }
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String[] ingredientes) {
        this.ingredientes = ingredientes;
    }

    public ArrayList<Plato> getColeccionPlatos() {
        return coleccionPlatos;
    }

    public void setColeccionPlatos(ArrayList<Plato> coleccionPlatos) {
        this.coleccionPlatos = coleccionPlatos;
    }
    
    public void generarPrimerP() throws vacioExcepcion, rangoExcepcion{
        coleccionPlatos.add(new Plato("Macarrones con tomate y chorizo",1));
        coleccionPlatos.add(new Plato("sopa de fideos con gabanzos",1));
        coleccionPlatos.add(new Plato("Salteado de coliflor gratinada en queso",1));
        coleccionPlatos.add(new Plato("Lentejas con zanahoria",1));
        coleccionPlatos.add(new Plato("berenjena rellena de carne picada y cebolla",1));
    }
    public void generarSegundoP() throws vacioExcepcion, rangoExcepcion{
        coleccionPlatos.add(new Plato("filete de ternera",2));
        coleccionPlatos.add(new Plato("salmon al papillote con cebolla",2));
        coleccionPlatos.add(new Plato("bacalao en salsa de melocoton",2));
        coleccionPlatos.add(new Plato("tabla de ibericos con quesomjamon,chorizo y tomate",2));
    }
    public void generarTercerP() throws vacioExcepcion, rangoExcepcion{
        coleccionPlatos.add(new Plato("Melon con jamon",3));
        coleccionPlatos.add(new Plato("tarta de queso",3));
        coleccionPlatos.add(new Plato("bizcocho de calabaza",3));
        coleccionPlatos.add(new Plato("zumo de naranja",2));
    }
    public static void main(String[] args) {
        
    }
    
    
    
}
