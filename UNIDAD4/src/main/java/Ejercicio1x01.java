/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Scanner;

/**
 * Este programa pide por teclado un caracter e indica si es arabico o no
 * @author iriia
 */
public class Ejercicio1x01 {

    public static boolean esNumeroArabico(char caracter) {
        return caracter >= '0' && caracter <= '9';
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce un caracter ");
        char caracter = teclado.next().charAt(0);

        if(esNumeroArabico(caracter)){
            System.out.printf("El caracter %s es arabico ",caracter);
        } else {
            System.out.printf("El caracter %s no es arabico ",caracter);
        }
    teclado.close();
    }
}
