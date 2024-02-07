package ventana.paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelBienvenida {

	private JPanel panel = null;

	public PanelBienvenida(ArrayList<JPanel> paneles) {

		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		JLabel lblNewLabelImagenBienvenida = new JLabel("");
		lblNewLabelImagenBienvenida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				paneles.get(0).setVisible(false);
				paneles.get(8).setVisible(true);
			}
		});
		lblNewLabelImagenBienvenida.setIcon(new ImageIcon("src/ventana/cine-logo.png"));
		lblNewLabelImagenBienvenida.setBounds(0, 0, 943, 323);
		panel.add(lblNewLabelImagenBienvenida);

		JLabel lblNewLabelTextoBienvenida = new JLabel("TextoBienvenida");
		lblNewLabelTextoBienvenida.setBounds(144, 316, 346, 119);
		panel.add(lblNewLabelTextoBienvenida);

		JButton btnNewButtonBienvenidaRegistro = new JButton("Registrarse");
		btnNewButtonBienvenidaRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(0).setVisible(false);
				paneles.get(6).setVisible(true);
			}
		});
		btnNewButtonBienvenidaRegistro.setBounds(597, 338, 141, 42);
		panel.add(btnNewButtonBienvenidaRegistro);

		panel.setLayout(null);
	}

	public JPanel getPanel() {
		return panel;
	}
}