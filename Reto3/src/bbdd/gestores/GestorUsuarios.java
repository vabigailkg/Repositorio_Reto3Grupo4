package bbdd.gestores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import bbdd.pojos.Cliente;
import bbdd.utils.DBUtils;

/**
 * Gestiona los datos de todos los usuarios registrados en nuestra base de
 * datos.
 */
public class GestorUsuarios {

	/**
	 * Obtiene el listado de usuarios de la base de datos.
	 * 
	 * @return Array con listado de usuarios registrados.
	 */
	public Cliente obtenerDatosDeUsuarios(String dni) {
		Cliente ret = null;

		String sql = "select * from cliente where dniCliente='" + dni + "';";

		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {

				ret = new Cliente(null, null, null, null, null);

				String dniCliente = resultSet.getString("dniCliente");
				String nombreCliente = resultSet.getString("nombreCliente");
				String apellidosCliente = resultSet.getString("apellidosCliente");
				String sexoCliente = resultSet.getString("sexoCliente");
				String passwordCliente = resultSet.getString("passwordCliente");

				ret.setDniCliente(dniCliente);
				ret.setNombreCliente(nombreCliente);
				ret.setApellidosCliente(apellidosCliente);
				ret.setSexoCliente(sexoCliente);
				ret.setPasswordCliente(passwordCliente);
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

//cambiar javadoc
	/**
	 * Registra un nuevo usuario en la base de datos
	 * 
	 * @param dniCliente       el DNI del nuevo usuario
	 * @param passwordCliente  contrasenna elegida por el usuario
	 * @param nombreCliente    nombre del usuario
	 * @param apellidosCliente apellidos del usuario
	 * @param sexoCliente      sexo del usuario
	 */
	public void registrarNuevoUsuario(String dniCliente, String passwordCliente, String nombreCliente,
			String apellidosCliente, String sexoCliente) {
		String sql = "insert into cliente (dniCliente, nombreCliente, apellidosCliente, sexoCliente, passwordCliente) values ('"
				+ dniCliente + "','" + nombreCliente + "','" + apellidosCliente + "','" + sexoCliente + "','"
				+ passwordCliente.toString() + "')";
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
		if (numeroFilas != 0) {
			JOptionPane.showMessageDialog(null,"Usuario registrado con exito");
		}
	}

	/**
	 * Comprueba que la contrasenna asociada al DNI y es correcta
	 * 
	 * @param dniCliente      el DNI del cliente
	 * @param passwordCliente la contrasenna del cliente
	 * @return true si la contrasenna es correcta, false si no lo es
	 */
	public boolean comprobarInicioSesion(String dniCliente, String passwordCliente) {
		boolean ret = false;

		String sql = "select passwordCliente from cliente where dniCliente='" + dniCliente + "'";
		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {
				String password = resultSet.getString("passwordCliente");
				if (password.equals(passwordCliente)) {
					ret = true;
				}
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
	 * comprueba si existe ya ese usuario en la BBDD
	 * 
	 * @param DNI dni del usuario
	 * @return true si el usuario ya esta en la BBDD, false en caso contrario
	 */
	public boolean comprobarSiExisteUsuario(String DNI) {
		boolean ret = false;
		String sql = "select dniCliente from cliente where dniCliente='" + DNI + "'";
		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {
				ret = true;
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
