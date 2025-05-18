package exportar;

import java.io.BufferedWriter;
import java.io.File;
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
	
		/*
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
		}*/
	
	/**
	 * 
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
