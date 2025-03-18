/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.pruebaExcepciones.teresa.act2x01v2;

import ejercicios.UNIDAD7.pruebaExcepciones.teresa.act2x01v2.excepciones.ExcepcionClientela;
import java.util.Arrays;

/**
 *
 * @author iriia
 */
public class Clientela {

    private Usuario[] usuarios;
    private int indice;

    public Clientela(int capacidad) {
        this.usuarios = new Usuario[capacidad];
        this.indice = 0;
    }

    @Override
    public String toString() {
        return "Clientela{" + Arrays.toString(usuarios) + /*POSICION EN EL VECTOR*/ '}';
    }

    public void agregar(Usuario newUser) {
        if (indice == usuarios.length) {
            throw new ExcepcionClientela(ExcepcionClientela.EXCEPCION_INSERTAR + ExcepcionClientela.EXCEPCION_INSERTAR_LLENO);
        }
        for (int i = 0; i < indice; i++) {
            if (usuarios[i].getNombre().equalsIgnoreCase(newUser.getNombre())) {
                throw new ExcepcionClientela(ExcepcionClientela.EXCEPCION_INSERTAR + ExcepcionClientela.EXCEPCION_INSERTAR_REPETIDO);
            }
        }
        usuarios[indice] = newUser;
        indice++;
    }

    public void eliminarPos(int posicion) {
        if (indice == 0) {
            throw new ExcepcionClientela(ExcepcionClientela.EXCEPCION_ELIMINAR + ExcepcionClientela.EXCEPCION_ELIMINAR_VACIO);
        }
        if (posicion < 0 || posicion > indice) {
            throw new ExcepcionClientela(ExcepcionClientela.EXCEPCION_ELIMINAR);
        }
        boolean borrado = false;
        for (int i = 0; i < this.indice && !borrado; i++) {
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

}
