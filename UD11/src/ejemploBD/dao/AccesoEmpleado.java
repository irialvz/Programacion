package ejemploBD.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import ejemploBD.config.ConfigMySql;
import ejemploBD.config.ConfigSQLite;
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
	public static Empleado consultarEmpleadoCodigo (int codigoEmp) throws BDException {
		Empleado empleado = null;
		PreparedStatement ps = null;
		Connection conexion = null;

		try {
			// Conexi�n a la bd
			conexion = ConfigSQLite.abrirConexion();
			String query = "SELECT * FROM empleado WHERE codigo = ? ";

			ps = conexion.prepareStatement(query);
			// Al primer interrogante le asigno salario (ps1)
			ps.setInt(1, codigoEmp);

			ResultSet resultados = ps.executeQuery();
			
			if (resultados.next()) {
                String nombre = resultados.getString("nombre");
                String fecha_alta = resultados.getString("fecha_alta");
                float salario = resultados.getFloat("salario");
                Departamento departamento = AccesoDepartamento.consultarDepartamento
                		(resultados.getInt("codigo_departamento"));

                empleado = new Empleado(codigoEmp, nombre, fecha_alta, salario, departamento);
            }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BDException(BDException.ERROR_QUERY + e.getMessage());
		} finally {
			if (conexion != null) {
				ConfigSQLite.cerrarConexion(conexion);
			}
		}
		return empleado;
	}
	//Cambiar el departamento de un empleado
	public static boolean cambiarDepartamentoEmpleado (int codigoEmp,String nombreDep) throws BDException {
		PreparedStatement ps = null;
		Connection conexion = null;
		int resultados = 0;
		try {
			// Conexi�n a la bd			
			conexion = ConfigSQLite.abrirConexion();
			String query = "UPDATE empleado SET codigo_departamento = (SELECT codigo FROM departamento WHERE nombre = ?) WHERE codigo = ?" ;
			
			ps = conexion.prepareStatement(query);			
			ps.setString(1, nombreDep);
			ps.setInt(2, codigoEmp);
			
			resultados = ps.executeUpdate();
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BDException(BDException.ERROR_QUERY + e.getMessage());
		}		
		finally {
			if (conexion!=null) {
				ConfigSQLite.cerrarConexion(conexion);
			}
		}
		return resultados == 1;
	}
	//Buscar todos los codigo y nombres de los empleados que trabajen en el 
	//departamento de informatica de la empresa
	public static List<Empleado> consultarInformaticosEmpleados () throws BDException{
		List<Empleado> listaEmpleados = new ArrayList<Empleado>();
		PreparedStatement ps = null;
		Connection conexion = null;

		try {
			// Conexi�n a la bd
			conexion = ConfigSQLite.abrirConexion();
			String query = "SELECT * FROM empleado e JOIN departamento d ON (e.codigo_departamento = d.codigo) WHERE d.nombre = 'Informatica' ";

			ps = conexion.prepareStatement(query);
			ResultSet resultados = ps.executeQuery();

			while (resultados.next()) {

				int codigo = resultados.getInt("codigo");
				String nombre = resultados.getString("nombre");
				float sal = resultados.getFloat("salario");
				String fecha = resultados.getString("fecha_alta");
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
	
	public static ArrayList<Empleado> consultarEmpleados() throws BDException{
		ArrayList<Empleado> arrayEmpleados = new ArrayList<Empleado>();
		PreparedStatement ps = null;
		Connection conexion = null;

		try {
			// Conexi�n a la bd
			conexion = ConfigSQLite.abrirConexion();
			String query = "SELECT e.codigo,e.nombre,e.salario,e.fecha_alta,e.codigo_departamento,d.nombre,d.ubicacion "
					+ "FROM empleado e JOIN departamento d ON (e.codigo_departamento = d.codigo)  ";

			ps = conexion.prepareStatement(query);
			ResultSet resultados = ps.executeQuery();

			while (resultados.next()) {

				int codigoEmp = resultados.getInt("codigo");
				String nombre = resultados.getString("nombre");
				float sal = resultados.getFloat("salario");
				String fecha = resultados.getString("fecha_alta");
				int codDpto = resultados.getInt("codigo_departamento");
				String nombreDep = resultados.getString("nombre");
				String ubicacionD = resultados.getString("ubicacion");


				Departamento d = new Departamento(codDpto,nombreDep,ubicacionD);

				Empleado empleado = new Empleado(codigoEmp, nombre, fecha, sal, d);

				arrayEmpleados.add(empleado);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BDException(BDException.ERROR_QUERY + e.getMessage());
		} finally {
			if (conexion != null) {
				ConfigSQLite.cerrarConexion(conexion);
			}
		}
		return arrayEmpleados;
	}
	public static void exportarFicheroCSV(String nombreFichero, ArrayList<Empleado> Empleados){
		BufferedWriter bw = null;
		try {
			File fichero = new File(nombreFichero);
			bw = new BufferedWriter(new FileWriter(fichero, false));
			for (Empleado empleado : Empleados) {				
				bw.write(empleado.toStringWithSeparators());
				bw.newLine();
			}
		} 
		catch(IOException ioe) {
			System.out.println("Error al escribir en el fichero: " + ioe.getMessage());
			ioe.printStackTrace();
		}
		finally {
			try {
				if (bw != null) {
					bw.close();
				}
			}
			catch (IOException ioe) {
				System.out.println("Error al cerrar el fichero: " + ioe.getMessage());
				ioe.printStackTrace();
			}
		}
	}
	public static boolean añadirEmpleado(Empleado empleado) throws BDException {
	    PreparedStatement ps = null;
	    Connection conexion = null;
	    int resultados = 0;
	    try {
	        // Conexión a la base de datos
	        conexion = ConfigSQLite.abrirConexion();
	        String query = "INSERT INTO empleado (codigo, nombre, fecha_alta, salario, codigo_departamento) "
	                     + "VALUES (?, ?, ?, ?, ?)";

	        ps = conexion.prepareStatement(query);
	        ps.setInt(1, empleado.getCodigo());
	        ps.setString(2, empleado.getNombre());
	        ps.setString(3, empleado.getFechaAlta());
	        ps.setFloat(4, empleado.getSalario());
	        ps.setInt(5, empleado.getDepartamento().getCodigo());

	        resultados = ps.executeUpdate();
	    } catch (SQLException e) {
	        throw new BDException(BDException.ERROR_QUERY + e.getMessage());
	    } finally {
	        if (conexion != null) {
	            ConfigSQLite.cerrarConexion(conexion);
	        }
	    }
	    return resultados == 1;
	}
	public static boolean eliminarEmpleado(int codigoEmpleado) throws BDException {
	    PreparedStatement ps = null;
	    Connection conexion = null;
	    int resultados = 0;
	    try {
	        // Conexión a la base de datos
	        conexion = ConfigSQLite.abrirConexion();
	        String query = "DELETE FROM empleado WHERE codigo = ?";

	        ps = conexion.prepareStatement(query);
	        ps.setInt(1, codigoEmpleado);

	        resultados = ps.executeUpdate();
	    } catch (SQLException e) {
	        throw new BDException(BDException.ERROR_QUERY + e.getMessage());
	    } finally {
	        if (conexion != null) {
	            ConfigSQLite.cerrarConexion(conexion);
	        }
	    }
	    return resultados == 1;
	}
	public static boolean modificarEmpleado(Empleado empleado) throws BDException {
	    PreparedStatement ps = null;
	    Connection conexion = null;
	    int resultados = 0;
	    try {
	        // Conexión a la base de datos
	        conexion = ConfigSQLite.abrirConexion();
	        String query = "UPDATE FROM empleado WHERE codigo = ?";

	        ps = conexion.prepareStatement(query);
	        ps.setInt(1, empleado.getCodigo());

	        resultados = ps.executeUpdate();
	    } catch (SQLException e) {
	        throw new BDException(BDException.ERROR_QUERY + e.getMessage());
	    } finally {
	        if (conexion != null) {
	            ConfigSQLite.cerrarConexion(conexion);
	        }
	    }
	    return resultados == 1;
	}
	
    public static boolean borrarEmpleadoCodigo(int codigo) throws BDException {
        int filas = 0;
        Connection conexion = null;

        try {
            String queryDelete = "DELETE FROM empleado WHERE codigo = ?"; // ?????
            PreparedStatement ps = conexion.prepareStatement(queryDelete);
            ps.setInt(1, codigo);
            filas = ps.executeUpdate();
        } catch (SQLException e) {
            throw new BDException(BDException.ERROR_QUERY + e.getMessage());
        } finally {
            if (conexion != null) {
                    ConfigSQLite.cerrarConexion(conexion);
                }
        }
        return filas == 1;
    }
	
	public static ArrayList<Empleado> importarFicheroCsv(String nombreFichero) {
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		BufferedReader br = null;
		try {
			// Abre fichero de alumnos en modo lectura
			br = new BufferedReader(new FileReader(new File(nombreFichero)));
			
			// Lectura linea por línea del fichero de empleados
      		String linea = br.readLine(); 
      		while (linea != null) { 
      			Empleado empleado = new Empleado(linea);
      			try {
      				AccesoEmpleado.añadirEmpleado(empleado);
      			}catch (BDException e) {
					// TODO: handle exception
      				AccesoEmpleado.modificarEmpleado(empleado);
				}
      			linea = br.readLine();
      		}     		
		}
		catch (FileNotFoundException fnfe) {                      
			System.out.println("Error al abrir el fichero: " + fnfe.getMessage());
			fnfe.printStackTrace();
		}
		catch (IOException ioe) {
			System.out.println("Error al leer del fichero: " + ioe.getMessage());
			ioe.printStackTrace();
		}
		catch (NumberFormatException nfe) {
			System.out.println("Error al convertir de cadena a n�mero: " + nfe.getMessage());
			nfe.printStackTrace();
		} catch (BDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (br != null) {
					br.close();
				}
			}
			catch (IOException ioe) {
				System.out.println("Error al cerrar el fichero: " + ioe.getMessage());
				ioe.printStackTrace();
			}
		}
		
		return empleados;
	}
	
	/*public static void leerArchivoCsv(String rutaArch) {
		BufferedReader br = null;
		try {
			File fichero = new File(rutaArch);
			br = new BufferedReader(new FileReader(fichero));
			int contador = 0;
      		String linea = br.readLine(); 
      		while (linea != null) { 	
      			Empleado empleado = new Empleado(linea);
      			System.out.println(empleado.toString());
      			contador++;
      			linea = br.readLine();
      		}
      		System.out.println("Se han leído " + contador + " empleados del fichero de texto.");
		}
		catch (FileNotFoundException fnfe) {                      
			System.out.println("Error al abrir el fichero: " + fnfe.getMessage());
			fnfe.printStackTrace();
		}
		catch (IOException ioe) {
			System.out.println("Error al leer del fichero: " + ioe.getMessage());
			ioe.printStackTrace();
		}
		catch (NumberFormatException nfe) {
			System.out.println("Error al convertir de cadena a n�mero: " + nfe.getMessage());
			nfe.printStackTrace();
		} catch (BDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (br != null) {
					br.close();
				}
			}
			catch (IOException ioe) {
				System.out.println("Error al cerrar el fichero: " + ioe.getMessage());
				ioe.printStackTrace();
			}
		}
		
	}*/
}
