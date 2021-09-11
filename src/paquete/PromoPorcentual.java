package paquete;

import java.util.List;

public class PromoPorcentual extends Promocion {

	int porcentajeDescuento;

	public PromoPorcentual(String nombrePromo, TipoAtraccion tipo, List<Atraccion> atracciones,
			int porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public void setCostoTotal() {
		int descuento = porcentajeDescuento * this.precio / 100;
		this.costoTotal = this.precio - descuento;
	}

	@Override
	public String toString() {
		return "PROMO! [porcentaje de descuento: " + porcentajeDescuento + ", nombre: " + nombre + ", atracciones: "
				+ atracciones + ", precio: " + precio + ", costo total: " + costoTotal + ", tipo de promocion: "
				+ tipoDePromocion + ", tiempo total: " + tiempoTotal + "]";
	}
}
