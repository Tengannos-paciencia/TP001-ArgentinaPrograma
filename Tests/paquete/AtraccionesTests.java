package paquete;

import static org.junit.Assert.*;
import org.junit.Test;

public class AtraccionesTests {
//-------------------------------------ATRACCIONES TEST----------------------------------------------------------//
	@Test
	public void quePuedeCrearAtraccion() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;

		Atraccion atraccion1 = new Atraccion("primeraAtraccion", 15, 150, 12, tipo);
		String expected = "[primeraAtraccion, costo: 15 monedas, tiempo: 150 minutos, cupo: 12, tipo: TERROR]\n";

		assertEquals(expected, atraccion1.toString());
	}

	@Test
	public void quePuedeCrearAtraccionYCalcularCosto() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;

		Atraccion atraccion1 = new Atraccion("primeraAtraccion", 15, 150, 12, tipo);
		int expected = 15;

		assertEquals(expected, atraccion1.getCosto());
	}

	@Test
	public void quePuedeCrearAtraccionYCalcularTiempo() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;

		Atraccion atraccion1 = new Atraccion("primeraAtraccion", 15, 150, 12, tipo);
		int expected = 150;

		assertEquals(expected, atraccion1.getTiempo());
	}

	@Test
	public void quePuedeCrearAtraccionYCalcularCupo() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;

		Atraccion atraccion1 = new Atraccion("primeraAtraccion", 15, 150, 12, tipo);
		int expected = 12;

		assertEquals(expected, atraccion1.getCupo());
	}

	@Test
	public void quePuedeCrearAtraccionYMostrarTipo() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;

		Atraccion atraccion1 = new Atraccion("primeraAtraccion", 15, 150, 12, tipo);
		TipoAtraccion expected = atraccion1.getTipo();

		assertEquals(expected, atraccion1.getTipo());
	}

}