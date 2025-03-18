/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.pruebaExcepciones.teresa.actividad2x01;

/**
 *
 * @author iriia
 */
public class Clientela {

    private Usuario[] usuarios;
    private int contadorUs;

    public Clientela(Usuario[] usuario, int capacidad) {
        this.usuarios = new Usuario[capacidad];
        this.contadorUs = 0;
    }

    @Override
    public String toString() {
        return "Clientela{" + "usuario=" + usuarios + "posicion vector " + /*TODO*/ '}';
    }

    //HACER METODOS
    public void agregar(Usuario nuevoUsuario) {
        if (contadorUs == usuarios.length) {
            throw new ExcepcionClientela(ExcepcionClientela.EXCEPCION_INSERTAR_LLENO);
        }
        for (int i = 0; i < contadorUs; i++) {
            if (usuarios[i].getNombre().equalsIgnoreCase(nuevoUsuario.getNombre())) {
                throw new ExcepcionClientela(ExcepcionClientela.EXCEPCION_INSERTAR_REPETIDO);
            }
        }

        usuarios[contadorUs] = nuevoUsuario;
        contadorUs++;

    }

    public void eliminarPosicion(int posicion) {
        if (contadorUs == 0) {
            throw new ExcepcionClientela(ExcepcionClientela.EXCEPCION_ELIMINAR_VACIO);
        }

        if (posicion < 0 || posicion > contadorUs) {
            throw new ExcepcionClientela(ExcepcionClientela.EXCEPCION_ELIMINAR);
        }
        boolean borrado = false;
        for (int i = 0; i < this.contadorUs && !borrado; i++) {
            Usuario u = this.usuarios[i];
            if (u != null && i == posicion) {
                u = null;
                borrado = true;
            }
        }
        if (!borrado) {
            throw new ExcepcionClientela(ExcepcionClientela.EXCEPCION_ELIMINAR + ExcepcionClientela.EXCEPCION_ELIMINAR_NO_ENCONTRADO);
        }
    }

    private String clientelaToString() {
        String usuariosString = "";
        for (int i = 0; i < contadorUs; i++) {
            usuariosString = usuariosString + " " + i + " " + usuarios[i].toString();
        }
        return usuariosString;
    }

}
