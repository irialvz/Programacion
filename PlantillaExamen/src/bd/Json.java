package bd;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



public class Json {
	/**
	 * Exporta a JSON la lista de trabajadores actual
	 * 
	 * SE AÑADE EN LA CLASE DE GESTION (GestionEmpleados,GestionAlumnos...)
	 * @param rutaFichero
	 * @param Trabajadores
	 * @return
	 */
	
	public static boolean exportarFicheroJson(String rutaFichero, ArrayList<Clase> Trabajadores) {
		boolean existoso = false;
		BufferedWriter bw = null;

		try {
			FileWriter fl = new FileWriter(rutaFichero);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(Trabajadores);
			fl.write(json);
			fl.flush();

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
	
	/**
	 *  ACTION PERFORMED DEL MAIN
	 *  declarar JFileChooser para ficheroSeleccionado,debe estar inicializado
	 *  eso nos permite tener una ventana para elegir la ubicacion del archivo
	 */
	
	/*
	 else if (e.getSource() == json) {
			resultado = ficheroSeleccionado.showSaveDialog(this);
			if (resultado == JFileChooser.APPROVE_OPTION) {
				ruta = ficheroSeleccionado.getSelectedFile().getAbsolutePath();
			}
			try {
				listaTrabajadores = TablaTrabajadores.obtenerTrabajadores();
				if (TablaTrabajadores.exportarFicheroJson(ruta, listaTrabajadores)) {
					JOptionPane.showMessageDialog(this, "Se ha generado correctamente");
					dispose();
				}
			} catch (BDException ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);			
				}
			
		}
	 */

}
