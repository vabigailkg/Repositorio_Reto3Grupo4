package bbdd.gestores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import bbdd.pojos.Sala;
import bbdd.utils.DBUtils;

public class GestorSalas {

	/**
	 * Trae el listado de salas de la base de datos.
	 * 
	 * @return Array con listado de salas.
	 */
	public ArrayList<Sala> obtenerListaDeSalas() {
		ArrayList<Sala> ret = null;

		String sql = "select * from sala";

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
					ret = new ArrayList<Sala>();

				Sala sala = new Sala(0, 0, sql);

				int codigoSala = resultSet.getInt("codigoSala");
				int codigoCine = resultSet.getInt("codigoCine");
				String nombreSala = resultSet.getString("nombreSala");

				sala.setCodigoSala(codigoSala);
				sala.setCodigoCine(codigoCine);
				sala.setNombreSala(nombreSala);

				ret.add(sala);
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