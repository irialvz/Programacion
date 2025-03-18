/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja7_2.ejer4;
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
public class StringAleatorios2 {

    private ArrayList<String> hashSetNum = new ArrayList<>();
    private LinkedList<String> LinkedhashSetNum = new LinkedList<>();

    public void generarNumeros() {
        Random aleatorio = new Random();
        String[] palabras = {"este","este","bajo"};
        
        while (hashSetNum.size() <3) {
            int num = aleatorio.nextInt(3)+1;
        hashSetNum.add(palabras[num]);
        LinkedhashSetNum.add(palabras[num]);            
        }

        System.out.println("Introduciendo...\n" + Arrays.toString(palabras));
        System.out.println("Valores de ArrayList:\n" + hashSetNum);
        System.out.println("Valores de LinkedListt:\n" + LinkedhashSetNum);
    }

}
