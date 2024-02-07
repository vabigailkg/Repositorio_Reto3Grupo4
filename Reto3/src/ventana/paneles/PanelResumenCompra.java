package vista.paneles;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PanelResumenCompra {
	
	private JPanel panel = null;
	private JTable tableTodaLaInformacion = null;
	private JTextField textFieldDescuento = null;
	private JTextField textFieldPrecioTotal = null;

	public PanelResumenCompra(ArrayList<JPanel> paneles) {
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		panel.setLayout(null);
		
		JLabel lblNewLabelSeleccion = new JLabel("Has seleccionado:");
		lblNewLabelSeleccion.setBounds(415, 111, 101, 14);
		panel.add(lblNewLabelSeleccion);
		
		tableTodaLaInformacion = new JTable();
		tableTodaLaInformacion.setBounds(286, 149, 338, 268);
		panel.add(tableTodaLaInformacion);
		
		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setBounds(295, 456, 101, 14);
		panel.add(lblDescuento);
		
		JLabel lblPrecioTotal = new JLabel("Precio total:");
		lblPrecioTotal.setBounds(540, 456, 101, 14);
		panel.add(lblPrecioTotal);
		
		textFieldDescuento = new JTextField();
		textFieldDescuento.setBounds(295, 481, 86, 20);
		panel.add(textFieldDescuento);
		textFieldDescuento.setColumns(10);
		
		textFieldPrecioTotal = new JTextField();
		textFieldPrecioTotal.setBounds(538, 481, 86, 20);
		panel.add(textFieldPrecioTotal);
		textFieldPrecioTotal.setColumns(10);
		
		JButton btnNewButtonAnular = new JButton("Anular compra");
		btnNewButtonAnular.setBounds(241, 528, 194, 57);
		panel.add(btnNewButtonAnular);
		
		JButton btnNewButtonPagar = new JButton("Pagar");
		btnNewButtonPagar.setBounds(492, 528, 194, 57);
		panel.add(btnNewButtonPagar);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(623, 149, 17, 268);
		panel.add(scrollBar);
	}
	public JPanel getPanel() {
		return panel;
	}
}
