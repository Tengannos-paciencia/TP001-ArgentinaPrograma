package promociones;

import java.util.Arrays;
import java.util.List;

import model.Atraccion;
import model.Promocion;

public class PromoAbsoluto extends Promocion {
	private int costoPromo;

	public PromoAbsoluto(String nombre, int tipo, List<Atraccion> atraccionesPromocion, int costoPromo) {
		this.costoPromo = costoPromo;
		this.atracciones = atraccionesPromocion;
		this.nombre = nombre;
		this.tipoDePromocion = tipo;
		this.setCostoTotal();
		this.setTiempoTotal();
	}

	@Override
	public void setCostoTotal() {
		this.costoTotal = costoPromo;
	}

	@Override
	public String toString() {
		return "------PROMO GUISO ESPELUZNANTE------ incluye:\n" + atracciones
				+ "\nCosto con descuento: " + this.costoTotal + ", tiempo total: " + this.tiempoTotal + " minutos\n";

	}

	@Override
	public int getID() {
		return super.getID();
	}

}