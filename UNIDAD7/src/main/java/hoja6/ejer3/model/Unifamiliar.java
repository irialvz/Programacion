/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja6.ejer3.model;

import ejercicios.UNIDAD7.hoja6.ejer3.excepciones.MiExcepcion;
import java.util.ArrayList;

/**
 *
 * @author iriia
 */
public class Unifamiliar extends Vivienda {

    private int metrosJardin;
    //private static ArrayList<Unifamiliar> listaUnifamiliares = new ArrayList<>();

    public Unifamiliar(String cod_vivienda, String cod_propietario, String direccion, double precio, boolean alquiler,int metrosJardin) throws MiExcepcion {
        super(cod_vivienda, cod_propietario, direccion, precio, alquiler);
        if (metrosJardin < 0) {
            throw new MiExcepcion("Los metros del jardin no pueden ser menos que cero ni nulo");
        }
        this.metrosJardin = metrosJardin;
    }

    public int getMetrosJardin() {
        return metrosJardin;
    }

    public void setMetrosJardin(int metrosJardin) {
        this.metrosJardin = metrosJardin;
    }
/*
    public static ArrayList<Unifamiliar> getListaUnifamiliares() {
        return listaUnifamiliares;
    }

    public static void setListaUnifamiliares(ArrayList<Unifamiliar> listaUnifamiliares) {
        Unifamiliar.listaUnifamiliares = listaUnifamiliares;
    }*/

    @Override
    public String toString() {
        return super.toString() + "\nUnifamiliar{" + "\nmetrosJardin=" + metrosJardin + '}';
    }
    

}
