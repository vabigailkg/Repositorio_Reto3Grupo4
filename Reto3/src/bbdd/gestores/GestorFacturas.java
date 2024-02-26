package bbdd.gestores;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import bbdd.pojos.Cliente;
import bbdd.pojos.Entrada;
import bbdd.utils.DBUtils;
import logica.Funcionalidades;

/**
 * Gestiona la emisión de facturas de cada cliente.
 */
public class GestorFacturas {
	private static final String NOMBRE_FICHERO = "entrada";
	private static final String RUTA_FICHERO = ".\\src\\Files\\";

	/**
	 * Crea un fichero de texto con la informacion de las entradas compradas en una
	 * compra de un usuario.
	 * 
	 * @param entradas lista de todas las entradas compradas por un usuario en una
	 *                 sesion
	 */
	public void crearTicket(ArrayList<Entrada> entradas) {
		String dniCliente = null;
		Funcionalidades funcionalidades = new Funcionalidades();
		int precioTotal = 0;
		LocalDate fechaTicket = LocalDate.now();
		String fechaTicketString = fechaTicket.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalTime horaTicket = LocalTime.now();
		String horaTicketString = horaTicket.format(DateTimeFormatter.ofPattern("HHmmss"));
		File ticket = new File(RUTA_FICHERO + NOMBRE_FICHERO + fechaTicketString + horaTicketString + ".txt");

		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		try {
			fileWriter = new FileWriter(ticket);
			printWriter = new PrintWriter(fileWriter);
			for (Entrada entrada : entradas) {
				if (null == dniCliente) {
					dniCliente = entrada.getDniCliente();
				}
				printWriter.println("Cine: " + entrada.getCine());
				printWriter.println("Sala: " + entrada.getSala());
				printWriter.println("Película: " + entrada.getPelicula());
				printWriter.println("Fecha: " + entrada.getFecha());
				printWriter.println("Hora: " + entrada.getHora());
				printWriter.println("Precio: " + entrada.getPrecio() + " euros");
				printWriter.println("-------------------------------------");
				precioTotal = precioTotal + entrada.getPrecio();
			}
			int descuento = funcionalidades.calcularDescuento(entradas.size());
			double precioConDescuento = funcionalidades.calcularPrecioTotal(entradas, descuento);
			printWriter.println("Precio Total: " + String.valueOf(precioTotal) + " euros");
			printWriter.println("Descuento: " + String.valueOf(descuento) + "%");
			printWriter.println("Precio con Descuento: " + String.valueOf(precioConDescuento) + " euros");
			printWriter.println("-------------------------------------");
			printWriter.println("DNI Cliente: " + dniCliente);

			GestorUsuarios gestorUsuarios = new GestorUsuarios();
			Cliente cliente = gestorUsuarios.obtenerDatosDeUsuarios(dniCliente);
			printWriter.println("Nombre: " + cliente.getNombreCliente());
			printWriter.println("Apellidos: " + cliente.getApellidosCliente());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"Error de escritura en el archivo de ticket");
			e.printStackTrace();
		} finally {
			try {
				if (printWriter != null) {
					printWriter.flush();
					printWriter.close();
				}
				if (fileWriter != null)
					fileWriter.close();
			} catch (IOException e) {

			}
		}
	}

	/**
	 * Trae el listado de entradas de la base de datos.
	 * 
	 * @return Array con listado de entradas.
	 */
	public ArrayList<Entrada> obtenerListaDeEntradas() {
		ArrayList<Entrada> ret = null;

		String sql = "select * from entrada";

		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				if (null == ret)
					ret = new ArrayList<Entrada>();

				Entrada entrada = new Entrada(0, null, null, null, null, null, null, 0, null);

				int codEntrada = resultSet.getInt("codEntrada");
				String cine = resultSet.getString("cine");
				String sala = resultSet.getString("sala");
				String genero = resultSet.getString("genero");
				String pelicula = resultSet.getString("pelicula");
				String fecha = resultSet.getString("fecha");
				String hora = resultSet.getString("hora");
				int precio = resultSet.getInt("precio");
				String dniCliente = resultSet.getString("dniCliente");

				entrada.setCodEntrada(codEntrada);
				entrada.setCine(cine);
				entrada.setSala(sala);
				entrada.setGenero(genero);
				entrada.setPelicula(pelicula);
				entrada.setFecha(fecha);
				entrada.setHora(hora);
				entrada.setPrecio(precio);
				entrada.setDniCliente(dniCliente);

				ret.add(entrada);
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null,"Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error generico - " + e.getMessage());
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
			}
			;
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			;
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
	 * Consulta en la BBDD el genero de una pelicula
	 * 
	 * @param pelicula pelicula de la que queremos saber el genero
	 * @return genero de dicha pelicula
	 */
	public String obtenerGeneroPelicula(String pelicula) {
		String ret = null;
		String sql = "select generoPelicula from pelicula where nombrePelicula='" + pelicula + "'";

		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {
				ret = resultSet.getString("generoPelicula");
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null,"Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error generico - " + e.getMessage());
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
			}
			;
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			;
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
	 * Almacena en la BBDD las entradas vendidas
	 * 
	 * @param entrada     informacion de las entradas vendidas
	 * @param fechaCompra fecha en la que se realizó la venta
	 * @param horaCompra  hora en la que se realizó la venta
	 */
	public void guardarNuevaEntrada(Entrada entrada, String fechaCompra, String horaCompra) {
		String genero = obtenerGeneroPelicula(entrada.getPelicula());
		if (null == genero) {
			return;
		}

		String sql = "insert into entrada (cine, sala, genero, pelicula, fecha, hora, precio, dniCliente) values ('"
				+ entrada.getCine() + "','" + entrada.getSala() + "','" + genero + "','" + entrada.getPelicula() + "','"
				+ fechaCompra + "','" + horaCompra + "','" + entrada.getPrecio() + "','" + entrada.getDniCliente()
				+ "')";
		Connection connection = null;

		Statement statement = null;
		int numeroFilas = 0;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			numeroFilas = statement.executeUpdate(sql);
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null,"Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error generico - " + e.getMessage());
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"algo va mal");
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"algo va mal 2");
			}
			;
		}
	}
}
//.
