package model;

import java.util.List;

public abstract class Ofertable {
	protected List<Atraccion> atracciones;
	protected int costoTotal;
	protected int tiempoTotal;
	int tipoAtraccion;

	public Ofertable() {
	}

	public abstract void ocuparAtraccion();

	public abstract boolean cupoDisponible();

	public abstract int getCostoTotal();

	public abstract int getTiempoTotal();

	public abstract void setCostoTotal();

	public abstract void setTiempoTotal();

	public int getTipo() {
		return this.tipoAtraccion;
	}

	public boolean esPromocion() {
		return (this instanceof Promocion);
	}

	public boolean esAtraccion() {
		return (this instanceof Atraccion);
	}

	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

	public abstract List<Atraccion> getListaAtracciones();

	public abstract int getCosto();

	public abstract int getTiempo();

	public abstract int getID();
}
