package paquete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Ofertable {
	protected Atraccion[] atracciones;
	protected int costoTotal;
	protected int tiempoTotal;
	TipoAtraccion tipoAtraccion;

	public Ofertable() {
	}

	public boolean cupoDisponible() {
		for (Atraccion atraccion : atracciones) {
			if (atraccion.getCupo() > 0) {
				return true;
			}
		}
		return false;
	}

	public String mostrarAtracciones() {
		String atraccionesMostradas = "";
		for (Atraccion atraccion : atracciones) {
			atraccionesMostradas += atraccion.getNombre() + ", ";
		}
		return atraccionesMostradas;
	}

	public abstract int getCostoTotal();

	public abstract int getTiempoTotal();

	public abstract void setCostoTotal();

	public abstract void setTiempoTotal();

	public TipoAtraccion getTipo() {
		return this.tipoAtraccion;
	}

	public boolean esPromocion() {
		return (this instanceof Promocion);
	}

	public boolean esAtraccion() {
		return (this instanceof Atraccion);
	}

	public Atraccion[] getAtracciones() {
		return atracciones;
	}

	public List<Atraccion> getListaAtracciones() {
		return Arrays.asList(atracciones);
	}

}
