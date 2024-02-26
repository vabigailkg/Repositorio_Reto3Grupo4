package bbdd.pojosJUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bbdd.pojos.Sala;

class SalaTest {

	private  Sala sala =new Sala(2,1,"B3");
	@Test
	public void testGetSala() {
		
		int CodSala=sala.getCodigoSala();
		assertEquals("Es igual", 2, CodSala);
		assertNotEquals("No son iguales", 5, CodSala);
		assertEquals("Error", 99, CodSala);
		
	}
	@Test
	public void testGetCine() {
		
		int CodCine=sala.getCodigoCine();
		assertEquals("Es igual", 1, CodCine);
		assertNotEquals("No son iguales", 2, CodCine);
		assertEquals("Error", 99, CodCine);
		assertNotNull("Error, es nulo", CodCine);
		
	}
	@Test
	public void testGetNombre() {
		
		String NombreSala=sala.getNombreSala();
		assertEquals("Es igual", "B3", NombreSala);
		assertNotEquals("No son iguales", "B4", NombreSala);
		assertEquals("Error", "c5", NombreSala);
		assertNotNull("Error, es nulo", NombreSala);
		
	}
	@Test
	public void testSetSala() {

		sala.setCodigoSala(4);
		assertEquals(4, sala.getCodigoSala());
		assertNotEquals("Codigo no correcto", 5, sala.getCodigoSala());
		assertEquals("Error en el Codigo", 99, sala.getCodigoSala());

	}
	@Test
	public void testSetCine() {

		sala.setCodigoCine(3);
		assertEquals(3, sala.getCodigoCine());
		assertNotEquals("Codigo no correcto", 4, sala.getCodigoCine());
		assertEquals("Error en el Codigo", 99, sala.getCodigoCine());

	}
	@Test
	public void testSetNombre() {

		sala.setNombreSala("C7");
		assertEquals("C7", sala.getNombreSala());
		assertNotEquals("Codigo no correcto", "CJ7", sala.getNombreSala());
		assertEquals("Error en el Codigo", "Error", sala.getNombreSala());

	}
	@Test
	// en toString retornamos una cadena con la informacion de la Sala incluyendo
	// el CodigoSala , el CodigoCine y el Nombre comparamos con el string
	public void testToString() {
		String string = sala.toString();
		assertEquals("Sala [codigoSala=2 , CodigoCine=1 , nombreSala=B3]", string);
		assertNotEquals("String no correcto","Sala [codigoSala=2 , CodigoCine=1 , nombreSala=B3]", string);
		assertEquals("String no correcto", "Sala [codigoSala=3 , CodigoCine=3 , nombreSala=c3]",string);
	}

	@Test
	// en Equals comparamos la Sala con salaNueva y como sus valores son
	// distintos resultara en falso
	public void testEquals() {
		Sala salaNueva =new Sala(3,3,"C3");
		boolean esIgual = sala.equals(salaNueva);
		assertEquals("Los objetos deben ser iguales", false, esIgual);
		assertNotEquals("Los objetos deben ser diferentes", true, esIgual);
	}

}//.
