package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bbdd.gestores.GestorFacturas;
import bbdd.gestores.GestorPeliculas;
import bbdd.gestores.GestorSesiones;
import bbdd.gestores.GestorUsuarios;
import bbdd.pojos.Cliente;
import bbdd.pojos.Entrada;
import bbdd.pojos.Pelicula;
import bbdd.utils.DBUtils;

/**
 * Gestiona los métodos y funciones necesarios en la aplicación.
 * 
 */
public class Funcionalidades {

	/**
	 * Resetea todos los valores del programa.
	 */
	public void borrarDatos() {
		ventana.VentanaMain.cineSeleccionado = 0;
		ventana.VentanaMain.peliculaSeleccionada = null;
		ventana.VentanaMain.entradaSeleccionada = null;
		ventana.VentanaMain.entradasSeleccionadas = null;
		ventana.VentanaMain.dniSeleccionado = null;
	}

	/**
	 * La aplicación espera antes de la siguiente acción.
	 * 
	 * @param segundos número de segundos a esperar.
	 */
	public void esperar(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException e) {
		}
	}

	/**
	 * Comprueba si la BBDD esta conectada
	 * 
	 * @return true si la BBDD esta conectada, false en caso contrario
	 */
	public boolean comprobarActivacionBBDD() {
		boolean ret = false;
		Connection connection = null;
		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			ret = true;

		} catch (SQLException e) {

		} catch (Exception e) {

		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;
		}
		return ret;
	}

	/**
	 * Comprueba si el contenido de un String es numerico
	 * 
	 * @param valor String del que queremos saber si su contenido es numerico
	 * @return true si el valor es numerico, false en caso contrario
	 */
	public boolean comprobarEsNumerico(String valor) {
		try {
			if (valor != null) {
				Long.parseLong(valor);
			}
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	/**
	 * Comprueba que la letra del DNI corresponde al numero del DNI
	 * 
	 * @param numeroString numero del DNI
	 * @param letra        letra asignada al numero del DNI
	 * @return true si la letra corresponde al DNI, false en caso contrario
	 */
	public boolean comprobarLetraDNI(String numeroString, String letra) {
		boolean ret = false;
		int numero = 0;
		String letraCalculada = null;
		numero = Integer.parseInt(numeroString);
		int resto = numero % 23;
		switch (resto) {
		case 0:
			letraCalculada = "T";
			break;
		case 1:
			letraCalculada = "R";
			break;
		case 2:
			letraCalculada = "W";
			break;
		case 3:
			letraCalculada = "A";
			break;
		case 4:
			letraCalculada = "G";
			break;
		case 5:
			letraCalculada = "M";
			break;
		case 6:
			letraCalculada = "Y";
			break;
		case 7:
			letraCalculada = "F";
			break;
		case 8:
			letraCalculada = "P";
			break;
		case 9:
			letraCalculada = "D";
			break;
		case 10:
			letraCalculada = "X";
			break;
		case 11:
			letraCalculada = "B";
			break;
		case 12:
			letraCalculada = "N";
			break;
		case 13:
			letraCalculada = "J";
			break;
		case 14:
			letraCalculada = "Z";
			break;
		case 15:
			letraCalculada = "S";
			break;
		case 16:
			letraCalculada = "Q";
			break;
		case 17:
			letraCalculada = "V";
			break;
		case 18:
			letraCalculada = "H";
			break;
		case 19:
			letraCalculada = "L";
			break;
		case 20:
			letraCalculada = "C";
			break;
		case 21:
			letraCalculada = "K";
			break;
		case 22:
			letraCalculada = "E";
			break;
		default:
			System.out.println("No deberia aparecer esta opcion");
		}
		if (letraCalculada.equals(letra.toUpperCase())) {
			ret = true;
		}
		return ret;
	}

	/**
	 * Llena la tabla del panel con las peliculas
	 * 
	 * @param numeroDeCine cine del que queremos saber las peliculas
	 * @param panel        panel en el que esta la tabla
	 * @param tabla        que queremos llenar
	 * @return tabla rellena
	 */
	public DefaultTableModel llenarTablaPeliculas(int numeroDeCine, JPanel panel, JTable tabla) {
		DefaultTableModel ret = null;
		GestorPeliculas gestorPeliculas = new GestorPeliculas();
		ArrayList<Pelicula> listaPeliculas = gestorPeliculas.obtenerPeliculasDeCine(numeroDeCine);
		String[] columnaDeLaTabla = { "Título de la película" };
		DefaultTableModel tableModel = new DefaultTableModel(columnaDeLaTabla, 0);
		tableModel.addRow(columnaDeLaTabla);
		for (Pelicula pelicula : listaPeliculas) {
			Object[] fila = { pelicula.getNombrePelicula() };
			tableModel.addRow(fila);
		}
		tabla.setModel(tableModel);
		tabla.repaint();
		ret = tableModel;
		return ret;
	}

	/**
	 * Llena el combobox con las fechas de emision de las peliculas
	 * 
	 * @param cineSeleccionado     cine del que queremos saber la emision de las
	 *                             peliculas
	 * @param peliculaSeleccionada pelicula de la que queremos saber los dias de
	 *                             emision
	 * @param comboFecha           combobox en el que queremos guardar la
	 *                             informacion
	 */
	public void llenarComboFechas(int cineSeleccionado, String peliculaSeleccionada, JComboBox<String> comboFecha) {
		GestorSesiones gestorSesiones = new GestorSesiones();
		ArrayList<String> fechas = gestorSesiones.obtenerFechasDeSesiones(peliculaSeleccionada, cineSeleccionado);
		for (String fecha : fechas) {
			comboFecha.addItem(fecha);
		}
	}

	public DefaultTableModel llenarTablaSesion(ArrayList<Entrada> sesiones, JPanel jPanel,
			JTable tableInformacionSesionesPelicula) {
		DefaultTableModel ret = null;
		if (null == sesiones) {
			return ret;
		}
		String[] columnasDeLaTabla = { "Título de la película", "Hora", "Precio", "Sala" };
		DefaultTableModel tableModel = new DefaultTableModel(columnasDeLaTabla, 0);
		tableModel.addRow(columnasDeLaTabla);
		for (Entrada sesion : sesiones) {
			Object[] fila = { sesion.getPelicula(), sesion.getHora(), sesion.getPrecio(), sesion.getSala() };
			tableModel.addRow(fila);
		}
		tableInformacionSesionesPelicula.setModel(tableModel);
		tableInformacionSesionesPelicula.repaint();
		ret = tableModel;
		return ret;
	}

	/**
	 * Llena la tabla de entradas
	 * 
	 * @param entradas                 entradas que queremos mostrar en la tabla
	 * @param jPanel                   panel en el que se encuentra la tabla
	 * @param tableInformacionEntradas tabla en la que queremos mostrar la
	 *                                 informacion
	 * @return tabla rellena
	 */
	public DefaultTableModel llenarTablaEntradas(ArrayList<Entrada> entradas, JPanel jPanel,
			JTable tableInformacionEntradas) {
		DefaultTableModel ret = null;
		if (null == entradas) {
			return ret;
		}
		String[] columnasDeLaTabla = { "Título de la película", "Cine", "Fecha", "Hora", "Precio", "Sala" };
		DefaultTableModel tableModel = new DefaultTableModel(columnasDeLaTabla, 0);
		tableModel.addRow(columnasDeLaTabla);
		for (Entrada entrada : entradas) {
			Object[] fila = { entrada.getPelicula(), entrada.getCine(), entrada.getFecha(), entrada.getHora(),
					entrada.getPrecio(), entrada.getSala() };
			tableModel.addRow(fila);
		}
		tableInformacionEntradas.setModel(tableModel);
		tableInformacionEntradas.repaint();
		ret = tableModel;
		return ret;
	}

	/**
	 * Obtiene el descuento aplicado
	 * 
	 * @param numeroDeEntradas numero de entradas compradas por el usuario en esta
	 *                         sesion
	 * @return int con el valor del porcentaje de descuento obtenido
	 */
	public int calcularDescuento(int numeroDeEntradas) {
		int ret = 0;
		switch (numeroDeEntradas) {
		case 0:
			ret = 0;
			break;
		case 1:
			ret = 0;
			break;
		case 2:
			ret = 20;
			break;
		case 3:
			ret = 30;
			break;
		case 4:
			ret = 40;
			break;
		case 5:
			ret = 50;
			break;
		default:
			ret = 50;
			break;
		}
		return ret;
	}

	/**
	 * Obtiene el precio que debe pagar el usuario
	 * 
	 * @param entradas  lista de entradas compradas por el usuario
	 * @param descuento descuento que ha obtenido el usuario
	 * @return total a pagar una vez aplicado el descuento
	 */
	public double calcularPrecioTotal(ArrayList<Entrada> entradas, int descuento) {
		double ret = 0;
		double precioTotal = 0;
		for (Entrada entrada : entradas) {
			precioTotal = precioTotal + entrada.getPrecio();
		}
		ret = Math.round(precioTotal * (100.0 - descuento)) / 100.0;
		return ret;
	}

	/**
	 * Llena la tabla de clientes
	 * 
	 * @param dniCliente   dni del Cliente
	 * @param panel        panel en el que se encuentra la tabla a completar
	 * @param tableCliente tabla que queremos completar
	 * @return tabla rellena
	 */
	public DefaultTableModel llenarTablaCliente(String dniCliente, JPanel panel, JTable tableCliente) {
		DefaultTableModel ret = null;
		GestorUsuarios gestorUsuarios = new GestorUsuarios();
		Cliente cliente = gestorUsuarios.obtenerDatosDeUsuarios(dniCliente);
		String[] columnaDeLaTabla = { "Dato del cliente" };
		DefaultTableModel tableModel = new DefaultTableModel(columnaDeLaTabla, 0);
		Object[] filaDni = { "DNI: " + cliente.getDniCliente() };
		tableModel.addRow(filaDni);
		Object[] filaNombre = { "Nombre: " + cliente.getNombreCliente() };
		tableModel.addRow(filaNombre);
		Object[] filaApellidos = { "Apellidos: " + cliente.getApellidosCliente() };
		tableModel.addRow(filaApellidos);
		Object[] filaSexo = { "Sexo: " + cliente.getSexoCliente() };
		tableModel.addRow(filaSexo);
		tableCliente.setModel(tableModel);
		tableCliente.repaint();
		ret = tableModel;
		return ret;
	}

	/**
	 * Guarda las entradas en la BBDD con la fecha y hora de la compra
	 * 
	 * @param entradas entradas que queremos guardar
	 */
	public void guardarEntradasEnBBDD(ArrayList<Entrada> entradas) {
		LocalDate fechaCompra = LocalDate.now();
		String fechaCompraString = fechaCompra.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalTime horaCompra = LocalTime.now();
		String horaCompraString = horaCompra.format(DateTimeFormatter.ofPattern("HH:mm"));

		GestorFacturas gestorFacturas = new GestorFacturas();
		for (Entrada entrada : entradas) {
			gestorFacturas.guardarNuevaEntrada(entrada, fechaCompraString, horaCompraString);
		}
	}
}
