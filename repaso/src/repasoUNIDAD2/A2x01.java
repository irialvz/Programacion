package repasoUNIDAD2;

import java.security.DomainCombiner;
import java.util.Scanner;

public class A2x01 {
	public static String escribirTablaMultiplicar(int numero) throws Exception {
		if (numero < 0) {
			throw new Exception("El numero debe ser positivo");
		}
		String tablaString = "";
		for (int i= 0;i <= 10;i++) {
			tablaString += (numero + "*" + i + " = " + numero*i + "\n");
		}
		return tablaString;
	}
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Numero?");
		int numero = teclado.nextInt();
		try {
			System.out.print(escribirTablaMultiplicar(numero));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
