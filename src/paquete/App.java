package paquete;

public class App {

	public static void main(String[] args) {
		Taquilla nuevaTaquilla = new Taquilla();

		nuevaTaquilla.agregarTodasLasAtracciones(ManejadorDeArchivos.obtenerAtraccionesDesdeArchivo());

		nuevaTaquilla.agregarTodasLasPromociones(ManejadorDeArchivos.obtenerPromosDesdeArchivo(nuevaTaquilla));

		nuevaTaquilla.ordenarLasAtracciones();
		nuevaTaquilla.ordenarLasPromociones();

	}

}
