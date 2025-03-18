/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja6.ejer3.model;

import ejercicios.UNIDAD7.hoja6.ejer3.excepciones.MiExcepcion;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author iriia
 */
public class Piso extends Vivienda {

    private String comunidad;
    private String numPiso;
    private static ArrayList<Piso> listaPisos = new ArrayList<>();

    public Piso(String cod_vivienda, String cod_propietario, String direccion, double precio, boolean alquiler, String comunidad, String numPiso) throws MiExcepcion {
        super(cod_vivienda, cod_propietario, direccion, precio, alquiler);
        if (comunidad.isBlank()) {
            throw new MiExcepcion("El campo de comunidad no puede estar vacio");
        }
        if (numPiso.isBlank()) {
            throw new MiExcepcion("El campo de numero de piso no puede estar vacio");
        }
        if (!validarNumPiso(numPiso)) {
            throw new MiExcepcion("El numero de piso no es valido,1 numero y 1 una letra");
        }
        this.comunidad = comunidad;
        this.numPiso = numPiso;
    }

    public static boolean validarNumPiso(String numPiso) {
        String patronBusqueda = "[0-9][A-Z-a-z]";
        Pattern patron = Pattern.compile(patronBusqueda);
        Matcher encaja = patron.matcher(numPiso);
        return encaja.matches();
    }

    public static void AltaPiso() throws MiExcepcion {
        Scanner teclado = new Scanner(System.in);

        //TODO Bucle para que cuando salga una excepcion se pare todo el programa
        System.out.println("Codigo vivienda? Ejemplo: 2021-A-000 ");
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
        System.out.println("Comunidad? ");
        String comunidad = teclado.nextLine();
        if (comunidad.isBlank()) {
            throw new MiExcepcion("El campo de comunidad no puede estar vacio");
        }

        System.out.println("Numero de piso? ");
        String numPiso = teclado.nextLine();
        if (numPiso.isBlank()) {
            throw new MiExcepcion("El campo de numero de piso no puede estar vacio");
        }

        Piso nuevoPiso = new Piso(cod_vivienda, cod_propietario, direccion, precio, alquiler, comunidad, numPiso);
        listaPisos.add(nuevoPiso);

    }

    public static void ListadoPisos() throws MiExcepcion{
        String listado = "";
        if (listaPisos.isEmpty()){
            throw new MiExcepcion("La lista de Pisos esta vacia");
        }
        for (int i = 0; i< listaPisos.size();i++){
             System.out.println(listaPisos.get(i).toString());
        }
    }
    public String getComunidad() {
        return comunidad;
    }

    public void setComunidad(String comunidad) {
        this.comunidad = comunidad;
    }

    public String getNumPiso() {
        return numPiso;
    }

    public void setNumPiso(String numPiso) {
        this.numPiso = numPiso;
    }

    @Override
    public String toString() {
        return super.toString() + "Piso{" + "\ncomunidad=" + comunidad + "\n,numPiso=" + numPiso + '}';
    }
    /*
    public static void main(String[] args) {
        try {
            AltaPiso();
        } catch (MiExcepcion ex) {
            System.out.println(ex.getMessage());;
        }
        try {
            AltaPiso();
        } catch (MiExcepcion ex){
            System.out.println(ex.getMessage());
        }
        try {
            ListadoPisos();
        } catch (MiExcepcion ex) {
            System.out.println(ex.getMessage());;
        }
    }*/
}
