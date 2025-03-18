/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja6.ejer3.model;

import ejercicios.UNIDAD7.hoja6.ejer3.excepciones.MiExcepcion;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class Chalet extends Unifamiliar {

    private boolean piscina;
    private static ArrayList<Chalet> listaChalets = new ArrayList<Chalet>();

    public Chalet(String cod_vivienda, String cod_propietario, String direccion, double precio, boolean alquiler,int metrosJardin, boolean piscina) throws MiExcepcion {
        super(cod_vivienda, cod_propietario, direccion, precio, alquiler, metrosJardin);
        this.piscina = piscina;
    }

    public static void AltaChalet() throws MiExcepcion {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Codigo de vivienda?");
        String cod_vivienda = teclado.nextLine();
        if (cod_vivienda.length() != 10 || !validarCodVivienda(cod_vivienda)) {
            throw new MiExcepcion("El codigo de vivienda debe ser de 10 digitos en total \n 4 numero,un guion,una letra,un guion y tres numeros");
        }
        System.out.println("Codigo propietario? Ejemplo: A001");
        String cod_propietario = teclado.nextLine();
        if (cod_propietario.length() != 4 || !validarCodProp(cod_propietario)) {
            throw new MiExcepcion("El codigo de propietario debe ser de 1 letra y 3 numeros");
        }

        System.out.println("Direccion? ");
        String direccion = teclado.nextLine();
        if (direccion.isBlank()) {
            throw new MiExcepcion("La direccion no puede estar vacio");
        }

        double precio;
        do {
            System.out.println("Precio? (minimo 100 euros)");
            precio = teclado.nextDouble();
            if (precio < 100) {
                throw new MiExcepcion("El precio tiene que ser superior a 100 euros");
            }
        } while (precio < 100);
        teclado.nextLine();

        boolean alquiler;
        if (precio >= 5000) {
            alquiler = false;
        } else {
            alquiler = true;
        }

        System.out.println("Metros cuadrados del jardin? ");
        int metrosJardin = teclado.nextInt();
        if (metrosJardin < 0) {
            throw new MiExcepcion("Los metros del jardin no pueden ser menos que cero ni nulo");
        }

        System.out.println("Tienes piscina? true/false");
        boolean piscina = teclado.nextBoolean();

        Chalet nuevoChalet = new Chalet(cod_vivienda, cod_propietario, direccion, precio, alquiler, metrosJardin, piscina);
        listaChalets.add(nuevoChalet);

    }

    public static void listarChalets() throws MiExcepcion {
        String datosChalets = "";
        if (listaChalets.isEmpty()) {
            throw new MiExcepcion("La lista de chalets no puede estar vacia");
        }
        for (int i = 0; i < listaChalets.size(); i++) {
            datosChalets = listaChalets.get(i).toString();
            System.out.println(datosChalets);
        }
    }

}
