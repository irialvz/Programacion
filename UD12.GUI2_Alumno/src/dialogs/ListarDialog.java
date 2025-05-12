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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
	JTextField busqueda;
	JScrollPane jsp;
	JLabel text;
	ArrayList<Trabajador> listaTrabajadores;
	TableRowSorter<TableModel> barraBusqueda;

	String texto = "";
	String[][] datos;
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
		try {
			datos = TablaTrabajadores.listarTrabajadores();
			tabla = new JTable(datos, columnas);
		} catch (BDException e) {
			System.err.println(e.getMessage());
		}
		
		text = new JLabel("<html>Barra busqueda:</html>");
		add(text);
		busqueda = new JTextField(20);
		add(busqueda);
		
		barraBusqueda = new TableRowSorter<>(tabla.getModel());
		tabla.setRowSorter(barraBusqueda);
		
		busqueda.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) { filtrar();}

			@Override
			public void removeUpdate(DocumentEvent e) { filtrar();}

			@Override
			public void changedUpdate(DocumentEvent e) {filtrar();}
			
			private void filtrar() {
				texto = busqueda.getText();
				if (texto.trim().length() == 0) {
					barraBusqueda.setRowFilter(null);
				}else {
					barraBusqueda.setRowFilter(RowFilter.regexFilter("(?i)" + texto));
				}
			}
			
		});
		// Mete la tabla en un JCrollPane
		jsp = new JScrollPane(tabla);
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
