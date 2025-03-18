/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja7_2.ejer2;

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
public class StringAleatorios {

    private HashSet<String> hashSetNum = new HashSet<>();
    private LinkedHashSet<String> LinkedhashSetNum = new LinkedHashSet<>();
    private TreeSet<String> TreeSetNum = new TreeSet<>();

    public void generarString() {
        Random aleatorio = new Random();
        String[] palabras = {"este", "montaña", "letra", "bajo", "frio", "bajo", "bajo", "aleatorio"};

        while (hashSetNum.size() < 6) {
            int posAleatoria = aleatorio.nextInt(8);
            hashSetNum.add(palabras[posAleatoria]);
            LinkedhashSetNum.add(palabras[posAleatoria]);
            TreeSetNum.add(palabras[posAleatoria]);

        }

        System.out.println("Introduciendo...\n" + Arrays.toString(palabras));
        System.out.println("Valores de HashSet:\n" + hashSetNum);
        System.out.println("Valores de LinkedHashSet:\n" + LinkedhashSetNum);
        System.out.println("Valores de TreeSet:\n" + TreeSetNum);

    }

}
