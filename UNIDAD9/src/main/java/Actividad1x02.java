/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
public class Actividad1x02 {

    public static void main(String[] args) {
        int contadorCaracteres = 0;
        Scanner teclado = new Scanner(System.in);
        try {
            System.out.println("Nombre de fichero?");
            String nombreTxt = teclado.nextLine();
            File fichero = new File(nombreTxt);
            if (fichero.exists()) {
                FileReader fichLec = new FileReader(fichero);
                int c = fichLec.read();
                while (c != -1) {
                    contadorCaracteres++;
                    fichLec.read();
                }

            } else if (!fichero.exists()) {
                throw new Exception("El archivo no existe en el sistema");
            } else if (fichero.isDirectory()) {
                throw new Exception("El archivo no es un fichero");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Actividad1x02.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Actividad1x02.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Actividad1x02.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
