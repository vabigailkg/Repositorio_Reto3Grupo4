package ventana.paneles;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bbdd.pojos.Entrada;
import logica.Funcionalidades;

public class PanelConfirmacion {

	private JPanel panel = null;
	private Color color = new Color(46, 46, 46);
	private JTable tableTodaLaInformacion = null;
	DefaultTableModel tableModelEntradas = null;

	public PanelConfirmacion(ArrayList<JPanel> paneles) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(color);

		panel.setLayout(null);

		JLabel lblNewLabelLogo = new JLabel("");
		lblNewLabelLogo.setIcon(new ImageIcon("src/ventana/Logo.png"));
		lblNewLabelLogo.setBounds(781, 21, 195, 195);
		panel.add(lblNewLabelLogo);

		JLabel lblNewLabelSeleccion = new JLabel("Has seleccionado:");
		lblNewLabelSeleccion.setBounds(415, 111, 120, 14);
		lblNewLabelSeleccion.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabelSeleccion);

		tableTodaLaInformacion = new JTable();
		tableTodaLaInformacion.setBounds(255, 149, 429, 268);
		panel.add(tableTodaLaInformacion);

		JButton btnNewButtonSeleccionCine_FinalizarPagar = new JButton("Finalizar y pagar");
		btnNewButtonSeleccionCine_FinalizarPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(1).setVisible(false);
				paneles.get(7).setVisible(true);
			}
		});
		btnNewButtonSeleccionCine_FinalizarPagar.setBounds(730, 543, 194, 57);
		panel.add(btnNewButtonSeleccionCine_FinalizarPagar);

		JButton btnNewButtonCancelarFinalizar = new JButton("Cancelar y finalizar");
		btnNewButtonCancelarFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(1).setVisible(false);
				paneles.get(0).setVisible(true);
				Funcionalidades funcionalidades = new Funcionalidades();
				funcionalidades.borrarDatos();
			}
		});
		btnNewButtonCancelarFinalizar.setBounds(50, 543, 194, 57);
		panel.add(btnNewButtonCancelarFinalizar);

		JButton btnNewButtonSeguirComprando = new JButton("Seguir comprando");
		btnNewButtonSeguirComprando.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(1).setVisible(false);
				paneles.get(8).setVisible(true);
			}
		});
		btnNewButtonSeguirComprando.setBounds(372, 543, 194, 57);
		panel.add(btnNewButtonSeguirComprando);

		JButton btnNewButtonVolver = new JButton("Volver");
		btnNewButtonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(1).setVisible(false);
				paneles.get(10).setVisible(true);
			}
		});
		btnNewButtonVolver.setBounds(10, 10, 85, 21);
		panel.add(btnNewButtonVolver);
		panel.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				if (null == ventana.VentanaMain.entradasSeleccionadas) {
					ventana.VentanaMain.entradasSeleccionadas = new ArrayList<Entrada>();
				}
				ventana.VentanaMain.entradasSeleccionadas.add(ventana.VentanaMain.entradaSeleccionada);
				Funcionalidades funcionalidades = new Funcionalidades();
				tableModelEntradas = funcionalidades.llenarTablaEntradas(ventana.VentanaMain.entradasSeleccionadas,
						panel, tableTodaLaInformacion);
			}
		});
	}

	public JPanel getPanel() {
		return panel;
	}
}
