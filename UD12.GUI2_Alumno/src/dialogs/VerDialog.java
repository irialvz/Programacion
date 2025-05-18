package dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.TablaTrabajadores;
import excepciones.BDException;
import modelo.Empresa;
import modelo.Trabajador;

public class VerDialog extends JDialog implements ActionListener {

	JButton aceptar;
	JButton cancelar;
	JLabel identificador;
	JTextField areaIdentificador;
	JPanel panel;
	JPanel panelBotones;
	JLabel texto;
	JTextArea areaResultado = new JTextArea(6, 25);
	Empresa empresa;

	int id = 0;

	/**
	 * Create the dialog.
	 */
	public VerDialog(Empresa empresa) {
		this.empresa = empresa;

		setResizable(false);
		// t�tulo del di�log
		setTitle("Buscar Trabajador");
		setSize(350, 300);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);

		texto = new JLabel("<html>Introduzca el ID del trabajador<br> que desea buscar<br><br></html>");
		add(texto);

		panel = new JPanel();
		panelBotones = new JPanel();
		add(panel);
		add(panelBotones);

		identificador = new JLabel("Identificador");
		panel.add(identificador);
		areaIdentificador = new JTextField(15);
		panel.add(areaIdentificador);

		aceptar = new JButton("Aceptar");
		aceptar.addActionListener(this);
		panelBotones.add(aceptar);

		cancelar = new JButton("Cancelar");
		cancelar.addActionListener(this);
		panelBotones.add(cancelar);

		areaResultado.setEditable(false);
		add(areaResultado);
		// Visible
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent accion) {
		// TODO Auto-generated method stub
		if (accion.getSource() == aceptar) {
			try {
				id = Integer.parseInt(areaIdentificador.getText());
				if (comprobarErrores()) {
					Trabajador t = TablaTrabajadores.obtenerTrabajador(id);
					if (t != null) {
						areaResultado.setText(t.toString());
					} else {
						JOptionPane.showMessageDialog(null, "El trabajador no existe");
					}
				}
			} catch (BDException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "Solo caracteres numericos", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else if (accion.getSource() == cancelar) {
			dispose();
		}

	}

	public boolean comprobarErrores() {
		if (id < 1) {
			JOptionPane.showMessageDialog(null, "El ID debe ser un n�mero entero positivo", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

}
