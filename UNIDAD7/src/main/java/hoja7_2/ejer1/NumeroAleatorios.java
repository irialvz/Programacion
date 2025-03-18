/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja7_2.ejer1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

/**
 *
 * @author iriia
 */
public class NumeroAleatorios {

    private HashSet<Integer> hashSetNum = new HashSet<>();
    private LinkedHashSet<Integer> LinkedhashSetNum = new LinkedHashSet<>();
    private TreeSet<Integer> TreeSetNum = new TreeSet<>();

    public void generarNumeros() {
        Random aleatorio = new Random();
        List<Integer> numAlt = new ArrayList<>();

        while (numAlt.size() < 6) {
            int num = aleatorio.nextInt(15)+1;
            if (!numAlt.contains(num)){
                numAlt.add(num);
            }
        }
        hashSetNum.addAll(numAlt);
        LinkedhashSetNum.addAll(numAlt);
        TreeSetNum.addAll(numAlt);
        System.out.println("Introduciendo...\n" + numAlt);
        System.out.println("Valores de HashSet:\n" + hashSetNum);
        System.out.println("Valores de LinkedHashSet:\n" + LinkedhashSetNum);
        System.out.println("Valores de TreeSet:\n" + TreeSetNum);

    }

}
