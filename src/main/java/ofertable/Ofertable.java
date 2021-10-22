package ofertable;

import java.util.List;

public abstract class Ofertable {
	protected Atraccion[] atracciones;
	protected int costoTotal;
	protected int tiempoTotal;
	TipoAtraccion tipoAtraccion;

	public Ofertable() {
	}

	public abstract void ocuparAtraccion();

	public abstract boolean cupoDisponible();

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

	public abstract List<Atraccion> getListaAtracciones();

	protected abstract int getCosto();

	protected abstract int getTiempo();

}