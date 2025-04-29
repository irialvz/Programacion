package dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Empresa;

public class VerDialog extends JDialog implements ActionListener {

	JButton aceptar;
	JButton cancelar;
	JLabel identificador;
	JTextField areaIdentificador;
	JPanel panel;
	JPanel panelBotones;
	JLabel texto;

	Empresa empresa;

	
	/**
	 * Create the dialog.
	 */
	public VerDialog(Empresa empresa) {
		this.empresa = empresa;
		
		setResizable(false);
		// t�tulo del di�log
		setTitle("Buscar Trabajador");
		setSize(300, 200);
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
		// Visible
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}


	@Override
	public void actionPerformed(ActionEvent accion) {
		// TODO Auto-generated method stub
		if (accion.getSource() == aceptar) {
			
		}
		
	}

}
