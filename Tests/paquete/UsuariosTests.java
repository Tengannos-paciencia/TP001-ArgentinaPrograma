package paquete;

import static org.junit.Assert.*;
import org.junit.Test;

public class UsuariosTests {
// ------------------------------------------USUARIO--------------------------------------------------------------------------------------//
	@Test
	public void quePuedeCrearUsuario() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;

		Usuario usuarioPruebas = new Usuario("juan carlos", 150, 480, tipo);
		String expected = usuarioPruebas.getNombre() + ", Tipo de atraccion favorita: "
				+ usuarioPruebas.getTipoAtraccion() + "\nPromociones compradas:" + usuarioPruebas.promocionesAceptadas
				+ "\nAtracciones sin promo compradas: " + usuarioPruebas.atraccionesCompradas + "\n[Total a gastar:"
				+ usuarioPruebas.getCostoFinal() + ", Tiempo total estimado: " + usuarioPruebas.getTiempoFinal()
				+ "]\n\n";

		assertEquals(expected, usuarioPruebas.toString());
	}

	@Test
	public void quePuedeCrearUsuarioYPuedeComprar() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;

		Usuario usuarioPruebas = new Usuario("juan carlos", 150, 480, tipo);
		Atraccion atraccion1 = new Atraccion("primeraAtraccion", 15, 150, 12, tipo);

		assertTrue(usuarioPruebas.puedeComprar(atraccion1));
	}

	@Test
	public void usuarioNoPuedeComprarPorDinero() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;

		Usuario usuarioPruebas = new Usuario("juan carlos", 5, 480, tipo);
		Atraccion atraccion1 = new Atraccion("primeraAtraccion", 15, 150, 12, tipo);

		assertFalse(usuarioPruebas.puedeComprar(atraccion1));
	}

	@Test
	public void usuarioNoPuedeComprarPorTiempo() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;

		Usuario usuarioPruebas = new Usuario("juan carlos", 150, 25, tipo);
		Atraccion atraccion1 = new Atraccion("primeraAtraccion", 15, 150, 12, tipo);

		assertFalse(usuarioPruebas.puedeComprar(atraccion1));
	}

	@Test
	public void usuarioNoPuedeComprarPorCupo() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;

		Usuario usuarioPruebas = new Usuario("juan carlos", 150, 25, tipo);
		Atraccion atraccion1 = new Atraccion("primeraAtraccion", 15, 150, 0, tipo);

		assertFalse(usuarioPruebas.puedeComprar(atraccion1));
	}

	@Test
	public void usuarioVerificaAtraccionYaComprada() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;

		Usuario usuarioPruebas = new Usuario("juan carlos", 1500, 1500, tipo);

		Atraccion atraccion = new Atraccion("atraccionSimple", 15, 150, 12, tipo);

		usuarioPruebas.aceptarOfertado(atraccion);

		assertTrue(usuarioPruebas.atraccionYaComprada(atraccion));
	}

	@Test
	public void usuarioVerificaPromoYaComprada() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;

		Usuario usuarioPruebas = new Usuario("juan carlos", 1500, 1500, tipo);

		Atraccion atraccion1 = new Atraccion("primeraAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion2 = new Atraccion("segundaAtraccion", 25, 150, 12, tipo);
		Atraccion atraccion3 = new Atraccion("terceraAtraccion", 7, 150, 12, tipo);
		Atraccion atraccion4 = new Atraccion("cuartaAtraccion", 3, 150, 12, tipo);
		Atraccion[] atracciones = new Atraccion[] { atraccion1, atraccion2, atraccion3, atraccion4 };

		PromoAxB promo2x1 = new PromoAxB("pruebaPromoAxB", tipo, atracciones, 3);

		usuarioPruebas.aceptarOfertado(promo2x1);

		assertTrue(usuarioPruebas.atraccionYaComprada(promo2x1));
	}

}
