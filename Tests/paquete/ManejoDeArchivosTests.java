package paquete;

import static org.junit.Assert.*;
import org.junit.Test;

public class ManejoDeArchivosTests {
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
}
