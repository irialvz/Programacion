/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja6.ejer3.model;

import ejercicios.UNIDAD7.hoja6.ejer3.excepciones.MiExcepcion;
import static ejercicios.UNIDAD7.hoja6.ejer3.model.Adosado.AltaAdosado;
import static ejercicios.UNIDAD7.hoja6.ejer3.model.Adosado.ListadoAdosados;
import static ejercicios.UNIDAD7.hoja6.ejer3.model.Chalet.AltaChalet;
import static ejercicios.UNIDAD7.hoja6.ejer3.model.Chalet.listarChalets;
import static ejercicios.UNIDAD7.hoja6.ejer3.model.Piso.AltaPiso;
import static ejercicios.UNIDAD7.hoja6.ejer3.model.Piso.ListadoPisos;
import static ejercicios.UNIDAD7.hoja6.ejer3.model.Vivienda.ListaVivienda;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
public class PruebaCasas {

    public static int menu() {
        Scanner teclado = new Scanner(System.in);
        int resultado;
        System.out.println("(1) Alta piso");
        System.out.println("(2) Alta adosado");
        System.out.println("(3) Alta chalet");
        System.out.println("(4) Listado viviendas");
        System.out.println("(5) Listado pisos");
        System.out.println("(6) Listado chalets");
        System.out.println("(7) Listado adosados");
        System.out.println("(8) Fin");
        System.out.println("Opcion? ");
        resultado = teclado.nextInt();
        return resultado;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        do {
            opcion = menu();
            switch (opcion) {
                case 8:
                    System.out.println("Saliendo....");
                    break;
                case 1: //DAR DE ALTA UN PISO
                    try {
                        AltaPiso();
                    } catch (MiExcepcion ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 2: //DAR DE ALTA UN ADOSADO
                    try {
                        AltaAdosado();
                    } catch (MiExcepcion ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 3://DAR DE ALTA UN CHALET
                    try {
                        AltaChalet();
                    } catch (MiExcepcion ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 4://LSITADO VIVIENDAS
                    try {
                        ListaVivienda();
                    } catch (MiExcepcion ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 5://LSITADO PISOS
                    try {
                        ListadoPisos();
                    } catch (MiExcepcion ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 6://LISTADO CHALETS
                    try {
                        listarChalets();
                    } catch (MiExcepcion ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 7://LISTADO ADOSADOS
                    try {
                        ListadoAdosados();
                    } catch (MiExcepcion ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }
        } while (opcion != 8);

    }

}
