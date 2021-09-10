package paquete;

public class Atraccion extends Ofertable {
	private String nombre;
	private int cupoMaximo;
	private int costo;
	private TipoAtraccion tipoDeAtraccion;
	private int cupoActual;

	public void reservarCupo() {
		if (this.cupoDisponible()) {
			cupoActual--;
		}
	}

}
