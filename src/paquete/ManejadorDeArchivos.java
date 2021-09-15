package paquete;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SuppressWarnings("unused")
public class ManejadorDeArchivos {
	public static Usuario[] obtenerUsuarioDesdeArchivo(String ruta) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		Usuario[] usuarios = null;

		try {
			archivo = new File(ruta);
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
				int tiempoEnMinutos = Integer.parseInt(preferenciaUsuario[2]);
				TipoAtraccion tipo = TipoAtraccion.valueOf(preferenciaUsuario[3]);

				usuarios[indice++] = new Usuario(nombre, presupuesto, tiempoEnMinutos, tipo);
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

	public static Atraccion[] obtenerAtraccionesDesdeArchivo(String ruta) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		Atraccion[] atracciones = null;

		try {
			archivo = new File(ruta);
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
				int tiempo = Integer.parseInt(datosAtraccion[2]);
				int cupo = Integer.parseInt(datosAtraccion[3]);
				TipoAtraccion tipo = TipoAtraccion.valueOf(datosAtraccion[4]);

				atracciones[indice++] = new Atraccion(nombre, costo, tiempo, cupo, tipo);
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

	public static Promocion[] obtenerPromosDesdeArchivo(Taquilla taquilla, String ruta) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		Promocion[] promociones = null;

		try {
			archivo = new File(ruta);
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

				String[] atraccionesPromo = datosPromo[3].split(";");
				Atraccion[] atraccionesPromocion = new Atraccion[atraccionesPromo.length];
				for (int i = 0; i < atraccionesPromo.length; i++) {

					atraccionesPromocion[i] = taquilla.obtenerAtraccionPorNombreAtraccion(atraccionesPromo[i]);
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
					int indiceAtraccionGratis = Integer.parseInt(datosPromo[4]);
					promociones[indice++] = new PromoAxB(nombrePromo, tipo, atraccionesPromocion,
							indiceAtraccionGratis);
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
		PrintWriter salida = new PrintWriter(new File("archivos_salida\\itinerario_" + u.getNombre() + ".txt"));
		try {
			salida.println(u.toString());

		} finally {
			salida.close();

		}
	}

}