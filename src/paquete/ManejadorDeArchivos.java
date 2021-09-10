package paquete;

import java.io.*;

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
				double presupuesto = Integer.parseInt(preferenciaUsuario[1]);
				int tiempoEnSegundos = Integer.parseInt(preferenciaUsuario[2]);
				//tipoFavorito tipo = tipoFavorito.valueOf(preferenciaUsuario[3]);
				
				usuarios[indice++] = new Usuario(nombre, presupuesto, tiempoEnSegundos/*, tipo*/);
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
				String[] datosAtraccion = linea.split(";");
				String nombre = datosAtraccion[0];
				double costo = Double.parseDouble(datosAtraccion[1]);
				double tiempo = Double.parseDouble(datosAtraccion[2]);
				int cupo = Integer.parseInt(datosAtraccion[3]);
				TipoDeAtraccion tipo = TipoDeAtraccion.valueOf(datosAtraccion[4]);

				atracciones[indice] = new Atraccion(nombre, costo, tiempo, cupo, tipo);
				// System.out.println(atracciones[indice]);
				indice++;
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

	public static Promocion[] obtenerPromosDesdeArchivo(Parque parque) {
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
				String[] datosPromo = linea.split(";");

				String tipoPromo = datosPromo[0];
				String nombrePromo = datosPromo[1];
				TipoDeAtraccion tipo = TipoDeAtraccion.valueOf(datosPromo[2]);

				String[] atraccionesPromo = datosPromo[3].split(",");
				Atraccion[] atraccionesPromocion = new Atraccion[atraccionesPromo.length];

				for (int i = 0; i < atraccionesPromo.length; i++) {

					atraccionesPromocion[i] = parque.obtenerAtraccionPorNombreAtraccion(atraccionesPromo[i]);
				}
				if (tipoPromo.equals("Porcentual")) {

					double porciento = Double.parseDouble(datosPromo[4]);
					promociones[indice++] = new Porcentual(tipoPromo, nombrePromo, tipo, atraccionesPromocion,
							porciento);

				}
				if (tipoPromo.equals("Absoluta")) {
					int costoPromo = Integer.parseInt(datosPromo[4]);
					promociones[indice++] = new Absoluta(tipoPromo, nombrePromo, tipo, atraccionesPromocion,
							costoPromo);

				}

				if (tipoPromo.equals("Combinada")) {
					// String[] atraccionesGratis = datosPromo[3].split(",");
					// Atraccion atraccionesGratis = new Atraccion[atraccionesGratis.length];
					Atraccion atraccionGratis = new Atraccion();
					atraccionGratis = parque.obtenerAtraccionPorNombreAtraccion(datosPromo[4]);
					// for (int i = 0; i < atraccionesGratis.length; i++) {

					// atraccionesRegalo[i] =
					// parque.obtenerAtraccionPorNombreAtraccion(atraccionesGratis[i]);

					// }
					promociones[indice++] = new Combinada(nombrePromo, tipoPromo, tipo, atraccionesPromocion,
							atraccionGratis);
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

}