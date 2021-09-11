package paquete;

import java.util.List;

public class PromoAxB extends Promocion {
	private int costoSinDescuento;

	public PromoAxB(String nombre, TipoAtraccion tipo, List<Atraccion> atracciones, Atraccion atraccionGratis) {
		this.setCostoTotal();
	}

	private int costoSinDescuento() {
		for (Atraccion atraccion : atracciones) {
			costoSinDescuento = +atraccion.getCosto();
		}
		return costoSinDescuento;
	}

	@Override
	public void setCostoTotal() {
		this.costoTotal = this.costoSinDescuento() - atracciones.get(0).getCosto();
	}

	@Override
	public String toString() {
		return "PROMO! [nombre: " + nombre + ", atracciones: " + atracciones + ", precio: " + precio + ", costo total: "
				+ costoTotal + ", tipo de promocion: " + tipoDePromocion + ", tiempo total: " + tiempoTotal + "]";
	}
}