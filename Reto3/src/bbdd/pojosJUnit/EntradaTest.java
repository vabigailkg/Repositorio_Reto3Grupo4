package bbdd.pojosJUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bbdd.pojos.Emision;
import bbdd.pojos.Entrada;

class EntradaTest {

	private Entrada entrada = new Entrada(1, "elorrieta","1A","Terror", "Chucky","2024-02-26" , "03:23", 10,"12345678F" );

	@Test
	public void testGetCodEntrada() {

		int CodEntrada = entrada.getCodEntrada();
		assertEquals("Es igual", 1, CodEntrada);
		assertNotEquals("No son iguales", 5, CodEntrada);
		assertEquals("Error", 99, CodEntrada);

	}

	@Test
	public void testGetCine() {

		String cine = entrada.getCine();
		assertEquals("Es igual", "elorrieta", cine);
		assertNotEquals("No son iguales", "Erreka", cine);
		assertEquals("Error", 1, cine);
		assertNotNull("Error, es nulo", cine);

	}

	@Test
	public void testGetSala() {

		String sala = entrada.getSala();
		assertEquals("Es igual", "1A", sala);
		assertNotEquals("No son iguales", "1B", sala);
		assertEquals("Error", 1, sala);
		assertNotNull("Error, es nulo", sala);

	}

	@Test
	public void testGetGenero() {

		String genero = entrada.getGenero();
		assertEquals("Es igual", "Terror", genero);
		assertNotEquals("No son iguales", "Drama", genero);
		assertEquals("Error", 1, genero);
		assertNotNull("Error, es nulo", genero);

	}

	@Test
	public void testGetPelicula() {

		String pelicula = entrada.getPelicula();
		assertEquals("Es igual", "Chucky", pelicula);
		assertNotEquals("No son iguales", "Annabelle", pelicula);
		assertEquals("Error", "2024-04-26", pelicula);
		assertNotNull("Error, es nulo", pelicula);

	}

	@Test
	public void testGetPrecio() {

		int precio = entrada.getPrecio();
		assertEquals("Es igual", 10, precio);
		assertNotEquals("No son iguales", 15, precio);
		assertEquals("Error", 0, precio);
		assertNotNull("Error, es nulo", precio);

	}
	@Test
	public void testGetDni() {

		String dni = entrada.getDniCliente();
		assertEquals("Es igual", "12345678F", dni);
		assertNotEquals("No son iguales", "12345678Z", dni);
		assertEquals("Error", 12345678, dni);
		assertNotNull("Error, es nulo", dni);

	}

	@Test
	public void testSetCodEntrada() {

		entrada.setCodEntrada(2);
		assertEquals(2, entrada.getCodEntrada());
		assertNotEquals("Codigo no correcto", 1, entrada.getCodEntrada());
		assertEquals("Error en el Codigo", 99, entrada.getCodEntrada());

	}

	@Test
	public void testSetCine() {

		entrada.setCine("casco-Viejo");
		assertEquals("casco-Viejo", entrada.getCine());
		assertNotEquals("Codigo no correcto", "elorrrieta", entrada.getCine());
		assertEquals("Error en el Codigo", 99, entrada.getCine());

	}

	@Test
	public void testSetSala() {

		entrada.setSala("2B");
		assertEquals("2B", entrada.getSala());
		assertNotEquals("Codigo no correcto", "1A", entrada.getSala());
		assertEquals("Error en el Codigo", 99, entrada.getSala());

	}

	@Test
	public void testSetGenero() {

		entrada.setGenero("Drama");
		assertEquals("Drama", entrada.getGenero());
		assertNotEquals("Codigo no correcto", "Terror", entrada.getGenero());
		assertEquals("Error en el Codigo", 999, entrada.getGenero());

	}

	@Test
	public void testSetPelicula() {

		entrada.setPelicula("Titanic");
		assertEquals("Titanic", entrada.getPelicula());
		assertNotEquals("Codigo no correcto", "Chucky", entrada.getPelicula());
		assertEquals("Error en el Codigo", "", entrada.getPelicula());

	}

	@Test
	public void testSetFecha() {

		entrada.setFecha("2024-01-27");
		assertEquals("2024-01-27", entrada.getFecha());
		assertNotEquals("Codigo no correcto", "2024-01-26", entrada.getFecha());
		assertEquals("Error en el Codigo", "00:00", entrada.getFecha());

	}
	@Test
	public void testSetHora() {

		entrada.setHora("03:45");
		assertEquals("03:45", entrada.getHora());
		assertNotEquals("Codigo no correcto", "03:23", entrada.getHora());
		assertEquals("Error en el Codigo", "00:00", entrada.getHora());

	}
	@Test
	public void testSetPrecio() {

		entrada.setPrecio(7);
		assertEquals(7, entrada.getPrecio());
		assertNotEquals("Codigo no correcto", 10, entrada.getPrecio());
		assertEquals("Error en el Codigo", 0, entrada.getPrecio());

	}
	@Test
	public void testSetDni() {

		entrada.setDniCliente("12345678Z");
		assertEquals("12345678Z", entrada.getDniCliente());
		assertNotEquals("Codigo no correcto", "12345678F", entrada.getDniCliente());
		assertEquals("Error en el Codigo", 12345678, entrada.getDniCliente());

	}

	@Test
	// en toString retornamos una cadena con la informacion de la Entrada incluyendo
	// codEntrada , cine ,sala,genero,pelicula,fecha,hora, precio y dni para luego comparamos con el string
	public void testToString() {
		String string = entrada.toString();
		assertEquals(
				"Entrada [codEntrada=1, cine=elorrieta, sala=1A, genero=Terror , pelicula=Chucky, fecha=2024-02-26, hora=03:23, precio=10, dniCliente=12345678F]",
				string);
		assertNotEquals("String no correcto",
				"Entrada [codEntrada=1, cine=elorrieta, sala=1A, genero=Terror , pelicula=Chucky, fecha=2024-02-26, hora=03:23, precio=10, dniCliente=12345678F]",
				string);
		assertEquals("String no correcto",
				"Entrada [codEntrada=2, cine=elorrieta, sala=3A, genero=Terror , pelicula=Chucky, fecha=2024-02-26, hora=03:23, precio=10, dniCliente=12345678F]",
				string);
	}

	@Test
	// en Equals comparamos la Entrada con entradaNueva y como sus valores son
	// distintos resultara en falso
	public void testEquals() {
		Entrada entradaNueva = new Entrada(1, "Casco-Viejo","2A","Drama", "Titanic","2024-03-26" , "03:51", 7,"12345678R" );
		boolean esIgual = entrada.equals(entradaNueva);
		assertEquals("Los objetos deben ser iguales", false, esIgual);
		assertNotEquals("Los objetos deben ser diferentes", true, esIgual);
	}

}
