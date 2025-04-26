package com.ejemplo.mongo.dao;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.Iterator;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.ejemplo.mongo.modelo.Empleado;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.DeleteResult;

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
		boolean eliminado = true;
		Bson filtroBson = eq("activo",false);
		DeleteResult eliminarEmpleado = collection.deleteMany(filtroBson);
		if (eliminarEmpleado.getDeletedCount() == 0) {
			return false;
		} 
		return eliminado;
	}

	public static boolean insertarEmpleados(MongoCollection<Document> collection, ArrayList<Empleado> empleados) {
		if (empleados.isEmpty()) {
			return false;
		}
		boolean insertado = true;
		Document newEmpleado = null;
		for (Empleado nuevoEmpleado : empleados) {
			newEmpleado = new Document("nombre",nuevoEmpleado.getNombre())
					.append("edad", nuevoEmpleado.getEdad())
					.append("puesto", nuevoEmpleado.getPuesto())
					.append("salario", nuevoEmpleado.getSalario())
					.append("activo", nuevoEmpleado.isActivo());
			collection.insertOne(newEmpleado);
		}
		if (newEmpleado.isEmpty()) {
			insertado = false;	
		}
		
		return insertado;
	}

}
