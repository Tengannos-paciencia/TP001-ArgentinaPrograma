package modelTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import model.Atraccion;
import promociones.PromoAbsoluto;
import promociones.PromoAxB;
import promociones.PromoPorcentual;

public class PromocionesTests {
	// -------------------------------------------PROMOCION ABSOLUTA
	// TEST-------------------------------------------------------------------//

	@Test
	public void quePuedeCrearPromoAbsolutaAfirmativo() {
		int tipo = 1;

		Atraccion atraccion1 = new Atraccion(1,"primeraAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion2 = new Atraccion(2,"segundaAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion3 = new Atraccion(3,"terceraAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion4 = new Atraccion(4,"cuartaAtraccion", 15, 150, 12, tipo);
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(atraccion1);
		atracciones.add(atraccion2);
		atracciones.add(atraccion3);
		atracciones.add(atraccion4);
		PromoAbsoluto promo1 = new PromoAbsoluto("pruebaDePromoAbsoluta", tipo, atracciones, 45);

		String expected = "------PROMO GUISO ESPELUZNANTE------ incluye:\n" + atracciones
				+ "\nCosto con descuento: " + promo1.getCostoTotal() + ", tiempo total: " + promo1.getTiempoTotal()
				+ " minutos\n";

		assertEquals(expected, promo1.toString());
	}

	@Test
	public void quePuedeCrearPromoAbsolutaNegativo() {
		int tipo = 1;

		Atraccion atraccion1 = new Atraccion(1,"primeraAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion2 = new Atraccion(2,"segundaAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion3 = new Atraccion(3,"terceraAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion4 = new Atraccion(4,"cuartaAtraccion", 15, 150, 12, tipo);

		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(atraccion1);
		atracciones.add(atraccion2);
		atracciones.add(atraccion3);
		atracciones.add(atraccion4);
		
		PromoAbsoluto promo1 = new PromoAbsoluto("pruebaDePromoAbsoluta", tipo, atracciones, 45);
		
		String expected = "------PROMO GUISO ESPELUZNANTE------ incluye: \n" + atracciones
				+ "\nCosto final: " + (promo1.getCostoTotal() - 5) + ", tiempo total: " + promo1.getTiempoTotal()
				+ " minutos\n";

		assertNotEquals(expected, promo1.toString());
	}

	// -------------------------------------------PROMOCION PORCENTUAL
	// TEST-----------------------------------------------------------------//

	@Test
	public void quePuedeCrearPromoPorcentualAfirmativo() {
		int tipo = 1;

		Atraccion atraccion1 = new Atraccion(1,"primeraAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion2 = new Atraccion(2,"segundaAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion3 = new Atraccion(3,"terceraAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion4 = new Atraccion(4,"cuartaAtraccion", 15, 150, 12, tipo);
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(atraccion1);
		atracciones.add(atraccion2);
		atracciones.add(atraccion3);
		atracciones.add(atraccion4);

		PromoPorcentual promoPorcentual = new PromoPorcentual("pruebaPromoPorcentual", tipo, atracciones, 25);

		String expected = "------PROMO 25% OFF!------ incluye:\n" + atracciones
				+ "\nCosto con descuento: " + promoPorcentual.getCostoTotal() + ", tiempo total: "
				+ promoPorcentual.getTiempoTotal() + " minutos\n";

		assertEquals(expected, promoPorcentual.toString());
	}

	@Test
	public void quePuedeCrearPromoPorcentualNegativo() {
		int tipo = 1;

		Atraccion atraccion1 = new Atraccion(1,"primeraAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion2 = new Atraccion(2,"segundaAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion3 = new Atraccion(3,"terceraAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion4 = new Atraccion(4,"cuartaAtraccion", 15, 150, 12, tipo);
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(atraccion1);
		atracciones.add(atraccion2);
		atracciones.add(atraccion3);
		atracciones.add(atraccion4);

		PromoPorcentual promoPorcentual = new PromoPorcentual("pruebaPromoPorcentual", tipo, atracciones, 25);

		String expected = "------PROMO 25% OFF!------ incluye:\n" + atracciones + "\nCosto final: "
				+ (promoPorcentual.getCostoTotal() - 5) + ", tiempo total: " + promoPorcentual.getTiempoTotal()
				+ " minutos\n";

		assertNotEquals(expected, promoPorcentual.toString());
	}
	// ------------------------------------------PROMOCION A*B
	// TEST-------------------------------------------------------------------------//

	@Test
	public void quePuedeCrearPromoAxB_Afirmativo() {
		int tipo = 1;

		Atraccion atraccion1 = new Atraccion(1,"primeraAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion2 = new Atraccion(2,"segundaAtraccion", 25, 150, 12, tipo);
		Atraccion atraccion3 = new Atraccion(3,"terceraAtraccion", 7, 150, 12, tipo);
		Atraccion atraccion4 = new Atraccion(4,"cuartaAtraccion", 3, 150, 12, tipo);
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(atraccion1);
		atracciones.add(atraccion2);
		atracciones.add(atraccion3);
		atracciones.add(atraccion4);

		PromoAxB promo2x1 = new PromoAxB("pruebaPromoAxB", tipo, atracciones, 3);

		String expected = "------PROMO 2x1!------ incluye:\n" + atracciones + "\nCosto con descuento: "
				+ promo2x1.getCostoTotal() + ", tiempo total: " + promo2x1.getTiempoTotal() + " minutos\n";

		assertEquals(expected, promo2x1.toString());
	}

	@Test
	public void quePuedeCrearPromoAxB_Negativo() {
		int tipo = 1;

		Atraccion atraccion1 = new Atraccion(1,"primeraAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion2 = new Atraccion(2,"segundaAtraccion", 18, 150, 12, tipo);
		Atraccion atraccion3 = new Atraccion(3,"terceraAtraccion", 9, 150, 12, tipo);
		Atraccion atraccion4 = new Atraccion(4,"cuartaAtraccion", 5, 150, 12, tipo);
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(atraccion1);
		atracciones.add(atraccion2);
		atracciones.add(atraccion3);
		atracciones.add(atraccion4);

		PromoAxB promo2x1 = new PromoAxB("pruebaPromoAxB", tipo, atracciones, 1);

		String expected = "------PROMO 22x1!------ incluye:\n" + atracciones + "\nCosto final: "
				+ promo2x1.getCostoTotal() + ", tiempo total: " + promo2x1.getCostoTotal() + " minutos\n";

		assertNotEquals(expected, promo2x1.toString());
	}

}
