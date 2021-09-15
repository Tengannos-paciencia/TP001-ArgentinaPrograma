package paquete;

import static org.junit.Assert.*;

import org.junit.Test;

public class OfertableTests {

	@Test
	public void verificaPromocion() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;
		Atraccion atraccion1 = new Atraccion("primeraAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion2 = new Atraccion("segundaAtraccion", 15, 150, 12, tipo);
		Atraccion[] arrayAtracciones = { atraccion1, atraccion2 };

		Promocion promo1 = new PromoAxB("promo1", tipo, arrayAtracciones, 0);

		assertTrue(promo1.esPromocion());
	}

	@Test
	public void verificaAtraccion() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;
		Atraccion atraccion1 = new Atraccion("primeraAtraccion", 15, 150, 12, tipo);

		assertTrue(atraccion1.esAtraccion());
	}

	@Test
	public void noVerificaPromocion() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;
		Atraccion atraccion1 = new Atraccion("primeraAtraccion", 15, 150, 12, tipo);

		assertFalse(atraccion1.esPromocion());
	}

	@Test
	public void noVerificaAtraccion() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;
		Atraccion atraccion1 = new Atraccion("primeraAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion2 = new Atraccion("segundaAtraccion", 15, 150, 12, tipo);
		Atraccion[] arrayAtracciones = { atraccion1, atraccion2 };

		Promocion promo1 = new PromoAxB("promo1", tipo, arrayAtracciones, 0);
		assertFalse(promo1.esAtraccion());

	}

}
