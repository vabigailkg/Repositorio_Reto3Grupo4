package vista.paneles;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class PanelSeleccionSesion {
	
	private JPanel panel = null;
	private JTable tableInformacionSesionesPelicula = null;

	public PanelSeleccionSesion(ArrayList<JPanel> paneles) {
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		panel.setLayout(null);
		
		JLabel lblNewLabelPeliculaSeleccionada = new JLabel("Pelicula Seleccionada");
		lblNewLabelPeliculaSeleccionada.setBounds(414, 51, 113, 14);
		panel.add(lblNewLabelPeliculaSeleccionada);
		
		JLabel lblNewLabelEligeElDia = new JLabel("Elige el dia");
		lblNewLabelEligeElDia.setBounds(435, 109, 63, 14);
		panel.add(lblNewLabelEligeElDia);
		
		JComboBox comboBoxSeleccionDia = new JComboBox<String>();
		comboBoxSeleccionDia.addItem("Martes");
		comboBoxSeleccionDia.addItem("Miercoles");
		comboBoxSeleccionDia.setBounds(414, 134, 113, 22);
		panel.add(comboBoxSeleccionDia);
		
		tableInformacionSesionesPelicula = new JTable();
		tableInformacionSesionesPelicula.setBounds(331, 178, 293, 309);
		panel.add(tableInformacionSesionesPelicula);
		
		JButton btnNewButtonSeleccionCine_Finalizar = new JButton("Finalizar");
		btnNewButtonSeleccionCine_Finalizar.setBounds(730, 543, 194, 57);
		panel.add(btnNewButtonSeleccionCine_Finalizar);
		
	}
	public JPanel getPanel() {
		return panel;
	}
}
