package ejemploBD.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ejemploBD.config.ConfigBD;
import ejemploBD.config.ConfigMySql;
import ejemploBD.excepciones.BDException;
import ejemploBD.modelo.Departamento;
import entrada.Teclado;

public class AccesoDepartamento {

	/**
	 * Consulta los departamentos de la base de datos personal.db
	 *  con la misma ubicaci�n y ordenados por nombre de forma ascendente.
	 * @param ubicacion
	 * @return
	 * @throws BDException
	 */
	public static List<Departamento> consultarDepartamentos(String ubicacion) throws BDException{

		List<Departamento> listaDepartamentos = new ArrayList<Departamento>();
		PreparedStatement ps = null;
		Connection conexion = null;

		try {
			// Conexi�n a la bd
			conexion = ConfigBD.abrirConexion();

			String query = "SELECT * FROM departamento WHERE ubicacion = ? ORDER BY nombre";

			ps = conexion.prepareStatement(query);
			// Al primer interrogante
			ps.setString(1, ubicacion);

			ResultSet resultados = ps.executeQuery();
			while (resultados.next()) {
				Departamento departamento = new Departamento(resultados.getInt("codigo"),
						resultados.getString("nombre"), resultados.getString("ubicacion"));
				listaDepartamentos.add(departamento);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BDException(BDException.ERROR_QUERY + e.getMessage());
		}		
		finally {
			if (conexion!=null) {
				ConfigMySql.cerrarConexion(conexion);
			}
		}
		return listaDepartamentos;
	}

	/**
	 * Consulta los departamentos de la base de datos
	 * con la misma ubicaci�n y ordenados por nombre de forma ascendente.
	 * @param ubicacion
	 * @return
	 * @throws BDException
	 */
	public static List<Departamento> consultarDepartamentos2(String ubicacion) throws BDException  {

		List<Departamento> listaDepartamentos = new ArrayList<Departamento>();
		Connection conexion = null;

		try {
			// Conexi�n a la bd			
			conexion = ConfigMySql.abrirConexion();
			String query = "SELECT * FROM departamento WHERE ubicacion = '" + ubicacion + "' order by nombre";
			
			Statement sentencia = conexion.createStatement();			
			ResultSet resultados = sentencia.executeQuery(query);
			
			while (resultados.next()) {
				Departamento departamento = new Departamento(resultados.getInt("codigo"),
						resultados.getString("nombre"), resultados.getString("ubicacion"));
				listaDepartamentos.add(departamento);
			}			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BDException(BDException.ERROR_QUERY + e.getMessage());
		}		
		finally {
			if (conexion!=null) {
				ConfigMySql.cerrarConexion(conexion);
			}
		}
		return listaDepartamentos;
	}
	
	// Consultar el departamento por c�digo
	
	
	// Modificar la ubicaci�n de un departamento
	// UPDATE departamento SET ubicacion = "ubicacion" where codigo="codigo"
	
	
	
	// Borrar un departamento por c�digo
	
	
	
	
	
	// Consultar todos los departamentos ordenados por nombre
	
	

	
}
