package ventana.paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bbdd.gestores.GestorUsuarios;
import logica.Funcionalidades;

public class PanelRegistrarUsuario {

	private JPanel panel = null;
	private JTextField textFieldDNI = null;
	private JPasswordField textFieldPassword = null;
	private JTextField textFieldNombre = null;
	private JTextField textFieldApellidos = null;
	private JTextField textFieldLetra = null;
	private Color color = new Color(46, 46, 46);

	public PanelRegistrarUsuario(ArrayList<JPanel> paneles) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(color);

		panel.setLayout(null);

		JLabel lblNewLabelNuevoUsuario = new JLabel("Nuevo Usuario");
		lblNewLabelNuevoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabelNuevoUsuario.setBounds(430, 168, 169, 29);
		lblNewLabelNuevoUsuario.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabelNuevoUsuario);

		JLabel lblNewLabelLogo = new JLabel("");
		lblNewLabelLogo.setIcon(new ImageIcon("src/ventana/Logo.png"));
		lblNewLabelLogo.setBounds(781, 21, 195, 195);
		panel.add(lblNewLabelLogo);

		JLabel lblUsuario = new JLabel("DNI:");
		lblUsuario.setBounds(338, 246, 60, 14);
		lblUsuario.setForeground(new Color(255, 255, 255));
		panel.add(lblUsuario);

		JLabel lblLetra = new JLabel("Letra:");
		lblLetra.setBounds(550, 246, 60, 14);
		lblLetra.setForeground(new Color(255, 255, 255));
		panel.add(lblLetra);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(338, 280, 60, 14);
		lblPassword.setForeground(new Color(255, 255, 255));
		panel.add(lblPassword);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(338, 318, 60, 14);
		lblNombre.setForeground(new Color(255, 255, 255));
		panel.add(lblNombre);

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(338, 352, 60, 14);
		lblApellidos.setForeground(new Color(255, 255, 255));
		panel.add(lblApellidos);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(338, 385, 60, 14);
		lblSexo.setForeground(new Color(255, 255, 255));
		panel.add(lblSexo);

		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(430, 243, 86, 20);
		panel.add(textFieldDNI);
		textFieldDNI.setColumns(10);

		textFieldLetra = new JTextField();
		textFieldLetra.setBounds(620, 243, 86, 20);
		panel.add(textFieldLetra);
		textFieldLetra.setColumns(10);

		textFieldPassword = new JPasswordField();
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

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Masculino", "Femenino" }));
		comboBox.setBounds(430, 385, 86, 20);
		panel.add(comboBox);

		JButton btnNewButtonCancelar = new JButton("Cancelar");
		btnNewButtonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(6).setVisible(false);
				paneles.get(0).setVisible(true);
			}
		});
		btnNewButtonCancelar.setBounds(238, 443, 169, 64);
		panel.add(btnNewButtonCancelar);

		JButton btnNewButtonContinuar = new JButton("Continuar");
		btnNewButtonContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionalidades funcionalidades = new Funcionalidades();
				GestorUsuarios gestorUsuarios = new GestorUsuarios();
				if (textFieldNombre.getText().isEmpty() || textFieldApellidos.getText().isEmpty()
						|| textFieldDNI.getText().isEmpty()
						|| String.valueOf(textFieldPassword.getPassword()).length() == 0
						|| textFieldLetra.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
				} else if (textFieldDNI.getText().trim().length() != 8) {
					JOptionPane.showMessageDialog(null, "El DNI no es correcto");
				} else if (!funcionalidades.comprobarEsNumerico(textFieldDNI.getText().trim())) {
					JOptionPane.showMessageDialog(null, "El DNI debe ser numerico");
				} else if (!funcionalidades.comprobarLetraDNI(textFieldDNI.getText().trim(),
						textFieldLetra.getText().trim())) {
					JOptionPane.showMessageDialog(null, "La letra no corresponde con el DNI");
				} else if (String.valueOf(textFieldPassword.getPassword()).length() > 7) {
					JOptionPane.showMessageDialog(null, "La contrasenna es demasiado larga, maximo 7 caracteres");
				} else if (textFieldNombre.getText().trim().length() > 40) {
					JOptionPane.showMessageDialog(null, "El nombre es demasiado largo, maximo 40 caracteres");
				} else if (textFieldApellidos.getText().trim().length() > 40) {
					JOptionPane.showMessageDialog(null, "Los apellidos son demasiado largos, maximo 40 caracteres");
				} else if (gestorUsuarios
						.comprobarSiExisteUsuario(textFieldDNI.getText().trim() + textFieldLetra.getText().trim())) {
					JOptionPane.showMessageDialog(null, "El usuario ya existe");
				} else {
					gestorUsuarios.registrarNuevoUsuario(
							textFieldDNI.getText().trim() + textFieldLetra.getText().trim().toUpperCase(),
							String.valueOf(textFieldPassword.getPassword()), textFieldNombre.getText().trim(),
							textFieldApellidos.getText().trim(),
							String.valueOf(comboBox.getSelectedItem()).substring(0, 1));

					textFieldNombre.setText(null);
					textFieldApellidos.setText(null);
					textFieldDNI.setText(null);
					textFieldPassword.setText(null);
					textFieldLetra.setText(null);

					paneles.get(6).setVisible(false);
					paneles.get(0).setVisible(true);
				}
			}
		});

		JButton btnNewButtonVolver = new JButton("Volver");
		btnNewButtonVolver.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				paneles.get(6).setVisible(false);
				paneles.get(5).setVisible(true);
			}

		});
		btnNewButtonVolver.setBounds(10, 10, 85, 21);
		panel.add(btnNewButtonVolver);

		btnNewButtonContinuar.setBounds(507, 443, 169, 64);
		panel.add(btnNewButtonContinuar);
	}

	public JPanel getPanel() {
		return panel;
	}
}
