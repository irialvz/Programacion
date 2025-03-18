/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6;

/**
 *
 * @author Alumno
 */

public class Circulo {

	// Atributos
	private double radio;
	// Ojo, String siempre en Mayuscula porque no es primitivo sino es clase
	private String color;

	/**
	 * Constructor vacío
	 */
	public Circulo() {
		radio = 0;
		color = "";
	}

	/**
	 * Constructor con radio
	 *
	 * @param rad
	 */
	public Circulo(double rad) {
		radio = rad;
		// El círculo se crea sin color
		color = "";
	}

	/**
	 * Constructor con color sin radio
	 *
	 * @param col
	 */
	public Circulo(String col) {
		radio = 0;
		// El círculo se crea sin color
		color = col;
	}

	/**
	 * Constructor con radio y color
	 *
	 * @param rad
	 * @param col
	 */
	public Circulo(double rad, String col) {
		radio = rad;
		color = col;
	}

	/**
	 *
	 * @return
	 */
	public double getRadio() { // obtiene el radio
		return radio; // retorna el radio
	}

	/**
	 *
	 * @param valor
	 */
	public void setRadio(double valor) { // pone el valor del radio
		radio = valor;
	}

	/**
	 *
	 * @return
	 */
	public String getColor() {
		return color;
	}

	/**
	 *
	 * @param valor
	 */
	public void setColor(String valor) {
		color = valor;
	}

	/**
	 * Calcula el area del circulo
	 *
	 * @return
	 */
	public double calcularArea() {
		return Math.PI * radio * radio;
	}

	/**
	 * Calcula el perimetro del circulo
	 *
	 * @return
	 */
	public double calcularPerimetro() {
		return Math.PI * 2 * radio;
	}

	/**
	 * Saca por pantalla un circulo
	 *
	 * @return
	 */
	@Override
	public String toString() {
		return "Circulo [radio=" + radio + ", color=" + color + "]";
	}

}
