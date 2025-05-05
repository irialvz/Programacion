package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ConfigSQLite;
import excepciones.BDException;
import modelo.Trabajador;

public class TablaTrabajadores {
	public static boolean existeTrabajador(int identificador) throws BDException {
		int resultados = 0;
		PreparedStatement ps = null;
		Connection conexion = null;

		
			// Conexi�n a la bd
			try {
				conexion = ConfigSQLite.abrirConexion();
				String query = "SELECT * FROM Trabajadores WHERE id = ?";

				
				ps = conexion.prepareStatement(query);
				ps.setInt(1, identificador);
				resultados = ps.executeUpdate();
				
				
			} catch (BDException | SQLException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}finally {
				if (conexion != null) {
					ConfigSQLite.cerrarConexion(conexion);
				}
			}
		return resultados == 1;
	}
	/**
	 * Crea la tabla Trabajadores en la base de datos
	 * @return boolean si ha sido exitoso
	 * @throws BDException
	 */
	public static boolean crearTabla() throws BDException {
		int resultados = 0;
		PreparedStatement ps = null;
		Connection conexion = null;

		
			// Conexi�n a la bd
			try {
				conexion = ConfigSQLite.abrirConexion();
				String query = "CREATE TABLE IF NOT EXISTS Trabajadores ( id INTEGER PRIMARY KEY AUTOINCREMENT,"
						+ "dni TEXT UNIQUE NOT NULL,"
						+ "nombre TEXT NOT NULL,"
						+ "apellidos TEXT NOT NULL,"
						+ "direccion TEXT NOT NULL,"
						+ "telefono TEXT NOT NULL,"
						+ "puesto TEXT)";

				
				ps = conexion.prepareStatement(query);
				resultados = ps.executeUpdate();
				
			} catch (BDException | SQLException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}finally {
				if (conexion != null) {
					ConfigSQLite.cerrarConexion(conexion);
				}
			}
		return resultados == 1;

	}
	
	/**
	 * INSERTA LOS TRABAJADORES SI NO EXISTEN,SI ESTE YA EXISTE LO MOFICA
	 * @param arrayList trabajadores del fichero
	 * @return boolean si ha sido exitoso
	 * @throws BDException
	 */
	public static boolean insertarOActualizar(ArrayList<Trabajador> trabaj) throws BDException {
		int resultados = 0;
		PreparedStatement ps = null;
		Connection conexion = null;

		
			// Conexi�n a la bd
			try {
				conexion = ConfigSQLite.abrirConexion();
				String query = "INSERT INTO Trabajadores (dni,nombre,apellidos,direccion,telefono,puesto) "
						+ "VALUES (?,?,?,?,?,?) "
						+ "ON CONFLICT (dni) DO UPDATE SET "
						+ "nombre = excluded.nombre,"
						+ "apellidos = excluded.apellidos,"
						+ "direccion = excluded.direccion,"
						+ "telefono = excluded.telefono,"
						+ "puesto = excluded.puesto";

				
		        ps = conexion.prepareStatement(query);
		        for (Trabajador trabajador : trabaj) {
			        ps.setString(1, trabajador.getDni());
			        ps.setString(2, trabajador.getNombre());
			        ps.setString(3, trabajador.getApellidos());
			        ps.setString(4,trabajador.getDireccion());
			        ps.setString(5,trabajador.getTelefono());
			        ps.setString(6, trabajador.getPuesto());

			        resultados += ps.executeUpdate();

		        }

				
			} catch (BDException | SQLException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}finally {
				if (conexion != null) {
					ConfigSQLite.cerrarConexion(conexion);
				}
			}
		return resultados >= 1;

	}
	
	/**
	 * LISTA LOS TRABAJADORES DE LA BASE DE DATOS
	 * @return 	ARRAYLIST DE TRABAJADORES
	 * @throws BDException
	 */
	public static ArrayList<Trabajador> obtenerTrabajadores() throws BDException{
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
		        	
		        	Trabajador t = new Trabajador(id,dni,nombre,apellido,direccion,telefono,puesto);
		        	trabajadores.add(t);
		        	
		        }
			} catch (BDException | SQLException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}finally {
				if (conexion != null) {
					ConfigSQLite.cerrarConexion(conexion);
				}
			}
		return trabajadores;
	}
	
	
	
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
		}finally {
			if (conexion != null) {
				ConfigSQLite.cerrarConexion(conexion);
			}
		}
		return resultados == 1;
	}
	/**
	 * Modifica los parametros de un trabajador segun su ID
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
		}finally {
			if (conexion != null) {
				ConfigSQLite.cerrarConexion(conexion);
			}
		}
		return resultados == 1;
		
	}
	/**
	 * Agrega un trabajador a la base de datos
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
		}finally {
			if (conexion != null) {
				ConfigSQLite.cerrarConexion(conexion);
			}
		}
		return resultados == 1;
	}
	
	/**
	 * Lista todos los trabajadores 
	 * @return Matriz para usarlo en el ListarDialog
	 * @throws BDException
	 */
	public static String[][] listarTrabajadores() throws BDException{
		ArrayList<Trabajador> trabajadores = obtenerTrabajadores();
		//[filas][columnas]
		String[][] listado = new String[trabajadores.size()][7];
		for (int i = 0; i<trabajadores.size();i++) {
			Trabajador trabajador = trabajadores.get(i);
			//siete elementos de un trabajador
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
	 * Obtiene todos los IDs para el desplegable de ID en ModificaDialog
	 * @return
	 * @throws BDException
	 */
	public static ArrayList<Integer> obtenerIDs() throws BDException{
		ArrayList<Integer> ids = new ArrayList<Integer>();
		PreparedStatement ps = null;
		Connection conexion = null;

		
			// Conexi�n a la bd
			try {
				conexion = ConfigSQLite.abrirConexion();
				String query = "SELECT id FROM Trabajadores;";

				
		        ps = conexion.prepareStatement(query);
		        ResultSet resultados = ps.executeQuery();
		        while (resultados.next()) {
		        	int id = resultados.getInt("id");
		        	ids.add(id);
		        	
		        }
			} catch (BDException | SQLException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}finally {
				if (conexion != null) {
					ConfigSQLite.cerrarConexion(conexion);
				}
			}
		return ids;
	}
	
	public static ArrayList<String> obtenerPuestos () throws BDException {
		ArrayList<String> puestos = new ArrayList<>();
		PreparedStatement ps = null;
		Connection conexion = null;

		
			// Conexi�n a la bd
			try {
				conexion = ConfigSQLite.abrirConexion();
				String query = "SELECT DISTINCT puesto FROM Trabajadores";

				
		        ps = conexion.prepareStatement(query);
		        ResultSet resultados = ps.executeQuery();
		        while (resultados.next()) {
		        	String puesto = resultados.getString("puesto");
		        	puestos.add(puesto);
		        }
			} catch (BDException | SQLException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}finally {
				if (conexion != null) {
					ConfigSQLite.cerrarConexion(conexion);
				}
			}
		return puestos;
	}
	
	public static Trabajador obtenerTrabajador (int identificador) throws BDException {
		Trabajador t = null;
		PreparedStatement ps = null;
		Connection conexion = null;

		
			// Conexi�n a la bd
			try {
				conexion = ConfigSQLite.abrirConexion();
				String query = "SELECT * FROM Trabajadores where id = ?;";

				
		        ps = conexion.prepareStatement(query);
		        ps.setInt(1, identificador);
		        ResultSet resultados = ps.executeQuery();
		        while (resultados.next()) {
		        	int id = resultados.getInt("id");
		        	String dni = resultados.getString("dni");
		        	String nombre = resultados.getString("nombre");
		        	String apellidos = resultados.getString("apellidos");
		        	String direccion = resultados.getString("direccion");
		        	String telefono = resultados.getString("telefono");
		        	String puesto = resultados.getString("puesto");
		        	
		        	t = new Trabajador(id,dni,nombre,apellidos,direccion,telefono,puesto);
		        	
		        }
			} catch (BDException | SQLException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}finally {
				if (conexion != null) {
					ConfigSQLite.cerrarConexion(conexion);
				}
			}
		return t;
	}
}
