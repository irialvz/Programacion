package x4_fichero_alumnos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerAlumnosDeFichero {
	
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			File fichero = new File("directorio/alumnos.txt");
			br = new BufferedReader(new FileReader(fichero));
			int contador = 0;
      		String linea = br.readLine(); 
      		while (linea != null) { 	
      			Alumno alumno = new Alumno(linea);
      			System.out.println(alumno.toString());
      			contador++;
      			linea = br.readLine();
      		}
      		System.out.println("Se han leído " + contador + " alumnos del fichero de texto.");
		}
		catch (FileNotFoundException fnfe) {                      
			System.out.println("Error al abrir el fichero: " + fnfe.getMessage());
			fnfe.printStackTrace();
		}
		catch (IOException ioe) {
			System.out.println("Error al leer del fichero: " + ioe.getMessage());
			ioe.printStackTrace();
		}
		catch (NumberFormatException nfe) {
			System.out.println("Error al convertir de cadena a n�mero: " + nfe.getMessage());
			nfe.printStackTrace();
		}
		finally {
			try {
				if (br != null) {
					br.close();
				}
			}
			catch (IOException ioe) {
				System.out.println("Error al cerrar el fichero: " + ioe.getMessage());
				ioe.printStackTrace();
			}
		}
	}

}
