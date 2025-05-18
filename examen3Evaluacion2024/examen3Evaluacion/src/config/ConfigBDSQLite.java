package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.sqlite.SQLiteConfig;

import excepciones.BDException;

public class ConfigBDSQLite {
	private static final String DRIVER = "org.sqlite.JDBC";
	private static final String URLBD = "jdbc:sqlite:data/transporte_ferroviario.db";

	public static Connection abrirConexion() throws BDException {
		Connection conexion = null;
		try {
			// Cargar el driver
			Class.forName(DRIVER);
			SQLiteConfig config = new SQLiteConfig();
			config.enforceForeignKeys(true);
			// Abrir la conexion mediante la url donde se encuentra la BD
			conexion = DriverManager.getConnection(URLBD, config.toProperties());
		} catch (ClassNotFoundException cnf) {
			throw new BDException(BDException.ERROR_CARGAR_DRIVER + cnf.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BDException(BDException.ERROR_ABRIR_CONEXION + e.getMessage());
		}
		return conexion;
	}

	public static void cerrarConexion(Connection conexion) throws BDException {
		try {
			conexion.close();
		} catch (SQLException sqle) {
			throw new BDException(BDException.ERROR_CERRAR_CONEXION + sqle.getMessage() );
		}
	}
}
