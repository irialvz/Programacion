package repasoUNIDAD4;

import java.util.Scanner;

public class A1x02 {
	public static boolean esMinuscula(String cadena) {
		boolean minuscula = false;
		if (cadena.length() != 1 || cadena.isEmpty()) {
			return false;
		}
		char caracter = cadena.charAt(0);
		if (caracter >= 'a' && caracter <= 'z') {
			minuscula = true;
			
		}
		return minuscula;
	}
	public static boolean esMayuscula(String cadena) {
		boolean mayuscula = false;
		if (cadena.length() != 1 || cadena.isEmpty()) {
			return false;
		}
		char caracter = cadena.charAt(0);
		if (caracter >= 'A' && caracter <= 'Z') {
			mayuscula = true;
			
		}
		return mayuscula;
	}
	public static void main (String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Caracter?");
		String cadena = teclado.nextLine();
		if (esMinuscula(cadena)) {
			System.out.println("El caracter " + cadena + " es minuscula");
		} else if (esMayuscula(cadena)) {
			System.out.println("El caracter " + cadena + " es mayuscula");
		} else {
			System.out.println("El caracter no es una letra");
		}
	}

}
