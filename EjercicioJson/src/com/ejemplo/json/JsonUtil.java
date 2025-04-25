package com.ejemplo.json;

import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.*;
import java.util.ArrayList;
import com.google.gson.reflect.TypeToken;
import java.io.Reader;

public class JsonUtil {
	private static final Gson GSON = new Gson();
	
	public static String convertirObjToJson(Persona persona) {
		return GSON.toJson(persona);
	}
	public static Persona convetirPersonaJsonObj(String json) {
		return GSON.fromJson(json, Persona.class);
	}
}
