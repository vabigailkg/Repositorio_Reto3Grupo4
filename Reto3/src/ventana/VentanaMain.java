package ventana;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import bbdd.pojos.Entrada;
import ventana.paneles.PanelBienvenida;
import ventana.paneles.PanelConfirmacion;
import ventana.paneles.PanelExitoAlGuardar;
import ventana.paneles.PanelGuardarTicket;
import ventana.paneles.PanelResumenFinal;
import ventana.paneles.PanelLoginUsuario;
import ventana.paneles.PanelRegistrarUsuario;
import ventana.paneles.PanelResumenCompra;
import ventana.paneles.PanelSeleccionCine;
import ventana.paneles.PanelSeleccionPelicula;
import ventana.paneles.PanelSeleccionSesion;

public class VentanaMain {
	public static int cineSeleccionado = 0;
	public static String peliculaSeleccionada = null;
	public static Entrada entradaSeleccionada = null;
	public static ArrayList<Entrada> entradasSeleccionadas = null;
	public static String dniSeleccionado = null;
	private JFrame frame;
	private ArrayList<JPanel> paneles = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new VentanaMain().frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaMain() {
		inicializar();
	}

	public void inicializar() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		paneles = new ArrayList<JPanel>();

		PanelBienvenida panelBienvenida = new PanelBienvenida(paneles);
		JPanel panel1 = panelBienvenida.getPanel();
		panel1.setVisible(true);

		paneles.add(panel1);
		frame.getContentPane().add(panel1);

		PanelConfirmacion panelConfirmacion = new PanelConfirmacion(paneles);
		JPanel panel2 = panelConfirmacion.getPanel();
		panel2.setVisible(false);

		paneles.add(panel2);
		frame.getContentPane().add(panel2);

		PanelExitoAlGuardar panelExitoAlGuardar = new PanelExitoAlGuardar(paneles);
		JPanel panel3 = panelExitoAlGuardar.getPanel();
		panel3.setVisible(false);

		paneles.add(panel3);
		frame.getContentPane().add(panel3);

		PanelGuardarTicket panelGuardarTicket = new PanelGuardarTicket(paneles);
		JPanel panel4 = panelGuardarTicket.getPanel();
		panel4.setVisible(false);

		paneles.add(panel4);
		frame.getContentPane().add(panel4);

		PanelResumenFinal panelResumenFinal = new PanelResumenFinal(paneles);
		JPanel panel5 = panelResumenFinal.getPanel();
		panel5.setVisible(false);

		paneles.add(panel5);
		frame.getContentPane().add(panel5);

		PanelLoginUsuario panelLoginUsuario = new PanelLoginUsuario(paneles);
		JPanel panel6 = panelLoginUsuario.getPanel();
		panel6.setVisible(false);

		paneles.add(panel6);
		frame.getContentPane().add(panel6);

		PanelRegistrarUsuario panelRegistrarUsuario = new PanelRegistrarUsuario(paneles);
		JPanel panel7 = panelRegistrarUsuario.getPanel();
		panel7.setVisible(false);

		paneles.add(panel7);
		frame.getContentPane().add(panel7);

		PanelResumenCompra panelResumenCompra = new PanelResumenCompra(paneles);
		JPanel panel8 = panelResumenCompra.getPanel();
		panel8.setVisible(false);

		paneles.add(panel8);
		frame.getContentPane().add(panel8);

		PanelSeleccionCine panelSeleccionCine = new PanelSeleccionCine(paneles);
		JPanel panel9 = panelSeleccionCine.getPanel();
		panel9.setVisible(false);

		paneles.add(panel9);
		frame.getContentPane().add(panel9);

		PanelSeleccionPelicula panelSeleccionPelicula = new PanelSeleccionPelicula(paneles);
		JPanel panel10 = panelSeleccionPelicula.getPanel();
		panel10.setVisible(false);

		paneles.add(panel10);
		frame.getContentPane().add(panel10);

		PanelSeleccionSesion panelSeleccionSesion = new PanelSeleccionSesion(paneles);
		JPanel panel11 = panelSeleccionSesion.getPanel();
		panel11.setVisible(false);

		paneles.add(panel11);
		frame.getContentPane().add(panel11);
	}
}//.
