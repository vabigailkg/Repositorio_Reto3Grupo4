package bbdd.gestoresJUnit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import bbdd.gestores.GestorSesiones;
import bbdd.pojos.Entrada;

class GestorSesionesTest {

	GestorSesiones gestorSesiones = new GestorSesiones();
	// Definir la película, el cine y la fecha seleccionados para obtener las
	// sesiones
	String peliculaSeleccionada = "Klaus";
	int cineSeleccionado = 1;
	String fechaEmision = "2024-02-01";

	@Test
	public void testObtenerFechasDeSesiones() {

		// Llamar al método para obtener las fechas de las sesiones
		ArrayList<String> fechasDeSesiones = gestorSesiones.obtenerFechasDeSesiones(peliculaSeleccionada,
				cineSeleccionado);

		// Verificar que la lista no sea nula
		assertNotNull("La lista de fechas de sesiones no debe ser nula", fechasDeSesiones);

		// Verificar que la lista contenga al menos una fecha
		assertTrue("La lista de fechas de sesiones debe contener al menos una fecha", fechasDeSesiones.size() > 0);

	}

	@Test
	public void testObtenerHorasDeSesiones() {

		// Llamar al metodo para obtener las horas de las sesiones
		ArrayList<String> horasDeSesiones = gestorSesiones.obtenerHorasDeSesiones(peliculaSeleccionada,
				cineSeleccionado);

		assertNotNull("La lista de horas de sesiones no debe ser nula", horasDeSesiones);

		// Verificar que la lista contenga al menos una hora
		assertTrue("La lista de horas de sesiones debe contener al menos una hora", horasDeSesiones.size() > 0);

	}

	@Test
	public void obtenerSesionesDe() {

		// Llamar al método para obtener las sesiones para la fecha y película
		// específicas
		ArrayList<Entrada> sesiones = gestorSesiones.obtenerDatosDeSesiones(peliculaSeleccionada, cineSeleccionado,
				fechaEmision);

		assertNotNull("La lista de sesiones no debe ser nula", sesiones);

		// Verificar que la lista tenga al menos una sesion
		assertTrue("La lista de sesiones debe contener al menos una sesión", sesiones.size() > 0);

	}

	@Test
	public void testObtenerPrecio() {

		// Llamar al método para obtener las sesiones para la fecha y película
		// específicas
		ArrayList<Entrada> sesiones = gestorSesiones.obtenerDatosDeSesiones(peliculaSeleccionada, cineSeleccionado,
				fechaEmision);

		assertNotNull("La lista de sesiones no debe ser nula", sesiones);

		// Verificar que la lista tenga al menos una sesión
		assertTrue("La lista de sesiones debe contener al menos una sesión", sesiones.size() > 0);

		// Verificar que el precio de la sesion sea mayor a 0
		for (Entrada sesion : sesiones) {
			assertTrue("El precio de la sesión debe ser mayor que cero", sesion.getPrecio() > 0);
		}
	}

	@Test
	public void testObtenerSalas() {

		// Llamar al método para obtener las sesiones para la fecha y película
		// específicas
		ArrayList<Entrada> sesiones = gestorSesiones.obtenerDatosDeSesiones(peliculaSeleccionada, cineSeleccionado,
				fechaEmision);

		assertNotNull("La lista de sesiones no debe ser nula", sesiones);
		assertTrue("La lista de sesiones debe contener al menos una sesión", sesiones.size() > 0);

		// Verificar que la sala sea igual a A1
		for (Entrada sesion : sesiones) {
			assertEquals("El precio de la sesión debe ser mayor que cero", sesion.getSala(), "A1");
		}
	}
}//.
