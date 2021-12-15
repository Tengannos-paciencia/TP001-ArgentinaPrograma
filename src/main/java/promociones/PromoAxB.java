package promociones;

import java.util.List;

import model.Atraccion;
import model.Promocion;

public class PromoAxB extends Promocion {
	private int costoSinDescuento;
	private int atraccionGratis;
	private int id = 3;

	public PromoAxB(String nombre, int tipo, List<Atraccion> atracciones, int indiceAtraccionGratis) {
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
		this.costoTotal = this.costoSinDescuento() - atracciones.get(atraccionGratis).getCosto();
	}

	@Override
	public String toString() {
		return "------PROMO 2x1!------ incluye:\n" + atracciones + "\nCosto con descuento: "
				+ this.costoTotal + ", tiempo total: " + this.tiempoTotal + " minutos\n";

	}
	@Override
	public int getID() {
		return this.id;
	}
}