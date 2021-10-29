package ofertable;

import java.util.List;

import model.Atraccion;
import model.Promocion;
import varios.TipoAtraccion;

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

	public int getPromocionID() {
		if (this.esPromocion()) {
			return this.getID();
		}
		return 0;
	}

	public int getAtraccionID() {
		if (this.esAtraccion()) {
			return this.getID();
		}
		return 0;
	}

	public abstract int getID();
}
