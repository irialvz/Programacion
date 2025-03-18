package ejercicios.UNIDAD6.ejercicios03.ejercicioBombilla;

public class Bombilla {
	private boolean encendido;
	private boolean fundido;
	private int contadorEncendidos;
	
	//CONSTRUCTOR
	public Bombilla () {
	}
	
	//METODOS
	public void encendido() {
		if (fundido) {
			System.out.println("La bombilla esta fundida");
		} else if (encendido) {
			System.out.println("La bombilla ya estaba encendida");
		} else {
			encendido = true;
			contadorEncendidos++;
			if (contadorEncendidos == 1000) {
				fundido = true;
				System.out.println("La bombilla se ha fundido, ha llegado a 1000 encendidos");
				encendido = false;
			}
		}
	}
	public void apagado() {
		if (fundido) {
			System.out.println("La bombilla esta fundida");
		} else if (!encendido) {
			System.out.println("La bombilla ya estaba apagada");
		} else {
			encendido = false;
		}
	}
	
}
