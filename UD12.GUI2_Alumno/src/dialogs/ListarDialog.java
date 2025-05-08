/**
 * 
 */
package dialogs;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import dao.TablaTrabajadores;
import excepciones.BDException;
import modelo.Empresa;
import modelo.Trabajador;

/**
 * 
 * @author usuario
 *
 */
public class ListarDialog extends JDialog implements ActionListener {

	Empresa empresa;
	JTable tabla;
	JButton cerrar;
	JButton csv;
	ArrayList<Trabajador> listaTrabajadores;

	public ListarDialog(Empresa empresa) {
		this.empresa = empresa;

		setResizable(false);
		// t�tulo del di�log
		setTitle("Listado Trabajadores");
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
		TableRowSorter<TableModel> ordenar = new TableRowSorter<>(tabla.getModel());
		tabla.setRowSorter(ordenar);
		// Mete la tabla en un JCrollPane
		JScrollPane jsp = new JScrollPane(tabla);
		jsp.setPreferredSize(new Dimension(700, 600));
		add(jsp);

		cerrar = new JButton("Cerrar");
		cerrar.addActionListener(this);
		add(cerrar);
		
		csv = new JButton("Exportar a csv");
		csv.addActionListener(this);
		add(csv);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == cerrar) {
			dispose();
		} else if (e.getSource() == csv) {
			try {
				listaTrabajadores = TablaTrabajadores.obtenerTrabajadores();
				if (TablaTrabajadores.exportarFicheroCSV("trabajadores", listaTrabajadores)) {
					JOptionPane.showMessageDialog(this, "Se ha generado correctamente");
					dispose();
				}
			} catch (BDException ex) {
				System.err.println(ex.getMessage());
			}
		}
	}

}
