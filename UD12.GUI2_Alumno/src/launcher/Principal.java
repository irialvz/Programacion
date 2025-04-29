package launcher;

import dao.TablaTrabajadores;
import excepciones.BDException;
import ficheros.FicheroDatos;
import gui.EmpresaGUI;

public class Principal {
	public static void main(String[] args) {
		try {
			TablaTrabajadores.crearTabla();
		} catch (BDException e) {
			System.err.println(e.getMessage());
		}
		FicheroDatos.leerFicheroBinario("ficheroDatos/empresa.dat");
		new EmpresaGUI();
	}

}
