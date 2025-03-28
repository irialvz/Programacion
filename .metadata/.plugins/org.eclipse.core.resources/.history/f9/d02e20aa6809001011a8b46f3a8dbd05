package x4_fichero_alumnos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GestionAlumnos {
	
	public static ArrayList<Alumno> importarFicheroAlumnos(String nombreFichero){
		
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		BufferedReader br = null;
		try {
			// Abre fichero de alumnos en modo lectura
			br = new BufferedReader(new FileReader(new File(nombreFichero)));
			
			// Lectura linea por línea del fichero de alumnos
      		String linea = br.readLine(); 
      		while (linea != null) { 
      			// Construye alumno a partir de la linea
      			Alumno alumno = new Alumno(linea);
      			// Inserta el alumno en el Array
      			alumnos.add(alumno);
      			linea = br.readLine();
      		}     		
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
		
		return alumnos;
	}
	
	/**
	 * 
	 * @param alumnos
	 * @return
	 */
	public static void exportarFicheroAlumnos(String nombreFichero, ArrayList<Alumno> alumnos){
		BufferedWriter bw = null;
		try {
			File fichero = new File(nombreFichero);
			bw = new BufferedWriter(new FileWriter(fichero, false));
			for (Alumno alumno: alumnos) {				
				bw.write(alumno.toStringWithSeparators());
				bw.newLine();
			}
		} 
		catch(IOException ioe) {
			System.out.println("Error al escribir en el fichero: " + ioe.getMessage());
			ioe.printStackTrace();
		}
		finally {
			try {
				if (bw != null) {
					bw.close();
				}
			}
			catch (IOException ioe) {
				System.out.println("Error al cerrar el fichero: " + ioe.getMessage());
				ioe.printStackTrace();
			}
		}
	}
	
	
	
	public static ArrayList<Alumno> alumnosConMinimaNota(ArrayList<Alumno> alumnos) {
		
		// primero saco la nota mínima
		double minimo = 10;
		for (Alumno alumno: alumnos) {
			double nota = alumno.getNota();
			if (nota<minimo) {
				minimo = nota;
			}
		}	
		
		// busco todos los que tengan la nota mínima
		ArrayList<Alumno> alumnosMinimaNota = new ArrayList<Alumno>();
		for (Alumno alumno: alumnos) {
			double nota = alumno.getNota();
			if (nota==minimo) {
				// Añado al array
				alumnosMinimaNota.add(alumno);
			}
		}
		
		return alumnosMinimaNota;	
	}

	public static void main(String[] args) {
				
		ArrayList<Alumno> alumnos = importarFicheroAlumnos("directorio/alumnos.txt");		
		ArrayList<Alumno> alumnosMinimaNota = alumnosConMinimaNota(alumnos);
		exportarFicheroAlumnos("directorio/alumnosMinimaNota" , alumnosMinimaNota);
		
		System.out.println("Se han exportado los datos de los alumnos con mínima nota");
		
	}

}
