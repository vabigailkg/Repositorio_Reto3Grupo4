package ventana.paneles;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bbdd.gestores.GestorCines;
import logica.Funcionalidades;

public class PanelBienvenida {

	private JPanel panel = null;
	private Color color = new Color(46, 46, 46);
	private String textoBienvenida = "<html><body>\"Bienvenido a cines Elorrieta Vizcaya.<br> "
			+ "Cines Elorrieta es la empresa líder en exhibición cinematográfica en España,<br>"
			+ "gracias a los 11 millones de espectadores que cada año <br>"
			+ "visitan una de las más de 400 salas repartidas en los 35 cines<br>"
			+ "que tiene en las mejores localizaciones de las principales ciudades españolas.\"</body></html>";

	public PanelBienvenida(ArrayList<JPanel> paneles) {

		Funcionalidades funcionalidades = new Funcionalidades();
		GestorCines gestorCines = new GestorCines();

		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(color);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (funcionalidades.comprobarActivacionBBDD()) {
					if (null == gestorCines.obtenerListaDeCines()) {
						JOptionPane.showMessageDialog(null, "No hay cines en la base de datos.");
					} else {
						funcionalidades.esperar(3);
						paneles.get(0).setVisible(false);
						paneles.get(8).setVisible(true);
					}
				} else {
					JOptionPane.showMessageDialog(null, "No hay conexión con la base de datos.");
				}
			}
		});

		JLabel lblNewLabelImagenBienvenida = new JLabel("");
		lblNewLabelImagenBienvenida.setIcon(new ImageIcon("src/ventana/cine-logo.png"));
		lblNewLabelImagenBienvenida.setBounds(244, 22, 540, 430);
		panel.add(lblNewLabelImagenBienvenida);

		JLabel lblNewLabelTextoBienvenida = new JLabel();
		lblNewLabelTextoBienvenida.setBounds(144, 316, 540, 430);
		lblNewLabelTextoBienvenida.setForeground(new Color(255, 255, 255));
		lblNewLabelTextoBienvenida.setText(textoBienvenida);
		panel.add(lblNewLabelTextoBienvenida);

		JButton btnNewButtonBienvenidaRegistro = new JButton("Registrarse");
		btnNewButtonBienvenidaRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (funcionalidades.comprobarActivacionBBDD()) {
					paneles.get(0).setVisible(false);
					paneles.get(6).setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "No hay conexión con la base de datos.");
				}
			}
		});
		btnNewButtonBienvenidaRegistro.setBounds(735, 516, 141, 42);
		panel.add(btnNewButtonBienvenidaRegistro);

		panel.setLayout(null);
	}

	public JPanel getPanel() {
		return panel;
	}
}//.