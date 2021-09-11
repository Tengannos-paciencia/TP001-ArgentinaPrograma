package paquete;

public class Promocion extends Ofertable {
	String tipoPromo;
	TipoAtraccion tipoDeAtraccion;
	String nombrePromocion;
	Atraccion[] atraccionesEnPromocion;

	public Promocion(Atraccion[] atracciones) {
		this.atraccionesEnPromocion = atracciones;
	}
}
