package vista.paneles;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PanelRegistrarUsuario {

	private JPanel panel = null;
	private JTextField textFieldUsuario = null;
	private JTextField textFieldPassword = null;
	private JTextField textFieldNombre = null;
	private JTextField textFieldApellidos = null;
	
	public PanelRegistrarUsuario(ArrayList<JPanel> paneles) {
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		panel.setLayout(null);
		
		JLabel lblNewLabelNuevoUsuario = new JLabel("Nuevo Usuario");
		lblNewLabelNuevoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabelNuevoUsuario.setBounds(430, 168, 169, 29);
		panel.add(lblNewLabelNuevoUsuario);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(338, 246, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(338, 280, 63, 14);
		panel.add(lblPassword);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(338, 318, 46, 14);
		panel.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(338, 352, 46, 14);
		panel.add(lblApellidos);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(430, 243, 86, 20);
		panel.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(430, 277, 86, 20);
		panel.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(430, 315, 86, 20);
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setBounds(430, 349, 86, 20);
		panel.add(textFieldApellidos);
		textFieldApellidos.setColumns(10);
		
		JButton btnNewButtonCancelar = new JButton("Cancelar");
		btnNewButtonCancelar.setBounds(238, 443, 169, 64);
		panel.add(btnNewButtonCancelar);
		
		JButton btnNewButtonContinuar = new JButton("Continuar");
		btnNewButtonContinuar.setBounds(507, 443, 169, 64);
		panel.add(btnNewButtonContinuar);
	}
	
	public JPanel getPanel() {
		return panel;
	}
}
