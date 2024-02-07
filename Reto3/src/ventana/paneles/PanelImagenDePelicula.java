package vista.paneles;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PanelImagenDePelicula {
	
	private JPanel panel = null;
	private JTable table = null;
	private JTable table_1 = null;
	
	public PanelImagenDePelicula(ArrayList<JPanel> paneles) {
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		panel.setLayout(null);
		
		JLabel lblNewLabelTicket = new JLabel("Ticket");
		lblNewLabelTicket.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabelTicket.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelTicket.setBounds(416, 108, 125, 48);
		panel.add(lblNewLabelTicket);
		
		JLabel lblNewLabel = new JLabel("Datos de la compra:");
		lblNewLabel.setBounds(307, 180, 132, 14);
		panel.add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(270, 205, 169, 338);
		panel.add(table);
		
		JLabel lblDatosDelCliente = new JLabel("Datos del cliente:");
		lblDatosDelCliente.setBounds(617, 180, 132, 14);
		panel.add(lblDatosDelCliente);
		
		table_1 = new JTable();
		table_1.setBounds(580, 205, 169, 338);
		panel.add(table_1);
	}
	public JPanel getPanel() {
		return panel;
	}

}
