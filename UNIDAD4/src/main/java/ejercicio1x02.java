/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;

/**
 *
 * @author iriia
 */
public class ejercicio1x02 {
    public static boolean esLetraMayuscula(char caracter){
        return (caracter >= 'A' && caracter <= 'Z') || caracter == 'Ñ';
        //if (caracter >= 'A' && caracter <= 'Z' || caracter == 'Ñ'){
        // return true;
        // }
        //else {
        //  return false;
        // }
        //}
    }
    public static boolean esLetraMinuscula(char caracter){
        return (caracter >= 'a' && caracter <= 'z') || caracter == 'ñ';
    }
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        System.out.print("caracter? ");
        char caracter = teclado.next().charAt(0);

        if(esLetraMayuscula(caracter)){
            System.out.printf("El caracter %s es una letra mayuscula",caracter);
        } else if (esLetraMinuscula(caracter)){
            System.out.printf("El caracter %s es una letra minuscula",caracter);
        } else {
            System.out.printf("El caracter %s no es una letra",caracter);
        }


    }
}
