package vista.paneles;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class PanelConfirmacion {

	private JPanel panel = null;
	private JTable tableTodaLaInformacion = null;

	public PanelConfirmacion(ArrayList<JPanel> paneles) {
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		panel.setLayout(null);
		
		JLabel lblNewLabelSeleccion = new JLabel("Has seleccionado:");
		lblNewLabelSeleccion.setBounds(415, 111, 101, 14);
		panel.add(lblNewLabelSeleccion);
		
		tableTodaLaInformacion = new JTable();
		tableTodaLaInformacion.setBounds(295, 149, 329, 268);
		panel.add(tableTodaLaInformacion);
		
		JButton btnNewButtonSeleccionCine_FinalizarPagar = new JButton("Finalizar y pagar");
		btnNewButtonSeleccionCine_FinalizarPagar.setBounds(730, 543, 194, 57);
		panel.add(btnNewButtonSeleccionCine_FinalizarPagar);
		
		JButton btnNewButtonCancelarFinalizar = new JButton("Cancelar y finalizar");
		btnNewButtonCancelarFinalizar.setBounds(50, 543, 194, 57);
		panel.add(btnNewButtonCancelarFinalizar);
		
		JButton btnNewButtonSeguirComprando = new JButton("Seguir comprando");
		btnNewButtonSeguirComprando.setBounds(372, 543, 194, 57);
		panel.add(btnNewButtonSeguirComprando);
	}


	public JPanel getPanel() {
		return panel;
	}
}
