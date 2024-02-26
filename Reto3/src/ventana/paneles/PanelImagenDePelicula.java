package ventana.paneles;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
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
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		panel.setLayout(null);
		
		JLabel lblNewLabelTicket = new JLabel("Ticket");
		lblNewLabelTicket.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabelTicket.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelTicket.setBounds(416, 78, 125, 48);
		panel.add(lblNewLabelTicket);
		
		JLabel lblNewLabel = new JLabel("Datos de la compra:");
		lblNewLabel.setBounds(307, 150, 132, 14);
		panel.add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(270, 175, 169, 338);
		panel.add(table);
		
		JLabel lblDatosDelCliente = new JLabel("Datos del cliente:");
		lblDatosDelCliente.setBounds(617, 150, 132, 14);
		panel.add(lblDatosDelCliente);
		
		table_1 = new JTable();
		table_1.setBounds(580, 175, 169, 338);
		panel.add(table_1);
		
		JButton btnNewButtonSeleccionImagenDePelicula_Finalizar = new JButton("Finalizar");
		btnNewButtonSeleccionImagenDePelicula_Finalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(4).setVisible(false);
				paneles.get(0).setVisible(true);
			}
		});
		btnNewButtonSeleccionImagenDePelicula_Finalizar.setBounds(730, 543, 194, 57);
		panel.add(btnNewButtonSeleccionImagenDePelicula_Finalizar);
	}
	public JPanel getPanel() {
		return panel;
	}

}//.
