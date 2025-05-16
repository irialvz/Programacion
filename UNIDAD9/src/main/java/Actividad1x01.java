/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
public class Actividad1x01 {

    public static void main(String[] args) {
        try {
        	ArrayList<String> contenido = new ArrayList<>();
        	//CREAR ENTRADA TXT
            File entrada = new File("entrada.txt");
            FileWriter fichEnt = new FileWriter(entrada);
            fichEnt.write("Este es el principio\n");
            fichEnt.write("Hola\n");
            fichEnt.write("Este es un fichero de texto\n");
            fichEnt.write("Adios\n");
            fichEnt.write("Este es el fin\n");
            fichEnt.close();
            
            //sacar por pantalla contenido
            
            FileReader fichLec = new FileReader(entrada);
            BufferedReader lector = new BufferedReader(fichLec);
            String hayLinea = lector.readLine();
            System.out.println("Fichero entrada.txt");
            while (hayLinea != null) {
            	contenido.add(hayLinea);
                hayLinea = lector.readLine();
            }
            lector.close();
            for (String l : contenido) {
            	System.out.println(l);
            }
            fichLec.close();
            //CREAR SALIDA TXT
            File salida = new File("salida.txt");
            FileWriter fichSal = new FileWriter(salida);
            int numeroLineas = (int) Files.lines(entrada.toPath()).count();
            for (int i = numeroLineas -1;i >= 0;i--) {
            	fichSal.write(contenido.get(i) + "\n");
            }
            fichSal.close();
            
            FileReader fichLecSal = new FileReader(salida);
            BufferedReader lectorSal = new BufferedReader(fichLecSal);
            String lineaSalida = lectorSal.readLine();
            System.out.println("\nFichero salida.txt");

            while (lineaSalida != null) {
            	System.out.println(lineaSalida);
                lineaSalida = lectorSal.readLine();
            }
            lectorSal.close();

        } catch (IOException ex) {
            Logger.getLogger(Actividad1x01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
