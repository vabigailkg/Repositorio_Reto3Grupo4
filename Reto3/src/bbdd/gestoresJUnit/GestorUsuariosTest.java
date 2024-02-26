package bbdd.gestoresJUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bbdd.gestores.GestorUsuarios;

class GestorUsuariosTest {

	GestorUsuarios gestorUsuarios = new GestorUsuarios();
	String dniCliente = "15937862J";
	String passwordCliente = "0101011";

	@Test
	public void testComprobarInicioDeSesionExitoso() {

		// Llamar al método para obtener el dni y la contrasena
		boolean inicioExitoso = gestorUsuarios.comprobarInicioSesion(dniCliente, passwordCliente);

		// Verificar que sea exitoso
		assertTrue("El inicio de sesión debe ser exitoso", inicioExitoso);
	}

	@Test
	public void testComprobarInicioDeSesionFallido() {

		// Llamar al método para obtener el dni y la contrasena
		boolean inicioExitoso = gestorUsuarios.comprobarInicioSesion(passwordCliente, dniCliente);

		// Verificar que el falle
		assertFalse("El inicio de sesión debe Fallar", inicioExitoso);
	}

}
