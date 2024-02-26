package bbdd.gestoresJUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import bbdd.gestores.GestorCines;
import bbdd.pojos.Cine;

class GestorCinesTest {

	GestorCines gestorCines = new GestorCines();

	@Test
	void testObtenerListaDeCines() {

		// Llamar al método para obtener la lista de cines
		ArrayList<Cine> listaDeCines = gestorCines.obtenerListaDeCines();
		// Verificar que la lista contenga 3 cines
		assertTrue(listaDeCines.size() == 3);
	}

	@Test
	void listaContieneAlMenosUnCine() {

		ArrayList<Cine> listaDeCines = gestorCines.obtenerListaDeCines();
		// Verificar que la lista contenga al menos un cine
		assertTrue(listaDeCines.size() > 0);
	}

	@Test
	void listaNoEsNula() {

		ArrayList<Cine> listaDeCines = gestorCines.obtenerListaDeCines();
		// Verificar que la lista no sea nula
		assertNotNull(listaDeCines);
	}
}//.
