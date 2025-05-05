package dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.TablaTrabajadores;
import excepciones.BDException;
import modelo.Empresa;
import modelo.Trabajador;

public class ModificaDialog extends JDialog implements ItemListener, ActionListener {

	/**
	 * Elementos del JFrame
	 */
	
	JLabel etiquetaIdentificador;
	JComboBox comboIdentificador;
	
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
	/**
	 * Variables a las que se pasar� el contenido de los JTextField y del combo box
	 */
	int id = 0;
	String dni = "";
	String nombre = "";
	String apellidos = "";
	String direccion = "";
	String telefono = "";
	String puesto = "";

	JPanel pIdentificador;
	JPanel pDni;
	JPanel pNombre;
	JPanel pApellidos;
	JPanel pDireccion;
	JPanel pTelefono;
	JPanel pPuesto;
	JPanel pBotones;
	
	Empresa empresa;
	
	public ModificaDialog(Empresa empresa) {
		this.empresa = empresa;
		setResizable(false);
		// t�tulo del di�log
		setTitle("Modificar Trabajador");
		setSize(300, 350);
		setLayout(new FlowLayout());

		setLocationRelativeTo(null);

		// una fila por JPanel
		pIdentificador = new JPanel();
		pDni = new JPanel();
		pNombre = new JPanel();
		pApellidos = new JPanel();
		pDireccion = new JPanel();
		pTelefono = new JPanel();
		pPuesto = new JPanel();
		pBotones = new JPanel();
		
		
		/**
		 * BOTON IDENTIFICADOR
		 */
		// Se crean los elementos y se añaden
		etiquetaIdentificador = new JLabel("Identificador                         ");
		pIdentificador.add(etiquetaIdentificador);
		// lista desplegable
		comboIdentificador = new JComboBox();
		ArrayList<Integer> identificadores = new ArrayList<>();
		try {
			identificadores = TablaTrabajadores.obtenerIDs();
			for (int id : identificadores) {
				comboIdentificador.addItem(id);
			}
		} catch (BDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		comboIdentificador.addItemListener(this);
		pIdentificador.add(comboIdentificador);
		// Se añaden al JPanel
		pIdentificador.add(etiquetaIdentificador);
		pIdentificador.add(comboIdentificador);

		/**
		 * BOTON DNI
		 */
		// Se crean los elementos y se añaden
		etiquetaDni = new JLabel("DNI                 ");
		areaDni = new JTextField(15);
		// Se añaden al JPanel
		pDni.add(etiquetaDni);
		pDni.add(areaDni);

		/**
		 * BOTON NOMBRE
		 */
		// Se crean los elementos y se añaden
		etiquetaNombre = new JLabel("Nombre         ");
		areaNombre = new JTextField(15);
		// Se añaden al JPanel
		pNombre.add(etiquetaNombre);
		pNombre.add(areaNombre);

		/**
		 * BOTON APELLIDOS
		 */
		// Se crean los elementos y se a�aden
		etiquetaApellidos = new JLabel("Apellidos      ");
		areaApellidos = new JTextField(15);
		// Se añaden al JPanel
		pApellidos.add(etiquetaApellidos);
		pApellidos.add(areaApellidos);

		/**
		 * BOTON DIRECCION
		 */
		// Se crean los elementos y se añaden
		etiquetaDireccion = new JLabel("Direccion      ");
		areaDireccion = new JTextField(15);
		// Se añaden al JPanel
		pDireccion.add(etiquetaDireccion);
		pDireccion.add(areaDireccion);

		/**
		 * BOTON TELEFONO
		 */
		// Se crean los elementos y se a�aden
		etiquetaTelefono = new JLabel("Telefono       ");
		areaTelefono = new JTextField(15);
		// Se añaden al JPanel
		pTelefono.add(etiquetaTelefono);
		pTelefono.add(areaTelefono);

		/**
		 * DESPLEGABLE DE PUESTO
		 */
		// Se crean los elementos y se añaden
		etiquetaPuesto = new JLabel("Puesto                         ");
		pPuesto.add(etiquetaPuesto);
		// lista desplegable
		comboPuesto = new JComboBox();
		comboPuesto.addItem("Elija Puesto");
		ArrayList<String> puestosDisponibles;
		try {
			puestosDisponibles = TablaTrabajadores.obtenerPuestos();
			for (String puesto : puestosDisponibles) {
				comboPuesto.addItem(puesto);

			}
		} catch (BDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		comboPuesto.addItemListener(this);
		pPuesto.add(comboPuesto);
		
		// Añadir al JDialog los JPanel
		add(pIdentificador);
		add(pDni);
		add(pNombre);
		add(pApellidos);
		add(pDireccion);
		add(pTelefono);
		add(pPuesto);

		aceptar = new JButton("Aceptar");
		aceptar.addActionListener(this);
		pBotones.add(aceptar);

		cancelar = new JButton("Cancelar");
		cancelar.addActionListener(this);
		pBotones.add(cancelar);

		add(pBotones);

		// Visible
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		puesto = comboPuesto.getSelectedItem().toString();
		id = comboIdentificador.getSelectedIndex();
		
	}

	@Override
	public void actionPerformed(ActionEvent accion) {
		// TODO Auto-generated method stub
		if (accion.getSource() == aceptar) {
			id = (int) comboIdentificador.getSelectedItem();
			dni = areaDni.getText();
			nombre= areaNombre.getText();
			apellidos = areaApellidos.getText();
			direccion = areaDireccion.getText();
			telefono = areaTelefono.getText();
			if (comprobarErrores()) {
				Trabajador t = new Trabajador(id,dni,nombre,apellidos,direccion,telefono,puesto);
				try {
					TablaTrabajadores.modificarTrabajador(t);
				} catch (BDException e) {
					System.err.println(e.getMessage());
				}
				JOptionPane.showMessageDialog(null,"Trabajador introducido correctamente");
			}
		} else if (accion.getSource() == cancelar) {
			dispose();
		}
		
	}
	/**
	 * M�todo que comprueba si no hay ning�n campo vac�o o si la longitud de los
	 * campos es la correcta
	 * 
	 * @return
	 */
	public boolean comprobarErrores() {
		if (id < 1) {
			JOptionPane.showMessageDialog(null, "El ID debe ser un n�mero entero positivo", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (dni.equals("") || dni.length() != 9) {
			JOptionPane.showMessageDialog(null, "El DNI debe tener longitud 9", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (nombre.equals("")) {
			JOptionPane.showMessageDialog(null, "Debe introducir el nombre del trabajador", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (apellidos.equals("")) {
			JOptionPane.showMessageDialog(null, "Debe introducir los apellidos del trabajador", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (direccion.equals("")) {
			JOptionPane.showMessageDialog(null, "Debe introducir la direcci�n del trabajador", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (telefono.equals("") || telefono.length() != 9) {
			JOptionPane.showMessageDialog(null, "El tel�fono debe tener longitud 9", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (puesto.equals("")) {
			JOptionPane.showMessageDialog(null, "Debe introducir el puesto del trabajador", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	//private static final long serialVersionUID = 1L;
	//private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			ModificaDialog dialog = new ModificaDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */


}
