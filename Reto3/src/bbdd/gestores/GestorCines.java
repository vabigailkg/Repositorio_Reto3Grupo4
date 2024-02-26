package bbdd.gestores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import bbdd.pojos.Cine;
import bbdd.utils.DBUtils;

/**
 * Gestiona la tabla 'Cine' de la base de datos.
 */
public class GestorCines {

	/**
	 * Trae el listado de cines de la base de datos.
	 * 
	 * @return Array con listado de cines.
	 */
	public ArrayList<Cine> obtenerListaDeCines() {
		ArrayList<Cine> ret = null;

		String sql = "select * from cine";

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
					ret = new ArrayList<Cine>();

				Cine cine = new Cine(0, sql, sql);

				int codigoCine = resultSet.getInt("codigoCine");
				String nombreCine = resultSet.getString("nombreCine");
				String direccionCine = resultSet.getString("direccionCine");

				cine.setcodigoCine(codigoCine);
				cine.setnombreCine(nombreCine);
				cine.setdireccionCine(direccionCine);

				ret.add(cine);
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

}