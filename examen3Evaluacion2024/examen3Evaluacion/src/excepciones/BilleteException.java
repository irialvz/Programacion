package excepciones;

public class BilleteException extends Exception{
	
	public static final String ERROR_NOSOCIO = "Debe ser socio para sacar un billete";
	public static final String ERROR_QUERY = "Error en la consulta ";
	public static final String ERROR_CERRAR_CONEXION = "Error al cerrar conexion ";
	public static final String ERROR_CARGAR_DRIVER = "Error al cargar driver";
	
	public BilleteException(String mensaje) {
		super("Error: " + mensaje);
	}
	
}
