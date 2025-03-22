package ejemploBD.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ejemploBD.config.ConfigMySql;
import ejemploBD.excepciones.BDException;
import ejemploBD.modelo.Departamento;
import ejemploBD.modelo.Empleado;

public class AccesoEmpleado {

	/**
	 * Consulta los empleados de la base de datos que ganen mas de un salario pasado
	 * por parametro
	 * 
	 * @param ubicacion
	 * @return
	 * @throws BDException
	 */
	public static List<Empleado> consultarEmpleados(float salario) throws BDException {

		List<Empleado> listaEmpleados = new ArrayList<Empleado>();
		PreparedStatement ps = null;
		Connection conexion = null;

		try {
			// Conexi�n a la bd
			conexion = ConfigMySql.abrirConexion();
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
				ConfigMySql.cerrarConexion(conexion);
			}
		}
		return listaEmpleados;
	}

}
