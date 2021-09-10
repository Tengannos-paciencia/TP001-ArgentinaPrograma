package paquete;

public class PromoPorcentual extends Promocion {
	private double porcentajeDePromocion;

	public PromoPorcentual(Atraccion[] atraccion) {
		super(atraccion);

	}

	public int calcularCosto() {
		return 1;
	}
}
