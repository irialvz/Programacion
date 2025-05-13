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
import javax.swing.JFileChooser;
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
	JButton json;
	JTextField busqueda;
	JScrollPane jsp;
	JLabel text;
	ArrayList<Trabajador> listaTrabajadores;
	TableRowSorter<TableModel> barraBusqueda;
	JFileChooser ficheroSeleccionado; 
	String ruta = "";
	int resultado = 0;

	String texto = "";
	String[][] datos;
	public ListarDialog(Empresa empresa) {
		this.empresa = empresa;

		setResizable(false);
		// t�tulo del di�log
		setTitle("Listado Trabajadores");
		// tama�o
		setSize(750, 720);
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
		
		json = new JButton("Exportar a JSON");
		json.addActionListener(this);
		add(json);
		
		ficheroSeleccionado = new JFileChooser();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == cerrar) {
			dispose();
		} else if (e.getSource() == csv) {
			resultado = ficheroSeleccionado.showSaveDialog(this);
			if (resultado == JFileChooser.APPROVE_OPTION) {
				ruta = ficheroSeleccionado.getSelectedFile().getAbsolutePath();
			}
			try {
				listaTrabajadores = TablaTrabajadores.obtenerTrabajadores();
				if (TablaTrabajadores.exportarFicheroCSV(ruta, listaTrabajadores)) {
					JOptionPane.showMessageDialog(this, "Se ha generado correctamente");
					dispose();
				}
			} catch (BDException ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);			}
		} else if (e.getSource() == json) {
			resultado = ficheroSeleccionado.showSaveDialog(this);
			if (resultado == JFileChooser.APPROVE_OPTION) {
				ruta = ficheroSeleccionado.getSelectedFile().getAbsolutePath();
			}
			try {
				listaTrabajadores = TablaTrabajadores.obtenerTrabajadores();
				if (TablaTrabajadores.exportarFicheroJson(ruta, listaTrabajadores)) {
					JOptionPane.showMessageDialog(this, "Se ha generado correctamente");
					dispose();
				}
			} catch (BDException ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);			}
			
		}
	}


}
