package paquete;

import static org.junit.Assert.*;

import org.junit.Test;

public class TierraMediaTests {

	@Test
	public void quePuedeCrearAtraccion() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;
		
		Atraccion atraccion1 = new Atraccion ("primeraAtraccion", 15, 150, 12, tipo);
		String expected = "primeraAtraccion, costo: 15 monedas, tiempo: 150 minutos, cupo: 12, tipo: TERROR\n";
		
		assertEquals(expected, atraccion1.toString());
	}
/*	
	@Test
	public void quePuedeCrearPromocion() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;
		
		Atraccion atraccion1 = new Atraccion ("primeraAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion2 = new Atraccion ("segundaAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion3 = new Atraccion ("terceraAtraccion", 15, 150, 12, tipo);
		Atraccion atraccion4 = new Atraccion ("cuartaAtraccion", 15, 150, 12, tipo);
		Atraccion[] atracciones = new Atraccion[] {atraccion1, atraccion2, atraccion3, atraccion4};
		
		Promocion promo = new Promocion("prueba1", atracciones, tipo);
		
		String expected = "[nombre: prueba1, atracciones:" + atracciones + "precio: " + promo.getCosto() + "]";
		assertEquals(expected, promo.toString());
	}
	*/
	@Test
	public void quePuedeCrearAtraccionYCalcularCosto() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;
		
		Atraccion atraccion1 = new Atraccion ("primeraAtraccion", 15, 150, 12, tipo);
		int expected = 15;
		
		assertEquals(expected, atraccion1.getCosto());
	}
	
	@Test
	public void quePuedeCrearAtraccionYCalcularTiempo() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;
		
		Atraccion atraccion1 = new Atraccion ("primeraAtraccion", 15, 150, 12, tipo);
		int expected = 150;
		
		assertEquals(expected, atraccion1.getTiempo());
	}
	
	@Test
	public void quePuedeCrearAtraccionYCalcularCupo() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;
		
		Atraccion atraccion1 = new Atraccion ("primeraAtraccion", 15, 150, 12, tipo);
		int expected = 12;
		
		assertEquals(expected, atraccion1.getCupo());
	}
	
	@Test
	public void quePuedeCrearAtraccionYMostrarTipo() {
		TipoAtraccion tipo = TipoAtraccion.TERROR;
		
		Atraccion atraccion1 = new Atraccion ("primeraAtraccion", 15, 150, 12, tipo);
		TipoAtraccion expected = atraccion1.getTipo();
		
		assertEquals(expected, atraccion1.getTipo());
	}
	
	@Test
	public void quePuedeCrearUsuariosDesdeArchivoAfirmativo() throws Exception{
		//ManejadorDeArchivos archivoUsuarios = new ManejadorDeArchivos();
		Usuario[] usuarios = ManejadorDeArchivos.obtenerUsuarioDesdeArchivo("archivos_entrada/usuarios.txt");
		
		assertNotNull(usuarios);
	}
	
	@Test
	public void quePuedeCrearUsuariosDesdeArchivoNegativo() throws Exception{
		//ManejadorDeArchivos archivoUsuarios = new ManejadorDeArchivos();
		Usuario[] usuarios = ManejadorDeArchivos.obtenerUsuarioDesdeArchivo("archivos_entrada/usuarioss.txt");
		
		assertNull(usuarios);
	}
	
	@Test
	public void quePuedeCrearAtraccionDesdeArchivoAfirmativo() throws Exception{
		//ManejadorDeArchivos archivoAtracciones = new ManejadorDeArchivos();
		Atraccion[] atracciones = ManejadorDeArchivos.obtenerAtraccionesDesdeArchivo("archivos_entrada/atracciones.txt");
		
		assertNotNull(atracciones);
	}
	
	@Test
	public void quePuedeCrearAtraccionDesdeArchivoNegativo() throws Exception{
		//ManejadorDeArchivos archivoAtracciones = new ManejadorDeArchivos();
		Atraccion[] atracciones = ManejadorDeArchivos.obtenerAtraccionesDesdeArchivo("archivos_entrada/atraccioness.txt");
		
		assertNull(atracciones);
	}
	
	@Test
	public void quePuedeCrearPromosDesdeArchivoAfirmativo() throws Exception{
		Taquilla nuevaTaquilla = new Taquilla();
		//ManejadorDeArchivos archivoPromos = new ManejadorDeArchivos();
		nuevaTaquilla.agregarTodosLosUsuarios(ManejadorDeArchivos.obtenerUsuarioDesdeArchivo("archivos_entrada/usuarios.txt"));
		nuevaTaquilla.agregarTodasLasAtracciones(ManejadorDeArchivos.obtenerAtraccionesDesdeArchivo("archivos_entrada/atracciones.txt"));
		nuevaTaquilla.agregarTodasLasPromociones(ManejadorDeArchivos.obtenerPromosDesdeArchivo(nuevaTaquilla, "archivos_entrada/promociones.txt"));
		
		Promocion[] promociones = ManejadorDeArchivos.obtenerPromosDesdeArchivo(nuevaTaquilla, "archivos_entrada/promociones.txt");
		
		assertNotNull(promociones);
	}
	
	@Test
	public void quePuedeCrearPromosDesdeArchivoNegativo() throws Exception{
		Taquilla nuevaTaquilla = new Taquilla();
		//ManejadorDeArchivos archivoPromos = new ManejadorDeArchivos();
		//nuevaTaquilla.agregarTodosLosUsuarios(archivoPromos.obtenerUsuarioDesdeArchivo("archivos_entrada/usuarios.txt"));
		//nuevaTaquilla.agregarTodasLasAtracciones(archivoPromos.obtenerAtraccionesDesdeArchivo("archivos_entrada/atracciones.txt"));
		//nuevaTaquilla.agregarTodasLasPromociones(archivoPromos.obtenerPromosDesdeArchivo(nuevaTaquilla, "archivos_entrada/promociones.txt"));
		
		Promocion[] promociones = ManejadorDeArchivos.obtenerPromosDesdeArchivo(nuevaTaquilla, "archivos_entrada/promocioness.txt");
		
		assertNull(promociones);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}