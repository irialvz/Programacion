/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD4;

import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class ejercicio2x07 {

    public static String leerFrase() {
        Scanner teclado = new Scanner(System.in);
        int limite = 60;
        String cadena;

        //este bucle realiza la primer pregunta, MIENTRAS QUE la cadena es mayor a 60 se repetirá
        do {
            System.out.print("Frase? ");
            cadena = teclado.nextLine();

            if (cadena.length() > limite) {
                System.out.print("La frase debe tener 60 caracteres como maximo");
            }
        } while (cadena.length() > limite);
        return cadena;
    }
    
    public static void main(String [] args){
        String cadena = leerFrase();
        System.out.println("ROTACIONES HACIA LA DERECHA");
        String rotacionDerecha = cadena;
        for (int i = 0; i < cadena.length();i++){
            System.out.println(rotacionDerecha);
            // legth-1 obtiene el utlimo caracter y charAt devuelve el caracter de ese indice
            rotacionDerecha = rotacionDerecha.charAt(rotacionDerecha.length() - 1) + rotacionDerecha.substring(0, rotacionDerecha.length() -1);
                            
        }
        System.out.println("ROTACIONES A LA IZQUIERDA");
        String rotacionIzquierda = cadena;
        for (int j = 0; j < cadena.length();j++){
            System.out.println(rotacionIzquierda);
            rotacionIzquierda = rotacionIzquierda.substring(1) + rotacionIzquierda.charAt(0);
            //substring visualiza los caracteres despues del 1 y se concatena con el caracter 0 del String
        }
    }
}
