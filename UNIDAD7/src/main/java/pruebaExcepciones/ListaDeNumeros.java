/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.pruebaExcepciones;

/**
 *
 * @author Alumno
 */
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListaDeNumeros {

    private int vector[];
    private int tamanio = 10;

    public ListaDeNumeros() {
        vector = new int[tamanio];
        for (int i = 0; i < tamanio; i++) {
            vector[i] = i;
        }
    }
    public void escribeLista() /*OPCION2: throws FileNotFoundException*/{
        /* OPCION 1
        PrintWriter fichTexto;
        try {
            fichTexto = new PrintWriter("Lista.txt");
            for (int i = 0; i < tamanio; i++) {
                fichTexto.println("El valor de " + i + " = " + vector[i]);
                fichTexto.close();
            }            
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error al abrir el fichero Lista.txt");
            ex.printStackTrace();
            
        }*/
    }
}

