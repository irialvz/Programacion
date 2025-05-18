package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ConfigBDSQLite;
import excepciones.BDException;
import excepciones.BilleteException;
import modelo.Billete;
import modelo.Clase;

public class AccesoBillete {
	public static int ultimoID () throws BDException, BilleteException {
		int ultimo = 0;

		PreparedStatement ps = null;
		Connection conexion = null;

		
			// Conexi�n a la bd
			try {
				conexion = ConfigBDSQLite.abrirConexion();
				String query = "Select max(codigo) from billete";

		        ps = conexion.prepareStatement(query);
		        ResultSet resultados = ps.executeQuery();
		        
		        if (resultados == null) {
		        	throw new BilleteException("No se ha encontrado ningun id");
		        }
		        while (resultados.next()) {
		        	ultimo = resultados.getInt("codigo");
		        }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}finally {
				if (conexion != null) {
					ConfigBDSQLite.cerrarConexion(conexion);
				}
			}
		return ultimo;
	}
	public static boolean nuevoBillete(Billete b) throws BDException {
		int resultados = 0;
		PreparedStatement ps = null;
		Connection conexion = null;

		
			// Conexi�n a la bd
			try {
				conexion = ConfigBDSQLite.abrirConexion();
				String query = "INSERT INTO billete VALUES (?,?,?,?,?,?,?,?)";

		        ps = conexion.prepareStatement(query);
		        ps.setInt(1, b.getCodigo());
		        ps.setInt(2, b.getViajero().getCodigo());
		        ps.setInt(3, b.getEstacionOrigen().getCodigo());
		        ps.setInt(4, b.getEstacionDestino().getCodigo());
		        ps.setString(5, b.getFecha());
		        ps.setString(6, b.getHoraSalida());
		        ps.setString(7, b.getHoraLlegada());
		        ps.setDouble(8,b.getImporte());


		        resultados = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}finally {
				if (conexion != null) {
					ConfigBDSQLite.cerrarConexion(conexion);
				}
			}
		return resultados == 1;
	}

}
