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
				//tipoFavorito tipo = preferenciaUsuario[3];
				

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
}