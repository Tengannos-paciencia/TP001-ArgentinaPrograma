package paquete;

import java.util.ArrayList;
import java.util.List;

public abstract class Ofertable {
	protected List<Atraccion> atracciones = new ArrayList<Atraccion>();
	protected int costoTotal;
	protected double tiempoTotal;

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

	public abstract double getTiempoTotal();

	public abstract void setCostoTotal();

	public abstract void setTiempoTotal();

}
