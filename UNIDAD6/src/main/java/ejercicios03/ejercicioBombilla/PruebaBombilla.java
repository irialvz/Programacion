package ejercicios.UNIDAD6.ejercicios03.ejercicioBombilla;

public class PruebaBombilla {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		 Bombilla b = new Bombilla();
		// Creamos un objeto bombilla

		 // La encendemos y apagamos 1000 veces
		 for(i=1; i<=1000;i++)
		 {
		 b.encendido();
		 b.apagado();
		 }
		// Y otra vez más, aunque ya debe estar fundida
		 b.encendido();
		 b.apagado();
	}

}
