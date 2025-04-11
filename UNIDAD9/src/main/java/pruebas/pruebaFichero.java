/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

/**
 *
 * @author Alumno
 */
import java.io.*;
import java.util.Scanner;
public class pruebaFichero {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

            System.out.println("Dime el nombre de un fichero (indicando ruta con \\\\");
            String ruta = teclado.nextLine();
            File fichero = new File(ruta);
            if (fichero.exists()){
                System.out.println("Ruta completa = " + fichero.getAbsolutePath());
                System.out.println("Es fichero? = " + fichero.isFile());
                System.out.println("Es un directorio? = " + fichero.isDirectory());
                System.out.println("Se puede leer? = " + fichero.canRead());
                System.out.println("Se puede escribir? = " + fichero.canWrite());
            } else {
                System.out.println("El fichero no existe");
            }
        
    }
    
}
