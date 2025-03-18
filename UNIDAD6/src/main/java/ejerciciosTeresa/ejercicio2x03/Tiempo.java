package ejercicios.UNIDAD6.ejerciciosTeresa.ejercicio2x03;
import java.util.Random;

public class Tiempo {
	private int horas;
	private int minutos;
	private int segundos;
	
	public Tiempo (int horas,int minutos,int segundos) {
		this.horas = horas;
		this.minutos = minutos;
		this.segundos = segundos;
	}
	public Tiempo() {
		Random aleatorio = new Random();
		this.horas = aleatorio.nextInt(24);
		this.minutos = aleatorio.nextInt(60);
		this.segundos = aleatorio.nextInt(60);

	}
	
	
	public static boolean validar(int horas,int minutos,int segundos) {
	if (horas >= 0 && horas <= 23 && minutos >= 0 && minutos <= 59 && segundos >= 0 && segundos <= 59) {
		return true;
	}
	return false;
	}
	
	public String toString() {
		return 
				String.format("%02d:%02d:%02d"
						,this.horas,this.minutos,this.segundos);
		
	}
	
	public boolean sumar(Tiempo fecha) {
		int segundo = this.segundos+ fecha.segundos;
		int minuto = this.minutos+ fecha.minutos;
		int hora = this.horas+ fecha.horas;
		
		boolean calculadoConExito = false;
		if (segundo < 0) {
			minuto = minuto + 60;
			minuto--;
		}
		if (minuto < 0) {
			minuto = minuto + 60;
			hora--;
		}
		if (hora < 24) {
			this.segundos = segundo;
			this.minutos = minuto;
			this.horas = hora;
			calculadoConExito = true;
		}
	return calculadoConExito;
	}
	public static void main (String[] args) {
		Tiempo fecha1 = new Tiempo(12,28,30);
		System.out.println(fecha1);
		System.out.println(fecha1.sumar(fecha1));
		
		
	}
}
