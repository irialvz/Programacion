package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ConfigBDSQLite;
import excepciones.BDException;
import modelo.Clase;
import modelo.Viajero;

public class AccesoViajero {
	public static Viajero obtenerViajero(int identificador) throws BDException{
		Viajero v = null;
		Clase c = null;
		PreparedStatement ps = null;
		Connection conexion = null;

		
			// Conexi�n a la bd
			try {
				conexion = ConfigBDSQLite.abrirConexion();
				String query = "SELECT * FROM viajero where codigo = ?;";

				
		        ps = conexion.prepareStatement(query);
		        ps.setInt(1, identificador);
		        ResultSet resultados = ps.executeQuery();
		        
		        while (resultados.next()) {
		        	//int codigo = resultados.getInt("codigo");
		        	int codigoClase = resultados.getInt("codigo_clase");
		        	String nombre = resultados.getString("nombre");
		        	String fecha_nacimiento = resultados.getString("fecha_nacimiento");
		        	String lugar_residencia = resultados.getString("lugar_residencia");
		        	String correo = resultados.getString("correo");
		        	int puntos = resultados.getInt("puntos");
		        	
		        	c = AccesoClase.obtenerClase(codigoClase);
		        	v = new Viajero(identificador,c,nombre,fecha_nacimiento,lugar_residencia,correo,puntos);
		        	
		        }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}finally {
				if (conexion != null) {
					ConfigBDSQLite.cerrarConexion(conexion);
				}
			}
		return v;
		
	}

}
