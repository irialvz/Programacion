package bd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class Csv {
	/**
	 * Exporta a csv la lista de trabajadores actual
	 * ESTO SE PONE EN LA CLASE DE GESTION
	 * 
	 * @param rutaFichero
	 * @param Trabajadores
	 * @return
	 */
	
		
		public static boolean exportarFicheroCSV(String rutaFichero, ArrayList<Trabajador> Trabajadores) {
			boolean existoso = false;
			BufferedWriter bw = null;
			try {
				File fichero = new File(rutaFichero);
				bw = new BufferedWriter(new FileWriter(fichero, false));
				for (Trabajador trabajador : Trabajadores) {
					bw.write(trabajador.toStringWithSeparators());
					bw.newLine();
					existoso = true;
				}
			} catch (IOException ioe) {
				System.out.println("Error al escribir en el fichero: " + ioe.getMessage());
				ioe.printStackTrace();
			} finally {
				try {
					if (bw != null) {
						bw.close();
					}
				} catch (IOException ioe) {
					System.out.println("Error al cerrar el fichero: " + ioe.getMessage());
					ioe.printStackTrace();
				}
			}
			return existoso;
		}
	
		public static ArrayList<Empleado> importarFicheroCsv(String nombreFichero) {
			ArrayList<Empleado> empleados = new ArrayList<Empleado>();
			BufferedReader br = null;
			try {
				// Abre fichero de alumnos en modo lectura
				br = new BufferedReader(new FileReader(new File(nombreFichero)));
				
				// Lectura linea por línea del fichero de empleados
	      		String linea = br.readLine(); 
	      		while (linea != null) { 
	      			Empleado empleado = new Empleado(linea);
	      			try {
	      				AccesoEmpleado.añadirEmpleado(empleado);
	      			}catch (BDException e) {
						// TODO: handle exception
	      				AccesoEmpleado.modificarEmpleado(empleado);
					}
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
			} catch (BDException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
			
			return empleados;
		}
	/**
	 * ACTION MAIN GUI
	 */
	
		/*
		 else if (e.getSource() == csv) {
				resultado = ficheroSeleccionado.showSaveDialog(this);
				if (resultado == JFileChooser.APPROVE_OPTION) {
					ruta = ficheroSeleccionado.getSelectedFile().getAbsolutePath();
				}
				try {
					listaTrabajadores = TablaTrabajadores.obtenerTrabajadores();
					if (TablaTrabajadores.exportarFicheroCSV(ruta, listaTrabajadores)) {
						JOptionPane.showMessageDialog(this, "Se ha generado correctamente");
						dispose();
					}
				} catch (BDException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);			}
			}*/

}
