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
	//CONSULTA TODOS LOS EMPLEADOS QUE GANAN MAS QUE UN SALARIO ESPECIFICADO
	public static List<Empleado> consultarEmpleados(double salario) throws BDException{

		List<Empleado> listaEmpleados = new ArrayList<Empleado>();
		PreparedStatement ps = null;
		Connection conexion = null;

		try {
			// Conexi�n a la bd
			conexion = ConfigBD.abrirConexion();

			String query = "SELECT * FROM empleados WHERE salario > ? ORDER BY nombre";

			ps = conexion.prepareStatement(query);
			// Al primer interrogante
			ps.setDouble(1, salario);
			

			ResultSet resultados = ps.executeQuery();
			while (resultados.next()) {
				int codigo = resultados.getInt("codigo");
				String nombreString = resultados.getString("nombre");
				String fechaString = resultados.getString("fecha_alta");
				Double salarioDouble = resultados.getString("salario");
				int codigoDepartamento = resultados.getInt("codigo_departamento");
				
				Departamento d = new Departamento(codigoDepartamento);
				Empleado e = new Empleado(codigo,nombreString,fechaString,salarioDouble,d);
				
				listaEmpleados.add(e);
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
	public static List<Empleado> consultarEmpleadosDepartamento(String ubicacion) throws BDException  {

		List<Departamento> listaDepartamentos = new ArrayList<Departamento>();
		PreparedStatement ps = null;
		Connection conexion = null;

		try {
			// Conexi�n a la bd			
			conexion = ConfigMySql.abrirConexion();
			String query = "SELECT * FROM empleados,departamento WHERE empleados.codigo_departamento = departamento.codigo AND salario > ? order by empleados.nombre;";
			ps = conexion.prepareStatement(query);
			// Al primer interrogante
			ps.setDouble(1, salario);		
			ResultSet resultados = sentencia.executeQuery();
			
			while (resultados.next()) {
				int codigo = resultados.getInt("codigo_empleado");
				String nombreString = resultados.getString("nombre_empleado");
				String fechaString = resultados.getString("fecha_alta");
				Double salarioDouble = resultados.getString("salario");
				int codigoDepartamento = resultados.getInt("codigo_departamento");
				String nombreDepartamentoString = resultados.getString("nombre_departamento");
				String ubicacion = resultados.getString("ubicacion");
				
				Departamento d = new Departamento(codigoDepartamento,nombreDepartamentoString,ubicacion);
				Empleado e = new Empleado(codigo,nombreString,fechaString,salarioDouble,d);
				
				listaEmpleados.add(e);
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
	}

	// UPDATE departamento SET ubicacion = "ubicacion" where codigo="codigo"
	
	
	// Consultar todos los departamentos ordenados por nombre
	//AÑADIR DEPARTAMENTO
	public static Lista<Departamento> agregarDepartamento(String nombre,String ubicacion){

		List<Departamento> listaDepartamentos = new ArrayList<Departamento>();
		PreparedStatement ps = null;
		Connection conexion = null;

		try {
			// Conexi�n a la bd			
			conexion = ConfigMySql.abrirConexion();
			String query = "INSERT INTO departamento (nombre,ubicacion) VALUES = ('" + nombre + "','" + ubicacion + "')";
			
			Statement sentencia = conexion.createStatement();			
			ResultSet resultados = sentencia.executeQuery(query);
					
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
	

	
}
