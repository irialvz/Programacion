/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6;

/**
 *
 * @author Alumno
 */
public class PruebaCirculos {
    public static void main(String[] args) {
    	Circulo c1 = new Circulo(3.4,"azul");
    	System.out.print(c1.calcularArea());
    	
    	c1.setColor("rojo");
    	System.out.print(c1.getColor());
    	
    	System.out.print(c1.calcularPerimetro());
    	
    	Circulo c2 = new Circulo(3.0);
    	System.out.println(c2.getColor());
    	
    	Circulo c3 = new Circulo("verde");
    	c2.getRadio();
    }
}
