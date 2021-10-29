package ofertableTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import model.Atraccion;
import model.Promocion;
import promociones.PromoAxB;

public class OfertableTests {

	@Test
	public void verificaPromocion() {
		int tipo = 1;
		Atraccion atraccion1 = new Atraccion(1, "primeraAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion2 = new Atraccion(2, "segundaAtraccion", 15, 150, 12, tipo);
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(atraccion1);
		atracciones.add(atraccion2);

		Promocion promo1 = new PromoAxB("promo1", tipo, atracciones, 0);

		assertTrue(promo1.esPromocion());
	}

	@Test
	public void verificaAtraccion() {
		int tipo = 1;
		Atraccion atraccion1 = new Atraccion(1, "primeraAtraccion", 15, 150, 12, tipo);

		assertTrue(atraccion1.esAtraccion());
	}

	@Test
	public void noVerificaPromocion() {
		int tipo = 1;
		Atraccion atraccion1 = new Atraccion(1, "primeraAtraccion", 15, 150, 12, tipo);

		assertFalse(atraccion1.esPromocion());
	}

	@Test
	public void noVerificaAtraccion() {
		int tipo = 1;
		Atraccion atraccion1 = new Atraccion(1, "primeraAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion2 = new Atraccion(2, "segundaAtraccion", 15, 150, 12, tipo);
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(atraccion1);
		atracciones.add(atraccion2);
		Promocion promo1 = new PromoAxB("promo1", tipo, atracciones, 0);
		assertFalse(promo1.esAtraccion());

	}
}
