package paquete;

import java.util.*;

import java.io.IOException;

public class App {

	public static void main(String[] args) {
		Taquilla nuevaTaquilla = new Taquilla();

		Scanner consolita = new Scanner(System.in);
		String respuesta = "";
		nuevaTaquilla.agregarTodosLosUsuarios(
				ManejadorDeArchivos.obtenerUsuarioDesdeArchivo("archivos_entrada/usuarios.txt"));

		Usuario[] usuarios = nuevaTaquilla.getUsuarios();
		// System.out.println(Arrays.toString(usuarios));

		nuevaTaquilla.agregarTodasLasAtracciones(
				ManejadorDeArchivos.obtenerAtraccionesDesdeArchivo("archivos_entrada/atracciones.txt"));

		Atraccion[] atracciones = nuevaTaquilla.getAtracciones();
		// System.out.println(Arrays.toString(atracciones));

		nuevaTaquilla.agregarTodasLasPromociones(
				ManejadorDeArchivos.obtenerPromosDesdeArchivo(nuevaTaquilla, "archivos_entrada/promociones.txt"));

		Promocion[] promociones = nuevaTaquilla.getPromociones();
		// System.out.println(Arrays.toString(promociones));

		Ofertable[] ofertas = new Ofertable[nuevaTaquilla.getAtracciones().length
				+ nuevaTaquilla.getPromociones().length];

		System.arraycopy(promociones, 0, ofertas, 0, promociones.length);
		System.arraycopy(atracciones, 0, ofertas, atracciones.length, promociones.length);

		for (int i = 0; i < usuarios.length; i++) {
			TipoAtraccion atraccionFavorita = usuarios[i].getTipoAtraccion();

			Arrays.sort(ofertas, new ComparadorDeOfertables(atraccionFavorita));
			System.out
					.println("*****Bienvenide " + usuarios[i].getNombre() + " al Parque del terror*****" + "\n" + "\n");

			for (int j = 0; j < ofertas.length; j++) {
				Ofertable oferta = ofertas[j];
				if (usuarios[i].puedeComprar(oferta) && !usuarios[i].atraccionYaComprada(oferta)
						&& oferta.cupoDisponible()) {
					respuesta = "";
					System.out.println(oferta);
					while (!respuesta.equalsIgnoreCase("Y") && !respuesta.equalsIgnoreCase("N")) {
						System.out.println("Desea aceptar esta oferta? (Y/N)");
						respuesta = consolita.nextLine();

					}
					if (respuesta.equalsIgnoreCase("Y")) {
						usuarios[i].aceptarOfertado(oferta);
						System.out.printf("%10s",
								"Gracias por su compra " + usuarios[i].getNombre() + "\n" + " (dinero restante: "
										+ usuarios[i].getDineroDisponible() + " monedas," + " tiempo restante: "
										+ usuarios[i].getTiempoDisponible() + " minutos)" + "\n" + "\n");

					}

				}

			}
			try {

				ManejadorDeArchivos.crearItinerario(usuarios[i]);
			}

			catch (IOException e) {
				e.printStackTrace();
			}

		}
		for (int i = 0; i < 50; ++i)
			System.out.println();
		System.out.println("Muchas gracias por visitar nuestro parque, vuelva prontos");

		consolita.close();
	}

}
