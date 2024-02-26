package ventana.paneles;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bbdd.gestores.GestorSesiones;
import logica.Funcionalidades;

public class PanelSeleccionPelicula {

	private JPanel panel = null;
	private Color color = new Color(46, 46, 46);
	private JTable tablaPeliculas = null;
	private DefaultTableModel tableModelPeliculas = null;

	public PanelSeleccionPelicula(ArrayList<JPanel> paneles) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(color);

		panel.setLayout(null);

		JLabel lblNewLabelLogo = new JLabel("");
		lblNewLabelLogo.setIcon(new ImageIcon("Reto3/src/ventana/Logo.png"));
		lblNewLabelLogo.setBounds(781, 21, 195, 195);
		panel.add(lblNewLabelLogo);

		tablaPeliculas = new JTable();
		tablaPeliculas.setBounds(350, 113, 250, 376);
		panel.add(tablaPeliculas);

		JLabel lblNewLabel = new JLabel("Lista de peliculas");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				paneles.get(9).setVisible(false);
				paneles.get(10).setVisible(true);
			}
		});
		lblNewLabel.setBounds(420, 80, 100, 14);
		panel.add(lblNewLabel);

		JButton btnNewButtonSeleccionCine_Finalizar = new JButton("Finalizar");
		btnNewButtonSeleccionCine_Finalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(9).setVisible(false);
				paneles.get(7).setVisible(true);
			}
		});
		btnNewButtonSeleccionCine_Finalizar.setBounds(730, 543, 194, 57);
		panel.add(btnNewButtonSeleccionCine_Finalizar);

		JButton btnNewButtonVolver = new JButton("Volver");
		btnNewButtonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(9).setVisible(false);
				paneles.get(8).setVisible(true);
			}
		});
		btnNewButtonVolver.setBounds(10, 10, 85, 21);
		panel.add(btnNewButtonVolver);

		panel.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				Funcionalidades funcionalidades = new Funcionalidades();
				tableModelPeliculas = funcionalidades.llenarTablaPeliculas(ventana.VentanaMain.cineSeleccionado,
						paneles.get(9), tablaPeliculas);

				tablaPeliculas.addMouseListener(new java.awt.event.MouseAdapter() {
					@Override
					public void mouseClicked(java.awt.event.MouseEvent evt) {
						int row = tablaPeliculas.rowAtPoint(evt.getPoint());
						if (row > 0) {
							ventana.VentanaMain.peliculaSeleccionada = tableModelPeliculas.getValueAt(row, 0)
									.toString();
							GestorSesiones gestorSesiones = new GestorSesiones();
							gestorSesiones.obtenerFechasDeSesiones(ventana.VentanaMain.peliculaSeleccionada,
									ventana.VentanaMain.cineSeleccionado);
							paneles.get(9).setVisible(false);
							paneles.get(10).setVisible(true);
						}
					}
				});
			}
		});
	}

	public JPanel getPanel() {
		return panel;
	}
}//.
