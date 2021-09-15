package paquete;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TierraMediaTests {
//-------------------------------------ATRACCIONES TEST----------------------------------------------------------//
	/*
	 * @Test public void quePuedeCrearPromocion() { TipoAtraccion tipo =
	 * TipoAtraccion.TERROR;
	 * 
	 * Atraccion atraccion1 = new Atraccion ("primeraAtraccion", 15, 150, 12, tipo);
	 * Atraccion atraccion2 = new Atraccion ("segundaAtraccion", 15, 150, 12, tipo);
	 * Atraccion atraccion3 = new Atraccion ("terceraAtraccion", 15, 150, 12, tipo);
	 * Atraccion atraccion4 = new Atraccion ("cuartaAtraccion", 15, 150, 12, tipo);
	 * Atraccion[] atracciones = new Atraccion[] {atraccion1, atraccion2,
	 * atraccion3, atraccion4};
	 * 
	 * Promocion promo = new Promocion("prueba1", atracciones, tipo);
	 * 
	 * String expected = "[nombre: prueba1, atracciones:" + atracciones + "precio: "
	 * + promo.getCosto() + "]"; assertEquals(expected, promo.toString()); }
	 */

	@Test
	public void quePuedeCrearAtraccion() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;

		Atraccion atraccion1 = new Atraccion("primeraAtraccion", 15, 150, 12, tipo);
		String expected = "primeraAtraccion, costo: 15 monedas, tiempo: 150 minutos, cupo: 12, tipo: TERROR\n";

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
		// ManejadorDeArchivos archivoUsuarios = new ManejadorDeArchivos();
		Usuario[] usuarios = ManejadorDeArchivos.obtenerUsuarioDesdeArchivo("archivos_entrada/usuarios.txt");

		assertNotNull(usuarios);
	}

	@Test
	public void quePuedeCrearUsuariosDesdeArchivoNegativo() throws Exception {
		// ManejadorDeArchivos archivoUsuarios = new ManejadorDeArchivos();
		Usuario[] usuarios = ManejadorDeArchivos.obtenerUsuarioDesdeArchivo("archivos_entrada/usuarioss.txt");

		assertNull(usuarios);
	}

	@Test
	public void quePuedeCrearAtraccionDesdeArchivoAfirmativo() throws Exception {
		// ManejadorDeArchivos archivoAtracciones = new ManejadorDeArchivos();
		Atraccion[] atracciones = ManejadorDeArchivos
				.obtenerAtraccionesDesdeArchivo("archivos_entrada/atracciones.txt");

		assertNotNull(atracciones);
	}

	@Test
	public void quePuedeCrearAtraccionDesdeArchivoNegativo() throws Exception {
		// ManejadorDeArchivos archivoAtracciones = new ManejadorDeArchivos();
		Atraccion[] atracciones = ManejadorDeArchivos
				.obtenerAtraccionesDesdeArchivo("archivos_entrada/atraccioness.txt");

		assertNull(atracciones);
	}

	@Test
	public void quePuedeCrearPromosDesdeArchivoAfirmativo() throws Exception {
		Taquilla nuevaTaquilla = new Taquilla();
		// ManejadorDeArchivos archivoPromos = new ManejadorDeArchivos();
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
		// ManejadorDeArchivos archivoPromos = new ManejadorDeArchivos();
		// nuevaTaquilla.agregarTodosLosUsuarios(archivoPromos.obtenerUsuarioDesdeArchivo("archivos_entrada/usuarios.txt"));
		// nuevaTaquilla.agregarTodasLasAtracciones(archivoPromos.obtenerAtraccionesDesdeArchivo("archivos_entrada/atracciones.txt"));
		// nuevaTaquilla.agregarTodasLasPromociones(archivoPromos.obtenerPromosDesdeArchivo(nuevaTaquilla,
		// "archivos_entrada/promociones.txt"));

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
				+ "\nCosto final: " + promo1.getCostoTotal() + ", tiempo total: " + promo1.getTiempoTotal()
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

		String expected = "------PROMO 25% OFF!------ incluye:\n" + Arrays.toString(atracciones) + "\nCosto final: "
				+ promoPorcentual.getCostoTotal() + ", tiempo total: " + promoPorcentual.getTiempoTotal()
				+ " minutos\n";

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

		String expected = "------PROMO 2x1!------ incluye:\n" + Arrays.toString(atracciones) + "\nCosto final: "
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

//------------------------------------------USUARIO------------------------------------------------------------------------------------//
	@Test
	public void quePuedeCrearUsuario() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;

		Usuario usuarioPruebas = new Usuario("juan carlos", 150, 480, tipo);
		String expected = usuarioPruebas.getNombre() + ", Tipo de atraccion favorita: " + usuarioPruebas.getTipoAtraccion()
						  + "\nPromociones compradas:" + usuarioPruebas.promocionesAceptadas + "\nAtracciones sin promo compradas: "
						  + usuarioPruebas.atraccionesAceptadas + "\nCosto total: " + costoFinal + ", Tiempo total estimado: " + tiempoFinal + "\n";

		assertEquals(expected, atraccion1.toString());
	}

	@Test
	public void quePuedeCrearUsuarioYPuedeComprar() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;

		Atraccion atraccion1 = new Atraccion("primeraAtraccion", 15, 150, 12, tipo);
		int expected = 15;

		assertEquals(expected, atraccion1.getCosto());
	}

	@Test
	public void quePuedeCrearUsuarioYVerificarAtraccionYaComprada() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;

		Atraccion atraccion1 = new Atraccion("primeraAtraccion", 15, 150, 12, tipo);
		int expected = 150;

		assertEquals(expected, atraccion1.getTiempo());
	}

	@Test
	public void quePuedeCrearUsuarioYVerificarDineroYTiempoSuficientes() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;

		Atraccion atraccion1 = new Atraccion("primeraAtraccion", 15, 150, 12, tipo);
		int expected = 12;

		assertEquals(expected, atraccion1.getCupo());
	}

	@Test
	public void quePuedeCrearUsuarioY() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;

		Atraccion atraccion1 = new Atraccion("primeraAtraccion", 15, 150, 12, tipo);
		TipoAtraccion expected = atraccion1.getTipo();

		assertEquals(expected, atraccion1.getTipo());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}