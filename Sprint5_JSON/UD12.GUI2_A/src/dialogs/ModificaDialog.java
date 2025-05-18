package dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;

import dao.TablaTrabajadores;
import excepciones.BDException;
import modelo.Empresa;
import modelo.Trabajador;


public class ModificaDialog extends JDialog implements ItemListener, ActionListener {
	/**
	 * 
	 */	JButton aceptar;
		JButton cancelar;
		JPanel panel;
		JPanel panelBotones;
		JLabel texto;

		Empresa empresa;
		JTable tabla;
		JButton cerrar;
		JButton modificar;
		JComboBox<String> comboPuestos;
		TableColumn columnaPuesto;
		
		/**
		 * Variables a las que se pasar� el contenido de los JTextField y del combo box
		 */
		//int id = 0;
		String dni = "";
		String nombre = "";
		String apellidos = "";
		String direccion = "";
		String telefono = "";
		String puesto = "";
		private static final long serialVersionUID = 1L;

	public ModificaDialog(Empresa empresa) {
		this.empresa = empresa;

		setResizable(false);
		// t�tulo del di�log
		setTitle("Modifica Trabajadores");
		// tama�o
		setSize(750, 700);
		setLayout(new FlowLayout());
		// colocaci�n en el centro de la pantalla
		setLocationRelativeTo(null);

		// Crea un JTable, cada fila será un trabajador
		String[] columnas = { "Identificador", "DNI", "Nombre", "Apellidos", "Direcci�n", "Tel�fono", "Puesto" };
		String[][] datos;
		try {
			String[] puestosDisponibles = TablaTrabajadores.obtenerPuestos();
			comboPuestos = new JComboBox<>(puestosDisponibles);

		} catch (BDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			datos = TablaTrabajadores.listarTrabajadores();
			tabla = new JTable(datos, columnas);
			columnaPuesto = tabla.getColumnModel().getColumn(6);
			columnaPuesto.setCellEditor(new DefaultCellEditor(comboPuestos));
		} catch (BDException e) {
			System.err.println(e.getMessage());
		}

		// Mete la tabla en un JCrollPane
		JScrollPane jsp = new JScrollPane(tabla);
		jsp.setPreferredSize(new Dimension(700, 600));
		add(jsp);

		cerrar = new JButton("Cerrar");
		cerrar.addActionListener(this);
		add(cerrar);

		modificar = new JButton("Modificar");
		modificar.addActionListener(this);
		add(modificar);
		

		setVisible(true);
	}
	

	@Override
	public void itemStateChanged(ItemEvent e) {

		
	}

	@Override
	public void actionPerformed(ActionEvent accion) {
		if (accion.getSource() == modificar) {
			int filaSeleccionada = tabla.getSelectedRow();
			if(filaSeleccionada != -1) {
				String filaID = tabla.getValueAt(filaSeleccionada, 0).toString();
				int idTrabajador = Integer.parseInt(filaID);
				String dniTrabajador = tabla.getValueAt(filaSeleccionada, 1).toString();
				String nombreTrabajador = tabla.getValueAt(filaSeleccionada, 2).toString();
				String apellidoTrabajador = tabla.getValueAt(filaSeleccionada, 3).toString();
				String direccionTrabajador = tabla.getValueAt(filaSeleccionada, 4).toString();
				String telefonoTrabajador = tabla.getValueAt(filaSeleccionada, 5).toString();
				String puestoTrabajador = (String) comboPuestos.getSelectedItem();
				Trabajador editTrabajador = new Trabajador(idTrabajador,dniTrabajador,nombreTrabajador,apellidoTrabajador,direccionTrabajador,telefonoTrabajador,puestoTrabajador);
				int respuesta = JOptionPane.showConfirmDialog(null, "Desea modificar el trabajador?", "Modificar", JOptionPane.YES_NO_OPTION);
				switch(respuesta) {
				case JOptionPane.YES_OPTION:
					try {
						if (TablaTrabajadores.modificarTrabajador(editTrabajador)) {
							JOptionPane.showMessageDialog(this, "El trabajador " + editTrabajador.getIdentificador() + " se ha modificado correctamente");
							String[][] nuevosDatos = TablaTrabajadores.listarTrabajadores();
							tabla.setModel(new javax.swing.table.DefaultTableModel(nuevosDatos, new String[] { "Identificador", "DNI", "Nombre", "Apellidos", "Direcci�n", "Tel�fono", "Puesto" }));
						} else {
							JOptionPane.showMessageDialog(null, "El trabajador no se ha modificado","Error",JOptionPane.ERROR_MESSAGE);
						}
					} catch (BDException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} else if (accion.getSource() == cerrar) {
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
		if (dni.equals("") || dni.length() != 9) {
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



