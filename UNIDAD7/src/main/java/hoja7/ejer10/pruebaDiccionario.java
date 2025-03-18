/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja7.ejer10;

import ejercicios.UNIDAD7.hoja7.ejer10.excepcion.exisitenteExcepcion;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
public class pruebaDiccionario {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Diccionario d = new Diccionario();
        String palabraEsp;
        d.diccionarioEspEng.put("Hola", "Hello");
        d.diccionarioEspEng.put("Adios", "Bye");
        d.diccionarioEspEng.put("Mesa", "Table");
        d.diccionarioEspEng.put("Diccionario", "Dictionary");
        do {
            System.out.println("Palabra en español?");
            palabraEsp = teclado.nextLine();
            if (palabraEsp.isEmpty()) return;
            if (d.diccionarioEspEng.containsKey(palabraEsp)) {
                System.out.println("Traduccion: " + d.diccionarioEspEng.get(palabraEsp));
            } else {
                System.out.println("La palabra en español no esta en el diccionario,agregala");
                System.out.println("Traduccion en ingles de la palabra " + palabraEsp);
                String palabraEn = teclado.nextLine();
                try {
                    d.agregarValor(palabraEsp, palabraEn);
                    System.out.println("Español " + palabraEsp + "-- Ingles " + d.diccionarioEspEng.get(palabraEsp));
                } catch (exisitenteExcepcion ex) {
                    System.out.println(ex.getMessage());
                }
            }

        } while (!palabraEsp.isEmpty());

    }
}
