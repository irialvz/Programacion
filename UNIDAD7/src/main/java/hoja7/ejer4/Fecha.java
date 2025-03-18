/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja7.ejer4;

import java.util.Random;
import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author iriia
 */
public class Fecha implements Comparable {

    private int dia;
    private int mes;
    private int anyo;
    Random aleatorio = new Random();

    public Fecha() {
        this.mes = generarMes();
        this.anyo = generarAnyo();
        this.dia = generarDia(mes, anyo);
    }

    public int generarAnyo() {
        return aleatorio.nextInt((2019 - 1900) + 1) + 1900;
    }

    public int generarMes() {
        return aleatorio.nextInt((12 - 1) + 1) + 1;
    }

    public int generarDia(int mes, int anyo) {
        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (mes == 2 && esBisiesto(anyo)) {
            return aleatorio.nextInt((29 - 1) + 1) + 1;
        }
        return aleatorio.nextInt(diasPorMes[mes - 1]) + 1;
    }

    public boolean esBisiesto(int anyo) {
        return (anyo % 4 == 0 && anyo % 100 != 0 || anyo % 400 == 0);
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + anyo;
    }

    public static void main(String[] args) {
        ArrayList<Fecha> fechas = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            fechas.add(new Fecha());
        }

            Collections.sort(fechas);
            System.out.println(fechas);
        

    }

    @Override
    public int compareTo(Object o) {
        Fecha otra = (Fecha) o;
        if (this.anyo != otra.anyo) {
            return Integer.compare(this.anyo, otra.anyo);
        } else if (this.mes != otra.mes) {
            return Integer.compare(this.mes, otra.mes);
        } else {
            return Integer.compare(this.dia, otra.dia);
        }    
    }


}
