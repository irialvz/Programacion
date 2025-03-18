package ejercicios.UNIDAD6.ejerciciosTeresa.ejercicio2x01;

import java.util.Scanner;

public class actividad_2x01 {
	public static int escribirMenu() {
		Scanner teclado = new Scanner(System.in);
		int opcion;
		do {
			System.out.println("0) Salir del programa");
			System.out.println("1) Visualizar en consola las dos cuentas");
			System.out.println("2) Ingresar un importe en la cuenta 1");
			System.out.println("3) Retirar un importe de la cuenta 1");
			System.out.println("4) Ingresar un importe en la cuenta 2");
			System.out.println("5) Retirar un importe de la cuenta 2");
			System.out.println("6) Transferir un importe de la cuenta 1 a la cuenta 2");
			System.out.println("7) Transferir un importe de la cuenta 2 a la cuenta 1");
			System.out.println("Opcion:");
			opcion = teclado.nextInt();
		}while(opcion!=0);
		teclado.close();
		return opcion;
	}

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Cuenta cuenta1 = new Cuenta(1, "Francisco");
		Cuenta cuenta2 = new Cuenta(2, "Victoria");
		int opcion = escribirMenu();
		float ingreso, retirada;
		/// para el examen: SACAR A UNA FUNCION APARTE EL MENU
		// USAR DO Y SWITCH EN VEZ DE IF
			switch (opcion) {
			case 0:
				break;
			case 1:
				System.out.println(cuenta1.obtenerEstado());
				System.out.println(cuenta2.obtenerEstado());
				break;
			case 2:
				System.out.println("¿Cuantia de ingreso?");
				ingreso = teclado.nextFloat();
				cuenta1.ingresar(ingreso);

				if (cuenta1.ingresar(ingreso) == true) {
					System.out.println("Se ha ingresado un importe en la cuenta 1");
				} else {
					System.out.println("Error al ingresar un importe en la cuenta 1: \nEl importe debe ser positivo");
				}
			case 3:
				System.out.println("¿Cuantia de retirada?");
				retirada = teclado.nextFloat();
				cuenta1.retirar(retirada);

				if (cuenta1.retirar(retirada) == true) {
					System.out.println("Se ha retirado un importe en la cuenta 1");
				} else {
					System.out.println(
							"Error al retirar un importe en la cuenta 1: \nEl importe debe ser positivo \nEl importe debe ser menor o igual que el saldo de la cuenta 1");
				}
			case 4:
				System.out.println("¿Cuantia de ingreso?");
				ingreso = teclado.nextFloat();
				cuenta2.ingresar(ingreso);

				if (cuenta2.ingresar(ingreso) == true) {
					System.out.println("Se ha ingresado un importe en la cuenta 2");
				} else {
					System.out.println("Error al ingresar un importe en la cuenta 2: \nEl importe debe ser positivo");
				}
			case 5:
				System.out.println("¿Cuantia de retirada?");
				retirada = teclado.nextFloat();
				cuenta2.retirar(retirada);

				if (cuenta2.retirar(retirada) == true) {
					System.out.println("Se ha retirado un importe en la cuenta 2");
				} else {
					System.out.println(
							"Error al retirar un importe en la cuenta 2: \nEl importe debe ser positivo \nEl importe debe ser menor o igual que el saldo de la cuenta 1");
				}
			case 6:

			}
			teclado.close();
		}
}
