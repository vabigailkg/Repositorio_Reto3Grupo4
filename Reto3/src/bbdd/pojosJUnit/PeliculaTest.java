package bbdd.pojosJUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bbdd.pojos.Pelicula;

class PeliculaTest {

	private Pelicula peli = new Pelicula(100, "ElConjuro", 120, "Terror", 1000);

	@Test
	// Esta prueba verifica si el id de la pelicula es igual al numero escrito en
	// assertEquals
	public void testGetId() {
		long idPeli = peli.getcodigoPelicula();
		assertEquals("Es igual", 100, idPeli);
		assertNotEquals("No son iguales", 101, idPeli);
		assertEquals("Error", 99, idPeli);
	}

	@Test
	// Esta prueba verifica si el nombre de la pelicula es igual al que esta escrito
	// en comillas
	public void testGetNombre() {
		String nombrePeli = peli.getNombrePelicula();
		assertEquals("Es igual", "ElConjuro", nombrePeli);
		assertNotEquals("No son iguales", "ElHechizo", nombrePeli);
		assertEquals("Error", "ElEncantamiento", nombrePeli);
		assertNotNull("Error, es nulo", nombrePeli);
	}

	@Test
	// Esta prueba verifica si la duracion de la pelicula es igual al que esta
	// escrito en comillas
	public void testGetDuracion() {
		int duracionPeli = peli.getDuracionPelicula();
		assertEquals("Es igual", 120, duracionPeli);
		assertNotEquals("No son iguales", 101, duracionPeli);
		assertEquals("Error", 99, duracionPeli);
	}

	@Test
	// Esta prueba verifica si el genero de la pelicula es igual al que esta escrito
	// en comillas
	public void testGetGenero() {
		String generoPeli = peli.getGeneroPelicula();
		assertEquals("Es igual", "Terror", generoPeli);
		assertNotEquals("No son iguales", "Drama", generoPeli);
		assertEquals("Error", "Drama", generoPeli);
		assertNotNull("Error, es nulo", generoPeli);
	}

	@Test
	// Esta prueba verifica si el coste de la pelicula es igual al que esta escrito
	// en comillas
	public void testGetCoste() {
		int costePeli = peli.getCostePelicula();
		assertEquals("Es igual", 1000, costePeli);
		assertNotEquals("No son iguales", 1500, costePeli);
		assertEquals("Error", 999, costePeli);
	}

	@Test
	// en el setId insertamos un numero(Long) a peli y comparamos si se inserto de
	// manera correcta
	public void testSetId() {

		peli.setcodigoPelicula(123);
		assertEquals(123, peli.getcodigoPelicula());
		assertNotEquals("Id no correcto", 124, peli.getcodigoPelicula());
		assertEquals("Error en el Id", 14, peli.getcodigoPelicula());

	}

	@Test
	// en el setNombre insertamos una palabra(String) a peli y comparamos si se
	// inserto de manera correcta
	public void testSetDuracion() {

		peli.setDuracionPelicula(150);
		assertEquals(150, peli.getDuracionPelicula());
		assertNotEquals("Duracion no correcto", 124, peli.getDuracionPelicula());
		assertEquals("Error en la Duracion", 14, peli.getDuracionPelicula());

	}

	@Test
	// en el setNombre insertamos una palabra(String) a peli y comparamos si se
	// inserto de manera correcta
	public void testSetGenero() {

		peli.setGeneroPelicula("Terror");
		assertEquals("Terror", peli.getGeneroPelicula());
		assertNotEquals("Genero no correcto", "Drama", peli.getGeneroPelicula());
		assertEquals("Error en el Genero", "Comedia", peli.getGeneroPelicula());

	}

	@Test
	// en el setNombre insertamos una palabra(String) a peli y comparamos si se
	// inserto de manera correcta
	public void testSetCoste() {

		peli.setCostePelicula(1500);
		assertEquals(1500, peli.getCostePelicula());
		assertNotEquals("Coste no correcto", 124, peli.getCostePelicula());
		assertEquals("Error en el Coste", 14, peli.getCostePelicula());

	}

	@Test
	// en el setNombre insertamos una palabra(String) a peli y comparamos si se
	// inserto de manera correcta
	public void testSetNombre() {

		peli.setNombrePelicula("ElConjuro");
		assertEquals("ElConjuro", peli.getNombrePelicula());
		assertNotEquals("Nombre no correcto", "ElConjuro", peli.getNombrePelicula());
		assertEquals("Error en el nombre", "ElConjuro", peli.getNombrePelicula());

	}

	@Test
	// en toString retornamos una cadena con la informacion de pelicula incluyendo
	// el Id y el Nombre y la comparamos con el string
	public void testToString() {
		String string = peli.toString();
		assertEquals("pelicula [id=100, Nombre=ElConjuro,duracion=120,genero=Terror,coste=1000]", string);
		assertNotEquals("String no correcto",
				"Pelicula [id=100, nombre=ElConjuro,duracion=120,genero=Terror,coste=1000", string);
		assertEquals("String no correcto", "Pelicula [id=13, nombre=ElHechizo,duracion=120,genero=Terror,coste=1000",
				string);
	}

	@Test
	// en Equals comparamos la peli con peliculaNueva y como sus valores son
	// distintos resultara en falso
	public void testEquals() {
		Pelicula peliculaNueva = new Pelicula(50, "JoJO", 60, "Accion", 500);
		boolean esIgual = peli.equals(peliculaNueva);
		assertEquals("Los objetos deben ser iguales", false, esIgual);
		assertNotEquals("Los objetos deben ser diferentes", true, esIgual);
	}
}//.
