package repasoUNIDAD4;

import java.util.Scanner;

public class A1x04 {
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
	public static char convertirMayuscula (String cadena) throws Exception {
		if (cadena.length() != 1) {
			throw new Exception("La cadena no es un unico caracter");
		}
		String cadMayuscula = cadena.toUpperCase();
		char caracter = cadMayuscula.charAt(0);
		return caracter;
	}
	public static char convertirMinuscula (String cadena) throws Exception {
		if (cadena.length() != 1) {
			throw new Exception("La cadena no es un unico caracter");
		}
		String cadMinuscula = cadena.toLowerCase();
		char caracter = cadMinuscula.charAt(0);
		return caracter;
	}
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Caracter?");
		String cadena = teclado.nextLine();
		if (esMinuscula(cadena)) {
			try {
				char minusAmayus = convertirMayuscula(cadena);
				System.out.printf("El caracter %s convertido a letra mayuscula es %s \n",cadena,minusAmayus);
				System.out.printf("El caracter %s convertido a letra minuscula es %s",cadena,cadena);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		} else if (esMayuscula(cadena)) {
			try {
				char mayusAminus = convertirMinuscula(cadena);
				System.out.printf("El caracter %s convertido a letra mayuscula es %s \n",cadena,cadena);
				System.out.printf("El caracter %s convertido a letra minuscula es %s",cadena,mayusAminus);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			
		} else {
			System.out.println("El caracter no es una letra");
		}
	}
}
