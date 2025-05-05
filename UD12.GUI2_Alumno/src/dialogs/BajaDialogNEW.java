/**
 * 
 */
package dialogs;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dao.TablaTrabajadores;
import excepciones.BDException;
import modelo.Empresa;

/**
 * 
 * @author usuario
 *
 */
public class BajaDialogNEW extends JDialog implements ActionListener {

	JButton aceptar;
	JButton cancelar;
	JPanel panel;
	JPanel panelBotones;
	JLabel texto;

	Empresa empresa;
	JTable tabla;
	JButton cerrar;
	JButton borrar;

	public BajaDialogNEW(Empresa empresa) {
		this.empresa = empresa;

		setResizable(false);
		// t�tulo del di�log
		setTitle("Borrado Trabajadores");
		// tama�o
		setSize(750, 700);
		setLayout(new FlowLayout());
		// colocaci�n en el centro de la pantalla
		setLocationRelativeTo(null);

		// Crea un JTable, cada fila será un trabajador
		String[] columnas = { "Identificador", "DNI", "Nombre", "Apellidos", "Direcci�n", "Tel�fono", "Puesto" };
		String[][] datos;
		try {
			datos = TablaTrabajadores.listarTrabajadores();
			tabla = new JTable(datos, columnas);
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

		borrar = new JButton("Borrar");
		borrar.addActionListener(this);
		add(borrar);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == cerrar) {
			dispose();
		} else if (e.getSource() == borrar) {
			int filaSeleccionada = tabla.getSelectedRow();
			if (filaSeleccionada != -1) {
				String filaID = tabla.getValueAt(filaSeleccionada,0).toString();
				int idEliminar = Integer.parseInt(filaID);

					int respuesta = JOptionPane.showConfirmDialog(null, "�Desea dar de baja el trabajador?", "Borrar",
							JOptionPane.YES_NO_OPTION);
					switch (respuesta) {
					case JOptionPane.YES_OPTION:
						try {
							// Operaciones en caso afirmativo
							if (TablaTrabajadores.bajaTrabajador(idEliminar)) {
								JOptionPane.showMessageDialog(this, "El trabajador se ha eliminado correctamente");
								String[][] nuevosDatos = TablaTrabajadores.listarTrabajadores();
								tabla.setModel(new javax.swing.table.DefaultTableModel(nuevosDatos, new String[] { "Identificador", "DNI", "Nombre", "Apellidos", "Direcci�n", "Tel�fono", "Puesto" }));
							} else {
								JOptionPane.showMessageDialog(null, "El trabajador no se encuentra en la lista", "Error",
										JOptionPane.ERROR_MESSAGE);
							}

							break;

						} catch (BDException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
			}
		}

	}
}

