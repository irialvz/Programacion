/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
public class Actividad1x01 {

    public static void main(String[] args) {
        try {
            File entrada = new File("entrada.txt");
            FileWriter fichEnt = new FileWriter(entrada);
            fichEnt.write("Este es el principio\n");
            fichEnt.write("Hola\n");
            fichEnt.write("Este es un fichero de texto\n");
            fichEnt.write("Adios\n");
            fichEnt.write("Este es el fin\n");
            fichEnt.close();
            FileReader fichLec = new FileReader(entrada);
            int c = fichLec.read();
            System.out.println("Fichero entrada.txt");
            while (c != -1) {
                System.out.print((char) c);
                c = fichLec.read();
            }

            File salida = new File("salida.txt");
            FileWriter fichSal = new FileWriter(salida);
            fichSal.write("Este es el fin\n");
            fichSal.write("Adios\n");
            fichSal.write("Este es un fichero de texto\n");
            fichSal.write("Hola\n");
            fichSal.write("Este es el principio\n");
            fichSal.close();
            FileReader fichLec2 = new FileReader(salida);
            int d = fichLec2.read();
            System.out.println("\nFichero salida.txt");
            while (d != -1) {
                System.out.print((char) d);
                d = fichLec2.read();
            }

        } catch (IOException ex) {
            Logger.getLogger(Actividad1x01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
