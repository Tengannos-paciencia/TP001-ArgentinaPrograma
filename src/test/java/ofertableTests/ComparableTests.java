package ofertableTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import model.Atraccion;
import model.Promocion;
import ofertable.ComparadorDeOfertables;
import promociones.PromoAxB;

public class ComparableTests {
	// ------------------------------------------COMPARABLE-----------------------------------------------------------------------------------//
	@Test
	public void queOrdeneCorrectamentePorCosto() {
		int tipo1 = 1;
		int tipo2 = 3;

		Atraccion atraccion1 = new Atraccion(1,"primeraAtraccionCosto", 15, 150, 12, tipo1);
		Atraccion atraccion2 = new Atraccion(2,"segundaAtraccionCosto", 25, 150, 12, tipo1);
		Atraccion atraccion3 = new Atraccion(3,"terceraAtraccionCosto", 500, 150, 12, tipo2);

		List<Atraccion> actualCosto = new ArrayList<Atraccion>();
		actualCosto.add(atraccion3);
		actualCosto.add(atraccion2);
		actualCosto.add(atraccion1);
		Collections.sort(actualCosto, new ComparadorDeOfertables(tipo1));
		
		List<Atraccion> expectedCosto = new ArrayList<Atraccion>();
		expectedCosto.add(atraccion2);
		expectedCosto.add(atraccion1);
		expectedCosto.add(atraccion3);
		assertEquals(expectedCosto, actualCosto);
		assertNotSame(expectedCosto, actualCosto);
	}

	@Test
	public void queOrdeneCorrectamentePorTiempo() {
		int tipo1 = 1;
		int tipo2 = 3;

		Atraccion atraccion1 = new Atraccion(1,"primeraAtraccionTiempo", 15, 150, 12, tipo1);
		Atraccion atraccion2 = new Atraccion(2,"segundaAtraccionTiempo", 15, 200, 12, tipo1);
		Atraccion atraccion3 = new Atraccion(3,"terceraAtraccionTiempo", 15, 350, 12, tipo2);

		
		List<Atraccion> actualTiempo = new ArrayList<Atraccion>();
		actualTiempo.add(atraccion3);
		actualTiempo.add(atraccion2);
		actualTiempo.add(atraccion1);

		Collections.sort(actualTiempo, new ComparadorDeOfertables(tipo1));

		List<Atraccion> expectedTiempo = new ArrayList<Atraccion>();
		expectedTiempo.add(atraccion2);
		expectedTiempo.add(atraccion1);
		expectedTiempo.add(atraccion3);

		assertEquals(expectedTiempo, actualTiempo);
		assertNotSame(expectedTiempo, actualTiempo);
	}

	@Test
	public void queOrdeneCorrectamentePorCostoYTiempo() {
		int tipo1 = 1;
		int tipo2 = 3;

		Atraccion atraccion1 = new Atraccion(1,"primeraAtraccionCosto", 15, 150, 12, tipo1);
		Atraccion atraccion2 = new Atraccion(2,"segundaAtraccionCosto", 25, 150, 12, tipo1);
		Atraccion atraccion5 = new Atraccion(5,"terceraAtraccionCosto", 500, 150, 12, tipo2);

		Atraccion atraccion3 = new Atraccion(3,"primeraAtraccionTiempo", 15, 150, 12, tipo1);
		Atraccion atraccion4 = new Atraccion(4,"segundaAtraccionTiempo", 15, 200, 12, tipo1);
		Atraccion atraccion6 = new Atraccion(6,"terceraAtraccionTiempo", 15, 350, 12, tipo2);

		List<Atraccion> actualCosto = new ArrayList<Atraccion>();
		actualCosto.add(atraccion2);
		actualCosto.add(atraccion5);
		actualCosto.add(atraccion1);
		List<Atraccion> actualTiempo = new ArrayList<Atraccion>();
		actualTiempo.add(atraccion4);
		actualTiempo.add(atraccion6);
		actualTiempo.add(atraccion3);

		Collections.sort(actualCosto, new ComparadorDeOfertables(tipo1)); // ordena por COSTO
		Collections.sort(actualTiempo, new ComparadorDeOfertables(tipo1)); // ordena por TIEMPO

		List<Atraccion> expectedCosto = new ArrayList<Atraccion>();
		expectedCosto.add(atraccion2);
		expectedCosto.add(atraccion1);
		expectedCosto.add(atraccion5);

		List<Atraccion> expectedTiempo = new ArrayList<Atraccion>();
		expectedTiempo.add(atraccion4);
		expectedTiempo.add(atraccion3);
		expectedTiempo.add(atraccion6);

		assertEquals(expectedCosto, actualCosto);
		assertNotSame(expectedCosto, actualCosto);

		assertEquals(expectedTiempo, actualTiempo);
		assertNotSame(expectedTiempo, actualTiempo);
	}

	@Test
	public void queOrdeneCorrectamentePromos() {
		int tipo1 = 1;

		Atraccion atraccion1 = new Atraccion(1,"primeraAtraccionPromoA", 15, 150, 12, tipo1);
		Atraccion atraccion2 = new Atraccion(2,"segundaAtraccionPromoA", 25, 150, 12, tipo1);
		Atraccion atraccion5 = new Atraccion(5,"terceraAtraccionPromoA", 500, 150, 12, tipo1);

		Atraccion atraccion3 = new Atraccion(3,"primeraAtraccionPromoB", 15, 150, 12, tipo1);
		Atraccion atraccion4 = new Atraccion(4,"segundaAtraccionPromoB", 15, 200, 12, tipo1);
		Atraccion atraccion6 = new Atraccion(6,"terceraAtraccionPromoB", 15, 350, 12, tipo1);

		List<Atraccion> atraccionesA = new ArrayList<Atraccion>();
		atraccionesA.add(atraccion1);
		atraccionesA.add(atraccion2);
		atraccionesA.add(atraccion5);
		PromoAxB promo1 = new PromoAxB("pruebaPromoAxB", tipo1, atraccionesA, 0);

		List<Atraccion> atraccionesB = new ArrayList<Atraccion>();
		atraccionesB.add(atraccion3);
		atraccionesB.add(atraccion4);
		atraccionesB.add(atraccion6);
		PromoAxB promo2 = new PromoAxB("pruebaPromoAxB", tipo1, atraccionesB, 0);

		List<Promocion> actual = new ArrayList<Promocion>();
		actual.add(promo2);
		actual.add(promo1);
		List<Promocion> expected = new ArrayList<Promocion>();
		expected.add(promo1);
		expected.add(promo2);

		Collections.sort(actual, new ComparadorDeOfertables(tipo1));

		assertEquals(expected, actual);
		assertNotSame(expected, actual);
	}

}
