package paquete;

import java.util.List;

public class PromoAbsoluto extends Promocion {
	private int costoPromo;

	public PromoAbsoluto(String nombre, TipoAtraccion tipo, List<Atraccion> atraccionesPromocion, int costoPromo) {
		this.costoPromo = costoPromo;

	}

	public void setCostoTotal() {
		this.costoTotal = costoPromo;
	}

	@Override
	public String toString() {
		return "PROMO! [nombre: " + nombre + ", atracciones: " + atracciones + ", precio: " + precio + ", costo total: "
				+ costoTotal + ", tipo de promocion: " + tipoDePromocion + ", tiempo total: " + tiempoTotal + "]";
	}

}