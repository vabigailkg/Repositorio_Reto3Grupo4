package vista.paneles;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelGuardarTicket {
	
	private JPanel panel = null;


	public PanelGuardarTicket(ArrayList<JPanel> paneles) {
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("¿Deseas guardar el ticket?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(358, 193, 259, 55);
		panel.add(lblNewLabel);
		
		JButton btnNewButtonSi = new JButton("Si");
		btnNewButtonSi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButtonSi.setBounds(214, 311, 192, 73);
		panel.add(btnNewButtonSi);
		
		JButton btnNewButtonNo = new JButton("No");
		btnNewButtonNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButtonNo.setBounds(512, 311, 192, 73);
		panel.add(btnNewButtonNo);
	}
	public JPanel getPanel() {
		return panel;
	}
}
