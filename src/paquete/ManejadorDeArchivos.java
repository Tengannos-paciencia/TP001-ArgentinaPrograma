package paquete;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManejadorDeArchivos {
	public static Usuario[] obtenerUsuarioDesdeArchivo() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		Usuario[] usuarios = null;

		try {
			archivo = new File("archivos_entrada/usuarios.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			int cantidad = Integer.parseInt(br.readLine());
			usuarios = new Usuario[cantidad];

			int indice = 0;
			String linea = br.readLine();

			while (linea != null) {
				String[] preferenciaUsuario = linea.split(",");

				String nombre = preferenciaUsuario[0];
				int presupuesto = Integer.parseInt(preferenciaUsuario[1]);
				int tiempoEnSegundos = Integer.parseInt(preferenciaUsuario[2]);
				TipoAtraccion tipo = TipoAtraccion.valueOf(preferenciaUsuario[3]);

				usuarios[indice++] = new Usuario(nombre, presupuesto, tiempoEnSegundos, tipo);
				linea = br.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();

			}
		}

		return usuarios;
	}

	public static Atraccion[] obtenerAtraccionesDesdeArchivo() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		Atraccion[] atracciones = null;

		try {
			archivo = new File("entrada/atracciones.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			int cantidad = Integer.parseInt(br.readLine());
			atracciones = new Atraccion[cantidad];

			int indice = 0;
			String linea = br.readLine();
			while (linea != null) {
				String[] datosAtraccion = linea.split(",");
				String nombre = datosAtraccion[0];
				int costo = Integer.parseInt(datosAtraccion[1]);
				double tiempo = Double.parseDouble(datosAtraccion[2]);
				int cupo = Integer.parseInt(datosAtraccion[3]);
				TipoAtraccion tipo = TipoAtraccion.valueOf(datosAtraccion[4]);

				atracciones[indice++] = new Atraccion(nombre, costo, tiempo, cupo, tipo);
				// System.out.println(atracciones[indice]);
				// indice++;
				linea = br.readLine();

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();

			}
		}
		return atracciones;
	}

	public static Promocion[] obtenerPromosDesdeArchivo(Taquilla taquilla) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		Promocion[] promociones = null;

		try {
			archivo = new File("entrada/promociones.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			int cantidad = Integer.parseInt(br.readLine());
			promociones = new Promocion[cantidad];
			int indice = 0;

			String linea = br.readLine();
			while (linea != null) {
				String[] datosPromo = linea.split(",");

				String tipoPromo = datosPromo[0];
				String nombrePromo = datosPromo[1];
				TipoAtraccion tipo = TipoAtraccion.valueOf(datosPromo[2]);

				String[] atraccionesPromo = datosPromo[3].split(".");
				List<Atraccion> atraccionesPromocion = new ArrayList<Atraccion>();

				for (int i = 0; i < atraccionesPromo.length; i++) {

					atraccionesPromocion.add(taquilla.obtenerAtraccionPorNombreAtraccion(atraccionesPromo[i]));
				}
				if (tipoPromo.equals("PromoPorcentual")) {

					int porciento = Integer.parseInt(datosPromo[4]);
					promociones[indice++] = new PromoPorcentual(nombrePromo, tipo, atraccionesPromocion, porciento);

				}
				if (tipoPromo.equals("PromoAbsoluta")) {
					int costoPromo = Integer.parseInt(datosPromo[4]);
					promociones[indice++] = new PromoAbsoluto(nombrePromo, tipo, atraccionesPromocion, costoPromo);

				}

				if (tipoPromo.equals("PromoAxB")) {
					Atraccion atraccionGratis = taquilla.obtenerAtraccionPorNombreAtraccion(atraccionesPromo[0]);
					promociones[indice++] = new PromoAxB(nombrePromo, tipo, atraccionesPromocion, atraccionGratis);
				}

				linea = br.readLine();

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return promociones;
	}

	public static void crearItinerario(Usuario u) throws IOException {
		PrintWriter salida = new PrintWriter(new File("itinerario" + u.getNombre() +".out"));
		salida.println("hola");
	}

}