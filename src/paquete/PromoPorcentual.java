package paquete;

import java.util.Arrays;

public class PromoPorcentual extends Promocion {
	private int porcentajeDescuento;
	protected int costoTotal;

	public PromoPorcentual(String nombre, TipoAtraccion tipo, Atraccion[] atracciones, int porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
		this.atracciones = atracciones;
		this.nombre = nombre;
		this.tipoDePromocion = tipo;
		this.setCostoTotal();
	}
	@Override
	public void setCostoTotal() {
		this.costoTotal = this.precio * (100 - porcentajeDescuento );
	}

	@Override
	public String toString() {
		return "PROMO 25% OFF! incluye: " + Arrays.toString(atracciones) + "costo final: " + this.getCostoTotal()
				+ ", tiempo total: " + this.getTiempoTotal();
	}
}
