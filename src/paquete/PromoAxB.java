package paquete;

import java.util.Arrays;

public class PromoAxB extends Promocion {
	private int costoSinDescuento;
	private Atraccion[] atracciones;
	private int atraccionGratis;

	public PromoAxB(String nombre, TipoAtraccion tipo, Atraccion[] atracciones, int indiceAtraccionGratis) {
		this.atracciones = atracciones;
		this.nombre = nombre;
		this.tipoDePromocion = tipo;
		this.setCostoTotal();
		this.atraccionGratis = indiceAtraccionGratis;
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
		return "PROMO 2x1! incluye: " + Arrays.toString(atracciones) + "costo final: " + this.costoTotal + ", tiempo total: "
				+ this.tiempoTotal;
	}
}