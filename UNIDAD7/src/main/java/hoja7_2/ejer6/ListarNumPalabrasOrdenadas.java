/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja7_2.ejer6;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author iriia
 */
public class ListarNumPalabrasOrdenadas {

    public static void main(String[] args) {
        String palabra;
        int numero;
        Scanner teclado = new Scanner(System.in);
        TreeSet<String> palabras = new TreeSet<>();
        do {
            System.out.println("Palabra? ");
            palabra = teclado.nextLine();
            if (!palabra.equals("*")) {
                palabras.add(palabra);
            }

        } while (!palabra.equals("*"));

        System.out.println(palabras);
        System.out.println("Numero no mayor de " + palabras.size() + "?");
        numero = teclado.nextInt();
        
        if (numero > palabras.size()) {
            System.out.println("Error");
            return;
        }

        System.out.println(numero + " PRIMERAS PALABRAS ORDENADAS");        
        Iterator<String> iterador = palabras.iterator();
        int contadorPalabras = 0;

        while (iterador.hasNext()) {
            System.out.println(iterador.next());
            if (contadorPalabras == numero - 1) {
                break;
            }
            contadorPalabras++;
        }
    }

}
