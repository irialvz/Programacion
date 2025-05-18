package dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ConfigBDSQLite;
import excepciones.BDException;
import modelo.Clase;

public class AccesoClase {
	public static ArrayList<Clase> obtenerClases() throws BDException{
		ArrayList<Clase> clasesAerolinea= new ArrayList<Clase>();
		PreparedStatement ps = null;
		Connection conexion = null;

		
			// Conexi�n a la bd
			try {
				conexion = ConfigBDSQLite.abrirConexion();
				String query = "SELECT * FROM clase;";

				
		        ps = conexion.prepareStatement(query);
		        ResultSet resultados = ps.executeQuery();
		        while (resultados.next()) {
		        	int codigo = resultados.getInt("codigo");
		        	String nombre = resultados.getString("nombre");
		        	double consumo_minimo_anual = resultados.getDouble("consumo_minimo_anual");
		        	int porcentaje_adicional = resultados.getInt("porcentaje_adicional");
		        	
		        	Clase c = new Clase(codigo,nombre,consumo_minimo_anual,porcentaje_adicional);
		        	clasesAerolinea.add(c);
		        	
		        }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}finally {
				if (conexion != null) {
					ConfigBDSQLite.cerrarConexion(conexion);
				}
			}
		return clasesAerolinea;
		
	}
	
	public static Clase obtenerClase(int identificador) throws BDException {
		Clase clase = null;
		PreparedStatement ps = null;
		Connection conexion = null;

		
			// Conexi�n a la bd
			try {
				conexion = ConfigBDSQLite.abrirConexion();
				String query = "SELECT * FROM clase where codigo = ?;";

				
		        ps = conexion.prepareStatement(query);
		        ps.setInt(1, identificador);
		        ResultSet resultados = ps.executeQuery();
		        while (resultados.next()) {
		        	int codigo = resultados.getInt("codigo");
		        	String nombre = resultados.getString("nombre");
		        	double consumo_minimo_anual = resultados.getDouble("consumo_minimo_anual");
		        	int porcentaje_adicional = resultados.getInt("porcentaje_adicional");
		        	
		        	Clase c = new Clase(codigo,nombre,consumo_minimo_anual,porcentaje_adicional);
		        	
		        }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}finally {
				if (conexion != null) {
					ConfigBDSQLite.cerrarConexion(conexion);
				}
			}
		return clase;
	}
	public static void exportarFicheroTexto(String ruta) {
		BufferedWriter bw = null;
		try {
			ArrayList<Clase> listaClases = obtenerClases();
			bw = new BufferedWriter(new FileWriter(ruta,false));
			for (int i=0;i< listaClases.size();i++) {
				Clase c = listaClases.get(i);
				bw.write(c.toString());
			}
			bw.newLine();
		} catch (IOException e) {
			System.out.println("Error en el dispositivo entrada/salida: " + e.getMessage());
			e.printStackTrace();
		} catch (BDException e) {
			System.out.println("Error en la conexion: " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					System.out.println("Error al cerrar el fichero " + e.getMessage());
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
