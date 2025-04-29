package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ConfigSQLite;
import excepciones.BDException;
import modelo.Trabajador;

public class TablaTrabajadores {
	public static boolean crearTabla() throws BDException {
		int resultados = 0;
		PreparedStatement ps = null;
		Connection conexion = null;

		
			// Conexi�n a la bd
			try {
				conexion = ConfigSQLite.abrirConexion();
				String query = "CREATE TABLE IF NOT EXISTS Trabajadores ( id INTEGER PRIMARY KEY AUTOINCREMENT,"
						+ "dni TEXT UNIQUE NOT NULL,"
						+ "nombre TEXT NOT NULL,"
						+ "apellidos TEXT NOT NULL,"
						+ "telefono TEXT NOT NULL,"
						+ "puesto TEXT)";

				
				ps = conexion.prepareStatement(query);
				resultados = ps.executeUpdate();
				
			} catch (BDException | SQLException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}finally {
				if (conexion != null) {
					ConfigSQLite.cerrarConexion(conexion);
				}
			}
		return resultados == 1;

	}
	public static boolean insertarOActualizar(Trabajador trabajador) throws BDException {
		int resultados = 0;
		PreparedStatement ps = null;
		Connection conexion = null;

		
			// Conexi�n a la bd
			try {
				conexion = ConfigSQLite.abrirConexion();
				String query = "INSERT INTO Trabajadores (dni,nombre,apellidos,telefono,puesto) "
						+ "VALUES (?,?,?,?,?) "
						+ "ON CONFLICT (dni) DO UPDATE SET "
						+ "nombre = excluded.nombre,"
						+ "apellidos = excluded.apellidos,"
						+ "telefono = excluded.telefono,"
						+ "puesto = excluded.puesto";

				
		        ps = conexion.prepareStatement(query);
		        ps.setString(1, trabajador.getDni());
		        ps.setString(2, trabajador.getNombre());
		        ps.setString(3, trabajador.getApellidos());
		        ps.setString(4,trabajador.getTelefono());
		        ps.setString(5, trabajador.getPuesto());
				
		        resultados = ps.executeUpdate();
			} catch (BDException | SQLException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}finally {
				if (conexion != null) {
					ConfigSQLite.cerrarConexion(conexion);
				}
			}
		return resultados == 1;

	}
}
