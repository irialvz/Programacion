package repasoUNIDAD4;

import java.util.Scanner;

public class A2x03 {

	public static boolean esVocal (char caracter) {
		boolean vocal = false;
		if (caracter == 'a' || caracter == 'A' || caracter == 'e' || caracter == 'E' ||
				caracter == 'i' || caracter == 'I' || caracter == 'o' || caracter == 'O' || caracter == 'u' || caracter == 'U') {
			vocal = true;
		}
		return vocal;
	}
	public static String separaVocales (String cadena) throws Exception {
		String vocalesString = "";
		if (cadena.isEmpty()) {
			throw new Exception("La cadena no puede estar vacia");
		}
		for (int i=0;i < cadena.length();i++) {
			if (esVocal(cadena.charAt(i))){
				vocalesString += cadena.charAt(i);				
			}
			
	}
		return vocalesString;
	}
	public static String separaConsonantes (String cadena) throws Exception {
		String consonantesString = "";
		if (cadena.isEmpty()) {
			throw new Exception("La cadena no puede estar vacia");
		}
		for (int i=0;i < cadena.length();i++) {
			if (!esVocal(cadena.charAt(i))){
				consonantesString += cadena.charAt(i);
			}
		}
				

		return consonantesString;
	}
	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		System.out.println("Cadena?");
		String cadena = teclado.nextLine();
		
		try {
			String vocalesCadena = separaVocales(cadena);
			System.out.printf("La frase tiene %d letras vocales\n",vocalesCadena.length()-1);
			System.out.printf("Letras vocales: %s \n",vocalesCadena);
			String consonantesCadena = separaConsonantes(cadena);
			consonantesCadena = consonantesCadena.replace(" ", "");
			System.out.printf("La frase tiene %d letras consonantes\n",consonantesCadena.length()-1);
			System.out.printf("Letras consonantes: %s \n",consonantesCadena);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
