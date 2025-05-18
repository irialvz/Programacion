package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ConfigSQLite;
import ejemploBD.modelo.Departamento;
import ejemploBD.modelo.Empleado;
import excepciones.BDException;
import modelo.Trabajador;

public class Gestion {

	/**
	 * Agrega un trabajador a la base de datos
	 * 
	 * @param Trabajador
	 * @return boolean confimando si ha sido exitoso
	 * @throws BDException
	 */
	public static boolean agregarTrabajador(Trabajador t) throws BDException {
		int resultados = 0;
		PreparedStatement ps = null;
		Connection conexion = null;

		// Conexi�n a la bd
		try {
			conexion = ConfigSQLite.abrirConexion();
			String query = "INSERT INTO Trabajadores (dni,nombre,apellidos,direccion,telefono,puesto)"
					+ "VALUES(?,?,?,?,?,?) ";

			ps = conexion.prepareStatement(query);
			ps.setString(1, t.getDni());
			ps.setString(2, t.getNombre());
			ps.setString(3, t.getApellidos());
			ps.setString(4, t.getDireccion());
			ps.setString(5, t.getTelefono());
			ps.setString(6, t.getPuesto());

			resultados = ps.executeUpdate();

		} catch (BDException | SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} finally {
			if (conexion != null) {
				ConfigSQLite.cerrarConexion(conexion);
			}
		}
		return resultados == 1;
	}
	/**
	 * Modifica los parametros de un trabajador segun su ID
	 * 
	 * @param Trabajador
	 * @return boolean confimando si ha sido exitoso
	 * @throws BDException
	 */
	public static boolean modificarTrabajador(Trabajador t) throws BDException {
		int resultados = 0;
		PreparedStatement ps = null;
		Connection conexion = null;

		// Conexi�n a la bd
		try {
			conexion = ConfigSQLite.abrirConexion();
			String query = "UPDATE Trabajadores SET dni = ?, nombre = ?, apellidos = ?, direccion = ?, telefono = ?, puesto = ? WHERE id = ?";
			ps = conexion.prepareStatement(query);

			ps.setString(1, t.getDni());
			ps.setString(2, t.getNombre());
			ps.setString(3, t.getApellidos());
			ps.setString(4, t.getDireccion());
			ps.setString(5, t.getTelefono());
			ps.setString(6, t.getPuesto());
			ps.setInt(7, t.getIdentificador());

			resultados = ps.executeUpdate();

		} catch (BDException | SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} finally {
			if (conexion != null) {
				ConfigSQLite.cerrarConexion(conexion);
			}
		}
		return resultados == 1;

	}
	/**
	 * Da de baja al trabajador introducido si el ID es valido
	 * 
	 * @param identificador
	 * @return
	 * @throws BDException
	 */
	public static boolean bajaTrabajador(int identificador) throws BDException {
		int resultados = 0;
		PreparedStatement ps = null;
		Connection conexion = null;

		// Conexi�n a la bd
		try {
			conexion = ConfigSQLite.abrirConexion();
			String query = "DELETE FROM Trabajadores WHERE id = ?";
			ps = conexion.prepareStatement(query);

			ps.setInt(1, identificador);

			resultados = ps.executeUpdate();

		} catch (BDException | SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} finally {
			if (conexion != null) {
				ConfigSQLite.cerrarConexion(conexion);
			}
		}
		return resultados == 1;
	}
	

	/**
	 * LISTA LOS TRABAJADORES DE LA BASE DE DATOS
	 * 
	 * @return ARRAYLIST DE TRABAJADORES
	 * @throws BDException
	 */
	public static ArrayList<Trabajador> obtenerTrabajadores() throws BDException {
		ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();
		PreparedStatement ps = null;
		Connection conexion = null;

		// Conexi�n a la bd
		try {
			conexion = ConfigSQLite.abrirConexion();
			String query = "SELECT * FROM Trabajadores;";

			ps = conexion.prepareStatement(query);
			ResultSet resultados = ps.executeQuery();
			while (resultados.next()) {
				int id = resultados.getInt("id");
				String dni = resultados.getString("dni");
				String nombre = resultados.getString("nombre");
				String apellido = resultados.getString("apellidos");
				String direccion = resultados.getString("direccion");
				String telefono = resultados.getString("telefono");
				String puesto = resultados.getString("puesto");

				Trabajador t = new Trabajador(id, dni, nombre, apellido, direccion, telefono, puesto);
				trabajadores.add(t);

			}
		} catch (BDException | SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} finally {
			if (conexion != null) {
				ConfigSQLite.cerrarConexion(conexion);
			}
		}
		return trabajadores;
	}
	
	public static boolean agregarTrabajador(Trabajador t) throws BDException {
		int resultados = 0;
		PreparedStatement ps = null;
		Connection conexion = null;

		// Conexi�n a la bd
		try {
			conexion = ConfigSQLite.abrirConexion();
			String query = "INSERT INTO Trabajadores (dni,nombre,apellidos,direccion,telefono,puesto)"
					+ "VALUES(?,?,?,?,?,?) ";

			ps = conexion.prepareStatement(query);
			ps.setString(1, t.getDni());
			ps.setString(2, t.getNombre());
			ps.setString(3, t.getApellidos());
			ps.setString(4, t.getDireccion());
			ps.setString(5, t.getTelefono());
			ps.setString(6, t.getPuesto());

			resultados = ps.executeUpdate();

		} catch (BDException | SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} finally {
			if (conexion != null) {
				ConfigSQLite.cerrarConexion(conexion);
			}
		}
		return resultados == 1;
	}

	/**
	 * Lista todos los trabajadores
	 * 
	 * @return Matriz para usarlo en el ListarDialog
	 * @throws BDException
	 */
	public static String[][] listarTrabajadores() throws BDException {
		ArrayList<Trabajador> trabajadores = obtenerTrabajadores();
		// [filas][columnas]
		String[][] listado = new String[trabajadores.size()][7];
		for (int i = 0; i < trabajadores.size(); i++) {
			Trabajador trabajador = trabajadores.get(i);
			// siete elementos de un trabajador
			listado[i][0] = String.valueOf(trabajador.getIdentificador());
			listado[i][1] = trabajador.getDni();
			listado[i][2] = trabajador.getNombre();
			listado[i][3] = trabajador.getApellidos();
			listado[i][4] = trabajador.getDireccion();
			listado[i][5] = trabajador.getTelefono();
			listado[i][6] = trabajador.getPuesto();
		}
		return listado;
	}
	
	/**
	 * Consulta los empleados de la base de datos que ganen mas de un salario pasado
	 * por parametro
	 * 
	 * @param ubicacion
	 * @return
	 * @throws BDException
	 */
	public static List<Empleado> consultarEmpleadosSalario(float salario) throws BDException {

		List<Empleado> listaEmpleados = new ArrayList<Empleado>();
		PreparedStatement ps = null;
		Connection conexion = null;

		try {
			// Conexi�n a la bd
			conexion = ConfigSQLite.abrirConexion();
			String query = "SELECT * FROM empleado WHERE salario > ? ORDER by nombre";

			ps = conexion.prepareStatement(query);
			// Al primer interrogante le asigno salario (ps1)
			ps.setFloat(1, salario);

			ResultSet resultados = ps.executeQuery();

			while (resultados.next()) {

				int codigo = resultados.getInt("codigo");
				String nombre = resultados.getString("nombre");
				String fecha = resultados.getString("fecha_alta");
				float sal = resultados.getFloat("salario");
				int codDpto = resultados.getInt("codigo_departamento");

				Departamento d = new Departamento(codDpto);

				Empleado empleado = new Empleado(codigo, nombre, fecha, sal, d);

				listaEmpleados.add(empleado);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BDException(BDException.ERROR_QUERY + e.getMessage());
		} finally {
			if (conexion != null) {
				ConfigSQLite.cerrarConexion(conexion);
			}
		}
		return listaEmpleados;
	}
}
