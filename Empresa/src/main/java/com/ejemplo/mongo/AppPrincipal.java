package com.ejemplo.mongo;

import com.ejemplo.mongo.dao.GestorEmpleado;
import com.ejemplo.mongo.modelo.Empleado;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;

import org.bson.Document;

public class AppPrincipal {
	public static void main(String[] args) {

		try {
			// Ejemplo de buscar todos los empleados de la base de datos
			MongoDatabase conexion = ConfigMongo.abrirConexion();
			MongoCollection<Document> empleados = conexion.getCollection("empresa");

			mostrarTodosLosEmpleados(empleados);
			buscarYMostrarEmpleadoPorNombreYEdad(empleados, "María", 30);

		} catch (Exception e) {
			System.err.println("❌ Error: " + e.toString());			
		} finally {
			// 4. Cerrar conexión
			ConfigMongo.cerrarConexion();
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
