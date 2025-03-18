package ejemploBD.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import org.sqlite.SQLiteConfig;

public class ConfigMySql {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URLBD = "jdbc:mysql://localhost:3306/empresa";//modificado
	
	private static final String usuario = "root";//modificado
	private static final String contraseña = "";	//modificado	
	
	/**
	 * 
	 * @return
	 */
	public static Connection abrirConexion() {
		Connection conexion = null;

		try {
			// Carga el driver
			Class.forName(DRIVER);
			// Abre conexi�n
			conexion = DriverManager.getConnection(URLBD,usuario,contraseña);			 
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al cargar driver" + e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al obtener la conexi�n a la bd" + e.getMessage());
			e.printStackTrace();
		}

		return conexion;

	}
	
	/**
	 * 
	 * @param conexion
	 */
	public static void cerrarConexion(Connection conexion) {
		// TODO Auto-generated method stub
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
