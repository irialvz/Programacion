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
import ejemploBD.modelo.Departamento;
import entrada.Teclado;

public class AccesoDepartamento {

	// Consulta los departamentos de la base de datos personal.db
	// con la misma ubicaci�n y ordenados por nombre de forma ascendente.
	public static List<Departamento> consultarDepartamentos2(String ubicacion) {// modificado

		List<Departamento> listaDepartamentos = new ArrayList<Departamento>();
		PreparedStatement ps = null;
		Connection conexion = null;

		try {
			// Conexi�n a la bd
			conexion = ConfigMySql.abrirConexion();// modificado

			String query = "SELECT * FROM departamento WHERE ubicacion = '" + ubicacion + "' order by nombre"; // modificado

			Statement sentencia = conexion.createStatement();

			ResultSet resultados = sentencia.executeQuery(query);

			while (resultados.next()) {
				Departamento departamento = new Departamento(resultados.getInt("codigo"),
						resultados.getString("nombre"), resultados.getString("ubicacion"));
				listaDepartamentos.add(departamento);
			}
		} catch (SQLException e) {
			System.out.println("Error al ejecutar la consulta consultarDepartamentos");
			e.printStackTrace();
		}

		finally {
			ConfigMySql.cerrarConexion(conexion);// modificado
		}
		return listaDepartamentos;
	}

	// consultar el departamento por codigo
	public static Departamento consultarDepartamento(int codigo) {
		Connection conexion = null;
		Departamento departamento = null;

		try {
			conexion = ConfigMySql.abrirConexion();

			String query = "SELECT * FROM departamento WHERE codigo =" + codigo;
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(query);

			if (resultados.next()) {
				departamento = new Departamento(resultados.getInt("codigo"), resultados.getString("nombre"),
						resultados.getString("ubicacion"));
			}
		} catch (SQLException e) {
			System.out.println("Error al ejecutar la consulta consultarDepartamentos");
			e.printStackTrace();
		} finally {
			ConfigMySql.cerrarConexion(conexion);// modificado
		}
		return departamento;
	}

	// MODIFICAR LA UBICACION DE UN DEPARTAMENTO
	public static boolean modificarUbicacionDepartamento(int codDepartamento, String ubicacion) {
		Departamento departamento = null;
		Connection conexion = null;
		int resultados = 0;
		try {
			conexion = ConfigMySql.abrirConexion();
			String query = "UPDATE departamento SET ubicacion = '" + ubicacion + "' WHERE codigo = " + codDepartamento;

			Statement sentencia = conexion.createStatement();
			resultados = sentencia.executeUpdate(query);
			
		} catch (SQLException e) {
			System.out.println("Error al ejecutar la consulta consultarDepartamentos");
			e.printStackTrace();
		} finally {
			ConfigMySql.cerrarConexion(conexion);// modificado
		}
		return resultados > 0;

	}
	//BORRAR UN DEPARTAMENTO POR CODIGO
	public static boolean eliminarDepartamento(int codDepartamento) {
		Departamento departamento = null;
		Connection conexion = null;
		int resultados = 0;
		try {
			conexion = ConfigMySql.abrirConexion();
			String queryDelete = "DELETE departamento WHERE codigo=" + codDepartamento;
			Statement sentencia = conexion.createStatement();
			resultados = sentencia.executeUpdate(queryDelete);
		} catch (SQLException e) {
			System.out.println("Error al ejecutar la consulta consultarDepartamentos");
			e.printStackTrace();
		} finally {
			ConfigMySql.cerrarConexion(conexion);// modificado
		}
		return resultados >0;
		
	}
	//CONSULTAR DEPARTAMENTOS ORDENADO POR NOMBRE
	public static List<Departamento> consultarDepartamentos2(String ubicacion) {// modificado

		List<Departamento> listaDepartamentos = new ArrayList<Departamento>();
		PreparedStatement ps = null;
		Connection conexion = null;

		try {
			// Conexi�n a la bd
			conexion = ConfigMySql.abrirConexion();// modificado

			String query = "SELECT * FROM departamento WHERE ubicacion = '" + ubicacion + "' order by nombre"; // modificado

			Statement sentencia = conexion.createStatement();

			ResultSet resultados = sentencia.executeQuery(query);

			while (resultados.next()) {
				Departamento departamento = new Departamento(resultados.getInt("codigo"),
						resultados.getString("nombre"), resultados.getString("ubicacion"));
				listaDepartamentos.add(departamento);
			}
		} catch (SQLException e) {
			System.out.println("Error al ejecutar la consulta consultarDepartamentos");
			e.printStackTrace();
		}

		finally {
			ConfigMySql.cerrarConexion(conexion);// modificado
		}
		return listaDepartamentos;
	}
	

	// Consulta los departamentos de la base de datos con la misma ubicaci�n y
	// ordenados por nombre de forma ascendente.
	public static void main(String[] args) {

		// Realiza la consulta
		//int codigo = Teclado.leerEntero("¿Codigo?");
		System.out.println(AccesoDepartamento.consultarDepartamento(2));
		Boolean departamentos = AccesoDepartamento.modificarUbicacionDepartamento(2,"Zaragoza");// modificado
		if (departamentos) {
			System.out.println("Se ha modificado correctamente");
			System.out.println(AccesoDepartamento.consultarDepartamento(2));
		}else {
			System.out.println("No se ha encontrado");
		}

	}

	/*
	 * sudo mysql alter user 'root'@'localhost' identified with
	 * mysql_native_password by 'password';
	 * 
	 * create user 'prompt'@'localhost' identified by 'case'
	 * 
	 * grant all privileges on empresa.* to 'prompt'@'localhost';
	 */
}
