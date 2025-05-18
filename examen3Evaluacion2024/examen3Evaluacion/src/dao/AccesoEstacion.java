package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ConfigBDSQLite;
import excepciones.BDException;
import modelo.Estacion;

public class AccesoEstacion {
	public static Estacion obtenerEstacion(String nombreEstacion) throws BDException {
		Estacion estacion = null;
		PreparedStatement ps = null;
		Connection conexion = null;

		
			// Conexi�n a la bd
			try {
				conexion = ConfigBDSQLite.abrirConexion();
				String query = "SELECT * FROM estacion where nombre = ?;";

				
		        ps = conexion.prepareStatement(query);
		        ps.setString(1, nombreEstacion);
		        ResultSet resultados = ps.executeQuery();
		        while (resultados.next()) {
		        	int codigo = resultados.getInt("codigo");
		        	String nombre = resultados.getString("nombre");
		        	String ubicacion = resultados.getString("ubicacion");
		        	int anyo_inauguracion = resultados.getInt("agno_inauguracion");
		        	int vias = resultados.getInt("vias");
		        	
		        	estacion = new Estacion(codigo,nombre,ubicacion,anyo_inauguracion,vias);
		        	
		        }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}finally {
				if (conexion != null) {
					ConfigBDSQLite.cerrarConexion(conexion);
				}
			}
		return estacion;
	}

}
