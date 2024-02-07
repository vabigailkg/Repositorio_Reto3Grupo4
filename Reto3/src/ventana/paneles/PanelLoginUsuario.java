package vista.paneles;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PanelLoginUsuario {
	
	private JPanel panel = null;
	private JTextField textFieldUsuario = null;
	private JTextField textFieldPassword = null;

	public PanelLoginUsuario(ArrayList<JPanel> paneles) {
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inicia sesion");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(427, 175, 117, 33);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabelUsuario = new JLabel("Usuario:");
		lblNewLabelUsuario.setBounds(377, 269, 74, 14);
		panel.add(lblNewLabelUsuario);
		
		JLabel lblNewLabelPassword = new JLabel("Password:");
		lblNewLabelPassword.setBounds(377, 342, 74, 14);
		panel.add(lblNewLabelPassword);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(471, 266, 137, 20);
		panel.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(471, 339, 137, 20);
		panel.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JButton btnNewButtonIniciarSesion = new JButton("Iniciar Sesion");
		btnNewButtonIniciarSesion.setBounds(492, 528, 194, 57);
		panel.add(btnNewButtonIniciarSesion);
		
		JButton btnNewButtonRegistrarse = new JButton("Registrarse");
		btnNewButtonRegistrarse.setBounds(241, 528, 194, 57);
		panel.add(btnNewButtonRegistrarse);
	}
	public JPanel getPanel() {
		return panel;
	}
}
