package com.ejemplo.json;

public class Persona {
	private String nombreString;
	private int edadString;
	
	public Persona(String nombreString, int edadString) {
		super();
		this.nombreString = nombreString;
		this.edadString = edadString;
	}

	public String getNombreString() {
		return nombreString;
	}

	public void setNombreString(String nombreString) {
		this.nombreString = nombreString;
	}

	public int getEdadString() {
		return edadString;
	}

	public void setEdadString(int edadString) {
		this.edadString = edadString;
	}
	
	

}
