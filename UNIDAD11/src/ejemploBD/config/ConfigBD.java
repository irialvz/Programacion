package ejemploBD.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.sqlite.SQLiteConfig;

import ejemploBD.excepciones.BDException;

public class ConfigBD {

	private static final String DRIVER = "org.sqlite.JDBC";
	private static final String URLBD = "jdbc:sqlite:db/personal.db";
	
	
	/**
	 * Abre conexión con la base de datos sqllite
	 * @return
	 * @throws BDException
	 */
	public static Connection abrirConexion() throws BDException {
		Connection conexion = null;

		try {
			// Carga el driver
			Class.forName(DRIVER);
			SQLiteConfig config = new SQLiteConfig();  
	        config.enforceForeignKeys(true);
			// Abre conexión
			conexion = DriverManager.getConnection(URLBD,config.toProperties());			 
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new BDException(BDException.ERROR_CARGAR_DRIVER + e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BDException(BDException.ERROR_ABRIR_CONEXION + e.getMessage());
		}

		return conexion;

	}
	
	/**
	 * Cierra conexión con SQLLite
	 * @param conexion
	 * @throws BDException 
	 */
	public static void cerrarConexion(Connection conexion) throws BDException {
		try {
			conexion.close();
		} catch (SQLException e) {
			throw new BDException(BDException.ERROR_CERRAR_CONEXION + e.getMessage() );
		}
	}

}
