package interfaz;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Elementos {
	/**
	 * Elementos del JFrame
	 */
	//JLabel etiquetaIdentificador;
	//JTextField areaIdentificador;
	JLabel etiquetaDni;
	JTextField areaDni;
	JLabel etiquetaNombre;
	JTextField areaNombre;
	JLabel etiquetaApellidos;
	JTextField areaApellidos;
	JLabel etiquetaDireccion;
	JTextField areaDireccion;
	JLabel etiquetaTelefono;
	JTextField areaTelefono;
	JLabel etiquetaPuesto;
	JComboBox comboPuesto;
	JButton aceptar;
	JButton cancelar;
	
	
	// Se crean los elementos y se añaden
	etiquetaDni = new JLabel("DNI                 ");
	areaDni = new JTextField(15);
	// Se añaden al JPanel
	pDni.add(etiquetaDni);
	pDni.add(areaDni);

}
