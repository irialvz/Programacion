package com.ejemplo.json;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class Main {
	public static void main(String[] args) {
		Persona persona1 = new Persona("Juan",30);
		
		String jsonPersonaString = JsonUtil.convertirObjToJson(persona1);
		System.out.println("Objeto a Json: \n" + jsonPersonaString);
		
		Persona personaDesdeJsonPersona = JsonUtil.convetirPersonaJsonObj(jsonPersonaString);
		System.out.println("JSON A objeto: \n " + personaDesdeJsonPersona);
	
	try {
		System.out.println("\nArchivo lista JSON a ArrayList:");
		FileReader reader = new FileReader("personas.json");
		ArrayList<Persona> listaDesdeArchivo = JsonUtil.convertirArchivoJsonALista(reader);
		System.out.println("Contenido del archivo a json: \n");
		for (Persona persona : listaDesdeArchivo) {
			System.out.println(persona);
		}
	}catch (Exception ex) {
		System.err.println("Error al leer el archivo Json " + ex.getMessage());
	}
	
	
	
	}

}
