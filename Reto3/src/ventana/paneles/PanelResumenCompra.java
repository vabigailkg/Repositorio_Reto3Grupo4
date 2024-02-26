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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bbdd.pojos.Entrada;
import logica.Funcionalidades;

public class PanelResumenCompra {

	private JPanel panel = null;
	private JTable tableTodaLaInformacion = null;
	private JTextField textFieldDescuento = null;
	private JTextField textFieldPrecioTotal = null;
	private Color color = new Color(46, 46, 46);
	DefaultTableModel tableModelEntradas = null;

	public PanelResumenCompra(ArrayList<JPanel> paneles) {
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

		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setBounds(295, 456, 101, 14);
		lblDescuento.setForeground(new Color(255, 255, 255));
		panel.add(lblDescuento);

		JLabel lblPrecioTotal = new JLabel("Precio total:");
		lblPrecioTotal.setBounds(540, 456, 101, 14);
		lblPrecioTotal.setForeground(new Color(255, 255, 255));
		panel.add(lblPrecioTotal);

		textFieldDescuento = new JTextField();
		textFieldDescuento.setBounds(295, 481, 86, 20);
		panel.add(textFieldDescuento);
		textFieldDescuento.setColumns(10);
		textFieldDescuento.setEditable(false);

		textFieldPrecioTotal = new JTextField();
		textFieldPrecioTotal.setBounds(538, 481, 86, 20);
		panel.add(textFieldPrecioTotal);
		textFieldPrecioTotal.setColumns(10);
		textFieldPrecioTotal.setEditable(false);

		JButton btnNewButtonAnular = new JButton("Anular compra");
		btnNewButtonAnular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(7).setVisible(false);
				paneles.get(0).setVisible(true);
				Funcionalidades funcionalidades = new Funcionalidades();
				funcionalidades.borrarDatos();
			}
		});
		btnNewButtonAnular.setBounds(241, 528, 194, 57);
		panel.add(btnNewButtonAnular);

		JButton btnNewButtonPagar = new JButton("Pagar");
		btnNewButtonPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(7).setVisible(false);
				paneles.get(5).setVisible(true);
			}
		});
		btnNewButtonPagar.setBounds(492, 528, 194, 57);
		panel.add(btnNewButtonPagar);

		JButton btnNewButtonVolver = new JButton("Volver");
		btnNewButtonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(7).setVisible(false);
				paneles.get(9).setVisible(true);
			}
		});
		btnNewButtonVolver.setBounds(10, 10, 85, 21);
		panel.add(btnNewButtonVolver);
		panel.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				if (null == ventana.VentanaMain.entradasSeleccionadas) {
					ventana.VentanaMain.entradasSeleccionadas = new ArrayList<Entrada>();
				}
				Funcionalidades funcionalidades = new Funcionalidades();
				tableModelEntradas = funcionalidades.llenarTablaEntradas(ventana.VentanaMain.entradasSeleccionadas,
						panel, tableTodaLaInformacion);
				int descuento = funcionalidades.calcularDescuento(ventana.VentanaMain.entradasSeleccionadas.size());
				double precioTotal = funcionalidades.calcularPrecioTotal(ventana.VentanaMain.entradasSeleccionadas,
						descuento);
				textFieldDescuento.setText(String.valueOf(descuento) + "%");
				textFieldPrecioTotal.setText(String.valueOf(precioTotal) + " euros");

			}
		});

	}

	public JPanel getPanel() {
		return panel;
	}
}
