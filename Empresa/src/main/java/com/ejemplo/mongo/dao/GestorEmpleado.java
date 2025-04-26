package com.ejemplo.mongo.dao;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;

import java.util.ArrayList;

import org.bson.Document;

import com.ejemplo.mongo.modelo.Empleado;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

public class GestorEmpleado {

	public static String buscarEmpleadoNombreEdad(MongoCollection<Document> collection, String nombre, int edad) throws Exception {
		// TODO Auto-generated method stub
		String json = "";

		// Filtro: nombre = "María" y edad >= 30
		FindIterable<Document> resultados = collection.find(and(eq("nombre", nombre), gte("edad", edad)));
		
		for (Document doc : resultados) {
			json += doc.toJson();
		}

		return json;
	}

	public static ArrayList<Empleado> buscarEmpleados(MongoCollection<Document> collection) throws Exception {
		ArrayList<Empleado> lista = new ArrayList<>();

		FindIterable<Document> resultados = collection.find();

		for (Document doc : resultados) {
			String nombre = doc.getString("nombre");
			Integer edad = doc.getInteger("edad", 0);
			String puesto = doc.getString("puesto");
			Double salario = doc.getDouble("salario");
			Boolean activo = doc.getBoolean("activo", false);

			Empleado empleado = new Empleado(nombre, edad, puesto, salario, activo);
			lista.add(empleado);
		}

		return lista;
	}
	public static boolean borrarEmpleadosInactivos(MongoCollection<Document> collection) throws Exception {
		boolean eliminado = false;
		ArrayList<Empleado> lista = new ArrayList<>();
		FindIterable<Document> resultados = collection.find();
		
		for (Document doc : resultados) {
			String nombre = doc.getString("nombre");
			Integer edad = doc.getInteger("edad", 0);
			String puesto = doc.getString("puesto");
			Double salario = doc.getDouble("salario");
			Boolean activo = doc.getBoolean("activo", false);
			
			Empleado empleado = new Empleado(nombre,edad,puesto,salario,activo);
			eliminado = lista.remove(empleado);
		}
		return eliminado;
	}

	public static boolean insertarEmpleados(MongoCollection<Document> collection, ArrayList<Empleado> empleados) {
		boolean insertado = false;
		//ArrayList<Empleado> lista = new ArrayList<>();
		FindIterable<Document> resultados = collection.find();
		for (Empleado empleado : empleados) {
			for (Document doc : resultados) {
				if (doc.getString("nombre").equalsIgnoreCase(empleado.getNombre())) {
					insertado = false;
				} else {
					String nombre = empleado.getNombre() ;
					Integer edad = empleado.getEdad();
					String puesto = empleado.getPuesto();
					//Double salario = empleado.get
				}
			}
		}
		return insertado;
	}

}
