package ventana.paneles;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bbdd.gestores.GestorSesiones;
import bbdd.pojos.Entrada;
import logica.Funcionalidades;

public class PanelSeleccionSesion {

	private JPanel panel = null;
	private JTable tableInformacionSesionesPelicula = null;
	private Color color = new Color(46, 46, 46);
	private DefaultTableModel tableModelSesiones = null;
	private ArrayList<Entrada> sesiones = null;

	public PanelSeleccionSesion(ArrayList<JPanel> paneles) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(color);

		panel.setLayout(null);

		JLabel lblNewLabelLogo = new JLabel("");
		lblNewLabelLogo.setIcon(new ImageIcon("src/ventana/Logo.png"));
		lblNewLabelLogo.setBounds(781, 21, 195, 195);
		panel.add(lblNewLabelLogo);

		JLabel lblNewLabelPeliculaSeleccionada = new JLabel("Pelicula Seleccionada");
		lblNewLabelPeliculaSeleccionada.setBounds(414, 51, 130, 14);
		lblNewLabelPeliculaSeleccionada.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabelPeliculaSeleccionada);

		JLabel lblNewLabelEligeElDia = new JLabel("Elige el dia");
		lblNewLabelEligeElDia.setBounds(435, 109, 63, 14);
		lblNewLabelEligeElDia.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabelEligeElDia);

		JComboBox<String> comboBoxSeleccionDia = new JComboBox<String>();
		comboBoxSeleccionDia.setBounds(414, 134, 113, 22);
		panel.add(comboBoxSeleccionDia);

		tableInformacionSesionesPelicula = new JTable();
		tableInformacionSesionesPelicula.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableInformacionSesionesPelicula.rowAtPoint(e.getPoint());
				if (row > 0 && sesiones.size() >= row) {
					ventana.VentanaMain.entradaSeleccionada = sesiones.get(row - 1);
					paneles.get(10).setVisible(false);
					paneles.get(1).setVisible(true);
				}
			}
		});
		tableInformacionSesionesPelicula.setBounds(331, 178, 293, 309);
		panel.add(tableInformacionSesionesPelicula);

		JButton btnNewButtonSeleccionCine_Finalizar = new JButton("Cancelar y finalizar");
		btnNewButtonSeleccionCine_Finalizar.setBounds(730, 543, 194, 57);
		btnNewButtonSeleccionCine_Finalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(10).setVisible(false);
				paneles.get(0).setVisible(true);
				Funcionalidades funcionalidades = new Funcionalidades();
				funcionalidades.borrarDatos();
			}
		});
		panel.add(btnNewButtonSeleccionCine_Finalizar);

		JButton btnNewButtonVolver = new JButton("Volver");
		btnNewButtonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(10).setVisible(false);
				paneles.get(9).setVisible(true);
			}
		});
		btnNewButtonVolver.setBounds(10, 10, 85, 21);
		panel.add(btnNewButtonVolver);

		panel.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				comboBoxSeleccionDia.removeAllItems();
				Funcionalidades funcionalidades = new Funcionalidades();
				funcionalidades.llenarComboFechas(ventana.VentanaMain.cineSeleccionado,
						ventana.VentanaMain.peliculaSeleccionada, comboBoxSeleccionDia);
				String fechaSeleccionada = String.valueOf(comboBoxSeleccionDia.getSelectedItem());
				GestorSesiones gestorSesiones = new GestorSesiones();
				sesiones = gestorSesiones.obtenerDatosDeSesiones(ventana.VentanaMain.peliculaSeleccionada,
						ventana.VentanaMain.cineSeleccionado, fechaSeleccionada);
				tableModelSesiones = funcionalidades.llenarTablaSesion(sesiones, paneles.get(10),
						tableInformacionSesionesPelicula);

				comboBoxSeleccionDia.addItemListener(new ItemListener() {
					@Override
					public void itemStateChanged(ItemEvent e) {
						if (e.getStateChange() == ItemEvent.SELECTED) {
							String fechaSeleccionada = String.valueOf(comboBoxSeleccionDia.getSelectedItem());
							GestorSesiones gestorSesiones = new GestorSesiones();
							ArrayList<Entrada> sesiones = gestorSesiones.obtenerDatosDeSesiones(
									ventana.VentanaMain.peliculaSeleccionada, ventana.VentanaMain.cineSeleccionado,
									fechaSeleccionada);
							tableModelSesiones = funcionalidades.llenarTablaSesion(sesiones, paneles.get(10),
									tableInformacionSesionesPelicula);
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
