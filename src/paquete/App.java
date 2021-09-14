package paquete;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Taquilla nuevaTaquilla = new Taquilla();
		Scanner consolita = new Scanner(System.in);
		nuevaTaquilla.agregarTodosLosUsuarios(ManejadorDeArchivos.obtenerUsuarioDesdeArchivo());

		nuevaTaquilla.agregarTodasLasAtracciones(ManejadorDeArchivos.obtenerAtraccionesDesdeArchivo());

		nuevaTaquilla.agregarTodasLasPromociones(ManejadorDeArchivos.obtenerPromosDesdeArchivo(nuevaTaquilla));
		Ofertable[] ofertas = new Ofertable[nuevaTaquilla.getAtracciones().length
				+ nuevaTaquilla.getPromociones().length];
		Usuario[] usuarios = nuevaTaquilla.getUsuarios();
		for (int i = 0; i < usuarios.length; i++) {
			TipoAtraccion atraccionFavorita = usuarios[i].getTipoAtraccion();
			Arrays.sort(ofertas, new ComparadorDeOfertables(atraccionFavorita));

			for (int j = 0; j < ofertas.length; j++) {
				Ofertable oferta = ofertas[j];
				if (usuarios[i].puedeComprar(oferta) && !usuarios[i].atraccionYaComprada(oferta)) {

					System.out.println("acepta la siguiente oferta?(Y/N)");
					System.out.println(oferta);
					String respuesta = consolita.nextLine();
					while (respuesta != "Y" || respuesta != "N") {
						System.out.println("acepta la siguiente oferta?(Y/N)");

					}
					if (respuesta == "Y") {
						usuarios[i].aceptarOfertado(oferta);
					}

				}

			}

			try {
				ManejadorDeArchivos.crearItinerario(usuarios[i]);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
