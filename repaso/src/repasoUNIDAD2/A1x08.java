package repasoUNIDAD2;

public class A1x08 {
	public static boolean sonAmigos (int numero1,int numero2) {
		int limite = 500;
		int divisor1 = 0,divisor2 = 0;
		boolean amigos = false;
		
		for (int i = 1;i < limite;i++) {
			if (numero1 % i == 0 && numero1 != i) {
				divisor1 += i;
			}
			if (numero2 % i == 0 && numero2 != i) {
				divisor2 += i;
			}
		}
		if (numero1 == divisor1 && numero2 == divisor2) {
			amigos =true;
			
		}
		return amigos;
	}
	public static void main(String[] args) {
		int limite = 500;
		for (int i = 1;i <= limite;i++) {
			for (int j = 1;j <= limite;j++) {
				if (sonAmigos(i, j)) {
					System.out.println("Los numeros " + i + " y " + j + " son amigos");
				}
			}
		}
	}

}
