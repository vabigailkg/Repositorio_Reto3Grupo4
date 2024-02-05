package vista;



import java.awt.EventQueue;

import java.util.ArrayList;



import javax.swing.JFrame;

import javax.swing.JPanel;



import vista.paneles.PanelBienvenida;

import vista.paneles.PanelConfirmacion;

import vista.paneles.PanelExitoAlGuardar;

import vista.paneles.PanelGuardarTicket;

import vista.paneles.PanelImagenDePelicula;

import vista.paneles.PanelLoginUsuario;

import vista.paneles.PanelRegistrarUsuario;

import vista.paneles.PanelResumenCompra;

import vista.paneles.PanelSeleccionCine;

import vista.paneles.PanelSeleccionPelicula;

import vista.paneles.PanelSeleccionSesion;



public class Ventana {



	private JFrame frame;

	private ArrayList <JPanel> paneles = null;



	/**

	 * Launch the application.

	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					new Ventana().frame.setVisible(true);

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

		});

	}



	/**

	 * Create the frame.

	 */

	public Ventana() {

		inicializar();

	}

	

	private void inicializar() {

		frame = new JFrame();

		frame.setBounds(100, 100, 1000, 650);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().setLayout(null);

		

		paneles = new ArrayList <JPanel> ();

		

		PanelBienvenida panelBienvenida = new PanelBienvenida(paneles);

		JPanel panel1 = panelBienvenida.getPanel();

		panel1.setVisible(true);

		

		paneles.add(panel1);

		frame.getContentPane().add(panel1);

		

		PanelConfirmacion panelConfirmacion = new PanelConfirmacion(paneles);

		JPanel panel2 = panelConfirmacion.getPanel();

		panel2.setVisible(true);

		

		paneles.add(panel2);

		frame.getContentPane().add(panel2);

		

		PanelExitoAlGuardar panelExitoAlGuardar = new PanelExitoAlGuardar(paneles);

		JPanel panel3 = panelExitoAlGuardar.getPanel();

		panel3.setVisible(true);

		

		paneles.add(panel3);

		frame.getContentPane().add(panel3);

		

		PanelGuardarTicket panelGuardarTicket = new PanelGuardarTicket(paneles);

		JPanel panel4 = panelGuardarTicket.getPanel();

		panel4.setVisible(true);

		

		paneles.add(panel4);

		frame.getContentPane().add(panel4);

		

		PanelImagenDePelicula panelImagenDePelicula = new PanelImagenDePelicula(paneles);

		JPanel panel5 = panelImagenDePelicula.getPanel();

		panel5.setVisible(true);

		

		paneles.add(panel5);

		frame.getContentPane().add(panel5);

		

		PanelLoginUsuario panelLoginUsuario = new PanelLoginUsuario(paneles);

		JPanel panel6 = panelLoginUsuario.getPanel();

		panel6.setVisible(true);

		

		paneles.add(panel6);

		frame.getContentPane().add(panel6);

		

		PanelRegistrarUsuario panelRegistrarUsuario = new PanelRegistrarUsuario(paneles);

		JPanel panel7 = panelRegistrarUsuario.getPanel();

		panel7.setVisible(true);

		

		paneles.add(panel7);

		frame.getContentPane().add(panel7);

		

		PanelResumenCompra panelResumenCompra = new PanelResumenCompra(paneles);

		JPanel panel8 = panelResumenCompra.getPanel();

		panel8.setVisible(true);

		

		paneles.add(panel8);

		frame.getContentPane().add(panel8);

		

		PanelSeleccionCine panelSeleccionCine = new PanelSeleccionCine(paneles);

		JPanel panel9 = panelSeleccionCine.getPanel();

		panel9.setVisible(true);

		

		paneles.add(panel9);

		frame.getContentPane().add(panel9);

		

		PanelSeleccionPelicula panelSeleccionPelicula = new PanelSeleccionPelicula(paneles);

		JPanel panel10 = panelSeleccionPelicula.getPanel();

		panel10.setVisible(true);

		

		paneles.add(panel10);

		frame.getContentPane().add(panel10);

		

		PanelSeleccionSesion panelSeleccionSesion = new PanelSeleccionSesion(paneles);

		JPanel panel11 = panelSeleccionSesion.getPanel();

		panel11.setVisible(true);

		

		paneles.add(panel11);

		frame.getContentPane().add(panel11);

	}



}
