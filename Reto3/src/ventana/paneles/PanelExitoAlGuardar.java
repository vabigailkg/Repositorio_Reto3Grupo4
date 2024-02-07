package vista.paneles;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PanelExitoAlGuardar {
	
	private JPanel panel = null;

	public PanelExitoAlGuardar(ArrayList<JPanel> paneles) {
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("El ticket se ha guardado con exito.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(0, 0, 984, 611);
		panel.add(lblNewLabel);
	}
	public JPanel getPanel() {
		return panel;
	}
}
