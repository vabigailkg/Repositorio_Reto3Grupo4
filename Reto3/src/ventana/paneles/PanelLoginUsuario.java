package ventana.paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bbdd.gestores.GestorUsuarios;
import bbdd.pojos.Entrada;

public class PanelLoginUsuario {

	private JPanel panel = null;
	private JTextField textFieldUsuario = null;
	private JPasswordField textFieldPassword = null;
	private Color color = new Color(46, 46, 46);

	public PanelLoginUsuario(ArrayList<JPanel> paneles) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(color);

		panel.setLayout(null);

		JLabel lblNewLabelLogo = new JLabel("");
		lblNewLabelLogo.setIcon(new ImageIcon("src/ventana/Logo.png"));
		lblNewLabelLogo.setBounds(781, 21, 195, 195);
		panel.add(lblNewLabelLogo);

		JLabel lblNewLabel = new JLabel("Inicia sesion");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(427, 175, 117, 33);
		panel.add(lblNewLabel);

		JLabel lblNewLabelUsuario = new JLabel("DNI:");
		lblNewLabelUsuario.setBounds(377, 269, 74, 14);
		lblNewLabelUsuario.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabelUsuario);

		JLabel lblNewLabelPassword = new JLabel("Password:");
		lblNewLabelPassword.setBounds(377, 342, 74, 14);
		lblNewLabelPassword.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabelPassword);

		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(471, 266, 137, 20);
		panel.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);

		textFieldPassword = new JPasswordField();
		textFieldPassword.setBounds(471, 339, 137, 20);
		panel.add(textFieldPassword);
		textFieldPassword.setColumns(10);

		JButton btnNewButtonIniciarSesion = new JButton("Iniciar Sesion");
		btnNewButtonIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestorUsuarios gestorUsuarios = new GestorUsuarios();
				if (textFieldUsuario.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Error, DNI incompleto");
				} else if (gestorUsuarios.comprobarInicioSesion(textFieldUsuario.getText().trim(),
						String.valueOf(textFieldPassword.getPassword()).trim())) {
					ventana.VentanaMain.dniSeleccionado = textFieldUsuario.getText();
					if (null != ventana.VentanaMain.entradasSeleccionadas) {
						for (Entrada entrada : ventana.VentanaMain.entradasSeleccionadas) {
							entrada.setDniCliente(ventana.VentanaMain.dniSeleccionado);
						}
					}
					paneles.get(5).setVisible(false);
					paneles.get(3).setVisible(true);
					textFieldPassword.setText(null);
					textFieldUsuario.setText(null);
				} else {
					JOptionPane.showMessageDialog(null, "Error, contrasenna incorrecta");
				}
			}
		});
		btnNewButtonIniciarSesion.setBounds(492, 528, 194, 57);
		panel.add(btnNewButtonIniciarSesion);

		JButton btnNewButtonVolver = new JButton("Volver");
		btnNewButtonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(5).setVisible(false);
				paneles.get(7).setVisible(true);
				textFieldPassword.setText(null);
				textFieldUsuario.setText(null);
			}
		});
		btnNewButtonVolver.setBounds(10, 10, 85, 21);
		panel.add(btnNewButtonVolver);

		JButton btnNewButtonRegistrarse = new JButton("Registrarse");
		btnNewButtonRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(5).setVisible(false);
				paneles.get(6).setVisible(true);
				textFieldPassword.setText(null);
				textFieldUsuario.setText(null);
			}
		});
		btnNewButtonRegistrarse.setBounds(241, 528, 194, 57);
		panel.add(btnNewButtonRegistrarse);
	}

	public JPanel getPanel() {
		return panel;
	}
}
