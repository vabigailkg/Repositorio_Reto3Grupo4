package bbdd.pojosJUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bbdd.pojos.Cliente;

class ClienteTest {

	private  Cliente cliente =new Cliente("12345678D","Daniel","Caballero","M","123456z");
	@Test
	public void testGetDni() {
		
		String dni=cliente.getDniCliente();
		assertEquals("Es igual","12345678D", dni);
		assertNotEquals("No son iguales", "12345678Z", dni);
		assertEquals("Error", 99, dni);
		
		
	}
	@Test
	public void testGetNombre() {
		
		String nombre=cliente.getNombreCliente();
		assertEquals("Es igual", "Daniel", nombre);
		assertNotEquals("No son iguales", "Daniela", nombre);
		assertEquals("Error", "", nombre);
		assertNotNull("Error, es nulo", nombre);
		
	}
	@Test
	public void testGetApellido() {
		
		String apellidos=cliente.getApellidosCliente();
		assertEquals("Es igual", "Caballero", apellidos);
		assertNotEquals("No son iguales", "caballo", apellidos);
		assertEquals("Error", "", apellidos);
		assertNotNull("Error, es nulo", apellidos);
		
	}
	@Test
	public void testGetSexo() {
		
		String sexo=cliente.getSexoCliente();
		assertEquals("Es igual", "M", sexo);
		assertNotEquals("No son iguales", "F", sexo);
		assertEquals("Error", "", sexo);
		assertNotNull("Error, es nulo", sexo);
		
	}
	@Test
	public void testGetPassword() {
		
		String password=cliente.getPasswordCliente();
		assertEquals("Es igual", "123456Z", password);
		assertNotEquals("No son iguales", "123456T", password);
		assertEquals("Error", "", password);
		assertNotNull("Error, es nulo", password);
		
	}
	@Test
	public void testSetDni() {

		cliente.setDniCliente("87654321D");
		assertEquals("87654321D", cliente.getDniCliente());
		assertNotEquals("Codigo no correcto", "12345678D", cliente.getDniCliente());
		assertEquals("Error en el Codigo", 99, cliente.getDniCliente());

	}
	@Test
	public void testSetNombre() {

		cliente.setNombreCliente("Edgar");
		assertEquals("Edgar", cliente.getNombreCliente());
		assertNotEquals("Codigo no correcto", "DANIEL", cliente.getNombreCliente());
		assertEquals("Error en el Codigo", "Error", cliente.getNombreCliente());

	}
	@Test
	public void testSetApellidos() {

		cliente.setApellidosCliente("Hurtado");
		assertEquals("Hurtado", cliente.getApellidosCliente());
		assertNotEquals("Codigo no correcto", "Caballero", cliente.getApellidosCliente());
		assertEquals("Error en el Codigo", "Error", cliente.getApellidosCliente());

	}
	@Test
	public void testSetSexo() {

		cliente.setSexoCliente("F");
		assertEquals("F", cliente.getSexoCliente());
		assertNotEquals("Codigo no correcto", "M", cliente.getSexoCliente());
		assertEquals("Error en el Codigo", "Error", cliente.getSexoCliente());

	}
	@Test
	public void testSetPassword() {

		cliente.setPasswordCliente("654321Z");
		assertEquals("654321Z", cliente.getPasswordCliente());
		assertNotEquals("Codigo no correcto", "123456Z", cliente.getPasswordCliente());
		assertEquals("Error en el Codigo", "Error", cliente.getPasswordCliente());

	}
	@Test
	// en toString retornamos una cadena con la informacion del cliente incluyendo
	// el dni , el Nombre , el apellido, sexo y password comparamos con el string
	public void testToString() {
		String string = cliente.toString();
		assertEquals("Cliente [dniCliente=12345678D, nombreCliente=Daniel, apellidosCliente=Caballero, sexoCliente=M, passwordCliente=123456Z]", string);
		assertNotEquals("Cliente [dniCliente=12345678D, nombreCliente=Daniel, apellidosCliente=Caballero, sexoCliente=M, passwordCliente=123456Z]", string);
		assertEquals("Cliente [dniCliente=12345678z nombreCliente=Edgar, apellidosCliente=Caballero, sexoCliente=M, passwordCliente=123456Z]",string);
	}

	@Test
	// en Equals comparamos el Cliente con clienteNuevo y como sus valores son
	// distintos resultara en falso
	public void testEquals() {
		Cliente clienteNuevo =new Cliente("87654321D","Edgar","Hurtado","F","654321z");
		boolean esIgual = cliente.equals(clienteNuevo);
		assertEquals("Los objetos deben ser iguales", false, esIgual);
		assertNotEquals("Los objetos deben ser diferentes", true, esIgual);
	}

}
