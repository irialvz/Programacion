package com.ejemplo.json;

import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.*;
import java.util.ArrayList;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.Reader;

public class JsonUtil {
	private static final Gson GSON = new Gson();
	
	public static String convertirObjToJson(Persona persona) {
		return GSON.toJson(persona);
	}
	public static Persona convetirPersonaJsonObj(String json) {
		return GSON.fromJson(json, Persona.class);
	}
	public static ArrayList<Persona> convertirArchivoJsonALista(FileReader reader){
		//CUANDO COGE LA LISTA DENTRO DEL ARCHIVO LA TRANSFORMA DIRECTAMENTE 
		Type listaTipo = new TypeToken<ArrayList<Persona>>() {}.getType();
		return GSON.fromJson(reader, listaTipo);
	}
	public static ArrayList<Persona> convertirJsonALista(String json){
		Type listaTipo = new TypeToken<ArrayList<Persona>>() {}.getType();
		return GSON.fromJson(json, listaTipo);
	}
}
