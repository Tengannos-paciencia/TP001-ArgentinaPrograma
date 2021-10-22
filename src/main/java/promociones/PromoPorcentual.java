package promociones;

import java.util.Arrays;

public class PromoPorcentual extends Promocion {
	private double porcentajeDescuento;
	private int costoSinDescuento;

	public PromoPorcentual(String nombre, TipoAtraccion tipo, Atraccion[] atracciones, int porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
		this.atracciones = atracciones;
		this.nombre = nombre;
		this.tipoDePromocion = tipo;
		this.setCostoTotal();
		this.setTiempoTotal();
	}

	@Override
	public void setCostoTotal() {
		this.costoTotal = (int) (this.costoSinDescuento()
				- (this.costoSinDescuento() * (this.porcentajeDescuento / 100)));
	}

	private int costoSinDescuento() {
		costoSinDescuento = 0;
		for (Atraccion atraccion : atracciones) {
			costoSinDescuento += atraccion.getCosto();
		}
		return costoSinDescuento;
	}

	@Override
	public String toString() {
		return "------PROMO 25% OFF!------ incluye:\n" + Arrays.toString(atracciones) + "\nCosto con descuento: "
				+ this.costoTotal + ", tiempo total: " + this.tiempoTotal + " minutos\n";
	}
}
