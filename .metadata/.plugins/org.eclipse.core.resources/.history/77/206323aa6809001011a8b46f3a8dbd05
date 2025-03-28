package x4_fichero_alumnos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import entrada.Teclado;

public class EscribirAlumnoEnFichero {

	public static void main(String[] args) {
		BufferedWriter bw = null;
		try {
			File fichero = new File("alumnos.txt");
			bw = new BufferedWriter(new FileWriter(fichero, true));
			
			int codigo = Teclado.leerNatural("Código del Alumno? ");
			String nombre = Teclado.leerCadena("Nombre del Alumno? ");
			double nota = Teclado.leerReal("Nota del Alumno? ");
			Alumno alumno = new Alumno(codigo, nombre, nota);
			bw.write(alumno.toStringWithSeparators());
			bw.newLine();
			System.out.println("Se ha escrito el alumno \'" + alumno.toString() + "\' en el fichero de texto.");
		} 
		catch (IOException ioe) {
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

}
