package repasoUNIDAD2;

import java.util.Scanner;

public class A1x07 {
	public static boolean esPerfecto(int entero) {
		if (entero <= 0) {
			return false;
		}
		int limite = 10000;
		boolean esPerf = false;
		int divisor = 0;
		for (int i = 1;i < limite;i++) {
			if (entero % i == 0 && entero != i) {
				divisor = divisor + i;
			}
		}
		if (entero == divisor) {
			esPerf = true;
		}
		return esPerf;
	}
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int limite = 10000;
		
		for (int i = 0;i < limite;i++) {
			if (esPerfecto(i)) {
				System.out.println("El numero " + i + " es perfecto");
			} 
			
		}
		

	}
	

}
