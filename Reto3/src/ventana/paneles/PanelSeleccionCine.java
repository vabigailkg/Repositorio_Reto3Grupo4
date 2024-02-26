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

import bbdd.gestores.GestorPeliculas;

public class PanelSeleccionCine {

	private JPanel panel = null;
	private Color color = new Color(46, 46, 46);

	public PanelSeleccionCine(ArrayList<JPanel> paneles) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(color);

		panel.setLayout(null);
		
		GestorPeliculas gestorPeliculas = new GestorPeliculas();

		JLabel lblNewLabelLogo = new JLabel("");
		lblNewLabelLogo.setIcon(new ImageIcon("src/ventana/Logo.png"));
		lblNewLabelLogo.setBounds(781, 21, 195, 195);
		panel.add(lblNewLabelLogo);

		JLabel lblNewLabelCine2Texto = new JLabel("Elorrieta-San-Mames");
		lblNewLabelCine2Texto.setBounds(450, 220, 150, 14);
		lblNewLabelCine2Texto.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabelCine2Texto);

		JLabel lblNewLabelCine1Texto = new JLabel("Elorrieta-Elorrieta");
		lblNewLabelCine1Texto.setBounds(200, 220, 150, 14);
		lblNewLabelCine1Texto.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabelCine1Texto);

		JLabel lblNewLabelCine3Texto = new JLabel("Elorrieta-Casco-Viejo");
		lblNewLabelCine3Texto.setBounds(700, 220, 150, 14);
		lblNewLabelCine3Texto.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabelCine3Texto);

		JButton btnNewButtonSeleccionCine_Finalizar = new JButton("Cancelar y finalizar");
		btnNewButtonSeleccionCine_Finalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(8).setVisible(false);
				paneles.get(0).setVisible(true);
			}
		});
		btnNewButtonSeleccionCine_Finalizar.setBounds(730, 543, 194, 57);
		panel.add(btnNewButtonSeleccionCine_Finalizar);

		JLabel lblNewLabelCine1Imagen = new JLabel("");
		lblNewLabelCine1Imagen.setIcon(new ImageIcon("src/ventana/cine1modificado.jpg"));
		lblNewLabelCine1Imagen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (null == gestorPeliculas.obtenerPeliculasDeCine(1)) {
					JOptionPane.showMessageDialog(null, "No hay peliculas disponibles en este cine.");
				} else {				
				ventana.VentanaMain.cineSeleccionado = 1;
				paneles.get(8).setVisible(false);
				paneles.get(9).setVisible(true);
				}
			}
		});
		lblNewLabelCine1Imagen.setBounds(136, 240, 200, 112);
		panel.add(lblNewLabelCine1Imagen);

		JLabel lblNewLabelCine2Imagen = new JLabel("");
		lblNewLabelCine2Imagen.setIcon(new ImageIcon("src/ventana/cine2modificado.jpg"));
		lblNewLabelCine2Imagen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (null == gestorPeliculas.obtenerPeliculasDeCine(2)) {
					JOptionPane.showMessageDialog(null, "No hay peliculas disponibles en este cine.");
				} else {
				ventana.VentanaMain.cineSeleccionado = 2;
				paneles.get(8).setVisible(false);
				paneles.get(9).setVisible(true);
				}
			}
		});
		lblNewLabelCine2Imagen.setBounds(394, 240, 200, 112);
		panel.add(lblNewLabelCine2Imagen);

		JLabel lblNewLabelCine3Imagen = new JLabel("");
		lblNewLabelCine3Imagen.setIcon(new ImageIcon("src/ventana/cine3modificado.jpg"));
		lblNewLabelCine3Imagen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (null == gestorPeliculas.obtenerPeliculasDeCine(3)) {
					JOptionPane.showMessageDialog(null, "No hay peliculas disponibles en este cine.");
				} else {
				ventana.VentanaMain.cineSeleccionado = 3;
				paneles.get(8).setVisible(false);
				paneles.get(9).setVisible(true);
				}
			}
		});
		lblNewLabelCine3Imagen.setBounds(645, 240, 200, 112);
		panel.add(lblNewLabelCine3Imagen);

	}

	public JPanel getPanel() {
		return panel;
	}
}//.
