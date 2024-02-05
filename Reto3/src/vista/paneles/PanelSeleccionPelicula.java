package vista.paneles;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelSeleccionPelicula {
	
	private JPanel panel = null;

	public PanelSeleccionPelicula(ArrayList<JPanel> paneles) {
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox<String>();
		comboBox.addItem("Martes");
		comboBox.setBounds(450, 83, 100, 22);
		panel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Pelicula1");
		lblNewLabel.setBounds(230, 200, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pelicula 2");
		lblNewLabel_1.setBounds(480, 200, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Pelicula 3");
		lblNewLabel_2.setBounds(730, 200, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Pelicula 4");
		lblNewLabel_3.setBounds(230, 300, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Pelicula 5");
		lblNewLabel_4.setBounds(480, 300, 46, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Pelicula 6");
		lblNewLabel_5.setBounds(730, 300, 46, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Pelicula 7");
		lblNewLabel_6.setBounds(230, 400, 46, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Pelicula 8");
		lblNewLabel_7.setBounds(480, 400, 46, 14);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Pelicula 9");
		lblNewLabel_8.setBounds(730, 400, 46, 14);
		panel.add(lblNewLabel_8);
		
		JButton btnNewButtonSeleccionCine_Finalizar = new JButton("Finalizar");
		btnNewButtonSeleccionCine_Finalizar.setBounds(730, 543, 194, 57);
		panel.add(btnNewButtonSeleccionCine_Finalizar);
	}
	public JPanel getPanel() {
		return panel;
	}
}
