package bbdd.gestores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import bbdd.pojos.Entrada;
import bbdd.utils.DBUtils;

/**
 * Gestiona las sesiones disponibles.
 */
public class GestorSesiones {

	/**
	 * Trae el listado de sesiones de la base de datos.
	 * 
	 * @return Array con listado de sesiones.
	 */
	public ArrayList<String> obtenerFechasDeSesiones(String peliculaSeleccionada, int cineSeleccionado) {
		ArrayList<String> ret = null;

		String sql = "select distinct emision.fechaEmision from cine join sala on cine.codigoCine=sala.codigoCine"
				+ "	join emision on sala.codigoSala=emision.codigoSala"
				+ "	join pelicula on emision.codigoPelicula=pelicula.codigoPelicula" + " where cine.codigoCine="
				+ cineSeleccionado + " and pelicula.nombrePelicula='" + peliculaSeleccionada + "'"
				+ " order by emision.fechaEmision asc";

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
					ret = new ArrayList<>();

				String fechaEmision = resultSet.getString("fechaEmision");

				ret.add(fechaEmision);
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
	 * obtiene los datos de una sesion concreta.
	 * 
	 * @param peliculaSeleccionada pelicula de la que queremos saber sus datos de
	 *                             emision
	 * @param cineSeleccionado     cine en el que se emite la pelicula
	 * @param fechaEmision         fecha en la que se emite la pelicula
	 * @return todos los datos sobre la emisión de una pelicula
	 */
	public ArrayList<Entrada> obtenerDatosDeSesiones(String peliculaSeleccionada, int cineSeleccionado,
			String fechaEmision) {

		ArrayList<Entrada> ret = null;

		String sql = "select emision.horaEmision, sala.nombreSala, emision.precioEmision, cine.nombreCine from cine join sala on cine.codigoCine=sala.codigoCine"
				+ "	join emision on sala.codigoSala=emision.codigoSala"
				+ "	join pelicula on emision.codigoPelicula=pelicula.codigoPelicula" + " where cine.codigoCine="
				+ cineSeleccionado + " and pelicula.nombrePelicula='" + peliculaSeleccionada + "'"
				+ " and emision.fechaEmision='" + fechaEmision + "' order by emision.horaEmision asc";

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
					ret = new ArrayList<>();
				Entrada entrada = new Entrada(0, null, null, null, null, null, null, 0, null);
				entrada.setFecha(fechaEmision);
				entrada.setPelicula(peliculaSeleccionada);
				entrada.setCine(resultSet.getString("nombreCine"));
				entrada.setHora(resultSet.getString("horaEmision"));
				entrada.setSala(resultSet.getString("nombreSala"));
				entrada.setPrecio(resultSet.getInt("precioEmision"));

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
	 * obtiene las horas en las que una pelicula se emite en un cine en concreto
	 * 
	 * @param peliculaSeleccionada pelicula de la que queremos saber sus emisiones
	 *                             en un cine en concreto
	 * @param cineSeleccionado     cine en el que queremos ver la pelicula
	 * @return horas de emision de una pelicula en un cine concreto
	 */
	public ArrayList<String> obtenerHorasDeSesiones(String peliculaSeleccionada, int cineSeleccionado) {
		ArrayList<String> ret = null;

		String sql = "select horaEmision from cine join sala on cine.codigoCine=sala.codigoCine "
				+ "join emision on sala.codigoSala=emision.codigoSala "
				+ "join pelicula on emision.codigoPelicula=pelicula.codigoPelicula " + "where cine.codigoCine="
				+ cineSeleccionado + "and pelicula.nombrePelicula = '" + peliculaSeleccionada
				+ "' order by emision.fechaEmision, emision.horaEmision asc;";

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
					ret = new ArrayList<>();

				String fechaEmision = resultSet.getString("fechaEmision");

				ret.add(fechaEmision);
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
}//.
