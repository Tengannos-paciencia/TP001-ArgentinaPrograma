package promociones;

import java.util.Arrays;

public class PromoAxB extends Promocion {
	private int costoSinDescuento;
	private int atraccionGratis;

	public PromoAxB(String nombre, TipoAtraccion tipo, Atraccion[] atracciones, int indiceAtraccionGratis) {
		this.atracciones = atracciones;
		this.nombre = nombre;
		this.tipoDePromocion = tipo;
		this.setCostoTotal();
		this.atraccionGratis = indiceAtraccionGratis;
		this.setTiempoTotal();
	}

	private int costoSinDescuento() {
		for (Atraccion atraccion : atracciones) {
			costoSinDescuento += atraccion.getCosto();
		}
		return costoSinDescuento;
	}

	@Override
	public void setCostoTotal() {
		this.costoTotal = this.costoSinDescuento() - atracciones[atraccionGratis].getCosto();
	}

	@Override
	public String toString() {
		return "------PROMO 2x1!------ incluye:\n" + Arrays.toString(atracciones) + "\nCosto con descuento: "
				+ this.costoTotal + ", tiempo total: " + this.tiempoTotal + " minutos\n";

	}
}