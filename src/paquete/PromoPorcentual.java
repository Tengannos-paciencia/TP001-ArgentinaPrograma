package paquete;

import java.util.Arrays;

public class PromoPorcentual extends Promocion {
	private double porcentajeDescuento;
	private int costoSinDescuento;

	public PromoPorcentual(String nombre, TipoAtraccion tipo, Atraccion[] atracciones, double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
		this.atracciones = atracciones;
		this.nombre = nombre;
		this.tipoDePromocion = tipo;
		this.setCostoTotal();
		this.setTiempoTotal();
	}

	@Override
	public void setCostoTotal() {
		this.costoTotal = (int) (costoSinDescuento()*(porcentajeDescuento/100));
	}

	private int costoSinDescuento() {
		for (Atraccion atraccion : atracciones) {
			costoSinDescuento += atraccion.getCosto();
		}
		return costoSinDescuento;
	}

	@Override
	public String toString() {
		return "PROMO 25% OFF! incluye: " + Arrays.toString(atracciones) + "costo final: " + this.costoTotal
				+ ", tiempo total: " + this.tiempoTotal + " minutos";
	}
}
