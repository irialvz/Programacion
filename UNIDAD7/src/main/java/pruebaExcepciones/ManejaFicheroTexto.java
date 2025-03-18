/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.pruebaExcepciones;

/**
 *
 * @author Alumno
 */
import java.io.*;
public class ManejaFicheroTexto {
    private FileReader manejadorFichero;
    
    public void visualiza (String nombreFichero){
        int caracter;
        try{
            manejadorFichero = new FileReader(nombreFichero);
            caracter = manejadorFichero.read();
            while (caracter != -1){
                System.out.write ((char) (caracter));
                caracter = manejadorFichero.read();
            }
            manejadorFichero.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error al abrir el fichero");
            
        }
        catch (IOException e){
            System.out.println("Error al leer o cerrar el fichero " + nombreFichero);
            e.printStackTrace();
        }
    }
}
