/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD9.pruebas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
public class NewClass {

    public static void main(String[] args) {
        try {
            File ruta = new File("prueba.txt");
            FileWriter fichEsc = new FileWriter(ruta);
            fichEsc.write('c');
            fichEsc.write('H');
            fichEsc.write("Hola");
            fichEsc.write("105");
            fichEsc.close();

            System.out.println(System.getProperty("user.dir"));

            FileReader fichLec = new FileReader(ruta);
            int c=fichLec.read();
            while (c != -1){ //mientras tengo caracteres... si devuelve -1 ha llegado al final
                System.out.println((char)c);
                c=fichLec.read();
            }
            fichLec.close();
            
            //FICHEROS DE BITES
            File ruta2 = new File("prueba.dat");
            FileOutputStream fos = new FileOutputStream(ruta2);
            fos.write('c');
            fos.write(9);
            fos.close();
            FileInputStream fis = new FileInputStream(ruta2);
            System.out.println((char) fis.read() + " " + fis.read() + " " + fis.read() + " ");
            fis.close();
            
            //
            File ruta3 = new File("prueba2.dat");
            FileOutputStream fos2 = new FileOutputStream(ruta3);
            DataOutputStream dos = new DataOutputStream(fos2);
            
            dos.writeInt(45645646);
            dos.writeDouble(5456.1245);
            dos.writeUTF("puto DAW");
            dos.writeBoolean(true);
            
            dos.close();
            fos.close();
            
            FileInputStream fis2 = new FileInputStream(ruta3);
            DataInputStream dis2 = new DataInputStream(fis2);
            
            System.out.println(dis2.readInt() + " "+ dis2.readDouble() + " "+ dis2.readUTF() + " " + dis2.readBoolean() );
        } catch (IOException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
