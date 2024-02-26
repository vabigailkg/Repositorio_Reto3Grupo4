package ventana.paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bbdd.pojos.Entrada;
import logica.Funcionalidades;

public class PanelResumenFinal {

	private JPanel panel = null;
	private JTable tableEntradas = null;
	private JTable tableCliente = null;
	private Color color = new Color(46, 46, 46);
	DefaultTableModel tableModelEntradas = null;
	DefaultTableModel tableModelCliente = null;

	public PanelResumenFinal(ArrayList<JPanel> paneles) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(color);

		panel.setLayout(null);

		JLabel lblNewLabelLogo = new JLabel("");
		lblNewLabelLogo.setIcon(new ImageIcon("src/ventana/Logo.png"));
		lblNewLabelLogo.setBounds(781, 21, 195, 195);
		panel.add(lblNewLabelLogo);

		JLabel lblNewLabelTicket = new JLabel("Ticket");
		lblNewLabelTicket.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabelTicket.setForeground(new Color(255, 255, 255));
		lblNewLabelTicket.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelTicket.setBounds(416, 78, 125, 48);
		panel.add(lblNewLabelTicket);

		JLabel lblNewLabel = new JLabel("Datos de la compra:");
		lblNewLabel.setBounds(307, 150, 132, 14);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);

		tableEntradas = new JTable();
		tableEntradas.setBounds(40, 175, 429, 338);
		panel.add(tableEntradas);

		JLabel lblDatosDelCliente = new JLabel("Datos del cliente:");
		lblDatosDelCliente.setBounds(617, 150, 132, 14);
		lblDatosDelCliente.setForeground(new Color(255, 255, 255));
		panel.add(lblDatosDelCliente);

		tableCliente = new JTable();
		tableCliente.setBounds(580, 175, 169, 338);
		panel.add(tableCliente);

		JButton btnNewButtonSeleccionImagenDePelicula_Finalizar = new JButton("Finalizar");
		btnNewButtonSeleccionImagenDePelicula_Finalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Gracias por su compra");
				paneles.get(4).setVisible(false);
				paneles.get(0).setVisible(true);
				Funcionalidades funcionalidades = new Funcionalidades();
				funcionalidades.borrarDatos();
			}
		});
		btnNewButtonSeleccionImagenDePelicula_Finalizar.setBounds(730, 543, 194, 57);
		panel.add(btnNewButtonSeleccionImagenDePelicula_Finalizar);

		panel.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				if (null == ventana.VentanaMain.entradasSeleccionadas) {
					ventana.VentanaMain.entradasSeleccionadas = new ArrayList<Entrada>();
				}
				Funcionalidades funcionalidades = new Funcionalidades();
				tableModelEntradas = funcionalidades.llenarTablaEntradas(ventana.VentanaMain.entradasSeleccionadas,
						panel, tableEntradas);
				tableModelCliente = funcionalidades.llenarTablaCliente(ventana.VentanaMain.dniSeleccionado, panel,
						tableCliente);
			}
		});
	}

	public JPanel getPanel() {
		return panel;
	}

}
