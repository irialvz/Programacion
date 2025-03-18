/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja7_2.ejer3;

import ejercicios.UNIDAD7.hoja7_2.ejer1.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

/**
 *
 * @author iriia
 */
public class NumAleatorios2 {

    private ArrayList<Integer> hashSetNum = new ArrayList<>();
    private LinkedList<Integer> LinkedhashSetNum = new LinkedList<>();

    public void generarNumeros() {
        Random aleatorio = new Random();
        List<Integer> numAlt = new ArrayList<>();

        while (numAlt.size() <14) {
            int num = aleatorio.nextInt(15)+1;
                numAlt.add(num);
            
        }
        hashSetNum.addAll(numAlt);
        LinkedhashSetNum.addAll(numAlt);
        System.out.println("Introduciendo...\n" + numAlt);
        System.out.println("Valores de ArrayList:\n" + hashSetNum);
        System.out.println("Valores de LinkedListt:\n" + LinkedhashSetNum);
    }

}
