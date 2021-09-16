package paquete;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

public class ComparablesTests {
//------------------------------------------COMPARABLE-----------------------------------------------------------------------------------//
	@Test
	public void queOrdeneCorrectamentePorCosto() {
		TipoAtraccion tipo1 = TipoAtraccion.TERROR;
		TipoAtraccion tipo2 = TipoAtraccion.EXPLORACION;

		Atraccion atraccion1 = new Atraccion("primeraAtraccionCosto", 15, 150, 12, tipo1);
		Atraccion atraccion2 = new Atraccion("segundaAtraccionCosto", 25, 150, 12, tipo1);
		Atraccion atraccion3 = new Atraccion("terceraAtraccionCosto", 500, 150, 12, tipo2);

		Atraccion[] actualCosto = { atraccion3, atraccion2, atraccion1 };

		Arrays.sort(actualCosto, new ComparadorDeOfertables(tipo1));

		Atraccion[] expectedCosto = { atraccion2, atraccion1, atraccion3 };

		assertArrayEquals(expectedCosto, actualCosto);
		assertNotSame(expectedCosto, actualCosto);
	}

	@Test
	public void queOrdeneCorrectamentePorTiempo() {
		TipoAtraccion tipo1 = TipoAtraccion.TERROR;
		TipoAtraccion tipo2 = TipoAtraccion.EXPLORACION;

		Atraccion atraccion1 = new Atraccion("primeraAtraccionTiempo", 15, 150, 12, tipo1);
		Atraccion atraccion2 = new Atraccion("segundaAtraccionTiempo", 15, 200, 12, tipo1);
		Atraccion atraccion3 = new Atraccion("terceraAtraccionTiempo", 15, 350, 12, tipo2);

		Atraccion[] actualTiempo = { atraccion3, atraccion2, atraccion1 };

		Arrays.sort(actualTiempo, new ComparadorDeOfertables(tipo1));

		Atraccion[] expectedTiempo = { atraccion2, atraccion1, atraccion3 };

		assertArrayEquals(expectedTiempo, actualTiempo);
		assertNotSame(expectedTiempo, actualTiempo);
	}

	@Test
	public void queOrdeneCorrectamentePorCostoYTiempo() {
		TipoAtraccion tipo1 = TipoAtraccion.TERROR;
		TipoAtraccion tipo2 = TipoAtraccion.EXPLORACION;

		Atraccion atraccion1 = new Atraccion("primeraAtraccionCosto", 15, 150, 12, tipo1);
		Atraccion atraccion2 = new Atraccion("segundaAtraccionCosto", 25, 150, 12, tipo1);
		Atraccion atraccion5 = new Atraccion("terceraAtraccionCosto", 500, 150, 12, tipo2);

		Atraccion atraccion3 = new Atraccion("primeraAtraccionTiempo", 15, 150, 12, tipo1);
		Atraccion atraccion4 = new Atraccion("segundaAtraccionTiempo", 15, 200, 12, tipo1);
		Atraccion atraccion6 = new Atraccion("terceraAtraccionTiempo", 15, 350, 12, tipo2);

		Atraccion[] actualCosto = { atraccion2, atraccion5, atraccion1 };
		Atraccion[] actualTiempo = { atraccion4, atraccion6, atraccion3 };

		Arrays.sort(actualCosto, new ComparadorDeOfertables(tipo1)); // ordena por COSTO
		Arrays.sort(actualTiempo, new ComparadorDeOfertables(tipo1)); // ordena por TIEMPO

		Atraccion[] expectedCosto = { atraccion2, atraccion1, atraccion5 };

		Atraccion[] expectedTiempo = { atraccion4, atraccion3, atraccion6 };

		assertArrayEquals(expectedCosto, actualCosto);
		assertNotSame(expectedCosto, actualCosto);

		assertArrayEquals(expectedTiempo, actualTiempo);
		assertNotSame(expectedTiempo, actualTiempo);
	}

	@Test
	public void queOrdeneCorrectamentePromos() {
		TipoAtraccion tipo1 = TipoAtraccion.TERROR;

		Atraccion atraccion1 = new Atraccion("primeraAtraccionPromoA", 15, 150, 12, tipo1);
		Atraccion atraccion2 = new Atraccion("segundaAtraccionPromoA", 25, 150, 12, tipo1);
		Atraccion atraccion5 = new Atraccion("terceraAtraccionPromoA", 500, 150, 12, tipo1);

		Atraccion atraccion3 = new Atraccion("primeraAtraccionPromoB", 15, 150, 12, tipo1);
		Atraccion atraccion4 = new Atraccion("segundaAtraccionPromoB", 15, 200, 12, tipo1);
		Atraccion atraccion6 = new Atraccion("terceraAtraccionPromoB", 15, 350, 12, tipo1);

		Atraccion[] atraccionesA = { atraccion1, atraccion2, atraccion5 };
		PromoAxB promo1 = new PromoAxB("pruebaPromoAxB", tipo1, atraccionesA, 0);

		Atraccion[] atraccionesB = { atraccion3, atraccion4, atraccion6 };
		PromoAxB promo2 = new PromoAxB("pruebaPromoAxB", tipo1, atraccionesB, 0);

		Promocion[] actual = { promo2, promo1 };
		Promocion[] expected = { promo1, promo2 };

		Arrays.sort(actual, new ComparadorDeOfertables(tipo1));

		assertArrayEquals(expected, actual);
		assertNotSame(expected, actual);
	}

}
