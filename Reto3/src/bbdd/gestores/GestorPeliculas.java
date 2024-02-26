package bbdd.gestores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import bbdd.pojos.Pelicula;
import bbdd.utils.DBUtils;

/**
 * Gestiona las películas de la base de datos.
 */
public class GestorPeliculas {

	/**
	 * Trae el listado de películas de la base de datos.
	 * 
	 * @return Array con listado de películas.
	 */
	public ArrayList<Pelicula> obtenerListaDePeliculas() {
		ArrayList<Pelicula> ret = null;

		String sql = "select * from pelicula";

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
					ret = new ArrayList<Pelicula>();

				Pelicula pelicula = new Pelicula(0, null, 0, null, 0);

				int codigoPelicula = resultSet.getInt("codigoPelicula");
				String nombrePelicula = resultSet.getString("nombrePelicula");
				int duracionPelicula = resultSet.getInt("duracionPelicula");
				String generoPelicula = resultSet.getString("generoPelicula");
				int costePelicula = resultSet.getInt("costePelicula");

				pelicula.setcodigoPelicula(codigoPelicula);
				pelicula.setNombrePelicula(nombrePelicula);
				pelicula.setDuracionPelicula(duracionPelicula);
				pelicula.setGeneroPelicula(generoPelicula);
				pelicula.setCostePelicula(costePelicula);

				ret.add(pelicula);
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
	 * Obtiene de la BBDD la lista de peliculas de un cine ordenadas por fecha y
	 * hora de emision
	 * 
	 * @param cineSeleccionado cine del que queremos saber sus emisiones
	 * @return lista de peliculas ordenadas de ese cine
	 */
	public ArrayList<Pelicula> obtenerPeliculasDeCine(int cineSeleccionado) {
		ArrayList<Pelicula> listaPeliculasPorCine = null;

		String sql = "select nombrePelicula from cine join sala on cine.codigoCine=sala.codigoCine "
				+ "join emision on sala.codigoSala=emision.codigoSala "
				+ "join pelicula on emision.codigoPelicula=pelicula.codigoPelicula " + "where cine.codigoCine="
				+ cineSeleccionado + " order by emision.fechaEmision, emision.horaEmision asc;";

		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				if (null == listaPeliculasPorCine)
					listaPeliculasPorCine = new ArrayList<Pelicula>();

				Pelicula pelicula = new Pelicula(0, null, 0, null, 0);

				String nombrePelicula = resultSet.getString("nombrePelicula");

				pelicula.setNombrePelicula(nombrePelicula);

				listaPeliculasPorCine.add(pelicula);
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
		return listaPeliculasPorCine;
	}
}
//.