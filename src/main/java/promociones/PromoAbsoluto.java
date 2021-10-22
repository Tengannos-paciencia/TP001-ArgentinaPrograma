package promociones;

import java.util.Arrays;

public class PromoAbsoluto extends Promocion {
	private int costoPromo;

	public PromoAbsoluto(String nombre, TipoAtraccion tipo, Atraccion[] atraccionesPromocion, int costoPromo) {
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
		return "------PROMO GUISO ESPELUZNANTE------ incluye:\n" + Arrays.toString(atracciones)
				+ "\nCosto con descuento: " + this.costoTotal + ", tiempo total: " + this.tiempoTotal + " minutos\n";

	}

}