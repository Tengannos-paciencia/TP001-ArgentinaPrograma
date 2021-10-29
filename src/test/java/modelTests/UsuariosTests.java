package modelTests;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import model.Atraccion;
import model.Usuario;
import promociones.PromoAxB;

public class UsuariosTests {

	// ------------------------------------------USUARIO--------------------------------------------------------------------------------------//
	@Test
	public void quePuedeCrearUsuario() {
		int tipo = 1;

		Usuario usuarioPruebas = new Usuario(1, "juan carlos", 150, 480, tipo);
		String expected = usuarioPruebas.getNombre() + ", Tipo de atraccion favorita: "
				+ usuarioPruebas.nombreTipo() + "\nPromociones compradas:" + usuarioPruebas.getPromocionesAceptadas()
				+ "\nAtracciones sin promo compradas: " + usuarioPruebas.getAtraccionesCompradas() + "\n[Total a gastar:"
				+ usuarioPruebas.getCostoFinal() + ", Tiempo total estimado: " + usuarioPruebas.getTiempoFinal()
				+ "]\n\n";

		assertEquals(expected, usuarioPruebas.toString());
	}

	@Test
	public void quePuedeCrearUsuarioYPuedeComprar() {
		int tipo = 1;

		Usuario usuarioPruebas = new Usuario(1, "juan carlos", 150, 480, tipo);
		Atraccion atraccion1 = new Atraccion(1, "primeraAtraccion", 15, 150, 12, tipo);

		assertTrue(usuarioPruebas.puedeComprar(atraccion1));
	}

	@Test
	public void usuarioNoPuedeComprarPorDinero() {
		int tipo = 1;

		Usuario usuarioPruebas = new Usuario(1,"juan carlos", 5, 480, tipo);
		Atraccion atraccion1 = new Atraccion(1,"primeraAtraccion", 15, 150, 12, tipo);

		assertFalse(usuarioPruebas.puedeComprar(atraccion1));
	}

	@Test
	public void usuarioNoPuedeComprarPorTiempo() {
		int tipo = 1;

		Usuario usuarioPruebas = new Usuario(1,"juan carlos", 150, 25, tipo);
		Atraccion atraccion1 = new Atraccion(1,"primeraAtraccion", 15, 150, 12, tipo);

		assertFalse(usuarioPruebas.puedeComprar(atraccion1));
	}

	@Test
	public void usuarioNoPuedeComprarPorCupo() {
		int tipo = 1;

		Usuario usuarioPruebas = new Usuario(1,"juan carlos", 150, 25, tipo);
		Atraccion atraccion1 = new Atraccion(1,"primeraAtraccion", 15, 150, 0, tipo);

		assertFalse(usuarioPruebas.puedeComprar(atraccion1));
	}

	@Test
	public void usuarioVerificaAtraccionYaComprada() {
		int tipo = 1;

		Usuario usuarioPruebas = new Usuario(1,"juan carlos", 1500, 1500, tipo);

		Atraccion atraccion = new Atraccion(1,"atraccionSimple", 15, 150, 12, tipo);

		usuarioPruebas.aceptarOfertado(atraccion);

		assertTrue(usuarioPruebas.atraccionYaComprada(atraccion));
	}

	@Test
	public void usuarioVerificaPromoYaComprada() {
		int tipo = 1;

		Usuario usuarioPruebas = new Usuario(1,"juan carlos", 1500, 1500, tipo);

		Atraccion atraccion1 = new Atraccion(1,"primeraAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion2 = new Atraccion(2,"segundaAtraccion", 25, 150, 12, tipo);
		Atraccion atraccion3 = new Atraccion(3,"terceraAtraccion", 7, 150, 12, tipo);
		Atraccion atraccion4 = new Atraccion(4,"cuartaAtraccion", 3, 150, 12, tipo);
		List<Atraccion> atracciones = new LinkedList<Atraccion>();
		atracciones.add(atraccion1);
		atracciones.add(atraccion2);
		atracciones.add(atraccion3);
		atracciones.add(atraccion4);
		PromoAxB promo2x1 = new PromoAxB("pruebaPromoAxB", tipo, atracciones, 3);

		usuarioPruebas.aceptarOfertado(promo2x1);

		assertTrue(usuarioPruebas.atraccionYaComprada(promo2x1));
	}

}
