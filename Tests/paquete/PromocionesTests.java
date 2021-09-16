package paquete;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

public class PromocionesTests {
//-------------------------------------------PROMOCION ABSOLUTA TEST-------------------------------------------------------------------//

	@Test
	public void quePuedeCrearPromoAbsolutaAfirmativo() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;

		Atraccion atraccion1 = new Atraccion("primeraAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion2 = new Atraccion("segundaAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion3 = new Atraccion("terceraAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion4 = new Atraccion("cuartaAtraccion", 15, 150, 12, tipo);
		Atraccion[] atracciones = new Atraccion[] { atraccion1, atraccion2, atraccion3, atraccion4 };

		PromoAbsoluto promo1 = new PromoAbsoluto("pruebaDePromoAbsoluta", tipo, atracciones, 45);

		String expected = "------PROMO GUISO ESPELUZNANTE------ incluye:\n" + Arrays.toString(atracciones)
				+ "\nCosto con descuento: " + promo1.getCostoTotal() + ", tiempo total: " + promo1.getTiempoTotal()
				+ " minutos\n";

		assertEquals(expected, promo1.toString());
	}

	@Test
	public void quePuedeCrearPromoAbsolutaNegativo() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;

		Atraccion atraccion1 = new Atraccion("primeraAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion2 = new Atraccion("segundaAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion3 = new Atraccion("terceraAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion4 = new Atraccion("cuartaAtraccion", 15, 150, 12, tipo);
		Atraccion[] atracciones = new Atraccion[] { atraccion1, atraccion2, atraccion3, atraccion4 };

		PromoAbsoluto promo1 = new PromoAbsoluto("pruebaDePromoAbsoluta", tipo, atracciones, 45);

		String expected = "------PROMO GUISO ESPELUZNANTE------ incluye: \n" + Arrays.toString(atracciones)
				+ "\nCosto final: " + (promo1.getCostoTotal() - 5) + ", tiempo total: " + promo1.getTiempoTotal()
				+ " minutos\n";

		assertNotEquals(expected, promo1.toString());
	}

//-------------------------------------------PROMOCION PORCENTUAL TEST-----------------------------------------------------------------//

	@Test
	public void quePuedeCrearPromoPorcentualAfirmativo() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;

		Atraccion atraccion1 = new Atraccion("primeraAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion2 = new Atraccion("segundaAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion3 = new Atraccion("terceraAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion4 = new Atraccion("cuartaAtraccion", 15, 150, 12, tipo);
		Atraccion[] atracciones = new Atraccion[] { atraccion1, atraccion2, atraccion3, atraccion4 };

		PromoPorcentual promoPorcentual = new PromoPorcentual("pruebaPromoPorcentual", tipo, atracciones, 25);

		String expected = "------PROMO 25% OFF!------ incluye:\n" + Arrays.toString(atracciones)
				+ "\nCosto con descuento: " + promoPorcentual.getCostoTotal() + ", tiempo total: "
				+ promoPorcentual.getTiempoTotal() + " minutos\n";

		assertEquals(expected, promoPorcentual.toString());
	}

	@Test
	public void quePuedeCrearPromoPorcentualNegativo() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;

		Atraccion atraccion1 = new Atraccion("primeraAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion2 = new Atraccion("segundaAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion3 = new Atraccion("terceraAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion4 = new Atraccion("cuartaAtraccion", 15, 150, 12, tipo);
		Atraccion[] atracciones = new Atraccion[] { atraccion1, atraccion2, atraccion3, atraccion4 };

		PromoPorcentual promoPorcentual = new PromoPorcentual("pruebaPromoPorcentual", tipo, atracciones, 25);

		String expected = "------PROMO 25% OFF!------ incluye:\n" + Arrays.toString(atracciones) + "\nCosto final: "
				+ (promoPorcentual.getCostoTotal() - 5) + ", tiempo total: " + promoPorcentual.getTiempoTotal()
				+ " minutos\n";

		assertNotEquals(expected, promoPorcentual.toString());
	}
//------------------------------------------PROMOCION A*B TEST-------------------------------------------------------------------------//

	@Test
	public void quePuedeCrearPromoAxB_Afirmativo() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;

		Atraccion atraccion1 = new Atraccion("primeraAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion2 = new Atraccion("segundaAtraccion", 25, 150, 12, tipo);
		Atraccion atraccion3 = new Atraccion("terceraAtraccion", 7, 150, 12, tipo);
		Atraccion atraccion4 = new Atraccion("cuartaAtraccion", 3, 150, 12, tipo);
		Atraccion[] atracciones = new Atraccion[] { atraccion1, atraccion2, atraccion3, atraccion4 };

		PromoAxB promo2x1 = new PromoAxB("pruebaPromoAxB", tipo, atracciones, 3);

		String expected = "------PROMO 2x1!------ incluye:\n" + Arrays.toString(atracciones) + "\nCosto con descuento: "
				+ promo2x1.getCostoTotal() + ", tiempo total: " + promo2x1.getTiempoTotal() + " minutos\n";

		assertEquals(expected, promo2x1.toString());
	}

	@Test
	public void quePuedeCrearPromoAxB_Negativo() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;

		Atraccion atraccion1 = new Atraccion("primeraAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion2 = new Atraccion("segundaAtraccion", 18, 150, 12, tipo);
		Atraccion atraccion3 = new Atraccion("terceraAtraccion", 9, 150, 12, tipo);
		Atraccion atraccion4 = new Atraccion("cuartaAtraccion", 5, 150, 12, tipo);
		Atraccion[] atracciones = new Atraccion[] { atraccion1, atraccion2, atraccion3, atraccion4 };

		PromoAxB promo2x1 = new PromoAxB("pruebaPromoAxB", tipo, atracciones, 1);

		String expected = "------PROMO 22x1!------ incluye:\n" + Arrays.toString(atracciones) + "\nCosto final: "
				+ promo2x1.getCostoTotal() + ", tiempo total: " + promo2x1.getCostoTotal() + " minutos\n";

		assertNotEquals(expected, promo2x1.toString());
	}

}
