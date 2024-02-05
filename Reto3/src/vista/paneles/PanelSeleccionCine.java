package vista.paneles;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelSeleccionCine {

	private JPanel panel = null;

	public PanelSeleccionCine(ArrayList<JPanel> paneles) {
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		panel.setLayout(null);

		JLabel lblNewLabelCine2Texto = new JLabel("CINE 2");
		lblNewLabelCine2Texto.setBounds(480, 165, 40, 14);
		panel.add(lblNewLabelCine2Texto);

		JLabel lblNewLabelCine1Texto = new JLabel("CINE 1");
		lblNewLabelCine1Texto.setBounds(230, 165, 40, 14);
		panel.add(lblNewLabelCine1Texto);

		JLabel lblNewLabelCine3Texto = new JLabel("CINE 3");
		lblNewLabelCine3Texto.setBounds(730, 165, 40, 14);
		panel.add(lblNewLabelCine3Texto);

		JButton btnNewButtonSeleccionCine_Finalizar = new JButton("Finalizar");
		btnNewButtonSeleccionCine_Finalizar.setBounds(730, 543, 194, 57);
		panel.add(btnNewButtonSeleccionCine_Finalizar);

		JLabel lblNewLabelCine1Imagen = new JLabel("Imagen1");
		lblNewLabelCine1Imagen.setBounds(136, 240, 210, 161);
		panel.add(lblNewLabelCine1Imagen);

		JLabel lblNewLabelCine2Imagen = new JLabel("Imagen2");
		lblNewLabelCine2Imagen.setBounds(394, 240, 210, 161);
		panel.add(lblNewLabelCine2Imagen);

		JLabel lblNewLabelCine3Imagen = new JLabel("Imagen3");
		lblNewLabelCine3Imagen.setBounds(645, 240, 210, 161);
		panel.add(lblNewLabelCine3Imagen);
	}

	public JPanel getPanel() {
		return panel;
	}
}
