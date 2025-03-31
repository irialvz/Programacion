package config;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager; 	
import java.sql.SQLException;

public class ConfigOracle {
    private static final String URLBD = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
    private static final String USUARIO = "pruebaJav";
    private static final String CONTRASENYA = "CASE";

    public static Connection abrirConexion() throws Exception {
        Connection conexion = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
				conexion = DriverManager.getConnection(URLBD,USUARIO,CONTRASENYA);
				System.out.println("Conectado");
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return conexion;
    }

    public static void cerrarConexion(Connection conexion) throws Exception  {
        try {
            conexion.close();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }
}
