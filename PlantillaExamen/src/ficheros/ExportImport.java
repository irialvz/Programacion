package ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import x4_fichero_alumnos.Alumno;

public class ExportImport {
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
    public static void eliminarEmpleadoPorDNI(String dniAEliminar, String rutaArchivo) {
        File archivoOriginal = new File(rutaArchivo);
        File archivoTemporal = new File("temporal.txt");

        try  {
        	BufferedReader lector = new BufferedReader(new FileReader(archivoOriginal));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoTemporal));
            String linea;

            while ((linea = lector.readLine()) != null) {
                if (!linea.contains(dniAEliminar)) {
                    escritor.write(linea);
                    escritor.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
            return;
        }

        // Reemplazar el archivo original con el temporal
        if (archivoOriginal.delete()) {
            if (!archivoTemporal.renameTo(archivoOriginal)) {
                System.out.println("No se pudo renombrar el archivo temporal.");
            }
        } else {
            System.out.println("No se pudo eliminar el archivo original.");
        }
    }

    public static void eliminarEmpleadosMenoresDe50(String rutaArchivo) {
        File archivoOriginal = new File(rutaArchivo);
        File archivoTemporal = new File("temporal.txt");

        try {

            BufferedReader lector = new BufferedReader(new FileReader(archivoOriginal));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoTemporal));
            String linea;

            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length >= 3) {
                    try {
                        int edad = Integer.parseInt(partes[2].trim());
                        if (edad >= 50) {
                            escritor.write(linea);
                            escritor.newLine();
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Edad no válida en la línea: " + linea);
                        // Si hay un error, puedes decidir mantener la línea o no
                    }
                } else {
                    System.out.println("Formato incorrecto en la línea: " + linea);
                    // Puedes decidir si guardarla igual:
                    // escritor.write(linea); escritor.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
            return;
        }

        // Reemplazar el archivo original con el temporal
        if (archivoOriginal.delete()) {
            if (!archivoTemporal.renameTo(archivoOriginal)) {
                System.out.println("No se pudo renombrar el archivo temporal.");
            }
        } else {
            System.out.println("No se pudo eliminar el archivo original.");
        }
    }
	/* LEER FICHERO MAIN
	 * BufferedReader br = null;
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
	 * */

}
