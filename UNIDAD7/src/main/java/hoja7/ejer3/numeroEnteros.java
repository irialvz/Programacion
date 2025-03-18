/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja7.ejer3;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.*;
/**
 *
 * @author iriia
 */
public class numeroEnteros {
    //private static TreeSet<Integer> listaNumeros = new TreeSet<Integer>(); // Los ordena directamente
    private static ArrayList<Integer> listaNumeros = new ArrayList<Integer>();
    
    public static void darValor(){
        for (int i= -1000;i<=1000;i++){
            listaNumeros.add(i);
        }
    }
    public static void main(String[] args) {
        darValor();
        System.out.println("ANTES");
        System.out.println(listaNumeros);
        Collections.sort(listaNumeros,Comparator.reverseOrder());
        System.out.println("DESPUES");
        System.out.println(listaNumeros);
    }
    
}
