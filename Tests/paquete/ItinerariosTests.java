package paquete;

import static org.junit.Assert.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedInputStream;
import org.junit.Test;

public class ItinerariosTests {
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

}
