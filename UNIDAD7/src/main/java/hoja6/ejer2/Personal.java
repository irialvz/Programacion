/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja6.ejer2;

import ejercicios.UNIDAD7.hoja6.ejer2.excepciones.caracteresExcepcion;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iriia
 */
public class Personal extends Cooperante {

    static ArrayList<Cooperante> listadoPersonal = new ArrayList<>();

    public Personal(String nombre, String dni, String pais) throws caracteresExcepcion {
        super(nombre, dni, pais);
    }

    public static void altaAsalariado(Asalariado a) {
        listadoPersonal.add(a);
        System.out.println("Asalariado agregado: " + a);

    }

    public static void altaVoluntario(Voluntario v) {
        listadoPersonal.add(v);
        System.out.println("Voluntario agregado: " + v);
    }

    public static void listadoCooperante() throws caracteresExcepcion {
        if (listadoPersonal.isEmpty()) {
            throw new caracteresExcepcion("El listado esta vacio");
        }
        for (int i = 0; i < listadoPersonal.size(); i++) {
            System.out.println(listadoPersonal.get(i).toString());
        }
    }

    public static void listadoAsalariados() throws caracteresExcepcion {
        if (listadoPersonal.isEmpty()) {
            throw new caracteresExcepcion("El listado esta vacio");
        }
        for (int i = 0; i < listadoPersonal.size(); i++) {
            Cooperante c = listadoPersonal.get(i);
            if (c instanceof Asalariado) {
                System.out.println(c.toString()+ "\t Sueldo: " + ((Asalariado) c).getSueldo());
            }
        }
    }

    public static void listadoVoluntario() throws caracteresExcepcion {
        if (listadoPersonal.isEmpty()) {
            throw new caracteresExcepcion("El listado esta vacio");
        }
        for (int i = 0; i < listadoPersonal.size(); i++) {
            Cooperante c = listadoPersonal.get(i);
            if (c instanceof Voluntario) {
                System.out.println(c.toString() + "\t Ong: " + ((Voluntario) c).getOng());
            }
        }
    }

    /* public static void main(String[] args) {
        try {
            Asalariado prueba = new Asalariado("iria", "12381193V", "España", 1233);
            altaAsalariado(prueba);

        } catch (caracteresExcepcion ex) {
            System.out.println(ex.getMessage());
        }
    }*/
}
