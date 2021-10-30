package promociones;

import java.util.List;

import model.Atraccion;
import model.Promocion;

public class PromoPorcentual extends Promocion {
	private double porcentajeDescuento;
	private int costoSinDescuento;
	private int id = 1;

	public PromoPorcentual(String nombre, int tipo, List<Atraccion> atracciones, int porcentajeDescuento) {
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
		return "------PROMO 25% OFF!------ incluye:\n" + atracciones
				+ "\nCosto con descuento: " + this.costoTotal + ", tiempo total: " + this.tiempoTotal + " minutos\n";
	}

	@Override
	public int getID() {
		return this.id;
	}
}
