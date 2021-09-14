package paquete;

public class App {

	public static void main(String[] args) {
		Taquilla nuevaTaquilla = new Taquilla();
		
		nuevaTaquilla.agregarTodosLosUsuarios(ManejadorDeArchivos.obtenerUsuarioDesdeArchivo());
		
		nuevaTaquilla.agregarTodasLasAtracciones(ManejadorDeArchivos.obtenerAtraccionesDesdeArchivo());

		nuevaTaquilla.agregarTodasLasPromociones(ManejadorDeArchivos.obtenerPromosDesdeArchivo(nuevaTaquilla));
		
		

		System.out.println(nuevaTaquilla.toString());
		
	}

}
