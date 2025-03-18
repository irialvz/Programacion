/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja7.ejer8;

import ejercicios.UNIDAD7.hoja7.ejer8.excepciones.nombreExcepcion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Alumno
 */
public class Contacto {

    private String nombre;
    private Integer telefono; // INTEGER EN VEZ DE INT PORQUE PUEDE SER NULO
    private String email;
    public static List<Contacto> listaContactos = new ArrayList<Contacto>(20) {
    };

    public Contacto(String nombre, Integer telefono, String email) throws nombreExcepcion {
        if (nombre == null) {
            throw new nombreExcepcion("El nombre no puede ser nulo");
        }
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contacto{\n"
                + "\tnombre=" + nombre + "\n"
                + "\ttelefono=" + telefono + "\n"
                + "\temail=" + email + "\n"
                + "}\n";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static void guardarLista(Contacto contactoNuevo) {
        if (listaContactos.size() >= 20) {
            System.out.println("Solo se puede añadir hasta 20 contactos");
            return;
        }
        listaContactos.add(contactoNuevo);
    }

    public static String mostrarLista() {
        if (listaContactos.isEmpty()) {
            return "La lista esta vacia";
        }
        return listaContactos.toString();
    }

    public static void eliminarContactoTelefono() {
        Iterator<Contacto> iterado = listaContactos.iterator();
        while (iterado.hasNext()) {
            Contacto c = iterado.next();
            if (c.getTelefono() == null) {
                iterado.remove();
               //System.out.println("Se ha eliminado a " + iterado.next());
            }

        }

    }

    public static void eliminarContactoEmail() {
        Iterator<Contacto> iterado = listaContactos.iterator();
        while (iterado.hasNext()) {
            Contacto c = iterado.next();
            if (c.getEmail() == null) {
                iterado.remove();
               // System.out.println("Se ha eliminado a " + iterado.next());
            }

        }
    }

}
