package paquete;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedInputStream;
import org.junit.Test;

public class TierraMediaTests {
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

//------------------------------------------MANEJO DE ARCHIVOS TESTS-----------------------------------------------------------//

	@Test
	public void quePuedeCrearUsuariosDesdeArchivoAfirmativo() throws Exception {
		Usuario[] usuarios = ManejadorDeArchivos.obtenerUsuarioDesdeArchivo("archivos_entrada/usuarios.txt");

		assertNotNull(usuarios);
	}

	@Test
	public void quePuedeCrearUsuariosDesdeArchivoNegativo() throws Exception {
		Usuario[] usuarios = ManejadorDeArchivos.obtenerUsuarioDesdeArchivo("archivos_entrada/usuarioss.txt");

		assertNull(usuarios);
	}

	@Test
	public void quePuedeCrearAtraccionDesdeArchivoAfirmativo() throws Exception {
		Atraccion[] atracciones = ManejadorDeArchivos
				.obtenerAtraccionesDesdeArchivo("archivos_entrada/atracciones.txt");

		assertNotNull(atracciones);
	}

	@Test
	public void quePuedeCrearAtraccionDesdeArchivoNegativo() throws Exception {
		Atraccion[] atracciones = ManejadorDeArchivos
				.obtenerAtraccionesDesdeArchivo("archivos_entrada/atraccioness.txt");

		assertNull(atracciones);
	}

	@Test
	public void quePuedeCrearPromosDesdeArchivoAfirmativo() throws Exception {
		Taquilla nuevaTaquilla = new Taquilla();
		nuevaTaquilla.agregarTodosLosUsuarios(
				ManejadorDeArchivos.obtenerUsuarioDesdeArchivo("archivos_entrada/usuarios.txt"));
		nuevaTaquilla.agregarTodasLasAtracciones(
				ManejadorDeArchivos.obtenerAtraccionesDesdeArchivo("archivos_entrada/atracciones.txt"));
		nuevaTaquilla.agregarTodasLasPromociones(
				ManejadorDeArchivos.obtenerPromosDesdeArchivo(nuevaTaquilla, "archivos_entrada/promociones.txt"));

		Promocion[] promociones = ManejadorDeArchivos.obtenerPromosDesdeArchivo(nuevaTaquilla,
				"archivos_entrada/promociones.txt");

		assertNotNull(promociones);
	}

	@Test
	public void quePuedeCrearPromosDesdeArchivoNegativo() throws Exception {
		Taquilla nuevaTaquilla = new Taquilla();
		nuevaTaquilla.agregarTodosLosUsuarios(
				ManejadorDeArchivos.obtenerUsuarioDesdeArchivo("archivos_entrada/usuarios.txt")); //
		nuevaTaquilla.agregarTodasLasAtracciones(
				ManejadorDeArchivos.obtenerAtraccionesDesdeArchivo("archivos_entrada/atracciones.txt")); //
		nuevaTaquilla.agregarTodasLasPromociones(ManejadorDeArchivos.obtenerPromosDesdeArchivo(nuevaTaquilla, //
				"archivos_entrada/promociones.txt"));

		Promocion[] promociones = ManejadorDeArchivos.obtenerPromosDesdeArchivo(nuevaTaquilla,
				"archivos_entrada/promocioness.txt");

		assertNull(promociones);
	}

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

//------------------------------------------USUARIO--------------------------------------------------------------------------------------//
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

//------------------------------------------ITINERARIO-----------------------------------------------------------------------------------//	

	@Test
	public void queLosItineariosSeanIgualesPeroNoMismoArchivo() throws IOException {
		TipoAtraccion tipo = TipoAtraccion.TERROR;

		Usuario usuarioPruebas = new Usuario("juancito", 150, 480, tipo);

		Atraccion atraccion1 = new Atraccion("primeraAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion2 = new Atraccion("segundaAtraccion", 25, 150, 12, tipo);
		Atraccion atraccion3 = new Atraccion("terceraAtraccion", 7, 150, 12, tipo);
		Atraccion atraccion4 = new Atraccion("cuartaAtraccion", 3, 150, 12, tipo);
		Atraccion[] atracciones = new Atraccion[] { atraccion1, atraccion2, atraccion3, atraccion4 };

		PromoAxB promo2x1 = new PromoAxB("pruebaPromoAxB", tipo, atracciones, 3);

		usuarioPruebas.aceptarOfertado(promo2x1);
		ManejadorDeArchivos.crearItinerario(usuarioPruebas, "salida_test\\prueba_");

		BufferedInputStream actual = null;
		BufferedInputStream expected = null;

		try {
			actual = new BufferedInputStream(new FileInputStream("salida_test\\prueba_juancito.txt"));
			expected = new BufferedInputStream(new FileInputStream("salida_test\\prueba_juancitoExpected.txt"));

			assertArrayEquals(expected.readAllBytes(), actual.readAllBytes());
			assertNotSame(expected, actual);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}

	}

	@Test
	public void queLosItinerariosSeanDistintosArchivosYContenido() throws IOException {
		TipoAtraccion tipo = TipoAtraccion.TERROR;

		Usuario usuarioPruebas = new Usuario("martin", 150, 480, tipo);

		Atraccion atraccion1 = new Atraccion("primeraAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion2 = new Atraccion("segundaAtraccion", 25, 150, 12, tipo);
		Atraccion atraccion3 = new Atraccion("terceraAtraccion", 7, 150, 12, tipo);
		Atraccion atraccion4 = new Atraccion("cuartaAtraccion", 3, 150, 12, tipo);
		Atraccion[] atracciones = new Atraccion[] { atraccion1, atraccion2, atraccion3, atraccion4 };

		PromoAxB promo2x1 = new PromoAxB("pruebaPromoAxB", tipo, atracciones, 3);

		usuarioPruebas.aceptarOfertado(promo2x1);
		ManejadorDeArchivos.crearItinerario(usuarioPruebas, "salida_test\\prueba_");

		BufferedInputStream actual = null;
		BufferedInputStream expected = null;

		try {
			actual = new BufferedInputStream(new FileInputStream("salida_test\\prueba_martin.txt"));
			expected = new BufferedInputStream(new FileInputStream("salida_test\\prueba_martinExpected.txt"));

			assertNotEquals(expected.readAllBytes(), actual.readAllBytes());
			assertNotSame(expected, actual);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}

	}

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