package com.ejemplo.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConfigMongo {
    
	private static MongoDatabase baseDatos;
	private static MongoClient cliente;
        
    private static final String URI = "mongodb://localhost:27017";
    private static final String nombre = "empresa";
    
   
    public static MongoDatabase abrirConexion() {    	    	    
        if (baseDatos == null) {
        	 cliente = MongoClients.create(URI);
             baseDatos = cliente.getDatabase(nombre);
             System.out.println("✅ Conexión creada con MongoDB");
        }
        return baseDatos;
    }
    
    public static void cerrarConexion() {
        if (cliente != null) {        	
            cliente.close();
            cliente = null;
            baseDatos = null;
            System.out.println("🛑 Conexión cerrada.");
        }
    }
   
}
