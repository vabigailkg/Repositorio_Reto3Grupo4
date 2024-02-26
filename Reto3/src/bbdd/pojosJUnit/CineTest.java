package bbdd.pojosJUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bbdd.pojos.Cine;

class CineTest {

	private  Cine cine =new Cine(4,"elorrieta","lejos");
	@Test
	public void testGetCine() {
		
		int CodCine=cine.getcodigoCine();
		assertEquals("Es igual", 4, CodCine);
		assertNotEquals("No son iguales", 5, CodCine);
		assertEquals("Error", 99, CodCine);
		
	}
	@Test
	public void testGetNombre() {
		
		String NombreCine=cine.getnombreCine();
		assertEquals("Es igual", "elorrieta", NombreCine);
		assertNotEquals("No son iguales", "erreka", NombreCine);
		assertEquals("Error", "Mari", NombreCine);
		assertNotNull("Error, es nulo", NombreCine);
		
	}
	@Test
	public void testGetDireccion() {
		
		String DireccionCine=cine.getdireccionCine();
		assertEquals("Es igual", "lejos", DireccionCine);
		assertNotEquals("No son iguales", "cerca", DireccionCine);
		assertEquals("Error", 99, DireccionCine);
		assertNotNull("Error, es nulo", DireccionCine);
		
	}
	@Test
	public void testSetCine() {

		cine.setcodigoCine(4);
		assertEquals(4, cine.getcodigoCine());
		assertNotEquals("Codigo no correcto", 5, cine.getcodigoCine());
		assertEquals("Error en el Codigo", 99, cine.getcodigoCine());

	}
	@Test
	public void testSetNombre() {

		cine.setnombreCine("Mari");
		assertEquals("Mari", cine.getnombreCine());
		assertNotEquals("Codigo no correcto", "elorrieta", cine.getnombreCine());
		assertEquals("Error en el Codigo", "Error", cine.getnombreCine());

	}
	@Test
	public void testSetDireccion() {

		cine.setdireccionCine("aquiCerca");
		assertEquals("aquiCerca", cine.getdireccionCine());
		assertNotEquals("Codigo no correcto", "lejos", cine.getdireccionCine());
		assertEquals("Error en el Codigo", "Error", cine.getdireccionCine());

	}
	@Test
	// en toString retornamos una cadena con la informacion del cine incluyendo
	// el Codigo , el Nombre y la Direccion comparamos con el string
	public void testToString() {
		String string = cine.toString();
		assertEquals("Cine [codigoCine=4 , nombreCine=elorrieta , direccionCine=lejos]", string);
		assertNotEquals("String no correcto","Cine [codigoCine=4 , nombreCine=elorrieta , direccionCine=lejos]", string);
		assertEquals("String no correcto", "Cine [codigoCine=5 , nombreCine=ERREKA , direccionCine=cerca]",string);
	}

	@Test
	// en Equals comparamos el cine con cineNuevo y como sus valores son
	// distintos resultara en falso
	public void testEquals() {
		Cine cineNuevo =new Cine(5,"ERREKA","cerca");
		boolean esIgual = cine.equals(cineNuevo);
		assertEquals("Los objetos deben ser iguales", false, esIgual);
		assertNotEquals("Los objetos deben ser diferentes", true, esIgual);
	}
}//.
