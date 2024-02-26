package bbdd.pojosJUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bbdd.pojos.Emision;

class EmisionTest {

	private Emision emision = new Emision(1, 1, 1, 10, "2024-02-26", "02:50", 1);

	@Test
	public void testGetCodEmision() {

		int CodEmision = emision.getCodigoEmision();
		assertEquals("Es igual", 1, CodEmision);
		assertNotEquals("No son iguales", 5, CodEmision);
		assertEquals("Error", 99, CodEmision);

	}

	@Test
	public void testGetCodSala() {

		int CodSala = emision.getCodigoSala();
		assertEquals("Es igual", 1, CodSala);
		assertNotEquals("No son iguales", 2, CodSala);
		assertEquals("Error", 99, CodSala);
		assertNotNull("Error, es nulo", CodSala);

	}

	@Test
	public void testGetCodCine() {

		int CodCine = emision.getCodigoCine();
		assertEquals("Es igual", 1, CodCine);
		assertNotEquals("No son iguales", 2, CodCine);
		assertEquals("Error", 99, CodCine);
		assertNotNull("Error, es nulo", CodCine);

	}

	@Test
	public void testGetPrecio() {

		int Precio = emision.getPrecioEmision();
		assertEquals("Es igual", 10, Precio);
		assertNotEquals("No son iguales", 11, Precio);
		assertEquals("Error", 99, Precio);
		assertNotNull("Error, es nulo", Precio);

	}

	@Test
	public void testGetFecha() {

		String Fecha = emision.getFechaEmision();
		assertEquals("Es igual", "2024-02-26", Fecha);
		assertNotEquals("No son iguales", "2024-03-26", Fecha);
		assertEquals("Error", "2024-04-26", Fecha);
		assertNotNull("Error, es nulo", Fecha);

	}

	@Test
	public void testGetHora() {

		String Hora = emision.getHoraEmision();
		assertEquals("Es igual", "02:50", Hora);
		assertNotEquals("No son iguales", "02:60", Hora);
		assertEquals("Error", "00:00", Hora);
		assertNotNull("Error, es nulo", Hora);

	}

	@Test
	public void testGetCodPelicula() {

		int CodPelicula = emision.getCodigopelicula();
		assertEquals("Es igual", 1, CodPelicula);
		assertNotEquals("No son iguales", 1, CodPelicula);
		assertEquals("Error", 99, CodPelicula);
		assertNotNull("Error, es nulo", CodPelicula);

	}

	@Test
	public void testSetCodEmision() {

		emision.setCodigoEmision(2);
		assertEquals(2, emision.getCodigoEmision());
		assertNotEquals("Codigo no correcto", 1, emision.getCodigoEmision());
		assertEquals("Error en el Codigo", 99, emision.getCodigoEmision());

	}

	@Test
	public void testSetCodSala() {

		emision.setCodigoSala(3);
		assertEquals(3, emision.getCodigoSala());
		assertNotEquals("Codigo no correcto", 4, emision.getCodigoSala());
		assertEquals("Error en el Codigo", 99, emision.getCodigoSala());

	}

	@Test
	public void testSetCodCine() {

		emision.setCodigoCine(2);
		assertEquals(2, emision.getCodigoCine());
		assertNotEquals("Codigo no correcto", 3, emision.getCodigoCine());
		assertEquals("Error en el Codigo", 99, emision.getCodigoCine());

	}

	@Test
	public void testSetPrecio() {

		emision.setPrecioEmision(20);
		assertEquals(20, emision.getPrecioEmision());
		assertNotEquals("Codigo no correcto", 10, emision.getPrecioEmision());
		assertEquals("Error en el Codigo", 999, emision.getPrecioEmision());

	}

	@Test
	public void testSetFecha() {

		emision.setFechaEmision("2024-03-26");
		assertEquals("2024-03-26", emision.getFechaEmision());
		assertNotEquals("Codigo no correcto", "2024-02-26", emision.getFechaEmision());
		assertEquals("Error en el Codigo", "0000-00-00", emision.getFechaEmision());

	}

	@Test
	public void testSetHora() {

		emision.setHoraEmision("03:09");
		assertEquals("03:09", emision.getHoraEmision());
		assertNotEquals("Codigo no correcto", "02:56", emision.getHoraEmision());
		assertEquals("Error en el Codigo", "00:00", emision.getHoraEmision());

	}

	@Test
	public void testSetCodPelicula() {

		emision.setCodigopelicula(3);
		assertEquals(3, emision.getCodigopelicula());
		assertNotEquals("Codigo no correcto", 1, emision.getCodigopelicula());
		assertEquals("Error en el Codigo", 99, emision.getCodigopelicula());

	}

	@Test
	// en toString retornamos una cadena con la informacion de la Emision incluyendo
	// codEmision , CodSala ,CodCine,Precio,Fecha,Hora,CodPelicula para luego comparamos con el string
	public void testToString() {
		String string = emision.toString();
		assertEquals(
				"Emision [codigoEmision=1 , codigoSala= 1, codigoCine= 1,	precioEmision=10 , fechaEmision=2024-02-27 , horaEmision=03:11 , codigopelicula=1 ]",
				string);
		assertNotEquals("String no correcto",
				"Emision [codigoEmision=1 , codigoSala= 1, codigoCine= 1,	precioEmision=10 , fechaEmision=2024-02-27 , horaEmision=03:11 , codigopelicula=1 ]",
				string);
		assertEquals("String no correcto",
				"Emision [codigoEmision=2 , codigoSala= 2, codigoCine= 2,	precioEmision=15 , fechaEmision=2024-02-27 , horaEmision=03:11 , codigopelicula=1 ]",
				string);
	}

	@Test
	// en Equals comparamos la Emision con emisionNueva y como sus valores son
	// distintos resultara en falso
	public void testEquals() {
		Emision emisionNueva = new Emision(2, 2, 2, 15, "2024-02-27", "03:11", 1);
		boolean esIgual = emision.equals(emisionNueva);
		assertEquals("Los objetos deben ser iguales", false, esIgual);
		assertNotEquals("Los objetos deben ser diferentes", true, esIgual);
	}
}
