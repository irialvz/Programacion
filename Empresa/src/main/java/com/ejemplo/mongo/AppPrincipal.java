package com.ejemplo.mongo;

import com.ejemplo.mongo.dao.GestorEmpleado;
import com.ejemplo.mongo.modelo.Empleado;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.Scanner;

import org.bson.Document;

public class AppPrincipal {
	public static void main(String[] args) {

		try {
			// Ejemplo de buscar todos los empleados de la base de datos
			MongoDatabase conexion = ConfigMongo.abrirConexion();
			MongoCollection<Document> empleados = conexion.getCollection("Empresa");

			//mostrarTodosLosEmpleados(empleados);
			//buscarYMostrarEmpleadoPorNombreYEdad(empleados, "María", 30);
			//borrarEmpleadosInactivos(empleados);
			insertarEmpleados(empleados);
		} catch (Exception e) {
			System.err.println("❌ Error: " + e.toString());			
		} finally {
			// 4. Cerrar conexión
			ConfigMongo.cerrarConexion();
		}
	}
	
	public static void insertarEmpleados(MongoCollection<Document> empleadosDoc) {
		Scanner teclado = new Scanner(System.in);
		boolean agregarOtro = true;
		ArrayList<Empleado> listaInserccion = new ArrayList<Empleado>();
		
		while (agregarOtro) {
		System.out.println("introduce un nombre");
		String nombreString = teclado.nextLine() ;
		System.out.println("Introduce la edad");
		int edad = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Introduce un puesto");
		String puesto = teclado.nextLine();
		System.out.println("Introduce un salario");
		Double salarioDouble = teclado.nextDouble();
		System.out.println("Esta activo? true/false");
		boolean activo = teclado.nextBoolean();
		Empleado empleado = new Empleado(nombreString, edad, puesto, salarioDouble, activo);
		listaInserccion.add(empleado);

		System.out.println("-----------------");
		System.out.println("Quiere agregar otro empleado? true/false");
		agregarOtro = teclado.nextBoolean();
		teclado.nextLine();
		}
		boolean insertados = GestorEmpleado.insertarEmpleados(empleadosDoc, listaInserccion);
		
		if (insertados) {
			System.out.println("Se han introducido correctamente");
		}else {
			System.out.println("No se ha introducido ningun empleado");
		}
	}
	
	/**
	 * Muestra mensaje informativo si se han eliminado o no empleados inactivos
	 * PARA MEJORAR : que saque el nombre del empleado/s eliminado
	 * @param empleados
	 * @throws Exception
	 */
	private static void borrarEmpleadosInactivos (MongoCollection<Document> empleados) throws Exception {
		boolean eliminados = GestorEmpleado.borrarEmpleadosInactivos(empleados);
		if (eliminados) {
			System.out.println("Se han eliminado correctamente");
		} else {
			System.out.println("No se ha encontrado ningun empleado inactivo");
		}
	}
	
	/**
	 * 
	 * @param empleados
	 * @throws Exception
	 */
	private static void mostrarTodosLosEmpleados(MongoCollection<Document> empleados) throws Exception {
		ArrayList<Empleado> lista = GestorEmpleado.buscarEmpleados(empleados);
		System.out.println("📋 Empleados:");
		System.out.println(lista.toString());
	}
	
	/**
	 * 
	 * @param empleados
	 * @param nombre
	 * @param edad
	 * @throws Exception
	 */
	private static void buscarYMostrarEmpleadoPorNombreYEdad(MongoCollection<Document> empleados, String nombre,
			int edad) throws Exception {
		String json = GestorEmpleado.buscarEmpleadoNombreEdad(empleados, nombre, edad);
		System.out.println("\n🔍 Empleados con nombre '" + nombre + "' y edad >= " + edad + ":");
		System.out.println(json);
	}

}
