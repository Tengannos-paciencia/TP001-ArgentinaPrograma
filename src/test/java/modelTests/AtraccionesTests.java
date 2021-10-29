package modelTests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Atraccion;

public class AtraccionesTests {
	// -------------------------------------ATRACCIONES
	// TEST----------------------------------------------------------//
	@Test
	public void quePuedeCrearAtraccion() {
		int tipo = 1;

		Atraccion atraccion1 = new Atraccion(1,"primeraAtraccion", 15, 150, 12, tipo);
		String expected = "[primeraAtraccion, costo: 15 monedas, tiempo: 150 minutos, cupo: 12, tipo: 1]\n";

		assertEquals(expected, atraccion1.toString());
	}

	@Test
	public void quePuedeCrearAtraccionYCalcularCosto() {
		int tipo = 1;

		Atraccion atraccion1 = new Atraccion(1,"primeraAtraccion", 15, 150, 12, tipo);
		int expected = 15;

		assertEquals(expected, atraccion1.getCosto());
	}

	@Test
	public void quePuedeCrearAtraccionYCalcularTiempo() {
		int tipo = 1;

		Atraccion atraccion1 = new Atraccion(1,"primeraAtraccion", 15, 150, 12, tipo);
		int expected = 150;

		assertEquals(expected, atraccion1.getTiempo());
	}

	@Test
	public void quePuedeCrearAtraccionYCalcularCupo() {
		int tipo = 1;

		Atraccion atraccion1 = new Atraccion(1,"primeraAtraccion", 15, 150, 12, tipo);
		int expected = 12;

		assertEquals(expected, atraccion1.getCupo());
	}

	@Test
	public void quePuedeCrearAtraccionYMostrarTipo() {
		int tipo = 1;

		Atraccion atraccion1 = new Atraccion(1,"primeraAtraccion", 15, 150, 12, tipo);
		int expected = atraccion1.getTipo();

		assertEquals(expected, atraccion1.getTipo());
	}
}
