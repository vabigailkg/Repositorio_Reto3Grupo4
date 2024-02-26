package bbdd.gestoresJUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import bbdd.gestores.GestorPeliculas;
import bbdd.pojos.Pelicula;

class GestorPeliculasTest {

	@Test
	void testObtenerListaDePeliculas() {

		GestorPeliculas gestorPeliculas = new GestorPeliculas();

		// Llamar al método para obtener la lista de películas
		ArrayList<Pelicula> listaDePeliculas = gestorPeliculas.obtenerListaDePeliculas();
		// Verificar que la lista contenga 10 Peliculas
		assertTrue(listaDePeliculas.size() == 10);
	}

	@Test
	void listaContieneAlMenosUnaPelicula() {

		GestorPeliculas gestorPeliculas = new GestorPeliculas();

		ArrayList<Pelicula> listaDePeliculas = gestorPeliculas.obtenerListaDePeliculas();
		// Verificar que la lista contenga al menos una pelicula
		assertTrue(listaDePeliculas.size() > 0);
	}

	@Test
	void listaNoEsNula() {

		GestorPeliculas gestorPeliculas = new GestorPeliculas();

		ArrayList<Pelicula> listaDePeliculas = gestorPeliculas.obtenerListaDePeliculas();
		// Verificar que la lista no sea nula
		assertNotNull(listaDePeliculas);
	}

	@Test
	public void testObtenerPeliculasDeCine() {

		GestorPeliculas gestorPeliculas = new GestorPeliculas();

		// Definir el código del cine del cual se quieren obtener las películas
		int codigoCine = 1;

		ArrayList<Pelicula> listaPeliculas = gestorPeliculas.obtenerPeliculasDeCine(codigoCine);

		assertNotNull("La lista de películas no debe ser nula", listaPeliculas);

		// Verificar que la lista contenga al menos una película
		assertTrue("La lista de películas debe contener al menos una película", listaPeliculas.size() > 0);
		int cantidadEsperada = listaPeliculas.size(); // Utilizamos el tamaño de la lista obtenida

		// Comparar la cantidad de películas obtenidas con la cantidad esperada
		assertEquals("La lista de películas no contiene la cantidad esperada", cantidadEsperada, listaPeliculas.size());
		assertEquals("La lista de películas no contiene 41 ", cantidadEsperada, 41);
	}

	@Test
	public void hayPeliculaLlamadaChucky() {

		GestorPeliculas gestorPeliculas = new GestorPeliculas();

		// Llamar al método para obtener la lista de películas
		ArrayList<Pelicula> listaDePeliculas = gestorPeliculas.obtenerListaDePeliculas();

		boolean chuckyEncontrado = false;
		for (Pelicula pelicula : listaDePeliculas) {
			if (pelicula.getNombrePelicula().equals("Chucky")) {
				chuckyEncontrado = true;
				break;
			}
		}

		// Verificar que se encontró la película "Chucky" en la lista
		assertTrue("La lista de películas debe contener la película 'Chucky'", chuckyEncontrado);
	}

}//.
