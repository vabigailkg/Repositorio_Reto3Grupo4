package vista.paneles;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelBienvenida {

	private JPanel panel = null;

	public PanelBienvenida(ArrayList<JPanel> paneles) {

		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		JLabel lblNewLabelImagenBienvenida = new JLabel("ImagenBienvenida");
		lblNewLabelImagenBienvenida.setBounds(0, 0, 943, 323);
		panel.add(lblNewLabelImagenBienvenida);

		JLabel lblNewLabelTextoBienvenida = new JLabel("TextoBienvenida");
		lblNewLabelTextoBienvenida.setBounds(144, 316, 346, 119);
		panel.add(lblNewLabelTextoBienvenida);

		JButton btnNewButtonBienvenidaRegistro = new JButton("Registrarse");
		btnNewButtonBienvenidaRegistro.setBounds(597, 338, 141, 42);
		panel.add(btnNewButtonBienvenidaRegistro);

		panel.setLayout(null);
	}

	public JPanel getPanel() {
		return panel;
	}
}