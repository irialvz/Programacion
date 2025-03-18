/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja6.ejer3.model;

import ejercicios.UNIDAD7.hoja6.ejer3.excepciones.MiExcepcion;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Alumno
 */
public class Vivienda {

    protected ArrayList<String> cod_vivienda = new ArrayList<>();
    protected ArrayList<String> cod_propietario;
    private static ArrayList<Vivienda> ListaVivienda = new ArrayList<>();
    protected String direccion;
    protected double precio;
    protected boolean alquiler;

    public Vivienda(String cod_vivienda, String cod_propietario, String direccion, double precio, boolean alquiler) throws MiExcepcion {
        if (cod_propietario.length() != 4 || !validarCodProp(cod_propietario)) {
            throw new MiExcepcion("El codigo de propietario debe ser de 1 letra y 3 numeros");
        }
        if (cod_vivienda.length() != 10 || !validarCodVivienda(cod_vivienda)) {
            throw new MiExcepcion("El codigo de vivienda debe ser de 10 digitos en total \n 4 numero,un guion,una letra,un guion y tres numeros");
        }
        if (direccion.isBlank()){
            throw new MiExcepcion("La direccion no puede estar vacio");
        }
        if (precio < 100){
            throw new MiExcepcion("El precio tiene que ser superior a 100 euros");
        }
        if (precio >= 5000){
            alquiler = false;
        } else {
            alquiler = true;
        }
        this.cod_vivienda = new ArrayList<>();
        this.cod_propietario = new ArrayList<>();
        
        this.cod_propietario.add(cod_propietario);
        this.cod_vivienda.add(cod_vivienda);
        this.direccion = direccion;
        this.precio = precio;
        this.alquiler = alquiler;
    }

    public static boolean validarCodVivienda(String cod_vivienda) {
        String patronBusqueda = "(\\d{4})-([AV])-(\\d{3})";
        Pattern patron = Pattern.compile(patronBusqueda);
        Matcher encaja = patron.matcher(cod_vivienda);

        return encaja.matches();
    }

    public static boolean validarCodProp(String cod_propietario) {
        /*if (cod_propietario.charAt(0) >= '0' || cod_propietario.charAt(0) <= '9') {
            return false;
        }
        for (int i = 1; i < cod_propietario.length(); i++) {
            if (cod_propietario.charAt(i) < 'A' || cod_propietario.charAt(i) > 'Z' || cod_propietario.charAt(i) == 'ñ') {
                return false;
            }
        }
        return true;*/

        //CON EXPRESION REGULAR
        String patronBusqueda = "[A-Z][0-9]{3}";
        Pattern patron = Pattern.compile(patronBusqueda);
        Matcher encaja = patron.matcher(cod_propietario);
        return encaja.matches();

    }
    public static void ListaVivienda() throws MiExcepcion{
        if (ListaVivienda.isEmpty()){
            throw new MiExcepcion("La lista de viviendas esta vacia");
        }
        for (int i= 0 ; i<ListaVivienda.size();i++){
            System.out.println(ListaVivienda.get(i).toString());
        }
    }

   
    public ArrayList<String> getCod_vivienda() {
        return cod_vivienda;
    }

    public void setCod_vivienda(ArrayList<String> cod_vivienda) {
        this.cod_vivienda = cod_vivienda;
    }

    public ArrayList<String> getCod_propietario() {
        return cod_propietario;
    }

    public void setCod_propietario(ArrayList<String> cod_propietario) {
        this.cod_propietario = cod_propietario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isAlquiler() {
        return alquiler;
    }

    public void setAlquiler(boolean alquiler) {
        this.alquiler = alquiler;
    }

    @Override
    public String toString() {
        return """
               Vivienda{
               cod_vivienda=""" + cod_vivienda + "\n" + ", cod_propietario=" + cod_propietario + "\n" + ", direccion=" + direccion + "\n" + ", precio=" + precio + "\n" + ", alquiler=" + alquiler + '}';
    }

}
