package com.ejemplo.json;
import 



public class Main {
	public static void main(String[] args) {
		Persona persona1 = new Persona("Juan",30);
		
		String jsonPersonaString = JsonUtil.convertirObjToJson(persona1);
		System.out.println("Objeto a Json: \n" + jsonPersonaString);
		
		Persona personaDesdeJsonPersona = JsonUtil.convetirPersonaJsonObj(jsonPersonaString);
		System.out.println("JSON A objeto: \n " + personaDesdeJsonPersona);
	
	try {
		System.out.println("\nArchivo lista JSON a ArrayList:");
		
	}catch (Exception ex) {
		System.out.println();
	}
	
	
	
	}

}
