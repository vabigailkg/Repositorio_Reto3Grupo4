package ventana.paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bbdd.gestores.GestorFacturas;
import logica.Funcionalidades;

public class PanelGuardarTicket {

	private JPanel panel = null;
	private Color color = new Color(46, 46, 46);

	public PanelGuardarTicket(ArrayList<JPanel> paneles) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(color);

		panel.setLayout(null);

		JLabel lblNewLabelLogo = new JLabel("");
		lblNewLabelLogo.setIcon(new ImageIcon("src/ventana/Logo.png"));
		lblNewLabelLogo.setBounds(781, 21, 195, 195);
		panel.add(lblNewLabelLogo);

		JLabel lblNewLabel = new JLabel("¿Deseas guardar el ticket?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(358, 193, 259, 55);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);

		JButton btnNewButtonSi = new JButton("Si");
		btnNewButtonSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestorFacturas gestorFacturas = new GestorFacturas();
				Funcionalidades funcionalidades = new Funcionalidades();
				funcionalidades.guardarEntradasEnBBDD(ventana.VentanaMain.entradasSeleccionadas);
				paneles.get(3).setVisible(false);
				paneles.get(2).setVisible(true);
				gestorFacturas.crearTicket(ventana.VentanaMain.entradasSeleccionadas);
			}
		});
		btnNewButtonSi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButtonSi.setBounds(214, 311, 192, 73);
		panel.add(btnNewButtonSi);

		JButton btnNewButtonNo = new JButton("No");
		btnNewButtonNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionalidades funcionalidades = new Funcionalidades();
				funcionalidades.guardarEntradasEnBBDD(ventana.VentanaMain.entradasSeleccionadas);
				paneles.get(3).setVisible(false);
				paneles.get(4).setVisible(true);
			}
		});

		btnNewButtonNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButtonNo.setBounds(512, 311, 192, 73);
		panel.add(btnNewButtonNo);
	}

	public JPanel getPanel() {
		return panel;
	}
}
