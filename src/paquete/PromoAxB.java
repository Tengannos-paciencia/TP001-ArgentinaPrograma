package paquete;

public class PromoAxB extends Promocion {
	private Atraccion atraccionesDescontadas[];

	public PromoAxB(Atraccion[] atraccion) {
		super(atraccion);
	}

	public int calcularCosto() {
		return 1;
	}
}
