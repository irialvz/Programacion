package ejercicios.UNIDAD5;

import java.util.Random;

public class PrincipalLineaAutobus {

	public static LineaAutobus creaLineaAleatoria() {
		Random aleatorio = new Random();
		// Genera numero linea aleatorio
		String numLinea = String.valueOf(aleatorio.nextInt(60 - 20 + 1) + 20);
		// Asignacion precio billete
		float precio = 1.4f;
		// frecuencia
		int frecuencia = aleatorio.nextInt(20 - 5 + 1) + 5;
		int[] paradas = new int[7];
		for (int i = 0; i < paradas.length; i++) {
			paradas[i] = aleatorio.nextInt(200 - 10 + 1) + 10;
		}
		return new LineaAutobus(numLinea, precio, frecuencia, paradas);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			LineaAutobus linea = creaLineaAleatoria(); //linea almacenara un obj creado con la clase LineaAutobus
			System.out.println(linea);
			System.out.println("Comprobacion de paradas..");
			
			int[] paradasEspeciales = { 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180,190, 200 };

			boolean tieneParadaEspecial = false;
			for (int j = 0; j < paradasEspeciales.length; j++) { //mientras que j sea menor que la anchura del vector
				if (linea.tieneParada(paradasEspeciales[j])) { // comprabara que el objeto creado tiene alguna parada igual que el vector 
					tieneParadaEspecial = true; // si es asi, devolvera true
					break;
				}
			}
			if (tieneParadaEspecial) { // si el booleano es verdadero
				linea.setFrecuencia(linea.getFrecuencia() + 5); // sumara 5 a la frecuencia del objeto linea
			}
			System.out.println(linea + "\n");

		}
	}
}
