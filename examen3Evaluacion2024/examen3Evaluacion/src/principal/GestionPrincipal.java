package principal;
import java.util.Scanner;

import dao.AccesoBillete;
import dao.AccesoClase;
import dao.AccesoEstacion;
import dao.AccesoViajero;
import entrada.Teclado;
import excepciones.BDException;
import excepciones.BilleteException;
import modelo.Billete;
import modelo.Estacion;
import modelo.Viajero;

public class GestionPrincipal {

	/**
	 * Visualiza en consola el menú de opciones del programa principal.
	 */
	public static void escribirMenuOpcionesPrincipal() {
		System.out.println();
		System.out.println("*********** MENÚ PRINCIPAL ***********");
		System.out.println("(0) Salir del programa.");
		System.out.println("(1) Exportar las clases a fichero de texto"); 
		System.out.println("(2) Sacar billete"); 
		System.out.println("(3) Actualizar viajero"); 
		System.out.println("(4) Consultar viajeros en estación y día"); 
	}
	public static boolean sacaBillete() throws BilleteException {
		boolean resultado = false;
		//Viajero v = null;
		Estacion eo = null,ed = null;
		boolean esSocio = Teclado.leerBooleano("Eres socio de la Aerolinea? true/false");
		if (!esSocio) {
			throw new BilleteException(BilleteException.ERROR_NOSOCIO);
		} else {
			int codViajero = Teclado.leerEntero("Codigo de viajero?");
			String nombreOrigen = Teclado.leerCadena("Estacion origen?");
			String nombreDestion = Teclado.leerCadena("Estacion destino?");
			String fecha = Teclado.leerCadena("Fecha?");
			String horaSalida = Teclado.leerCadena("hora de salida?");
			String horaLlegada = Teclado.leerCadena("hora de llegada?");
			Double importe = Teclado.leerReal("importe?");
			
			try {
				if (AccesoViajero.obtenerViajero(codViajero) != null) {
					int idBillete = AccesoBillete.ultimoID() + 1;
					Viajero v = AccesoViajero.obtenerViajero(codViajero);
					eo = AccesoEstacion.obtenerEstacion(nombreOrigen);
					ed = AccesoEstacion.obtenerEstacion(nombreDestion);
					Billete b = new Billete(idBillete,v,eo,ed,fecha,horaSalida,horaLlegada,importe);
					resultado = AccesoBillete.nuevoBillete(b);
				}
			} catch (BDException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
		return resultado;
	}
	
	/**
	 * 
	 * @param args
	 * @throws BilleteException 
	 */
	public static void main(String[] args) throws BilleteException {
		int opcion;
		do {
			escribirMenuOpcionesPrincipal();
			opcion = Teclado.leerEntero("Opción?");
			switch (opcion) {
			// Salir del programa.
			case 0:
				System.out.println("Finalizando programa.");
				break;
				
			// TODO: Exportar las clases a fichero de texto.
			case 1:
				System.out.println("\n*********** EXPORTAR TABLA CLASE A FICHERO ***********");
				String ruta = Teclado.leerCadena("Ruta del fichero?");
				AccesoClase.exportarFicheroTexto(ruta);
				break;
								
			// TODO: Sacar un billete
			case 2:
				System.out.println("\n*********** SACAR BILLETE ***********");
				if (sacaBillete()) {
					System.out.println("Se ha sacado correctamente el billete");
				} else {
					throw new BilleteException("Error,no se ha sacado el billete");
				}
				
				break;
			
			// TODO: Actualizar viajero
			case 3:
				System.out.println("\n*********** ACTUALIZAR VIAJERO ***********");				
				break;
				
			// TODO: Consultar viajeros en estación y día
			case 4:
				System.out.println("\n*********** CONSULTAR VIAJEROS EN ESTACIÓN Y DÍA ***********");				
				break;
						 
			default:
				System.out.println("La opción de menú debe estar comprendida entre 0 y 4.");
			}
		}
		while (opcion != 0);
	}
}
