package ficheros;

import java.io.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Trabajador;

/**
 * @author alumno
 *
 */
public class FicheroDatos {
	
	public static List<Trabajador> leerFicheroBinario(String rutaFichero){
		List<Trabajador> lista = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaFichero))) {
            lista = (List<Trabajador>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se pudo leer el fichero: " + e.getMessage());
        }
        return lista;
	}
	
	
	/**
	 * Escribe un ArrayList en el fichero
	 * @param ruta
	 * @param trabajadores
	 */
	public static void escribirTrabajadores(String ruta, ArrayList<Trabajador> trabajadores){
		
		DataOutputStream fichero = null;
		try {
			fichero = new DataOutputStream (new FileOutputStream(ruta)); 
			for(int i=0; i<trabajadores.size(); i++){
				fichero.writeInt(trabajadores.get(i).getIdentificador());
				fichero.writeUTF(trabajadores.get(i).getDni());
				fichero.writeUTF(trabajadores.get(i).getNombre());
				fichero.writeUTF(trabajadores.get(i).getApellidos());
				fichero.writeUTF(trabajadores.get(i).getDireccion());
				fichero.writeUTF(trabajadores.get(i).getTelefono());
				fichero.writeUTF(trabajadores.get(i).getPuesto());
			}		
		} 
		catch (FileNotFoundException e1){
			System.out.printf("Error al abrir fichero para escritura");
		}
		catch (IOException e){ 
			System.out.printf("Error al escribir en el fichero%n"); 
		} 
		finally{ 
			try{
			fichero.close();
			} 
			catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}		
	}
	

	/**
	 * Devuelve un arraylist con los trabajadores del fichero
	 * @param rutaFichero
	 * @return
	 */
	public static ArrayList<Trabajador> obtenerTrabajadores(String rutaFichero) {

		DataInputStream ficheroDatos=null;
		ArrayList<Trabajador> trabajadoresLeidos = new ArrayList <Trabajador>();
		Trabajador t = null;
		try {
			ficheroDatos=new DataInputStream(new FileInputStream(rutaFichero));
			while (true){
				int id = ficheroDatos.readInt();
				String dni =ficheroDatos.readUTF();
				String nombre =ficheroDatos.readUTF();
				String apellidos =ficheroDatos.readUTF();
				String direccion =ficheroDatos.readUTF();
				String telefono =ficheroDatos.readUTF();
				String puesto =ficheroDatos.readUTF();
				t = new Trabajador(id,dni,nombre,apellidos,direccion,telefono,puesto);
				trabajadoresLeidos.add(t);				
			}			
		}
		catch (EOFException e){

		} 
		catch (FileNotFoundException e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);		
			} 
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);		}
		finally{
			try {
				ficheroDatos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			} 
		}
		
		return trabajadoresLeidos;
	}

}
